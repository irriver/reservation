package kr.or.connect.reservation.dao.product;

public class ProductDaoSqls {
	private static final int PAGE_COUNT = 10;
	
	public static final String SELECT_ALL = 
			"SELECT "
			+ "d.id, "
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
	
	public static final String SELECT_BY_CATEGORY_ID = 
			"SELECT "
			+ "d.id, "
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
	
	public static final String SELECT_BY_DISPLAY_ID = 
			"SELECT "
				+ "p.id, p.category_id, d.id, c.name, p.description, p.content, p.event, d.opening_hours, d.place_name, d.place_lot, d.place_street, d.tel, d.homepage, d.email, d.create_date, d.modify_date, di.file_id "
			+ "FROM product p "
				+ "LEFT JOIN display_info d ON p.id = d.product_id "
				+ "LEFT JOIN category c ON c.id = p.category_id "
				+ "LEFT JOIN display_info_image di ON di.display_info_id = d.id "
			+ "WHERE d.id = :displayId";
	
	
	public static final String SELECT_PRODUCT_IMAGES_BY_DISPLAY_ID = 
			"SELECT "
				+ "pi.product_id, pi.id, pi.type, pi.file_id, f.file_id, f.file_name, f.save_file_name, f.content_type, f.delete_flag, f.create_date, f.modify_date "
			+ "FROM product_image pi "
				+ "LEFT JOIN file_info f ON f.id = pi.file_id "
				+ "LEFT JOIN display_info d ON d.product_id = pi.product_id "
			+ "WHERE d.id = :displayId";
	
	public static final String SELECT_PRODUCT_PRICES_BY_DISPLAY_ID = 
			"SELECT "
				+ "pp.id, pp.product_id, pp.price_type_name, pp.price, pp.discount_rate, pp.create_date, pp.modify_date "
			+ "FROM product_price pp "
				+ "LEFT JOIN display_info d ON d.product_id = pp.product_id"
			+ "WHERE d.id = :displayId";
}
