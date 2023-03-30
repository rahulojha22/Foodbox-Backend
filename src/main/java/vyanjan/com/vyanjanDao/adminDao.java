package vyanjan.com.vyanjanDao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vyanjan.com.vyanjanImpl.adminImpl;
import vyanjan.com.vyanjanModels.carousel;
import vyanjan.com.vyanjanModels.product;
import vyanjan.com.vyanjanRepository.carouselRepository;
import vyanjan.com.vyanjanRepository.productRepository;

@Service
public class adminDao implements adminImpl{
	@Autowired
	productRepository productRepo;
	
	@Autowired
	carouselRepository carouselRepo;
	
	private String productImageFolder = "D:\\Projects\\Vyanjan\\Images\\Product\\";
	private String carouselImageFolder = "D:\\Projects\\Vyanjan\\Images\\Carousel\\";

	@Override
	public product addProduct(product product, MultipartFile productImage) throws IllegalStateException, IOException {
		String productImagePath = productImageFolder + productImage.getOriginalFilename();
		product.setProductImageType(productImage.getContentType());
		product.setProductImagePath(productImagePath);
		productImage.transferTo(new File(productImagePath));
		return productRepo.save(product);
	}

	@Override
	public List<product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public carousel addCarousel(carousel carousel, MultipartFile carouselImage) throws IllegalStateException, IOException {
		String carouselFilePath = carouselImageFolder + carouselImage.getOriginalFilename();
		carousel.setCarouselId(carousel.getCarouselName());
		carousel.setCarouselImageType(carouselImage.getContentType());
		carousel.setCarouselImagePath(carouselFilePath);
		carouselImage.transferTo(new File(carouselFilePath));
		return carouselRepo.save(carousel);
	}

	@Override
	public List<carousel> getAllCarousel() {
		// TODO Auto-generated method stub
		return null;
	}

}
