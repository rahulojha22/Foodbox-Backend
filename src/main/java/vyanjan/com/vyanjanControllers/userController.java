package vyanjan.com.vyanjanControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import vyanjan.com.vyanjanImpl.orderCartImpl;
import vyanjan.com.vyanjanImpl.ordersImpl;
import vyanjan.com.vyanjanModels.orderCart;
import vyanjan.com.vyanjanModels.orders;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class userController {
	@Autowired
	orderCartImpl orderCartImpl;
	
	@Autowired
	ordersImpl ordersImpl;
	
	@PostMapping("/addToCart/{userId}/{productId}/{productQuantity}")
	public ResponseEntity<?> addToCart(@PathVariable("userId") String userId, @PathVariable("productId") String productId, @PathVariable("productQuantity") int productQuantity){
		orderCart orderCart = orderCartImpl.addToCart(userId, productId, productQuantity);
		return ResponseEntity.status(HttpStatus.OK).body(orderCart);		
	}
	
	@GetMapping("/getOrderCart/{userId}")
	public ResponseEntity<?> getOrderCartList(@PathVariable("userId") String userId){
		List<orderCart> listCart = orderCartImpl.getOrderCartList(userId);
		for(orderCart oc: listCart) {
			System.out.println(oc.getCartId());
		}
		return ResponseEntity.status(HttpStatus.OK).body(listCart);
	}
	
	@PostMapping("/saveOrder")
	public ResponseEntity<?> saveOrder(@RequestBody orders orders){
		orders savedOrders = ordersImpl.saveOrder(orders);
		return ResponseEntity.status(HttpStatus.OK).body(savedOrders);
	}
	
	@PostMapping("/updateOrder")
	public ResponseEntity<?> updateOrder(@RequestBody long orderId){
		orders savedOrders = ordersImpl.updateOrders(orderId);
		return ResponseEntity.status(HttpStatus.OK).body(savedOrders);
	}

}
