package vyanjan.com.vyanjanDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vyanjan.com.vyanjanImpl.userImpl;
import vyanjan.com.vyanjanModels.user;
import vyanjan.com.vyanjanRepository.userRepository;

@Service
public class userDao implements userImpl {
	@Autowired
	userRepository userRepo;

	@Override
	public user userLogin(String userEmail, long userMobNumber, String userPassword) {
		user user = new user();
		if(userEmail !=null) {
			user = userRepo.findUserByUserEmail(userEmail).orElse(null);
		}else {
			user = userRepo.findUserByUserMobNumber(userMobNumber).orElse(null);
		}
		return user;
	}	

}
