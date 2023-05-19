package DAO;

import java.util.Collection;

import DTO.MemberDTO;

public interface IMemberDAO {
	public Collection<MemberDTO> selectAll();

	public MemberDTO selectEmail(String email);

	public void insert(MemberDTO member);

	public void update(MemberDTO member);

	public void delete(String email);
}
