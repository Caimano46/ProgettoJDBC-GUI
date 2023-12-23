import java.sql.*;

public class UtenteDAO {
	
	private Controller controller;
	private Connection connessione;
	
	public UtenteDAO(Controller _controller) {
		controller=_controller;
	}
	
	public void startConnection() throws SQLException {
		Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "110502");
		
		connessione=conn;
		
	}
	
	public void stopConnection() throws SQLException {
		connessione.close();
	}
	
	public boolean checkEmailPasswordinDB(String _email, String _password) throws SQLException {
		
		String query="SELECT 1 FROM programma.Utente WHERE email = ? AND password = ?";
		
		PreparedStatement st = connessione.prepareStatement(query);
		st.setString(1, _email);
		st.setString(2, _password);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
			
	}
}
