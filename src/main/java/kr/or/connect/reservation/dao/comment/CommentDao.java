package kr.or.connect.reservation.dao.comment;

import static kr.or.connect.reservation.dao.comment.CommentDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.comment.Comment;

@Repository
public class CommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Comment> rowMapper = BeanPropertyRowMapper.newInstance(Comment.class);
	
	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public int getAverageScoresByDisplayId(Integer displayId) {
		Map<String, Object> param = new HashMap<>();
		param.put("displayId", displayId);
		return jdbc.queryForObject(SELECT_AVERAGE_SCORE_BY_DISPLAY_ID, param, Integer.class);
	}

	public List<Comment> selectAllCommentsByProductId(Integer productId, int start) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		params.put("start", start);
		return jdbc.query(SELECT_ALL_COMMENTS_BY_PRODUCT_ID, params, rowMapper);
	}
	
}
