import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SignInPage extends JFrame{

	
	private JTextField textField;
	private JPasswordField passwordField;
	private Controller controller;
	
	public SignInPage(Controller _controller) {
		
		controller=_controller;
		setSize(500, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Sign In");
		ImageIcon a=new ImageIcon("risorse/LogIn-SignInIcon.png");
		setIconImage(a.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//-----------------------------------
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton pulsanteAnnulla = new JButton("Torna indietro");
		pulsanteAnnulla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.hideSignIn();
				controller.showLogIn();
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Hai già un account? ");
		panel.add(lblNewLabel_3);
		panel.add(pulsanteAnnulla);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Inserisci i dati per il Sign In:");
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 171, 184, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 50, 50, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		panel_2.add(passwordField, gbc_passwordField);
		
		
		JButton pulsanteInserisci = new JButton("Iscriviti");
		GridBagConstraints gbc_pulsanteInserisci = new GridBagConstraints();
		gbc_pulsanteInserisci.insets = new Insets(0, 0, 0, 5);
		gbc_pulsanteInserisci.gridx = 2;
		gbc_pulsanteInserisci.gridy = 3;
		panel_2.add(pulsanteInserisci, gbc_pulsanteInserisci);
		pulsanteInserisci.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				
				String email = textField.getText();
				char[] passwordChar = passwordField.getPassword();
				String password = new String(passwordChar);
				
				try {
					controller.signIn(email, password);
					
				} catch (EmailFieldEmptyException e) {
					JOptionPane.showMessageDialog(null, "Attenzione il campo E-mail è vuoto", "Attenzione", JOptionPane.INFORMATION_MESSAGE);
				} catch (PasswordFieldEmptyException e) {
					JOptionPane.showMessageDialog(null, "Attenzione il campo Password è vuoto", "Attenzione", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Errore nel Database (ResultSet)", "DataBase error", JOptionPane.WARNING_MESSAGE);
				}
			
				
			}
		});
	}
	
	
}
