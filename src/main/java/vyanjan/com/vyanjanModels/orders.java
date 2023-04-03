package vyanjan.com.vyanjanModels;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class orders {
	@Id
	private String orderId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private user user;
	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<productQuantity> productQuantityList = new HashSet<productQuantity>();
	
	private Date orderDate;
	private Date deliveryDate;
	private String deliveryAddress;
	//Code for discount(Functionality need to write)
//	private String appliedCode;
	//total discount & tax calculation need to add
	private int orderTotal;
	private String orderStatus;
	private String paymentStatus;
	
}
