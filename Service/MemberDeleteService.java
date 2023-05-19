package Service;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class MemberDeleteService {
	private MemberDAO memberDao;

	public MemberDeleteService(MemberDAO memberDao) {
		// 그 생성자인 memberDao를 각각 넣어줌.
		this.memberDao = memberDao;
	}

	public void checkEmail(String email, String name  ) {
		// MemberDAO 객체 내 selectEmail() 메소드를 호출
		MemberDTO member = memberDao.selectEmail(email);
		if (member == null) {
			System.out.println(email + "는/은 등록되지 않은 계정입니다.");
		} else {
			// 패스워드 확인
			// 저장된 회원 정보와 입력된 회원 정보 검증
			if (name == null) {
				// MemberDAO 객체 내 delete() 호출
				memberDao.delete(email);
				System.out.println(email + "이메일이 삭제되었습니다.");
			} else {
				System.out.println("이름이 일치하지 않습니다.");
			}
		}

	}
}
