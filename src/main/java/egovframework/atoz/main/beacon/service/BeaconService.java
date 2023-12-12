package egovframework.atoz.main.beacon.service;

import java.util.List;

import egovframework.atoz.main.page.Criteria;

public interface BeaconService {
	List<BeaconDTO> selectBeaconList(Criteria cri) throws Exception;
	int selectBeaconListTotCnt(Criteria cri) throws Exception;
	BeaconDTO selectBeacon(int beaconNumber) throws Exception;
	
}
