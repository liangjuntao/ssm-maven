package ssm.menu.dao;

import java.util.List;

import ssm.menu.pojo.Menu;
import ssm.user.pojo.User;

public interface MenuDao {
	List<Menu> findAll(User user);
}
