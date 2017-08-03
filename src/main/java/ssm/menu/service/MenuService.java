package ssm.menu.service;

import java.util.List;

import ssm.menu.pojo.Menu;
import ssm.user.pojo.User;

public interface MenuService {

	List<Menu> findAll(User user);

}
