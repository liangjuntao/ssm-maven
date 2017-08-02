package ssm.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.menu.dao.MenuDao;
import ssm.menu.pojo.Menu;
import ssm.menu.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;

	public List<Menu> findAll() {
		return menuDao.findAll();
	}

}
