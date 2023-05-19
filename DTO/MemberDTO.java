package DTO;

public class MemberDTO implements IMemberDTO {
	private String email;
	private String name;
	private String registerDate;

	@Override
	public void setEmail(String email) {
		this.email = email;

	}


	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public void setRegisterDate(String registerDate) {

		this.registerDate = registerDate;

	}

	@Override
	public String getEmail() {
		return email;
	}


	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getRegisterDate() {

		return registerDate;
	}

}
