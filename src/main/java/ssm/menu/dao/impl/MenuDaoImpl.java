package ssm.menu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ssm.menu.dao.MenuDao;
import ssm.menu.pojo.Menu;
import ssm.user.pojo.User;

@Repository
public class MenuDaoImpl implements MenuDao {
private SqlSession session;
	
	@Resource(name="sqlSessionTemplate")
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public List<Menu> findAll(User user) {
		return session.selectList("findAll",user);
	}

}
