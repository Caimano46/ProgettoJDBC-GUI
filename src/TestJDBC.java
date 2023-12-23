import java.sql.*;;

public class TestJDBC {
	
//	public static void main(String[] args) {
//       
//		String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
//        String username = "postgres";
//        String password = "110502";
//
//        try {
//        	// Stabilisci la connessione
//            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
//
//            if (conn != null) {
//                String query = "SELECT * FROM programma.Utente";
//                PreparedStatement st= conn.prepareStatement(query);
//                ResultSet rs= st.executeQuery();
//                
//                while(rs.next()) {
//                	String temp1=rs.getString("email");
//                	String temp2=rs.getString("password");
//                	
//                	System.out.println(temp1+" "+temp2);
//                }
//                rs.close();
//                conn.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
	
}
