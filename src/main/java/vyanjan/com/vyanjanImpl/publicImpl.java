package vyanjan.com.vyanjanImpl;

import java.util.Optional;

import vyanjan.com.vyanjanModels.user;

public interface publicImpl {
	
	public user userSignUp(user user);
	public Optional<user> userLogin(user user);

}
