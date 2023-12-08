package egovframework.atoz.mobile.mapper;

import java.util.List;

import egovframework.atoz.mobile.model.NoticDto;
import egovframework.atoz.mobile.model.NoticPagingDto;

public interface NoticMapper {
	List<NoticDto> readNoticList(NoticPagingDto pagingDto) throws Exception;
	int noticAllCnt(int com_number) throws Exception;
}
