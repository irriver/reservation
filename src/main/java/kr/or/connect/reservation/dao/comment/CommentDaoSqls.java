package kr.or.connect.reservation.dao.comment;

public class CommentDaoSqls {
	//displayId로 어떻게 평균값 구하나, productId 필요할 것 같은데?
	public static final String SELECT_AVERAGE_SCORE_BY_DISPLAY_ID = "SELECT AVG(score) FROM reservation_user_comment";
}
