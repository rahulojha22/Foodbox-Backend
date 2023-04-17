package vyanjan.com.vyanjanModels;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private user user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private product product;
	
	private int productQuantity;
	
}
