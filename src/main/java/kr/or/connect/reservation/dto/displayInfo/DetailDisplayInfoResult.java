package kr.or.connect.reservation.dto.displayInfo;

import java.util.List;

import kr.or.connect.reservation.dto.product.Product;
import kr.or.connect.reservation.dto.product.ProductImage;
import kr.or.connect.reservation.dto.product.ProductPrice;

public class DetailDisplayInfoResult {
	private Product product;
	private List<ProductImage> productImages;
	private List<DisplayInfoImage> displayInfoImages;
	private int avgScore;
	private List<ProductPrice> productPrices;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<ProductImage> getProductImages() {
		return productImages;
	}
	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}
	public List<DisplayInfoImage> getDisplayInfoImages() {
		return displayInfoImages;
	}
	public void setDisplayInfoImages(List<DisplayInfoImage> displayInfoImages) {
		this.displayInfoImages = displayInfoImages;
	}
	public int getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(int avgScore) {
		this.avgScore = avgScore;
	}
	public List<ProductPrice> getProductPrices() {
		return productPrices;
	}
	public void setProductPrices(List<ProductPrice> productPrices) {
		this.productPrices = productPrices;
	}
}
