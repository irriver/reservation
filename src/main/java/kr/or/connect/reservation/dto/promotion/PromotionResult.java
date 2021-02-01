package kr.or.connect.reservation.dto.promotion;

import java.util.List;

public class PromotionResult {
	private int size;
	private List<Promotion> items;
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<Promotion> getItems() {
		return items;
	}
	public void setItems(List<Promotion> items) {
		this.items = items;
	}
}
