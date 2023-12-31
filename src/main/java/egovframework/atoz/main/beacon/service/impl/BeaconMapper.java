package egovframework.atoz.main.beacon.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.atoz.main.beacon.service.BeaconDTO;
import egovframework.atoz.main.beacon.service.SearchCompanyDTO;
import egovframework.atoz.main.page.Criteria;

@Mapper("beaconMapper")
public interface BeaconMapper {
	List<BeaconDTO> selectBeaconList(Criteria cri) throws Exception;
	int selectBeaconListTotCnt(Criteria cri) throws Exception;
	BeaconDTO selectBeacon(int beaconNumber) throws Exception;
	List<SearchCompanyDTO> searchCompany(Map<String, String> searchData) throws Exception;
	int updateBeacon(BeaconDTO dto) throws Exception;
	int insertBeacon(BeaconDTO dto) throws Exception;
	List<BeaconDTO> printBeacon(Criteria cri) throws Exception;
	List<SearchCompanyDTO> searchCompanyList()throws Exception;
}
