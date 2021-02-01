package kr.or.connect.reservation.service.product;

import java.util.List;

import kr.or.connect.reservation.dto.product.Product;
import kr.or.connect.reservation.dto.product.ProductImage;
import kr.or.connect.reservation.dto.product.ProductPrice;

public interface ProductService {

	public List<Product> selectAll(int start);

	public List<Product> selectByCategoryId(Integer categoryId, int start);

	public Product selectByDisplayId(Integer displayId);

	public List<ProductImage> selectProductImages(Integer displayId);

	public List<ProductPrice> selectProductPrices(Integer displayId);

}
