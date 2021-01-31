package kr.or.connect.reservation.service.product;

import java.util.List;

import kr.or.connect.reservation.dto.product.Product;

public interface ProductService {

	public List<Product> selectAll(int start);

	public List<Product> selectByCategoryId(Integer categoryId, int start);

}
