package kr.or.connect.reservation.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.comment.CommentDao;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDao commentDao;
	
	@Override
	public int getAverageScoresByDisplayId(Integer displayId) {
		return commentDao.getAverageScoresByDisplayId(displayId);
	}

}
