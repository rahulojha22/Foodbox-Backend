package vyanjan.com.vyanjanRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vyanjan.com.vyanjanModels.product;

public interface productRepository extends JpaRepository<product, String> {
	
	List<product> findProductByproductActive(boolean active);

}
