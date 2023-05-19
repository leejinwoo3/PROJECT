package DTO;

public class RegisterRequest implements IRegisterRequest {

	private String email;
	private String name;
	private String cofirmPassword;

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String getName() {
		return this.name;
	}



	@Override
	public void setEmail(String email) {

		this.email = email;

	}

	@Override
	public void setName(String name) {

		this.name = name;

	}

	public String getCofirmPassword() {
		return cofirmPassword;
	}

	public void setCofirmPassword(String cofirmPassword) {
		this.cofirmPassword = cofirmPassword;
	}


}
