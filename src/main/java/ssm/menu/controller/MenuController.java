package ssm.menu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.menu.pojo.Menu;
import ssm.menu.service.MenuService;
import ssm.util.MenuUtil;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping("/list")
	@ResponseBody
	private String list(ModelMap model){
		List<Menu> menus = menuService.findAll();
		Map<String,Object> menusMap = MenuUtil.generatorMenuList(menus);
		model.put("menus", menusMap);
		return "list";
	}
	

}
