

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.JLabel;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JPopupMenu menu;
	JPopupMenu menu2;
	JMenuItem m1,m2,m3,m4;
	JTextArea textArea;
	ArrayList<Customer> customers = new ArrayList<Customer>();
	Personal personalCurrent;
	Business businessCurrent;
	Personal personalDeposit;
	Business businessDeposit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setTitle("Bank App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnCreateAccounts = new JButton("Create");
		btnCreateAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customers = new ArrayList<Customer>();
				System.out.println(customers.size());
				for(int i = 0; i<20; i++){
					if(i < 5){
						personalCurrent = new Personal("RamboLad"+i, "21 The Avenue, Vietnam" + i, "087123456" + i, "25/12/1990"+i, "8020865u"+i);
						personalCurrent.setAccount(new Current("0000000"+i, 67+i, 500.0D, -100.0D, false));
						customers.add(personalCurrent);
					} else if(i >= 5 && i < 10) {
						businessCurrent = new Business("Zebra Businessman"+i, "21 The Avenue, Vietnam" + i, "087123456" + i, "VAT0000"+i, true);
						businessCurrent.setAccount(new Current("0000000"+i, 67+i, 500.0D, -100.0D, false));
						customers.add(businessCurrent);
					} else if (i >= 10 && i < 15) {
						personalDeposit = new Personal("John Personalman"+i, "21 The Avenue, Vietnam" + i, "087123456" + i, "25/12/1990"+i, "8020865u"+i);
						personalDeposit.setAccount(new Deposit("0000000"+i, 7+i, 200.0D, 0.01D ));
						customers.add(personalDeposit);
					} 	else if (i >= 15) {
						businessDeposit = new Business("John Businessman"+i, "21 The Avenue, Vietnam" + i, "087123456" + i, "VAT0000"+i, true);
						businessDeposit.setAccount(new Deposit("0000000"+i, 7+i, 200.0D, 0.01D ));
						customers.add(businessDeposit);
					}
				}
			}
		});
		btnCreateAccounts.setBounds(8, 6, 161, 23);
		contentPane.add(btnCreateAccounts);
		
		JButton btnDisplayAccounts = new JButton("Display All");
		btnDisplayAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder builder = new StringBuilder();

				for(int i = 0; i<customers.size(); i++){
					
					builder.append(customers.get(i).customerType + ", " + customers.get(i).getAccount().accountType + ", " +customers.get(i).getName()+", " + customers.get(i).getAddress() + ", "
							+ customers.get(i).getPhoneNo() + ", "+ customers.get(i).getAccount().getAccountNo() + "\n");
				}
				String fullList = builder.toString();
				textArea.setText(fullList);
			}
		});
		btnDisplayAccounts.setBounds(218, 6, 161, 23);
		contentPane.add(btnDisplayAccounts);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchFor = textField.getText();
				StringBuilder builder = new StringBuilder();
				for(int i = 0; i<customers.size(); i++){	
					if(searchFor.equalsIgnoreCase(customers.get(i).getName())){
					builder.append(customers.get(i).customerType + ", " + customers.get(i).getAccount().accountType + ", " +customers.get(i).getName()+", " + customers.get(i).getAddress() + ", "
							+  customers.get(i).getAccount().getAccountNo() + "\n");
					String searchResult = builder.toString();
					textArea.setText(searchResult);
					break;
					}
					else{
						textArea.setText("Account not found");
					}
				}
			}
		});
		textField.setBounds(460, 7, 89, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Account List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(2, 76, 547, 345);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 531, 318);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnAccountType = new JButton("Select Account");
		btnAccountType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAccountType.setBounds(8, 42, 161, 23);
		contentPane.add(btnAccountType);
		
		menu=new JPopupMenu();
		m1=new JMenuItem("Deposit");
		m2=new JMenuItem("Current");
		menu.add(m1);
		menu.add(m2);	
		ActionListener a1=new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				showPopup(ae);
			}
		};
		btnAccountType.addActionListener(a1);
		ActionListener a2=new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				StringBuilder builder = new StringBuilder();

				for(int i = 0; i<customers.size(); i++){
					if(customers.get(i).getAccount().accountType == "Deposit"){
					builder.append(customers.get(i).customerType + ", " + customers.get(i).getAccount().accountType + ", " + customers.get(i).getName()+", " + customers.get(i).getAddress() + ", "
							+  customers.get(i).getAccount().getAccountNo() + "\n");
					}
				}
				String fullList = builder.toString();
				textArea.setText(fullList);
			}
		};
		m1.addActionListener(a2);
		ActionListener a3=new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				StringBuilder builder = new StringBuilder();

				for(int i = 0; i<customers.size(); i++){
					if(customers.get(i).getAccount().accountType == "Current"){
					builder.append(customers.get(i).customerType + ", " + customers.get(i).getAccount().accountType + ", " + customers.get(i).getName()+", " + customers.get(i).getAddress() + ", "
							+  customers.get(i).getAccount().getAccountNo() + "\n");
					}
				}
				String fullList = builder.toString();
				textArea.setText(fullList);
			}
		};
		m2.addActionListener(a3);
		JButton btnCustomer = new JButton("Select Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

			}
		});
		btnCustomer.setBounds(218, 42, 161, 23);
		contentPane.add(btnCustomer);
		menu2=new JPopupMenu();
		m3=new JMenuItem("Personal");
		m4=new JMenuItem("Business");
		menu2.add(m3);
		menu2.add(m4);
		ActionListener a4=new ActionListener(){
			public void actionPerformed(ActionEvent as)
			{
				showPopup2(as);
			}
		};
		btnCustomer.addActionListener(a4);
		ActionListener a5=new ActionListener() {
			public void actionPerformed(ActionEvent as) {
				StringBuilder builder = new StringBuilder();

				for(int i = 0; i<customers.size(); i++){
					if(customers.get(i).customerType == "Personal"){
					builder.append(customers.get(i).customerType + ", " +customers.get(i).getName()+", " + customers.get(i).getAddress() + ", "
							+  customers.get(i).getAccount().getAccountNo() + "\n");
					}
				}
				String fullList = builder.toString();
				textArea.setText(fullList);
			}
		};
		m3.addActionListener(a5);
		ActionListener a6=new ActionListener() {
			public void actionPerformed(ActionEvent as) {
				
				StringBuilder builder = new StringBuilder();

				for(int i = 0; i<customers.size(); i++){
					if(customers.get(i).customerType == "Business"){
					builder.append(customers.get(i).customerType + ", " +customers.get(i).getName()+", " + customers.get(i).getAddress() + ", "
							+  customers.get(i).getAccount().getAccountNo() + "\n");
					}
				}
				String fullList = builder.toString();
				textArea.setText(fullList);	
			}
		};
		m4.addActionListener(a6); 
		JButton btnNewButton = new JButton("Display Auditable");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder builder = new StringBuilder();

				for(int i = 0; i<customers.size(); i++){
					if(customers.get(i).getAccount() instanceof Auditable || customers.get(i) instanceof Auditable){
					builder.append(customers.get(i).getAccount().accountType + ", " + customers.get(i).customerType + ", " +customers.get(i).getName()+", " + customers.get(i).getAddress() + ", "
							+  customers.get(i).getAccount().getAccountNo() + "\n");
					}
				}
				String fullList = builder.toString();
				textArea.setText(fullList);
			}
		});
		btnNewButton.setBounds(389, 42, 160, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Search >>");
		lblNewLabel.setBounds(389, 10, 61, 14);
		contentPane.add(lblNewLabel);
	}
	private void showPopup(ActionEvent ae) {
		Component b=(Component)ae.getSource();
		Point p=b.getLocationOnScreen();
		menu.show(this,0,0);
		menu.setLocation(p.x,p.y+b.getHeight());
	}
	private void showPopup2(ActionEvent as) {
		Component b=(Component)as.getSource();
		Point p=b.getLocationOnScreen();
		menu2.show(this,0,0);
		menu2.setLocation(p.x,p.y+b.getHeight());
	}
}
