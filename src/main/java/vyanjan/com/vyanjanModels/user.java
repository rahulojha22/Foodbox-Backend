package vyanjan.com.vyanjanModels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class user {
	@Id
	private String userId;	
	private String userFirstName;
	private String userLastName;
	private int userAge;
	private String prodGender;
	@Column(unique = true)
	private long userMobNumber;
	@Column(unique = true)
	private String userEmail;
	private String userPassword;
	private String userRole;
	private String profilePicName;
	private String profilePicFileType;
	private String profilePicFilePath;
	@OneToMany
	@JoinColumn(name="orderId")
	private order order;
}
