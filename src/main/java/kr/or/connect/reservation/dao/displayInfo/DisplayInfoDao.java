package kr.or.connect.reservation.dao.displayInfo;

import static kr.or.connect.reservation.dao.displayInfo.DisplayInfoDaoSqls.COUNT_ALL;
import static kr.or.connect.reservation.dao.displayInfo.DisplayInfoDaoSqls.COUNT_BY_CATEGORY_ID;
import static kr.or.connect.reservation.dao.displayInfo.DisplayInfoDaoSqls.SELECT_DISPLAY_IMAGES_BY_DISPLAY_ID;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.displayInfo.DisplayInfoImage;

@Repository
public class DisplayInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<DisplayInfoImage> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	
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

	public List<DisplayInfoImage> selectDisplayInfoImages(Integer displayId) {
		Map<String, Integer> param = new HashMap<>();
		param.put("displayId", displayId);
		return jdbc.query(SELECT_DISPLAY_IMAGES_BY_DISPLAY_ID, param, rowMapper);
	}

}
