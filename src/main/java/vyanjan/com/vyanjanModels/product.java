package vyanjan.com.vyanjanModels;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	private int orderSteps;
	private String productDescription;
	private String productInstructions;
	private boolean productActive;
	private String productImageType;
	private String productImagePath;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<orderCart> orderCart;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<orders> orders;

}
