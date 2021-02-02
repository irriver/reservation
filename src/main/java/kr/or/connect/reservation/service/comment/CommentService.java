package kr.or.connect.reservation.service.comment;

import java.util.List;

import kr.or.connect.reservation.dto.comment.Comment;

public interface CommentService {

	public int getAverageScoresByDisplayId(Integer displayId);

	public List<Comment> selectAllCommentsByProductId(Integer productId, int start);

}
