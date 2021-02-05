package kr.or.connect.reservation.dao.displayInfo;

public class DisplayInfoDaoSqls {
	//이렇게 만들면 DisplayInfoResult 타입의 데이터가 나오는데?
	
	//totalCount(without categoryId)
	public static final String COUNT_ALL = "SELECT count(*) FROM display_info";
	
	//productCount(with categoryId), categoryId 는 product 테이블이 가지고 있음
	public static final String COUNT_BY_CATEGORY_ID = "SELECT count(*) "
													+ "FROM display_info d "
														+ "LEFT JOIN product p ON d.product_id = p.id "
													+ "WHERE p.category_id = :categoryId";
	
	//카테코리 아이디별 전시상품 목록을 추출하는 products

	public static final String SELECT_DISPLAY_IMAGES_BY_DISPLAY_ID = 
			"SELECT "
					+ "di.id, di.display_info_id, di.file_id, f.file_name, f.save_file_name, f.content_type, f.delete_flag, f.create_date, f.modify_date "
			+ "FROM display_info_image di "
				+ "LEFT JOIN file_info f ON f.id = di.file_id "
			+ "WHERE di.display_info_id = :displayId";
}
