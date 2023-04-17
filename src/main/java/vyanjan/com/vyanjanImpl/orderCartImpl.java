package vyanjan.com.vyanjanImpl;

import java.util.List;

import vyanjan.com.vyanjanModels.orderCart;
import vyanjan.com.vyanjanModels.user;

public interface orderCartImpl {
	
	public orderCart addToCart(String userId, String productId, int productQuantity);
	public List<orderCart> getOrderCartList(String userId);

}
