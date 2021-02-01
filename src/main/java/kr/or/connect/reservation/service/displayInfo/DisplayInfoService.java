package kr.or.connect.reservation.service.displayInfo;

import java.util.List;

import kr.or.connect.reservation.dto.displayInfo.DisplayInfoImage;

public interface DisplayInfoService {

	public int countAll();

	public int countByCategoryId(Integer categoryId);

	public List<DisplayInfoImage> selectDisplayInfoImages(Integer displayId);

}
