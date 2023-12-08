package egovframework.atoz.mobile.service;

import java.util.List;

import egovframework.atoz.mobile.model.NoticDto;
import egovframework.atoz.mobile.model.NoticPagingDto;

public interface NoticService {
	List<NoticDto> readNoticList(NoticPagingDto pagingDto) throws Exception;
	int noticAllCnt(int com_number) throws Exception;
}
