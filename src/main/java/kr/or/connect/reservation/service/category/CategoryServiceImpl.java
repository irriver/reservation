package kr.or.connect.reservation.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.category.CategoryDao;
import kr.or.connect.reservation.dto.category.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;

	@Override
	public List<Category> selectAll() {
		return categoryDao.selectAll();
	}

}
