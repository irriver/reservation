package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.promotion.Promotion;
import kr.or.connect.reservation.dto.promotion.PromotionResult;
import kr.or.connect.reservation.service.promotion.PromotionService;

@RestController
@RequestMapping(path = "/api/promotions")
public class PromotionApiController {

	@Autowired
	private PromotionService promotionService;
	
	@GetMapping
	public PromotionResult getPromotions() {
		PromotionResult result = new PromotionResult();
		
		List<Promotion> list = promotionService.selectAll();
		result.setSize(list.size());
		result.setItems(list);
		
		return result;
	}
}
