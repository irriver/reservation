package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.displayInfo.DisplayInfoResult;
import kr.or.connect.reservation.dto.product.Product;
import kr.or.connect.reservation.service.displayInfo.DisplayInfoService;
import kr.or.connect.reservation.service.product.ProductService;

@RestController
@RequestMapping(path = "/api/displayinfos")
public class DisplayInfoApiController {
	@Autowired
	private DisplayInfoService displayInfoService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public DisplayInfoResult getDisplayInfos(
			@RequestParam(name = "categoryId", required = false, defaultValue = "0") Integer categoryId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {
		DisplayInfoResult displayInfoResult = new DisplayInfoResult();
		List<Product> products;
		
		if (categoryId == 0 || categoryId == null) {
			// 전체조회
			products = productService.selectAll(start);
			
			displayInfoResult.setTotalCount(displayInfoService.countAll());
			displayInfoResult.setProductCount(products.size());
			displayInfoResult.setProducts(products);
		} else {
			// categoryId를 조건으로 조회
			products = productService.selectByCategoryId(categoryId, start);
			
			displayInfoResult.setTotalCount(displayInfoService.countByCategoryId(categoryId));
			displayInfoResult.setProductCount(products.size());
			displayInfoResult.setProducts(products);
		}
		return displayInfoResult;
	}
}
