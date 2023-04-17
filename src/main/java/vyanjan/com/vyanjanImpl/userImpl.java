package vyanjan.com.vyanjanImpl;

import org.springframework.beans.factory.annotation.Autowired;

import vyanjan.com.vyanjanDao.userDao;
import vyanjan.com.vyanjanModels.user;

public interface userImpl {
	
	public user userLogin(String userEmail, long userMobNumber, String userPassword);

}
