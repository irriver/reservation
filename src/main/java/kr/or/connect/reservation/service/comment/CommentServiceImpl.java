package kr.or.connect.reservation.service.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.comment.CommentDao;
import kr.or.connect.reservation.dto.comment.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDao commentDao;
	
	@Override
	public int getAverageScoresByDisplayId(Integer displayId) {
		return commentDao.getAverageScoresByDisplayId(displayId);
	}

	@Override
	public List<Comment> selectAllCommentsByProductId(Integer productId, int start) {
		return commentDao.selectAllCommentsByProductId(productId, start);
	}

}
