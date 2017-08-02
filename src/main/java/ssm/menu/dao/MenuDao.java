package ssm.menu.dao;

import java.util.List;

import ssm.menu.pojo.Menu;

public interface MenuDao {
	List<Menu> findAll();
}
