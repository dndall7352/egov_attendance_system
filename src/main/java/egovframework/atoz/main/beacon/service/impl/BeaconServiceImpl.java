package egovframework.atoz.main.beacon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import egovframework.atoz.main.beacon.service.BeaconDTO;
import egovframework.atoz.main.beacon.service.BeaconService;
import egovframework.atoz.main.page.Criteria;

@Service("beaconService")
public class BeaconServiceImpl extends EgovAbstractServiceImpl implements BeaconService{
	@Resource(name = "beaconDAO")
	private BeaconDAO beaconDAO;
	
	@Override
	public List<BeaconDTO> selectBeaconList(Criteria cri) throws Exception {
		return beaconDAO.selectBeaconList(cri);
	}
	@Override
	public int selectBeaconListTotCnt(Criteria cri) throws Exception {
		return beaconDAO.selectBeaconListTotCnt(cri);
	}
	@Override
	public BeaconDTO selectBeacon(int beaconNumber) throws Exception {
		return beaconDAO.selectBeacon(beaconNumber);
	}
	@Override
	public String searchComNumber(int com_number) throws Exception {
		return beaconDAO.searchComNumber(com_number);
	}
	@Override
	public int updateBeacon(BeaconDTO dto) throws Exception {
		return beaconDAO.updateBeacon(dto);
	}
}
