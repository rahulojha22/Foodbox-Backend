package vyanjan.com.vyanjanRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import vyanjan.com.vyanjanModels.orders;

public interface ordersRepository extends JpaRepository<orders, Long> {

}
