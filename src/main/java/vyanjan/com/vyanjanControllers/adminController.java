package vyanjan.com.vyanjanControllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class adminController {
	@Autowired
	carouselDao carouselDao;
	
	@PostMapping("/uploadCarousel")
	public ResponseEntity<?> uploadCarousel(@RequestParam("carouselImage") MultipartFile carouselFile) throws IllegalStateException, IOException {
		String uploadCarouselFile = carouselDao.uploadCarousel(carouselFile);
		return ResponseEntity.status(HttpStatus.OK).body(uploadCarouselFile);
	}
	
	@GetMapping("/downloadCarousel/{carouselName}")
	public ResponseEntity<?> downloadCarousel(@PathVariable("carouselName") String carouselName) throws IOException{
		byte[] carouselImage = carouselDao.downloadCarousel(carouselName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(carouselImage);
	}
	
	@PostMapping(value="/uploadCarouselImage", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> uploadCarouselImage(@RequestPart("carousel") carousel carousel,
												@RequestPart("carouselImage") MultipartFile carouselFile) throws IllegalStateException, IOException{
		System.out.println(carousel);
		String uploadCarouselFile = carouselDao.uploadCarousel(carouselFile);
		return ResponseEntity.status(HttpStatus.OK).body("image uploaded");
	}
	
}
