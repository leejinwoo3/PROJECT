package Service;

import DAO.MemberDAO;
import DTO.MemberDTO;
import java.util.Collection;

public class MemberAllService {
	private MemberDAO memberDao;

//그 생성자인 memberDao를 각각 넣어줌.
	public MemberAllService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public void selectAll() {
		// MemberDAO 객체 내부 selectAll() 호출 후 회원 모든 정보 출력.
		Collection<MemberDTO> members = memberDao.selectAll();
		if (members.isEmpty()) {
			System.out.println("등록된 정보가 없습니다.");
		} else {
			for (MemberDTO member : members) {
				System.out.println("이메일 : " + member.getEmail());
				System.out.println("이름 : " + member.getName());
				System.out.println("등록일 : " + member.getRegisterDate());
				System.out.println();
			}
		}
	}
}
