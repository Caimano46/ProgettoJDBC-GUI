
public class Controller {
	
	LogInPage login;
	
	public Controller() {
		login=new LogInPage(this);
	}
	
	public void showLogIn() {
		login.setVisible(true);
	}
	public void hideLogIn() {
		login.setVisible(false);
	}
}
