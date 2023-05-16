package mon.projet.pharmacy.Gestionpharmacie.dto;

public class UserRegistrationDto {

	//@NotEmpty(message = "Email name can't be empty!")
	//@Email(message = "*Please provide a valid Email")
	private String userName;

	//@Length(min = 5, message = "*Your password must have at least 5 characters")
	//@NotEmpty(message = "*Please provide your password")
	private String password;

	public UserRegistrationDto(){
	}
	
	public UserRegistrationDto(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String email) {
		this.userName = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
