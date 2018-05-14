package com.shiro.sample.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RedisSessionDao extends AbstractSessionDAO {

    @Autowired
    private JedisUtils jedisUtils;

    private final String SHIRO_SESSION_PREFIX = "fgq_shiro_session:";

    private byte[] getKey(String key) {
        return (SHIRO_SESSION_PREFIX + key).getBytes();
    }


    private void saveSessionToRedis(Session session) {
        if (session != null && session.getId() != null) {
            byte[] key = getKey(session.getId().toString()); //  生成存储的key
            byte[] value = SerializationUtils.serialize(session); //   生成存储的value(序列化)

            jedisUtils.set(key, value);// 保存到Redis
            jedisUtils.expire(key, 600);//  超时时间，单位：秒
        }
    }

    /**
     * 生成Session
     */
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);//  生成sessionId
        assignSessionId(session, sessionId);//  将session与sessionId捆绑
        saveSessionToRedis(session);    //  保存session
        return sessionId;
    }

    /**
     * 读取Session
     */
    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            return null;
        }
        byte[] key = getKey(sessionId.toString());
        byte[] value = jedisUtils.get(key);
        return (Session) SerializationUtils.deserialize(value);//反序列化
    }

    /**
     * 更新Session
     */
    @Override
    public void update(Session session) throws UnknownSessionException {
        Serializable sessionId = generateSessionId(session);
        saveSessionToRedis(session);
    }

    /**
     * 删除Session
     */
    @Override
    public void delete(Session session) {
        if (session != null && session.getId() != null) {
            return;
        }
        byte[] key = getKey(session.getId().toString());
        jedisUtils.del(key);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<byte[]> keys = jedisUtils.keys(SHIRO_SESSION_PREFIX);
        Set<Session> sessions = new HashSet<>();
        if (CollectionUtils.isEmpty(keys)) {
            return sessions;
        }
        for (byte[] key : keys) {
            Session session = (Session) SerializationUtils.deserialize(jedisUtils.get(key));
            sessions.add(session);
        }
        return sessions;
    }

}
