package vyanjan.com.vyanjanRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vyanjan.com.vyanjanModels.carousel;
import vyanjan.com.vyanjanModels.carouselImage;

public interface carouselRepository extends JpaRepository<carousel, String> {
	Optional<carousel> findCarouselBycarouselName(String carouselName);
	List<carousel> findCarouselBycarouselActive(boolean active);
}
