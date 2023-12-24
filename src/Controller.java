import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Controller {
	
	private LogInPage login;
	private HomePage home;
	private UtenteDAO dao;
	private SignInPage signin;
	
	public Controller() {
		login=new LogInPage(this);
		home=new HomePage(this);
		dao=new UtenteDAO(this);
		signin=new SignInPage(this);
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
	public void showSignIn() {
		signin.setVisible(true);
	}
	public void hideSignIn() {
		signin.setVisible(false);
	}
	
	public boolean checkEmailPasswordNotEmpty(String _email, String _password) throws EmailFieldEmptyException, PasswordFieldEmptyException {
		
		if(_email.isEmpty()) {
			throw new EmailFieldEmptyException();
		} else if(_password.isEmpty()) {
			throw new PasswordFieldEmptyException();
		} else {
			return true;
		}
		
		
	}
	
	public void checkLogIn(String _email, String _password) throws EmailFieldEmptyException, PasswordFieldEmptyException, AccountNonExistentException, SQLException {

		checkEmailPasswordNotEmpty(_email, _password);
			
		dao.startConnection();
			
		try {
			if(dao.checkEmailPasswordinDB(_email, _password)) {
				hideLogIn();
				showHome();
			} else {
				throw new AccountNonExistentException();			
			}
			
		} catch (SQLException e) {
			throw e;		
		} catch (AccountNonExistentException ee) {
			throw ee;
		} finally {
			dao.stopConnection();
		}

	}
	
	public void signIn(String _email, String _password) throws EmailFieldEmptyException, PasswordFieldEmptyException, SQLException {
		
		checkEmailPasswordNotEmpty(_email, _password);
		
		dao.startConnection();
			
		try {
			if(!dao.checkEmailPasswordinDB(_email, _password)) {
				dao.signInNewAccount(_email, _password);
			} else {
				JOptionPane.showMessageDialog(null, "Account già registrato", "Account esistente", JOptionPane.INFORMATION_MESSAGE);			
			}
			
		} catch (SQLException e) {
			throw e;
		} finally {
			dao.stopConnection();
		}
	
	}
}
