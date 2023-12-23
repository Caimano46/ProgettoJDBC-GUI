import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Controller {
	
	private LogInPage login;
	private HomePage home;
	private UtenteDAO dao;
	
	public Controller() {
		login=new LogInPage(this);
		home=new HomePage(this);
		dao=new UtenteDAO(this);
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
	
	
	//DA AGGIUSTARE!!!!
	
	public void checkLogIn(String _email, String _password) throws EmailFieldEmptyException, PasswordFieldEmptyException, AccountNonExistentException {
		
		try {
			dao.startConnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Non è stato possibile collegarsi con il Database", "Errore di connesione", JOptionPane.WARNING_MESSAGE);
		}
		
		if(_email.isEmpty()) {
			throw new EmailFieldEmptyException();
		} else if(_password.isEmpty()) {
			throw new PasswordFieldEmptyException();
		} else {
			
			
			
			try {
				if(dao.checkEmailPasswordinDB(_email, _password)) {
					hideLogIn();
					showHome();
				} else {
					throw new AccountNonExistentException();
						
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Errore nel Database", "DataBase error", JOptionPane.WARNING_MESSAGE);
				
			} catch (AccountNonExistentException e) {
				throw e;
			}
			
		}
		
		try {
			dao.stopConnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Non è stato possibile scollegarsi dal il Database", "Errore di connesione", JOptionPane.WARNING_MESSAGE);

		}
		
		
		
	}
	
}
