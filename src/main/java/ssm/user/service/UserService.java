package ssm.user.service;

import ssm.user.pojo.User;

public interface UserService {
	User findUserById(Integer id);

	User getByLoginName(User user);
	
	User getByLoginName(String name);
}
