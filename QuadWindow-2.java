//Quad Graphics by Andrea Seguya
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;

public class QuadWindow {

	private JFrame frmQuadWindowBy;
	private JLabel lblNewLabel;
	private JLabel lblEnterCoeffecientA;
	private JTextField textFieldA;
	private JLabel lblEnterCoeffientB;
	private JTextField textFieldB;
	private JLabel lblEnterCoeffecientC;
	private JTextField textFeildC;
	private JButton btnQuadRoots;
	private JTextField FinalAnswer;
	private GPanel panel;
public static double a;
public static double b;
public static double c;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuadWindow window = new QuadWindow();
					window.frmQuadWindowBy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuadWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuadWindowBy = new JFrame();
		frmQuadWindowBy.getContentPane().setBackground(SystemColor.menu);
		frmQuadWindowBy.setBackground(Color.PINK);
		frmQuadWindowBy.setTitle("Quad Window by Andrea Seguya");
		frmQuadWindowBy.setBounds(100, 100, 661, 539);
		frmQuadWindowBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuadWindowBy.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("The purpose of this program is to calculate the roots of a quadratic equation given the coefficients of A,B and C");
		lblNewLabel.setBounds(10, 11, 610, 39);
		frmQuadWindowBy.getContentPane().add(lblNewLabel);
		
		lblEnterCoeffecientA = new JLabel("Enter Co-effecient A");
		lblEnterCoeffecientA.setBounds(10, 61, 140, 25);
		frmQuadWindowBy.getContentPane().add(lblEnterCoeffecientA);
		
		textFieldA = new JTextField();
		textFieldA.setBounds(10, 97, 86, 20);
		frmQuadWindowBy.getContentPane().add(textFieldA);
		textFieldA.setColumns(10);
		
		lblEnterCoeffientB = new JLabel("Enter Co-effecient B");
		lblEnterCoeffientB.setBounds(10, 147, 129, 20);
		frmQuadWindowBy.getContentPane().add(lblEnterCoeffientB);
		
		textFieldB = new JTextField();
		textFieldB.setBounds(10, 178, 86, 20);
		frmQuadWindowBy.getContentPane().add(textFieldB);
		textFieldB.setColumns(10);
		
		lblEnterCoeffecientC = new JLabel("Enter Co-effecient C");
		lblEnterCoeffecientC.setBounds(10, 233, 129, 14);
		frmQuadWindowBy.getContentPane().add(lblEnterCoeffecientC);
		
		textFeildC = new JTextField();
		textFeildC.setBounds(10, 258, 86, 20);
		frmQuadWindowBy.getContentPane().add(textFeildC);
		textFeildC.setColumns(10);
		
		btnQuadRoots = new JButton("Quad Roots");
		btnQuadRoots.addActionListener(new BtnQuadRootsActionListener());
		btnQuadRoots.setBounds(283, 108, 115, 23);
		frmQuadWindowBy.getContentPane().add(btnQuadRoots);
		
		FinalAnswer = new JTextField();
		FinalAnswer.setEditable(false);
		FinalAnswer.setBounds(132, 147, 488, 51);
		frmQuadWindowBy.getContentPane().add(FinalAnswer);
		FinalAnswer.setColumns(10);
		
		panel = new GPanel();
		panel.setBounds(246, 209, 358, 255);
		frmQuadWindowBy.getContentPane().add(panel);
	}
	private class BtnQuadRootsActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			String A= textFieldA.getText();
			String B= textFieldB.getText();
			String C= textFeildC.getText();
			a= Double.parseDouble(A);
			b= Double.parseDouble(B);
			c= Double.parseDouble(C);
			double discriminant=Math.pow(2,b)-4*a* c;
			if (discriminant==0) {
				 double OnlyRoot = -b+Math.sqrt(b*b-4*a*c)/(2*a);
				 FinalAnswer.setText("The Only Root is  " +OnlyRoot);
				}
				if(discriminant<0) {
				double realPart=((-b)/(2*a));
				double imagin= Math.sqrt(Math.abs(discriminant))/(2*a);
				FinalAnswer.setText("Complex root where real part is  "+ realPart+" And imaginery is " + imagin + "i");
				}
				if (discriminant >0) {
			double FirstRoot = (-b+Math.sqrt(b*b-4*a*c))/(2*a);
			double SecondRoot= (-b-Math.sqrt(b*b-4*a*c))/(2*a);
			FinalAnswer.setText("Two roots at " +FirstRoot +" and"  +SecondRoot);
			panel.repaint();
			
			
				}
			
			
			
			
			
			
			
			
		}
	}
}
