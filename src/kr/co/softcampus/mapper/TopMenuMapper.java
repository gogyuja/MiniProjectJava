package kr.co.softcampus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.softcampus.beans.BoardInfoBean;

public interface TopMenuMapper {

	
	@Select("SELECT board_info_idx, board_info_name "+
			"FROM board_info_table "+
			"ORDER BY board_info_idx;")
	List<BoardInfoBean>getTopMenuList();
}
