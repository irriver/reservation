package kr.or.connect.reservation.dao.category;

public class CategoryDaoSql {
	public static final String SELECT_ALL = "SELECT category.id, "
													+ "category.name, "
													+ "(SELECT count(*) "
													+ "FROM product "
													+ "WHERE category.id = product.category_id) AS count "
											+ "FROM category";
}
