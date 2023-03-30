package vyanjan.com.vyanjanModels;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class order {
	@Id
	private String orderId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userID")
	private user user;
}
