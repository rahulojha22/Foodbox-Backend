package vyanjan.com.vyanjanControllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vyanjan.com.vyanjanDao.carouselDao;
import vyanjan.com.vyanjanDao.publicDao;
import vyanjan.com.vyanjanImpl.productImpl;
import vyanjan.com.vyanjanImpl.userImpl;
import vyanjan.com.vyanjanMapper.productMapper;
import vyanjan.com.vyanjanModels.Role;
import vyanjan.com.vyanjanModels.carouselImage;
import vyanjan.com.vyanjanModels.user;

@CrossOrigin("*")
@RestController
@RequestMapping("/public")
public class publicController {
	
	@Autowired
	publicDao publicDao;
	
	@Autowired
	productImpl productImpl;
	
	@Autowired
	carouselDao carouselDao;
	
	@Autowired
	userImpl userImpl;
	
	@PostMapping("/user/signup")
	public user userSignUp(@RequestBody user user) {
		user.setUserId(user.getUserFirstName());
		user.setRole(Role.USER);
		return publicDao.userSignUp(user);
	}
	
	@GetMapping("/user/login/{userEmail}/{userMobNumber}/{userPassword}")
	public ResponseEntity<?> userLogin(@PathVariable("userEmail") String userEmail, @PathVariable("userMobNumber") long userMobNumber, @PathVariable("userPassword") String userPassword) {
		System.out.println(userEmail);
		user user = userImpl.userLogin(userEmail, userMobNumber, userPassword);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@GetMapping("/getActiveCarousel")
	public ResponseEntity<?> getActiveCarousel() throws IOException{
		List<carouselImage> carouselList = carouselDao.getActiveCarousel();
		return ResponseEntity.status(HttpStatus.OK).body(carouselList);
	}
	
	@GetMapping("/getActiveProduct")
	public ResponseEntity<?> getActiveProduct() throws IOException{
		List<productMapper> productList = productImpl.getActiveProducts();
		return ResponseEntity.status(HttpStatus.OK).body(productList);
	}

}
