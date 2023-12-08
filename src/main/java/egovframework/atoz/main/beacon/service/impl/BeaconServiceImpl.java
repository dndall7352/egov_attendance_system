package egovframework.atoz.main.beacon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import egovframework.atoz.main.beacon.service.BeaconDTO;
import egovframework.atoz.main.beacon.service.BeaconDefaultVO;
import egovframework.atoz.main.beacon.service.BeaconService;

@Service("beaconService")
public class BeaconServiceImpl extends EgovAbstractServiceImpl implements BeaconService{
	@Resource(name = "beaconDAO")
	private BeaconDAO beaconDAO;
	
	@Override
	public List<BeaconDTO> selectBeaconList(BeaconDefaultVO searchVO) throws Exception {
		return beaconDAO.selectBeaconList(searchVO);
	}
	@Override
	public int selectBeaconListTotCnt(BeaconDefaultVO searchVO) throws Exception {
		return beaconDAO.selectBeaconListTotCnt(searchVO);
	}
}
