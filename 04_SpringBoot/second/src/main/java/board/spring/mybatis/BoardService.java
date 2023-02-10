package board.spring.mybatis;

import java.util.List;

public interface BoardService {
	//게시물리스트 서비스
	int getTotalBoard();
	List<BoardDTO> getBoardList(int limit);
	BoardDTO getOneBoard(int seq);
	int updateViewCount(int seq);
}
