package egovframework.atoz.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.atoz.main.dao.NoticDao;
import egovframework.atoz.main.model.NoticDto;
import egovframework.atoz.main.model.NoticPagingDto;
import egovframework.atoz.main.service.NoticService;

@Service
public class NoticServiceImpl implements NoticService{
	@Autowired
	NoticDao noticDao;
	
	@Override
	public List<NoticDto> readNoticList(NoticPagingDto pagingDto) throws Exception {
		return noticDao.readNoticList(pagingDto);
	}
	
	@Override
	public int noticAllCnt(int com_number) throws Exception {
		return noticDao.noticAllCnt(com_number);
	}
}
