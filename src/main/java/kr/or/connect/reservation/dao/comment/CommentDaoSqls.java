package kr.or.connect.reservation.dao.comment;

public class CommentDaoSqls {
	public static final String SELECT_AVERAGE_SCORE_BY_DISPLAY_ID = 
			"SELECT AVG(score) "
			+ "FROM reservation_user_comment c "
				+ "LEFT JOIN display_info d ON d.product_id = c.product_id "
			+ "WHERE d.id = :displayId";
	
	public static final String SELECT_ALL_COMMENTS_BY_PRODUCT_ID = 
			"SELECT "
					+ "c.id, c.product_id, c.reservation_info_id, c.score, u.email, c.comment, c.create_date, c.modify_date, "
					+ "(SELECT ci.file_id "
					+ "FROM reservation_user_comment_image ci "
					+ "WHERE ci.reservation_user_comment_id = c.id) as comment_images "
			+ "FROM reservation_user_comment c "
				+ "LEFT JOIN user u ON u.id = c.user_id "
			+ "WHERE c.product_id = :productId";
}
