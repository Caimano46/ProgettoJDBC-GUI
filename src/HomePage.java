import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class HomePage extends JFrame {
	
	private Controller controller;
	
	public HomePage(Controller _controller) {
		
		controller=_controller;
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//----------------------------------------------
		
		
		JLabel lblNewLabel = new JLabel("Complimenti hai raggiunto la Home Page");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
	}

}
