package ssm.test.springHttpInvoker;

import java.util.List;

import ssm.menu.pojo.Menu;
import ssm.user.pojo.User;

public interface LocalMenuService {
	List<Menu> findAll(User user);
}
