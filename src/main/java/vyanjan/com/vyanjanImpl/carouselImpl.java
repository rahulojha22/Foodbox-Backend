package vyanjan.com.vyanjanImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vyanjan.com.vyanjanModels.carousel;
import vyanjan.com.vyanjanModels.carouselImage;

public interface carouselImpl {
	
	public String uploadCarousel(MultipartFile carouselFile) throws IllegalStateException, IOException;
	public byte[] downloadCarousel(String carouselName) throws IOException;
	public carousel addCarousel(carousel carousel, MultipartFile carouselImage) throws IllegalStateException, IOException;
	public List<carousel> getAllCarousel();
	public List<carouselImage> getActiveCarousel() throws IOException;
}
