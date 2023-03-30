package vyanjan.com.vyanjanDao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vyanjan.com.vyanjanImpl.carouselImpl;
import vyanjan.com.vyanjanModels.carousel;
import vyanjan.com.vyanjanModels.carouselImage;
import vyanjan.com.vyanjanRepository.carouselRepository;

@Service
public class carouselDao implements carouselImpl{
	@Autowired
	carouselRepository carouselRepo;
	
	private String carouselImageFolder = "D:\\Projects\\Vyanjan\\Images\\Carousel\\";
	
	@Override
	public String uploadCarousel(MultipartFile carouselFile) throws IllegalStateException, IOException {
//		String carouselFilePath = carouselFolderPath+carouselFile.getOriginalFilename();
//		String carouselId = carouselFile.getOriginalFilename();
//		carousel uploadCarousel = carouselRepo.save(carousel.builder()
//				.carouselId(carouselId)
//				.carouselName(carouselFile.getOriginalFilename())
//				.carouselImageType(carouselFile.getContentType())
//				.carouselImagePath(carouselFilePath).build());
//		carouselFile.transferTo(new File(carouselFilePath));
//		if(uploadCarousel != null) {
//			return "Carousel uploaded successfully!!";
//		}else {
			return null;
//		}
	}

	@Override
	public byte[] downloadCarousel(String carouselName) throws IOException {
		Optional<carousel> downloadCarousel = carouselRepo.findCarouselBycarouselName(carouselName);
		String carouselFilePath = downloadCarousel.get().getCarouselImagePath();
		byte[] carouselImage = Files.readAllBytes(new File(carouselFilePath).toPath());
		return carouselImage;
	}

	@Override
	public carousel addCarousel(carousel carousel, MultipartFile carouselImage)
			throws IllegalStateException, IOException {
		String carouselImagePath = carouselImageFolder + carouselImage.getOriginalFilename();
		carousel.setCarouselId(carousel.getCarouselName());
		carousel.setCarouselImageType(carouselImage.getContentType());
		carousel.setCarouselImagePath(carouselImagePath);
		carouselImage.transferTo(new File(carouselImagePath));
		return carouselRepo.save(carousel);
	}

	@Override
	public List<carousel> getAllCarousel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<carouselImage> getActiveCarousel() throws IOException {
		List<carousel> carouselActiveList = carouselRepo.findCarouselBycarouselActive(true);		
		List<carouselImage> carouselList = new ArrayList<carouselImage>();
		for(carousel carousel : carouselActiveList) {
			carouselImage activeCarousel = new carouselImage();
			activeCarousel.setCarouselId(carousel.getCarouselId());
			activeCarousel.setCarouselName(carousel.getCarouselName());
			activeCarousel.setCarouselImageType(carousel.getCarouselImageType());
			activeCarousel.setCarouselActive(carousel.isCarouselActive());
			activeCarousel.setCarouselImageByte(Files.readAllBytes(new File(carousel.getCarouselImagePath()).toPath()));
			carouselList.add(activeCarousel);
		}
		return carouselList;
	}
}
