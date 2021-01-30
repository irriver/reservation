package kr.or.connect.reservation.dto.displayInfo;

import java.util.List;

import kr.or.connect.reservation.dto.product.Product;

public class DisplayInfoResult {
	private int totalCount;
	private int productCount;
	private List<Product> products;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
