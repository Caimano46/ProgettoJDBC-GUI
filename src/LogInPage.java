import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LogInPage extends JFrame {
	
	
	private JTextField textField;
	private JPasswordField passwordField;
	private Controller controller;
	
	public LogInPage(Controller _controller) {
		
		controller=_controller;
		setSize(500, 350);
		setLocationRelativeTo(null);
		setResizable(true);
		setTitle("Log In");
		ImageIcon a=new ImageIcon("risorse/LogInIcon.png");
		setIconImage(a.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//-----------------------------------
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton pulsanteAnnulla = new JButton("Annulla");
		pulsanteAnnulla.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(pulsanteAnnulla);
		
		
		JButton pulsanteInserisci = new JButton("Inserisci");
		pulsanteInserisci.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				
				String email=textField.getText();
				char[] charPassword=passwordField.getPassword();
				String passwordstr=new String(charPassword); // Corretta conversione
				
				
				
				try {
						controller.checkLogIn(email, passwordstr);
						controller.hideLogIn();
						controller.showHome();
					
				} catch (EmailFieldEmptyException e) {
					JOptionPane.showMessageDialog(null, "Attenzione il campo E-mail è vuoto", "Attenzione", JOptionPane.WARNING_MESSAGE);
				} catch (PasswordFieldEmptyException ee) {
					JOptionPane.showMessageDialog(null, "Attenzione il campo Password è vuoto", "Attenzione", JOptionPane.WARNING_MESSAGE);
				} catch (AccountNonExistentException eee) {
					JOptionPane.showMessageDialog(null, "Account inesistente", "Errore", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(pulsanteInserisci);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Inserisci i dati per il log in");
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
	}

}
