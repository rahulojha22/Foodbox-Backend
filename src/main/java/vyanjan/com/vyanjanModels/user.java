package vyanjan.com.vyanjanModels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class user {
	@Id
	private String userId;	
	private String userFirstName;
	private String userLastName;
	private int userAge;
	private String userGender;
	@Column(unique = true)
	private long userMobNumber;
	@Column(unique = true)
	private String userEmail;
	private String userPassword;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private String profilePicName;
	private String profilePicFileType;
	private String profilePicFilePath;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<orders> orderList = new ArrayList<orders>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<orderCart> orderCart;	
	
}
