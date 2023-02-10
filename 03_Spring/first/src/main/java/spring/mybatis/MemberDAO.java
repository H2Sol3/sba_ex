package spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository("memberdao")
public class MemberDAO {
	@Autowired
	SqlSession session;

	public List<MemberDTO> memberlist() {
		return session.selectList("member.memberlist");
	}
	
	public int membercount() {
		return session.selectOne("member.membercount");	
	}
	
	public MemberDTO onemember(String id) {
		return session.selectOne("member.onemember", id);
	} 
	
	public List<MemberDTO> paginglist(int[] limit){
		return session.selectList("member.paginglist",limit);
	}
	
	public int insertmember(MemberDTO dto) {
		return session.insert("member.insertmember", dto);
	}

	public int updatemember(MemberDTO updatedto) {
		return session.update("member.updatemember",updatedto);
	}
	
	public int updatemember2(MemberDTO dto) {
		return session.update("member.updatemember2",dto);
	}
	
	public int deletemember(String id) {
		return session.delete("member.deletemember",id);
	}

	public List<MemberDTO> searchmember(HashMap map) {
		return session.selectList("searchmember", map);
	}

	public List<MemberDTO> addresssearch(ArrayList<String> addresslist){
		return session.selectList("addresssearch", addresslist);
	}

	public List<MemberDTO> combination(MemberDTO dto) {
		return session.selectList("combination",dto); //name, email 모두 있는 상태
	}
	
	public List<HashMap<String,String>> memberboard(String writer){
		return session.selectList("memberboard",writer);
	}

	public void deleteBoard(List<HashMap<String, String>> boardlist2) {
		session.delete("deleteBoard",boardlist2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
