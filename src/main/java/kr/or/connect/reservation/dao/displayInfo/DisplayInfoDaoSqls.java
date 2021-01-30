package kr.or.connect.reservation.dao.displayInfo;

public class DisplayInfoDaoSqls {
	//이렇게 만들면 DisplayInfoResult 타입의 데이터가 나오는데?
	
	//totalCount(without categoryId)
	public static final String COUNT_ALL = "SELECT count(*) FROM display_info";
	
	//productCount(with categoryId)
	public static final String COUNT_BY_CATEGORY_ID = "SELECT count(*) FROM ";
	
	//카테코리 아이디별 전시상품 목록을 추출하는 products
	
}
