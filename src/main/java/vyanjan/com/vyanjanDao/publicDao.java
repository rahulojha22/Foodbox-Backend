package vyanjan.com.vyanjanDao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vyanjan.com.vyanjanImpl.publicImpl;
import vyanjan.com.vyanjanModels.user;
import vyanjan.com.vyanjanRepository.userRepository;

@Service
public class publicDao implements publicImpl {
	@Autowired
	userRepository userRepo;

	@Override
	public user userSignUp(user user) {
		return userRepo.save(user);
	}

	@Override
	public Optional<user> userLogin(user user) {
		return userRepo.findUserByUserMobNumber(12345);
	}

}
