package vyanjan.com.vyanjanDao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vyanjan.com.vyanjanImpl.orderCartImpl;
import vyanjan.com.vyanjanModels.orderCart;
import vyanjan.com.vyanjanModels.product;
import vyanjan.com.vyanjanModels.user;
import vyanjan.com.vyanjanRepository.orderCartRepository;
import vyanjan.com.vyanjanRepository.productRepository;
import vyanjan.com.vyanjanRepository.userRepository;

@Service
public class orderCartDao implements orderCartImpl {
	@Autowired
	userRepository userRepo;
	
	@Autowired
	orderCartRepository orderCartRepo;
	
	@Autowired
	productRepository productRepo;

	@Override
	public orderCart addToCart(String userId, String productId, int productQuantity) {
		orderCart orderCart = new orderCart();
		System.out.println(userId);
		user user = userRepo.findById(userId).orElse(null);
		product product = productRepo.findById(productId).orElse(null);
		orderCart.setUser(user);
		if(product != null) {
			orderCart.setProduct(product);
		}
		orderCart.setProductQuantity(productQuantity);
		return orderCartRepo.save(orderCart);
	}

	@Override
	public List<orderCart> getOrderCartList(String userId) {
		user user = userRepo.findById(userId).orElse(null);
		List<orderCart> orderCartList = orderCartRepo.findByUser(user);
		return orderCartList;
	}	

}
