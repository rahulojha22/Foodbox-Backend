package vyanjan.com.vyanjanDao;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vyanjan.com.vyanjanImpl.ordersImpl;
import vyanjan.com.vyanjanModels.orders;
import vyanjan.com.vyanjanRepository.ordersRepository;

@Service
public class ordersDao implements ordersImpl {
	@Autowired
	ordersRepository ordersRepo;

	@Override
	public orders saveOrder(orders orders) {
		orders.setSellingPrice(orders.getProduct().getProductBasePrice());
		Date date = new Date();
		orders.setDeliveryDate(date);
		orders.setOrderDate(date);
		orders.setOrderStatus("pending");
		return ordersRepo.save(orders);
	}

	@Override
	public orders updateOrders(long orderUniqueId) {
		orders userOrder = ordersRepo.findById(orderUniqueId).orElse(null);
		userOrder.setOrderStatus("done");
		
		return ordersRepo.save(userOrder);
	}

}
