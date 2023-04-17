package vyanjan.com.vyanjanControllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vyanjan.com.vyanjanDao.carouselDao;
import vyanjan.com.vyanjanModels.carousel;
import vyanjan.com.vyanjanModels.carouselImage;
import vyanjan.com.vyanjanDao.adminDao;
import vyanjan.com.vyanjanModels.product;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class adminController {
	@Autowired
	carouselDao carouselDao;
	@Autowired
	adminDao adminDao;
	
	@PostMapping(value="/addProduct", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public product addProduct(@RequestPart("productData") product product,
										@RequestPart("productImage") MultipartFile productImage) throws IllegalStateException, IOException{
		System.out.println(product);
		String productId = product.getProductName();
		product.setProductId(productId);
		product addedProduct = new product();
		addedProduct = adminDao.addProduct(product, productImage);
		return addedProduct;
	}
	
	@PostMapping(value="/addCarousel", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> addCarousel(@RequestPart("carouselData") carousel carousel,
												@RequestPart("carouselImage") MultipartFile carouselImage) throws IllegalStateException, IOException{
		System.out.println(carousel);		
		carousel addedCarousel = new carousel();
		addedCarousel = carouselDao.addCarousel(carousel, carouselImage);
		return ResponseEntity.status(HttpStatus.OK).body(addedCarousel);
	}
	
	@GetMapping("/getActiveCarousel")
	public ResponseEntity<?> getActiveCarousel() throws IOException{
		List<carouselImage> carouselList = carouselDao.getActiveCarousel();
		return ResponseEntity.status(HttpStatus.OK).body(carouselList);
	}
	
}
