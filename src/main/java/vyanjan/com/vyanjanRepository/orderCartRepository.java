package vyanjan.com.vyanjanRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vyanjan.com.vyanjanModels.orderCart;
import vyanjan.com.vyanjanModels.product;
import vyanjan.com.vyanjanModels.user;

public interface orderCartRepository extends JpaRepository<orderCart, String> {
	
	public orderCart findByUserAndProduct(user user, product product);
	public List<orderCart> findByUser(user user);

}
