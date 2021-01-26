package kr.or.connect.reservation.dto.category;

import java.util.List;

public class CategoryResult {
	private int size;
	private List<Category> items;
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<Category> getItems() {
		return items;
	}
	public void setItems(List<Category> items) {
		this.items = items;
	}
}
