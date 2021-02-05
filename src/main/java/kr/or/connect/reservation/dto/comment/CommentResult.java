/*
 * created Feb-02-21
 * author @irriver
 * 
 * 클래스 DisplayInfoApiController 의 @GetMapping getComments()가 사용할 응답 결과
 * 
 */
package kr.or.connect.reservation.dto.comment;

import java.util.List;

public class CommentResult {
	private int totalCount;
	private int commentCount;
	private List<Comment> reservationUserComments;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public List<Comment> getReservationUserComments() {
		return reservationUserComments;
	}
	public void setReservationUserComments(List<Comment> reservationUserComments) {
		this.reservationUserComments = reservationUserComments;
	}
}
