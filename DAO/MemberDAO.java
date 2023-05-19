package DAO;

import java.util.Collection;
import DTO.MemberDTO;
import java.util.HashMap;

public class MemberDAO implements IMemberDAO {

	private HashMap<String, MemberDTO> members = new HashMap<>();

	@Override
	public void insert(MemberDTO member) {
		members.put(member.getEmail(), member);

	}

	@Override
	public MemberDTO selectEmail(String email) {
		return members.get(email);
	}

	@Override
	public void delete(String email) {
		members.remove(email);

	}

	@Override
	public Collection<MemberDTO> selectAll() {
		return members.values();
	}

	@Override
	public void update(MemberDTO member) {
		members.put(member.getEmail(), member);

	}
}