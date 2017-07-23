package ssm.user.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import ssm.base.pojo.ResponseResult;
import ssm.user.pojo.User;
import ssm.user.service.UserService;



@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	UserService userService;
	
	@RequestMapping(value= "/login" ,method =RequestMethod.POST )
	@ResponseBody
	public ResponseResult login(User user){
		ResponseResult responseResult = new ResponseResult(ResponseResult.FAILURECODE);
		logger.info("---------"+user+"--login处理中------------");
		//这个是什么作用？不是很懂。
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());
		try {
			//根据输出的用户名和密码去做登陆。这个期间会去访问自定义的realm，根据输入的用户名和密码去做比对。
			subject.login(token);
			responseResult.setMsg("登录成功");
			responseResult.setCode(ResponseResult.SUCCESSCODE);
		} catch(UnknownAccountException ue) {
			token.clear();
			responseResult.setMsg("登录失败，您输入的账号不存在");
		} catch(IncorrectCredentialsException ie) {
			token.clear();
			responseResult.setMsg("登录失败，密码不匹配");
		} catch(RuntimeException re) {
			token.clear();
			responseResult.setMsg("登录失败");
		}
		return responseResult;
	}
	
	@RequestMapping("/toIndex")
	public String toIndex(){
		return "index";
	}
	
	
	
	@RequestMapping("/findUserById")
	public User findUserById(String id){
		return userService.findUserById(Integer.valueOf(id));
	}
	
}
