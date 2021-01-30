package kr.or.connect.reservation.service.product;

import java.util.List;

import kr.or.connect.reservation.dto.product.Product;

public interface ProductService {

	List<Product> selectAll(int start);

	List<Product> selectByCategoryId(int categoryId, int start);

}
