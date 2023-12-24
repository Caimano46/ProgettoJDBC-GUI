import java.sql.*;

import javax.swing.JOptionPane;

public class UtenteDAO {
	
	private Controller controller;
	private Connection connessione;
	
	public UtenteDAO(Controller _controller) {
		controller=_controller;
	}
	
	public void startConnection() {
		
		try {
			Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "110502");
			connessione=conn;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Non è stato possibile collegarsi con il Database", "Errore di connesione", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public void stopConnection() {
		
		try {
			connessione.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Non è stato possibile scollegarsi dal il Database", "Errore di connesione", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public boolean checkEmailPasswordinDB(String _email, String _password) throws SQLException  {
		
		String query="SELECT 1 FROM programma.Utente WHERE email = ? AND password = ?";
		
		PreparedStatement st;
		ResultSet rs = null;
		
		try {
			st = connessione.prepareStatement(query);
			st.setString(1, _email);
			st.setString(2, _password);
		
			rs = st.executeQuery();
		
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Errore nel Database", "DataBase error", JOptionPane.WARNING_MESSAGE);
		}
		
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
			
	}
	
	public void signInNewAccount(String _email, String _password) {
		
		String query = "INSERT INTO programma.Utente (email, password) VALUES (?, ?)";
		
		try {
			PreparedStatement st = connessione.prepareStatement(query);
			st.setString(1, _email);
			st.setString(2, _password);
			
			st.executeUpdate();
			JOptionPane.showMessageDialog(null, "Accout creato con successo", "GG", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Impossibile creare accout", "Errore", JOptionPane.ERROR_MESSAGE);
			
		}
	}
}
