package vyanjan.com.vyanjanRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vyanjan.com.vyanjanModels.user;

public interface userRepository extends JpaRepository<user, String> {
	
//	Optional<user> findByEmail(String email);
	Optional<user> findUserByUserMobNumber(long userMobNumber);
	Optional<user> findUserByUserEmail(String userEmail);
	public user findUserByUserId(String userId);
	
}
