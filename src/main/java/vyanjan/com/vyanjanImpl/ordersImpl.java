package vyanjan.com.vyanjanImpl;

import vyanjan.com.vyanjanModels.orders;

public interface ordersImpl {
	
	public orders saveOrder(orders orders);
	public orders updateOrders(long orderUniqueId);

}
