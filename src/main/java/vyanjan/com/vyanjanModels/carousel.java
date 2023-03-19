package vyanjan.com.vyanjanModels;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class carousel {

	@Id
	private String carouselId;
	private String carouselName;
	private String carouselFileType;
	private String carouselFilePath;
}
