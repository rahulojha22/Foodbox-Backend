package vyanjan.com.vyanjanRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vyanjan.com.vyanjanModels.carousel;

public interface carouselRepository extends JpaRepository<carousel, String> {
	Optional<carousel> findCarouselBycarouselName(String carouselName);
}
