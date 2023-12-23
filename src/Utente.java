
public class Utente {
	
	
	private String email;
	private String password;
	
	
	public Utente(String _email, String _password) {
		if(!_email.isEmpty()) {
			email=_email;
		}
		if(!_password.isEmpty()) {
			password=_password;
		}
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
