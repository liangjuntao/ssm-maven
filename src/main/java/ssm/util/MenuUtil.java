package ssm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ssm.menu.pojo.Menu;

public class MenuUtil {

	public static Map<String, Object> generatorMenuList(List<Menu> rootMenu) {
		for (Menu menu : rootMenu) {
			System.out.println(menu);
		}
		// 先找到所有的一级菜单
		List<Menu> menuList = new ArrayList<Menu>();
		for (int i = 0; i < rootMenu.size(); i++) {
			if (rootMenu.get(i).getParentId() == null) {
				menuList.add(rootMenu.get(i));
			}
		}
		// 为一级菜单设置子菜单，getChild是递归调用的
		for (Menu menu : menuList) {
			menu.setChildMenus(getChild(menu.getId(), rootMenu));
		}
		Map<String, Object> menuMap = new HashMap();
		menuMap.put("menu", menuList);
		return menuMap;
	}

	private static List<Menu> getChild(Object id, List<Menu> rootMenu) {
		// 子菜单
		List<Menu> childList = new ArrayList();
		for (Menu menu : rootMenu) {
			// 遍历所有节点，将父菜单id与传过来的id比较
			// 如果是父子关系，加入childList
			if (menu.getParentId() != null) {
				if (menu.getParentId().equals(id)) {
					childList.add(menu);
				}
			}
		}
		// 把子菜单的子菜单再循环一遍
		for (Menu menu : childList) {// 没有url子菜单还有子菜单
			if (menu.getParentId() != null) {
				// 递归
				menu.setChildMenus(getChild(menu.getId(), rootMenu));
			}
		} // 递归退出条件
		if (childList.size() == 0) {
			return null;
		}
		return childList;
	}

}
