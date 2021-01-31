package kr.or.connect.reservation.dao.displayInfo;

import static kr.or.connect.reservation.dao.displayInfo.DisplayInfoDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DisplayInfoDao {
	private NamedParameterJdbcTemplate jdbc;
//RowMapper는 언제 사용하지?
	
	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	// totalCount를 구하는 2가지 메소드
	public int countAll() {
		return jdbc.queryForObject(COUNT_ALL, Collections.emptyMap(), Integer.class);
	}
 
	public int countByCategoryId(Integer categoryId) {
		Map<String, Integer> param = new HashMap<>();
		param.put("categoryId", categoryId);
		return jdbc.queryForObject(COUNT_BY_CATEGORY_ID, param, Integer.class);
	}

}
