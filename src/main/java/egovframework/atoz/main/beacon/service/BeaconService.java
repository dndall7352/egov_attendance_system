package egovframework.atoz.main.beacon.service;

import java.util.List;

public interface BeaconService {
	List<BeaconDTO> selectBeaconList(BeaconDefaultVO searchVO) throws Exception;
	int selectBeaconListTotCnt(BeaconDefaultVO searchVO) throws Exception;
}
