package ssm.user.dao;

import ssm.user.pojo.User;

public interface UserDao {
	User findUserById(Integer id);

	User getByLoginName(User user);

	User getByLoginName(String name);
}
