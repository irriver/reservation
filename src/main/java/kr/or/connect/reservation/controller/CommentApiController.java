package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.comment.Comment;
import kr.or.connect.reservation.dto.comment.CommentResult;
import kr.or.connect.reservation.service.comment.CommentService;

@RestController
@RequestMapping(path = "/api/comments")
public class CommentApiController {
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/{productId}")
	public CommentResult getComments(
			@RequestParam(name = "productId", required = false) Integer productId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {
		CommentResult result = new CommentResult();
		
		List<Comment> comments = commentService.selectAllCommentsByProductId(productId, start);
		result.setTotalCount(comments.size());
		result.setCommentCount(start);	//상품의 댓글은 최대 5개까지 읽어온다. commentCount는 읽어온 댓글 수
		result.setReservationUserComments(comments);
		
		return result;
	}
}
