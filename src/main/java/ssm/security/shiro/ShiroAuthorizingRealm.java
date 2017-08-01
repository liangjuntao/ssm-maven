package ssm.security.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import ssm.security.shiro.ShiroAuthorizingRealm;
import ssm.user.pojo.User;
import ssm.user.service.UserService;

/**
 * 自定义relam
 * 
 * @author Administrator
 *
 */
public class ShiroAuthorizingRealm extends AuthorizingRealm {

	private static final Logger logger = Logger.getLogger(ShiroAuthorizingRealm.class);
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
		return null;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//此处使用的shiro自带的token，可以自定义
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String userName = usernamePasswordToken.getUsername();
	
		if (userName == null) {
			logger.warn("用户名不能为空");
			throw new AccountException("用户名不能为空");
		}

		User user = null;
		try {
			user = userService.getByLoginName(userName);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.warn("获取用户失败\n" + ex.getMessage());
		}
		if (user == null) {
			logger.warn("用户不存在");
			throw new UnknownAccountException("用户不存在");
		}
		// 到这里已经获取服务器中真实的存在的用户了。下面
		logger.info("用户【" + userName + "】登录成功");
		AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userName, user.getPassword(),
				getName());
		return authcInfo;
	}

}
