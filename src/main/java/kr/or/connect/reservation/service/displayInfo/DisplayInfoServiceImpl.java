package kr.or.connect.reservation.service.displayInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.displayInfo.DisplayInfoDao;
import kr.or.connect.reservation.dto.displayInfo.DisplayInfoImage;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService {

	@Autowired
	DisplayInfoDao displayInfoDao;
	
	@Override
	public int countAll() {
		return displayInfoDao.countAll();
	}

	@Override
	public int countByCategoryId(Integer categoryId) {
		return displayInfoDao.countByCategoryId(categoryId);
	}

	@Override
	public List<DisplayInfoImage> selectDisplayInfoImages(Integer displayId) {
		return displayInfoDao.selectDisplayInfoImages(displayId);
	}

}
