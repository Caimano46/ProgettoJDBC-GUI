
public class Controller {
	
	private LogInPage login;
	private HomePage home;
	
	public Controller() {
		login=new LogInPage(this);
		home=new HomePage(this);
	}
	
	public void showLogIn() {
		login.setVisible(true);
	}
	public void hideLogIn() {
		login.setVisible(false);
	}
	public void showHome() {
		home.setVisible(true);
	}
	public void hideHome() {
		home.setVisible(false);
	}
	
	public boolean checkLogIn(String _email, String _password) throws EmailFieldEmptyException, PasswordFieldEmptyException {
			
			if(_password.isEmpty()) {
				throw new PasswordFieldEmptyException();
			} else if(_email.isEmpty()) {
				throw new EmailFieldEmptyException();
			} else {
				return true;
			}
	}
	
	
	
}
