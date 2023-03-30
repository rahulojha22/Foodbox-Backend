package vyanjan.com.vyanjanControllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vyanjan.com.vyanjanDao.carouselDao;
import vyanjan.com.vyanjanDao.publicDao;
import vyanjan.com.vyanjanImpl.productImpl;
import vyanjan.com.vyanjanMapper.productMapper;
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
