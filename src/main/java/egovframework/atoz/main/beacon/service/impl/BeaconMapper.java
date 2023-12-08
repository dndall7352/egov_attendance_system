package egovframework.atoz.main.beacon.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.atoz.main.beacon.service.BeaconDTO;
import egovframework.atoz.main.beacon.service.BeaconDefaultVO;

@Mapper("beaconMapper")
public interface BeaconMapper {
	List<BeaconDTO> selectBeaconList(BeaconDefaultVO searchVO) throws Exception;
	int selectBeaconListTotCnt(BeaconDefaultVO searchVO) throws Exception;
}
