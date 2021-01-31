package kr.or.connect.reservation.dao.product;

public class ProductDaoSqls {
	private static final int PAGE_COUNT = 10;
	
	public static final String SELECT_ALL = "SELECT d.id, "
			+ "p.category_id, "
			+ "    d.id, "
			+ "    c.name, "
			+ "    p.description, p.content, p.event, "
			+ "    d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email, d.create_date, d.modify_date, "
			+ "    i.file_id "
			+ "FROM display_info d "
			+ "LEFT JOIN product p ON p.id = d.product_id "
			+ "LEFT JOIN category c ON c.id = p.category_id "
			+ "LEFT JOIN display_info_image i ON i.display_info_id = d.id "
			+ "LIMIT :start, "
			+ PAGE_COUNT;
	
	public static final String SELECT_BY_CATEGORY_ID = "SELECT d.id, "
			+ "	p.category_id, "
			+ "    d.id, "
			+ "    c.name, "
			+ "    p.description, p.content, p.event, "
			+ "    d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email, d.create_date, d.modify_date, "
			+ "    i.file_id "
			+ "FROM display_info d "
			+ "LEFT JOIN product p ON p.id = d.product_id "
			+ "LEFT JOIN category c ON c.id = p.category_id "
			+ "LEFT JOIN display_info_image i ON i.display_info_id = d.id "
			+ "WHERE p.category_id = :categoryId "
			+ "LIMIT :start, "
			+ PAGE_COUNT;

}
