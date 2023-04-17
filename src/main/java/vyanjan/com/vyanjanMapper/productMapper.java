package vyanjan.com.vyanjanMapper;

import lombok.Data;

@Data
public class productMapper {
	
	private String productId;
	private String productName;
	private String productCategory;
	private int productBasePrice;
	private String pricingMethod;
	private int minOrder;
	private int orderSteps;
	private String productDescription;
	private String productInstructions;
	private String productImageType;
	private boolean productActive;
	private byte[] productImageByte;

}
