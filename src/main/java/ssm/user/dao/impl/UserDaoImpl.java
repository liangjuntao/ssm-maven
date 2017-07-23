package ssm.user.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ssm.user.dao.UserDao;
import ssm.user.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private SqlSession session;
	
	@Resource(name="sqlSessionTemplate")
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public User findUserById(Integer id) {
		return null;
	}

	public User getByLoginName(User user) {
		return session.selectOne("getByLoginName", user);
	}

}
