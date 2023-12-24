import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class HomePage extends JFrame {
	
	private Controller controller;
	
	public HomePage(Controller _controller) {
		
		controller=_controller;
		setTitle("Home Page");
		ImageIcon a = new ImageIcon("risorse/HomePageIcon.png");
		setIconImage(a.getImage());
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//----------------------------------------------
		
		
		JLabel lblNewLabel = new JLabel("Complimenti hai raggiunto la Home Page");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Torna indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.hideHome();
				controller.showLogIn();
				
			}
		});
		panel.add(btnNewButton);
	}

}
