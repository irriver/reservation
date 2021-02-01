package kr.or.connect.reservation.dao.comment;

import static kr.or.connect.reservation.dao.comment.CommentDaoSqls.SELECT_AVERAGE_SCORE_BY_DISPLAY_ID;

import java.util.HashMap;
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
		Map<String, Integer> param = new HashMap<>();
		param.put("displayId", displayId);
		return jdbc.queryForObject(SELECT_AVERAGE_SCORE_BY_DISPLAY_ID, param, Integer.class);
	}
	
}
