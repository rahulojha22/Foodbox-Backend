package vyanjan.com.vyanjanImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vyanjan.com.vyanjanModels.carousel;
import vyanjan.com.vyanjanModels.product;

public interface adminImpl {
	
	public product addProduct(product product, MultipartFile productImage) throws IllegalStateException, IOException;
	public List<product> getAllProducts();
	public carousel addCarousel(carousel carousel, MultipartFile carouselImage) throws IllegalStateException, IOException;
	public List<carousel> getAllCarousel();

}
