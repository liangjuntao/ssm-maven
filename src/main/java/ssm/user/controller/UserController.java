package ssm.user.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import ssm.base.pojo.ResponseResult;
import ssm.menu.pojo.Menu;
import ssm.menu.service.MenuService;
import ssm.user.pojo.User;
import ssm.user.service.UserService;
import ssm.util.MenuUtil;



@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	UserService userService;
	
	@Resource
	MenuService menuService;
	
	@RequestMapping(value= "/login" ,method =RequestMethod.POST )
	@ResponseBody
	public ResponseResult login(User user){
		ResponseResult responseResult = new ResponseResult(ResponseResult.FAILURECODE);
		logger.info("---------"+user+"--login处理中------------");
		//这个是一个门面，表示当前需要认证的程序，用户等
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
		//认证不通过，删除shiro中添加的session
		if( ! subject.isAuthenticated()){
			subject.getSession().removeAttribute("currentUser");
		}
		return responseResult;
	}
	
	@RequestMapping("/toIndex")
	public String toIndex(ModelMap model,HttpServletRequest req){
		Subject subject = SecurityUtils.getSubject();
		User user = (User)subject.getSession().getAttribute("currentUser");
		
		List<Menu> menus = menuService.findAll(user);
		Map<String,Object> map = MenuUtil.generatorMenuList(menus);
		model.put("menus", map);
		return "index";
	}
	
	@RequestMapping("/findUserById")
	public User findUserById(String id){
		return userService.findUserById(Integer.valueOf(id));
	}
	
	@RequestMapping(value= "/test" ,method =RequestMethod.POST )
	@ResponseBody
	public ResponseResult test(User user){
		ResponseResult responseResult = new ResponseResult(ResponseResult.FAILURECODE);
		User u = userService.getByLoginName(user.getName());
		return responseResult;
	}
	
	
	@RequestMapping(value= "/logout" )
	@ResponseBody
	public ResponseResult loginOut(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		ResponseResult responseResult = new ResponseResult(ResponseResult.SUCCESSCODE,"退出成功");
		return responseResult;
	}
	
	
	
	
	
	
}
