package Service;

import DAO.MemberDAO;
import DTO.MemberDTO;
import DTO.RegisterRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberRegisterService {
	private MemberDAO memberDao;

	public MemberRegisterService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public void regist(RegisterRequest req) {
		if (req.getEmail().equals(req.getEmail()) == false) {
			System.out.println("이메일이 다릅니다.");
			return;
		}

		MemberDTO check = memberDao.selectEmail(req.getEmail());
		if (check == null) {
			MemberDTO member = new MemberDTO();
			member.setEmail(req.getEmail());
			member.setName(req.getName());

			Date day = new Date();
			SimpleDateFormat fDay = new SimpleDateFormat("yyyy년 MM월 dd일 E요일, hh:mm:ss");
			String sfDay = fDay.format(day);
			member.setRegisterDate(sfDay);

			memberDao.insert(member);
			System.out.println(req.getEmail() + " 이메일 등록이 완료 되었습니다.");

		} else
			System.out.println(req.getEmail() + "는/은 이미 등록된 이메일입니다.");
		System.out.println();
	}

}
