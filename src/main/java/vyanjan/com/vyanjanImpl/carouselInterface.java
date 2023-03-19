package vyanjan.com.vyanjanImpl;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface carouselInterface {
	
	public String uploadCarousel(MultipartFile carouselFile) throws IllegalStateException, IOException;
	public byte[] downloadCarousel(String carouselName) throws IOException;
}
