package kr.or.connect.reservation.dao.promotion;

public class PromotionDaoSql {
	public static final String SELECT_ALL = "SELECT pm.id, pm.product_id, pr.category_id, c.name, pr.description, pi.file_id "
			+ "FROM promotion pm "
			+ "LEFT JOIN product pr ON pm.product_id = pr.id "
			+ "LEFT JOIN category c ON c.id = pr.category_id "
			+ "LEFT JOIN product_image pi ON pi.product_id = pr.id "
			+ "WHERE pi.type = 'ma'";
}
