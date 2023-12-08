package egovframework.atoz.mobile.dao;

import java.util.List;

import egovframework.atoz.mobile.model.NoticDto;
import egovframework.atoz.mobile.model.NoticPagingDto;

public interface NoticDao {
	List<NoticDto> readNoticList(NoticPagingDto pagingDto) throws Exception;
	int noticAllCnt(int com_number) throws Exception;
}

