import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {


    private SimpleAccountRealm realm = new SimpleAccountRealm();

    @Before
    public void addUser(){
//        realm.addAccount("root", "123456","admin");//   参数：用户名、密码、角色

        String password = new Md5Hash("123456").toString();//   数据库中MD5加密的密码
        realm.addAccount("root", password,"admin");//   参数：用户名、密码、角色
    }

    /**
     * 认证
     */
    @Test
    public void auth(){
        //  1、构建securityManager环境
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(realm);

        //  加密(可选)
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);//加密次数
        realm.setCredentialsMatcher(matcher);

        //  2、获取当前用户对象
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        //  3、创建登录令牌
        AuthenticationToken token = new UsernamePasswordToken("root", "123456");

        //  4、登录(认证)          Subject对象登录----会调用securityManager------securityManager调用Ream认证
        subject.login(token);

        System.out.println("判断是否认证isAuthenticated："+ subject.isAuthenticated());
        //  subject.checkRole("admin"); 判断当前对象是否拥有admin角色
    }



}
