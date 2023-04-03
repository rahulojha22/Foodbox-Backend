package vyanjan.com.vyanjanModels;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class product {
	@Id
	private String productId;
	private String productName;
	private String productCategory;
	private int productBasePrice;
	private String pricingMethod;
	private int minOrder;
	private String productDescription;
	private String productInstructions;
	private boolean productActive;
	private String productImageType;
	private String productImagePath;

}
