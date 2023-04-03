package vyanjan.com.vyanjanModels;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class productQuantity {
	@Id
	private Long pqId;
	
	@OneToOne(fetch = FetchType.EAGER)
	private product product;
	
	private int productQuantity;
	//This price is for unit quantity
	private int sellingPrice;

}
