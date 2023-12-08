package egovframework.atoz.main.beacon.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.beacon.service.BeaconDTO;
import egovframework.atoz.main.beacon.service.BeaconDefaultVO;

@Repository("beaconDAO")
public class BeaconDAO {
	@Autowired
	SqlSession sqlSession;
	
	public List<BeaconDTO> selectBeaconList(BeaconDefaultVO searchVO) throws Exception{
		BeaconMapper mapper = sqlSession.getMapper(BeaconMapper.class);
		return mapper.selectBeaconList(searchVO);
	}
	public int selectBeaconListTotCnt(BeaconDefaultVO searchVO) throws Exception{
		BeaconMapper mapper = sqlSession.getMapper(BeaconMapper.class);
		return mapper.selectBeaconListTotCnt(searchVO);
	}
}
