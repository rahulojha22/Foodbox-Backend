package vyanjan.com.vyanjanDao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vyanjan.com.vyanjanImpl.carouselInterface;
import vyanjan.com.vyanjanModels.carousel;
import vyanjan.com.vyanjanRepository.carouselRepository;

@Service
public class carouselDao implements carouselInterface{
	@Autowired
	carouselRepository carouselRepo;
	
	private String carouselFolderPath = "D:\\Projects\\Vyanjan\\Images\\Carousel\\";
	
	@Override
	public String uploadCarousel(MultipartFile carouselFile) throws IllegalStateException, IOException {
		String carouselFilePath = carouselFolderPath+carouselFile.getOriginalFilename();
		String carouselId = carouselFile.getOriginalFilename();
		carousel uploadCarousel = carouselRepo.save(carousel.builder()
				.carouselId(carouselId)
				.carouselName(carouselFile.getOriginalFilename())
				.carouselFileType(carouselFile.getContentType())
				.carouselFilePath(carouselFilePath).build());
		carouselFile.transferTo(new File(carouselFilePath));
		if(uploadCarousel != null) {
			return "Carousel uploaded successfully!!";
		}else {
			return null;
		}
	}

	@Override
	public byte[] downloadCarousel(String carouselName) throws IOException {
		Optional<carousel> downloadCarousel = carouselRepo.findCarouselBycarouselName(carouselName);
		String carouselFilePath = downloadCarousel.get().getCarouselFilePath();
		byte[] carouselImage = Files.readAllBytes(new File(carouselFilePath).toPath());
		return carouselImage;
	}
}
