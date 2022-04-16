package prat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Intrestgui extends JFrame {

	private JPanel wind;
	private JTextField tfbalance;
	private JTextField tfapr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intrestgui frame = new Intrestgui();
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
	public Intrestgui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 500);
		wind = new JPanel();
		wind.setBackground(new Color(240, 240, 240));
		wind.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(wind);
		wind.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel toppan = new JPanel();
		toppan.setBackground(new Color(171, 196, 255));
		wind.add(toppan);
		toppan.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel toplb = new JLabel("Weekly Intrest Calc.");
		toplb.setBackground(new Color(0, 255, 255));
		toplb.setFont(new Font("Tahoma", Font.BOLD, 20));
		toplb.setHorizontalAlignment(SwingConstants.CENTER);
		toppan.add(toplb);
		
		JTextArea txtrStartingCash = new JTextArea();
		txtrStartingCash.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrStartingCash.setLineWrap(true);
		txtrStartingCash.setBackground(new Color(193, 211, 254));
		txtrStartingCash.setText("Takes your starting cash & APR to show weekly gains");
		toppan.add(txtrStartingCash);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(193, 211, 254));
		toppan.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel startcashlb = new JLabel("Starting Cash:  $");
		startcashlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		startcashlb.setBounds(0, 0, 124, 31);
		panel_2.add(startcashlb);
		
		tfbalance = new JTextField();
		tfbalance.setBounds(127, 0, 86, 31);
		panel_2.add(tfbalance);
		tfbalance.setColumns(10);
		
		JPanel botpan = new JPanel();
		botpan.setBackground(new Color(193, 211, 254));
		wind.add(botpan);
		botpan.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Your Weekly Gains:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(42, 140, 202, 39);
		botpan.add(lblNewLabel_1_1);
		
		JLabel weeklylb = new JLabel("");
		weeklylb.setHorizontalAlignment(SwingConstants.CENTER);
		weeklylb.setFont(new Font("Tahoma", Font.BOLD, 15));
		weeklylb.setBounds(10, 175, 224, 39);
		botpan.add(weeklylb);
		
		tfapr = new JTextField();
		tfapr.setColumns(10);
		tfapr.setBounds(68, 0, 86, 31);
		botpan.add(tfapr);
		
		JButton calcbut = new JButton("Calculate");
		calcbut.setBackground(new Color	(237, 242, 251));
		calcbut.setFont(new Font("Tahoma", Font.BOLD, 14));
		calcbut.setBounds(66, 67, 107, 34);
		botpan.add(calcbut);
		calcbut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String balance = tfbalance.getText();
				double balanceint=Integer.parseInt(balance);
				String apr = tfapr.getText();
				double aprint=Integer.parseInt(apr);
				double weekly = 0.0;
				
				
				weekly = aprint / 100.00;
				weekly = weekly / 52.00;
				weekly = balanceint * weekly;
				
				
				
				
				lblNewLabel_1_1.setText("Your Weekly Gains:");
				weeklylb.setText("$ " + Math.round(weekly*100.0)/100.0);

			}
		});
			
		
		
		JLabel aprlb = new JLabel("APR:  %");
		aprlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		aprlb.setBounds(0, 0, 69, 31);
		botpan.add(aprlb);
		
	}
}
