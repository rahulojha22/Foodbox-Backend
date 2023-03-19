package vyanjan.com.vyanjanRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vyanjan.com.vyanjanModels.user;

public interface userRepository extends JpaRepository<user, String> {
	Optional<user> findUserByuserMobNumber(long userMobNumber);

}
