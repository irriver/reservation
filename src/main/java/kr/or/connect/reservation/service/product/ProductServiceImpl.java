package kr.or.connect.reservation.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.product.ProductDao;
import kr.or.connect.reservation.dto.product.Product;
import kr.or.connect.reservation.dto.product.ProductImage;
import kr.or.connect.reservation.dto.product.ProductPrice;

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

	// 전시 정보 구하기: GET /api/displayinfos/{displayid}
	@Override
	public Product selectByDisplayId(Integer displayId) {
		return productDao.selectByDisplayId(displayId);
	}
	
	@Override
	public List<ProductImage> selectProductImages(Integer displayId) {
		return productDao.selectProductImages(displayId);
	}

	@Override
	public List<ProductPrice> selectProductPrices(Integer displayId) {
		return productDao.selectProductPrices(displayId);
	}

}
