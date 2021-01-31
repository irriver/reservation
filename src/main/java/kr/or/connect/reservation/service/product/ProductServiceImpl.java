package kr.or.connect.reservation.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.product.ProductDao;
import kr.or.connect.reservation.dto.product.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> selectAll(int start) {
		return productDao.selectAll(start);
	}

	@Override
	public List<Product> selectByCategoryId(Integer categoryId, int start) {
		return productDao.selectByCategoryId(categoryId, start);
	}

}
