package ssm.user.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.user.dao.UserDao;
import ssm.user.pojo.User;
import ssm.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	public User getByLoginName(User user) {
		User u = null;
		try {
			 u = userDao.getByLoginName(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	public User findUserById(Integer id) {
		return null;
	}

	public User getByLoginName(String name) {
		 return  userDao.getByLoginName(name);
	}

}
