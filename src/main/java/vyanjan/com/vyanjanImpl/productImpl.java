package vyanjan.com.vyanjanImpl;

import java.io.IOException;
import java.util.List;

import vyanjan.com.vyanjanMapper.productMapper;

public interface productImpl {
	
	public List<productMapper> getActiveProducts() throws IOException;

}
