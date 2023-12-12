package egovframework.atoz.main.beacon.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.beacon.service.BeaconDTO;
import egovframework.atoz.main.beacon.service.BeaconDefaultVO;
import egovframework.atoz.main.page.Criteria;

@Repository("beaconDAO")
public class BeaconDAO {
	@Autowired
	SqlSession sqlSession;
	
	public List<BeaconDTO> selectBeaconList(Criteria cri) throws Exception{
		BeaconMapper mapper = sqlSession.getMapper(BeaconMapper.class);
		return mapper.selectBeaconList(cri);
	}
	public int selectBeaconListTotCnt(Criteria cri) throws Exception{
		BeaconMapper mapper = sqlSession.getMapper(BeaconMapper.class);
		return mapper.selectBeaconListTotCnt(cri);
	}
	public BeaconDTO selectBeacon(int beaconNumber) throws Exception{
		BeaconMapper mapper = sqlSession.getMapper(BeaconMapper.class);
		return mapper.selectBeacon(beaconNumber);
	}
}
