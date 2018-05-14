一、相关参数
    1、 Subject：主体
		访问系统的用户，主体可以是用户、程序等，进行认证的都称为主体
	2、Principal：身份信息
		是主体（subject）进行身份认证的标识，标识必须具有唯一性，如用户名、手机号、邮箱地址等，一个主体可以有多个身份，但是必须有一个主身份（Primary Principal）
	3、credential：凭证信息
		 是只有主体自己知道的安全信息，如密码、证书等
	4、认证
	5、授权

二、拦截方式
	1、URL拦截----基于过滤器实现
	    anon            无需认证就能访问
	    authc           认证后才能访问
	    user            需要当前存在用户才可以访问
	    logout          退出

	    perms   具有某种权限才能访问      /deleteUser = perms["delete"]
	    roles   具有某种角色才能访问      /deleteUser = roles["admin"]
	    ssl     协议
	    port    端口

    2：方法注解------基于代理技术实现
		@RequiresAuthentication
		@RequiresUser
		@RequiresGuest
		@RequiresRoles
		@RequiresPermissions
		
	3：页面标签------基于标签技术实现
		<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
		
		<shiro:authenticated>......</shiro:authenticated>
        <shiro:hasRolename="admin">......</shiro:hasRole>
		<shiro:hasPermission name="delete">......</shiro:hasPermission>
		
	4 代码 
		Subject subject = SecurityUtils.getSubject();
		subject.isAuthenticated();	是否认证
		subject.hasRole(...);
		subject.checkPermission(...);


三、常见异常
	UnknownAccountException 		账号不存在异常
	IncorrectCredentialsException   密码错误异常
	
	DisabledAccountException（帐号被禁用）
	LockedAccountException（帐号被锁定）
	ExcessiveAttemptsException（登录失败次数过多）
	ExpiredCredentialsException（凭证过期）