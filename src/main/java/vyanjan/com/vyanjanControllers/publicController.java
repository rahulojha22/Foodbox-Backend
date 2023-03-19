package vyanjan.com.vyanjanControllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vyanjan.com.vyanjanDao.publicDao;
import vyanjan.com.vyanjanModels.user;

@CrossOrigin("*")
@RestController
@RequestMapping("/public")
public class publicController {
	@Autowired
	publicDao publicDao;
	
	@PostMapping("/user/signup")
	public user userSignUp(@RequestBody user user) {
		user.setUserId(user.getUserFirstName());
		user.setUserRole("customer");
		return publicDao.userSignUp(user);
	}
	
	@GetMapping("/user/login")
	public Optional<user> userLogin() {
		
		return publicDao.userLogin(null);
	}

}
