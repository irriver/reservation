package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.category.Category;
import kr.or.connect.reservation.dto.category.CategoryResult;
import kr.or.connect.reservation.service.category.CategoryService;
/**
 * @version 1.0 25 Jan 2021
 * @author irriver
 * 
 * <응답결과>
 *  {
 *  	"size":5,
 *  	"items":[
 *  		{
 *  			"id":1,
 *  			"name":"전시",
 *  			"count":10
 *  		}
 *  	]
 *  }
 *  
 *  Category 타입의 '리스트'를 반환하는 것은 간단.
 *  그런데 size, items은 어떻게 한담?
 *  
 *  따로 Result용 dto를 만드는 것이 좋을지, 메소드 내부에서 '리스트 사이즈'를 구해서 쓰는 게 좋을지?
 */
@RestController
@RequestMapping(path = "/api/categories")
public class CategoryApiController {

	@Autowired
	private CategoryService catergoryService;
	
	@GetMapping
	public CategoryResult getCategories() {
		CategoryResult result = new CategoryResult();
		
		List<Category> list = catergoryService.selectAll();
		result.setSize(list.size());
		result.setItems(list);
		
		return result;
	}
}
