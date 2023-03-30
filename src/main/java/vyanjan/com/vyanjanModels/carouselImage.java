package vyanjan.com.vyanjanModels;

import lombok.Data;

@Data
public class carouselImage {
	
	private String carouselId;
	private String carouselName;
	private String carouselImageType;;
	private boolean carouselActive;
	private byte[] carouselImageByte;
}
