package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("boardservice")
	BoardService service;

	@RequestMapping("/boardlist")
	public ModelAndView boardlist(@RequestParam(value="page", required = false, defaultValue = "1")int page) {
		// 몇페이지로 구성할걸ㄴ지 선택 가능 보여주는 링크
//		1.select count(*) from board-int-model 저장
//		2. select * from board limit(page-1)*3,3 - list- model저장
//		3. board/

		int totalboard = service.getTotalBoard();
		int limit = (page - 1) * 3;
		List<BoardDTO> list = service.getBoardList(limit);

		ModelAndView mv = new ModelAndView();
		mv.addObject("totalboard", totalboard);
		mv.addObject("list", list);
		mv.setViewName("board/list");
		return mv;
	}

	@RequestMapping("/oneboard")
	public ModelAndView oneboard(int seq) {
		ModelAndView mv = new ModelAndView();
		BoardDTO dto = service.getOneBoard(seq); 
		int cnt = service.updateViewCount(seq);
		mv.addObject("oneboard",dto);
		mv.addObject("cnt",cnt);
		mv.setViewName("board/oneboard");
		return mv;
	}
	
	
}
