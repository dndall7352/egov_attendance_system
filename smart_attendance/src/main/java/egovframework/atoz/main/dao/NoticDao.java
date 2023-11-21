package egovframework.atoz.main.dao;

import java.util.List;

import egovframework.atoz.main.model.NoticDto;
import egovframework.atoz.main.model.NoticPagingDto;

public interface NoticDao {
	List<NoticDto> readNoticList(NoticPagingDto pagingDto) throws Exception;
	int noticAllCnt(int com_number) throws Exception;
}

