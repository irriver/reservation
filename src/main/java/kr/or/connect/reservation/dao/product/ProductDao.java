package kr.or.connect.reservation.dao.product;

import static kr.or.connect.reservation.dao.product.ProductDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.product.Product;
import kr.or.connect.reservation.dto.product.ProductImage;
import kr.or.connect.reservation.dto.product.ProductPrice;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Product> selectAll(Integer start) {
		Map<String, Integer> param = new HashMap<>();
		param.put("start", start);
		return jdbc.query(SELECT_ALL, param, rowMapper);
	}

	//넘어온 categoryId와 일치하는 product 정보를 start부터 시작해서 추출
	public List<Product> selectByCategoryId(Integer categoryId, int start) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		return jdbc.query(SELECT_BY_CATEGORY_ID, params, rowMapper);
	}
	
	public Product selectByDisplayId(Integer displayId) {
		Map<String, Integer> param = new HashMap<>();
		param.put("displayId", displayId);
		return jdbc.queryForObject(SELECT_BY_DISPLAY_ID, param, rowMapper);
	}

	public List<ProductImage> selectProductImages(Integer displayId) {
		Map<String, Integer> param = new HashMap<>();
		param.put("displayId", displayId);
		return jdbc.query(SELECT_PRODUCT_IMAGES_BY_DISPLAY_ID, param, rowMapper);
	}

	public List<ProductPrice> selectProductPrices(Integer displayId) {
		Map<String, Integer> param = new HashMap<>();
		param.put("displayId", displayId);
		return jdbc.query(SELECT_PRODUCT_PRICES_BY_DISPLAY_ID, param, rowMapper);
	}

}
