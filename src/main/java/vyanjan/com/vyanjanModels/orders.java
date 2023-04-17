package vyanjan.com.vyanjanModels;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderUniqueId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private user user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private product product;
	
	private int productQuantity;
	private int sellingPrice;
	private Date orderDate;
	private Date deliveryDate;
	private String deliveryAddress;
	//Code for discount(Functionality need to write)
//	private String appliedCode;
	//total discount & tax calculation need to add
	private int orderTotal;
	private String orderId;
	private String transactionId;
	private String orderStatus;
	private String paymentStatus;
	
}
