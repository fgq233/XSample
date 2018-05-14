package com.shiro.sample.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.WebSessionKey;

import javax.servlet.ServletRequest;
import java.io.Serializable;

/**
 * 默认 DefaultSessionManager 调用SessionDao从Redis中读取session次数太多，对Redis压力过大
 */
public class MySessionManager extends DefaultSessionManager {


    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {

        Serializable sessionId = getSessionId(sessionKey);
        ServletRequest request = null;
        if (sessionKey instanceof WebSessionKey) {
            request = ((WebSessionKey) sessionKey).getServletRequest();
        }
        if (request != null && sessionId != null) {   // 先从request中获取session
            Session session = (Session) request.getAttribute(sessionId.toString());
            if(session!=null){
                return session;
            }
        }

        Session session = super.retrieveSession(sessionKey);    //调用SessionDao从Redis中取

        if (request != null && sessionId != null) {  // 把session设置到request
            request.setAttribute(sessionId.toString(), session);
        }
        return session;
    }
}
