package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.displayInfo.DetailDisplayInfoResult;
import kr.or.connect.reservation.dto.displayInfo.DisplayInfoImage;
import kr.or.connect.reservation.dto.displayInfo.DisplayInfoResult;
import kr.or.connect.reservation.dto.product.Product;
import kr.or.connect.reservation.dto.product.ProductImage;
import kr.or.connect.reservation.dto.product.ProductPrice;
import kr.or.connect.reservation.service.displayInfo.DisplayInfoService;
import kr.or.connect.reservation.service.product.ProductService;
import kr.or.connect.reservation.service.comment.CommentService;

@RestController
@RequestMapping(path = "/api/displayinfos")
public class DisplayInfoApiController {
	@Autowired
	private DisplayInfoService displayInfoService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CommentService commentService;
	
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
	
/*		[상세보기 페이지]
		product : 상품정보
		productImages : 상품 이미지 정보들
		displayInfoImages : 전시 이미지 정보들
		avgScore : 댓글 점수의 평균 (int값)
		productPrices : 상품 가격 정보들
*/
	@GetMapping("/{displayId}")
	public DetailDisplayInfoResult getDetailedDisplayInfos(@PathVariable("displayId") Integer displayId) {
		DetailDisplayInfoResult result = new DetailDisplayInfoResult();
		
		Product product = productService.selectByDisplayId(displayId);
		List<ProductImage> productImages = productService.getProductImages(displayId);
		List<DisplayInfoImage> displayInfoImages = displayInfoService.getDisplayInfoImages(displayId);
		int avgScore = commentService.getAverageScoresByDisplayId(displayId);
		List<ProductPrice> productPrices = productService.getProductPrices(displayId);
		
		result.setProduct(product);
		result.setProductImages(productImages);
		result.setDisplayInfoImages(displayInfoImages);
		result.setAvgScore(avgScore);
		result.setProductPrices(productPrices);
		
		return result;
	}
	
}
