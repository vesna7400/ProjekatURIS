package smartConverter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtHexadecimal;
	private JTextField txtBinary;
	private JTextField txtDecimal;
	private JLabel lblNewLabel;
	private JTextField textField;
	String brojZaKonverziju = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{22, 176, 79, 141, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Cambria", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hexadecimal", "Binary", "Decimal"}));
		comboBox.setBackground(SystemColor.activeCaption);
		comboBox.setToolTipText("");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		contentPane.add(comboBox, gbc_comboBox);
		
		lblNewLabel = new JLabel("Enter number for conversion:");
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				brojZaKonverziju = textField.getText();
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(comboBox.getSelectedItem() == "Decimal") {
						try {
							int decimalniBroj = Integer.parseInt(brojZaKonverziju);
							txtDecimal.setText("" + decimalniBroj);
							if (decimalniBroj>=0) {
								String binarniBroj = Integer.toBinaryString(decimalniBroj);
								txtBinary.setText(binarniBroj);
								String heksadecimalniBroj = Integer.toHexString(decimalniBroj);
								txtHexadecimal.setText(heksadecimalniBroj);
							} else {
								String binarniBroj = "-" + Integer.toBinaryString(-decimalniBroj);
								txtBinary.setText(binarniBroj);
								String heksadecimalniBroj = "-" + Integer.toHexString(-decimalniBroj);
								txtHexadecimal.setText(heksadecimalniBroj);
							} 
						}
						catch (NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Morate uneti decimalni broj", "Los unos", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(comboBox.getSelectedItem() == "Binary") {
						try {
							String binarniBroj = brojZaKonverziju;
							txtBinary.setText(binarniBroj);
							if (Integer.parseInt(binarniBroj)>=0) {
								int decimalniBroj = Integer.parseInt(binarniBroj, 2);
								txtDecimal.setText("" + decimalniBroj);
								String heksadecimalniBroj = Integer.toHexString(decimalniBroj);
								txtHexadecimal.setText(heksadecimalniBroj);
							} else {
								int decimalniBroj = Integer.parseInt(binarniBroj, 2);
								txtDecimal.setText("" + decimalniBroj);
								String heksadecimalniBroj = "-" + Integer.toHexString(-decimalniBroj);
								txtHexadecimal.setText(heksadecimalniBroj);
							}
						}
						catch(NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Morate uneti binarni broj", "Los unos", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(comboBox.getSelectedItem() == "Hexadecimal") {
						try {
							String heksadecimalniBroj = brojZaKonverziju;
							txtHexadecimal.setText(heksadecimalniBroj);
							
							if(Integer.parseInt(heksadecimalniBroj, 16)>=0) {
								int decimalniBroj = Integer.parseInt(heksadecimalniBroj, 16);
								txtDecimal.setText("" + decimalniBroj);
								String binarniBroj = Integer.toBinaryString(decimalniBroj);
								txtBinary.setText(binarniBroj);
							} else {
								int decimalniBroj = Integer.parseInt(heksadecimalniBroj, 16);
								txtDecimal.setText("" + decimalniBroj);
								String binarniBroj = "-" + Integer.toBinaryString(-decimalniBroj);
								txtBinary.setText(binarniBroj);
							}
						}
						catch(NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Morate uneti heksadecimalni broj", "Los unos", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		txtHexadecimal = new JTextField();
		txtHexadecimal.setEditable(false);
		txtHexadecimal.setForeground(SystemColor.activeCaptionText);
		txtHexadecimal.setFont(new Font("Cambria", Font.PLAIN, 14));
		txtHexadecimal.setText("Hexadecimal");
		GridBagConstraints gbc_txtHexadecimal = new GridBagConstraints();
		gbc_txtHexadecimal.gridwidth = 3;
		gbc_txtHexadecimal.insets = new Insets(0, 0, 5, 5);
		gbc_txtHexadecimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHexadecimal.gridx = 1;
		gbc_txtHexadecimal.gridy = 3;
		contentPane.add(txtHexadecimal, gbc_txtHexadecimal);
		txtHexadecimal.setColumns(10);
		
		txtBinary = new JTextField();
		txtBinary.setEditable(false);
		txtBinary.setForeground(SystemColor.activeCaptionText);
		txtBinary.setFont(new Font("Cambria", Font.PLAIN, 14));
		txtBinary.setText("Binary");
		GridBagConstraints gbc_txtBinary = new GridBagConstraints();
		gbc_txtBinary.gridwidth = 3;
		gbc_txtBinary.insets = new Insets(0, 0, 5, 5);
		gbc_txtBinary.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBinary.gridx = 1;
		gbc_txtBinary.gridy = 4;
		contentPane.add(txtBinary, gbc_txtBinary);
		txtBinary.setColumns(10);
		
		txtDecimal = new JTextField();
		txtDecimal.setEditable(false);
		txtDecimal.setForeground(SystemColor.activeCaptionText);
		txtDecimal.setFont(new Font("Cambria", Font.PLAIN, 14));
		txtDecimal.setText("Decimal");
		GridBagConstraints gbc_txtDecimal = new GridBagConstraints();
		gbc_txtDecimal.gridwidth = 3;
		gbc_txtDecimal.insets = new Insets(0, 0, 5, 5);
		gbc_txtDecimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDecimal.gridx = 1;
		gbc_txtDecimal.gridy = 5;
		contentPane.add(txtDecimal, gbc_txtDecimal);
		txtDecimal.setColumns(10);	
	}

}
