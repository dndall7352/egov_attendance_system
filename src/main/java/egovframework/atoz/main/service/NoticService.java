package egovframework.atoz.main.service;

import java.util.List;

import egovframework.atoz.main.model.NoticDto;
import egovframework.atoz.main.model.NoticPagingDto;

public interface NoticService {
	List<NoticDto> readNoticList(NoticPagingDto pagingDto) throws Exception;
	int noticAllCnt(int com_number) throws Exception;
}
