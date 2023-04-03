package vyanjan.com.vyanjanModels;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class orderCart {
	@Id
	private String cartId;
	
	@OneToOne(fetch = FetchType.LAZY)
	private user user;
	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<productQuantity> productQuantityList = new HashSet<productQuantity>();
	
}
