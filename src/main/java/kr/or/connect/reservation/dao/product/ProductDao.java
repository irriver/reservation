package kr.or.connect.reservation.dao.product;

import static kr.or.connect.reservation.dao.product.ProductDaoSqls.SELECT_ALL;
import static kr.or.connect.reservation.dao.product.ProductDaoSqls.SELECT_BY_CATEGORY_ID;

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
		return jdbc.queryForObject(SELECT_ALL, param, rowMapper);
	}

	//넘어온 categoryId와 일치하는 product 정보를 start부터 시작해서 추출
	public List<Product> selectByCategoryId(Integer categoryId, Integer start) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		return jdbc.query(SELECT_BY_CATEGORY_ID, params, rowMapper);
	}

}
