package vyanjan.com.vyanjanDao;

import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vyanjan.com.vyanjanImpl.productImpl;
import vyanjan.com.vyanjanMapper.productMapper;
import vyanjan.com.vyanjanModels.product;
import vyanjan.com.vyanjanRepository.productRepository;

@Service
public class productDao implements productImpl {
	@Autowired
	productRepository productRepo;

	@Override
	public List<productMapper> getActiveProducts() throws IOException {
		List<product> activeProductList = productRepo.findProductByproductActive(true);
		List<productMapper> productList = new ArrayList<productMapper>();
		for(product product: activeProductList) {
			productMapper activeProduct = new productMapper();
			activeProduct.setProductId(product.getProductId());
			activeProduct.setProductName(product.getProductName());
			activeProduct.setProductCategory(product.getProductCategory());
			activeProduct.setProductBasePrice(product.getProductBasePrice());
			activeProduct.setPricingMethod(product.getPricingMethod());
			activeProduct.setMinOrder(product.getMinOrder());
			activeProduct.setOrderSteps(product.getOrderSteps());
			activeProduct.setProductDescription(product.getProductDescription());
			activeProduct.setProductInstructions(product.getProductInstructions());
			activeProduct.setProductImageType(product.getProductImageType());
			activeProduct.setProductActive(product.isProductActive());
			activeProduct.setProductImageByte(Files.readAllBytes(new File(product.getProductImagePath()).toPath()));
			productList.add(activeProduct);
		}
		return productList;
	}

}
