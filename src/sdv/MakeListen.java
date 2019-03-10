package sdv;

import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class MakeListen extends JFrame {
	private JComboBox<String> ausKl;
	private JComboBox<String> inKl;
	private JPanel contentPane;
	private JCheckBox probe;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { MakeListen frame = new
	 * MakeListen(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public MakeListen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Listen für das Schulamt");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 436, 263);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Anmeldungen", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Auswahlkriterien",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("aus Klasse");
		panel_3.add(lblNewLabel);

		ausKl = new JComboBox<String>(Main.KLASSE);
		panel_3.add(ausKl);

		JLabel lblNewLabel_1 = new JLabel("in Klasse");
		panel_3.add(lblNewLabel_1);

		inKl = new JComboBox<String>(Main.KLASSE);
		panel_3.add(inKl);
		
		probe = new JCheckBox("Probeunterricht");
		panel_3.add(probe);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));

		JButton btnNewButton = new JButton("Liste erstellen (pdf)");
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Liste erstellen - Probeunterricht (xslx)");
		btnNewButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEADING);
		panel_4.add(btnNewButton_1);
		

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			if (probe.isSelected())
			{
				System.out.println("probe is selected");
				if (ausKl.getSelectedItem().toString()!="" && inKl.getSelectedItem().toString()!=""){
					MakePdf mp = new MakePdf();
					mp.createAnmeldungSA_probe(ausKl.getSelectedItem().toString(),
							inKl.getSelectedItem().toString(), Main.OutDir
									+ "listen/"
									+ "Anmeldungen_"
									+ ausKl.getSelectedItem().toString() + "_"
									+ inKl.getSelectedItem().toString()
									+ "_probe.pdf");
				}else
				{
					JOptionPane.showMessageDialog(null,"Sie haben keine korrekte Auswahl getroffen.","Upps, eine Fehlermeldung!"
							,JOptionPane.ERROR_MESSAGE); 
				}	
			}
			else
			{
				if (ausKl.getSelectedItem().toString()!="" && inKl.getSelectedItem().toString()!=""){
					MakePdf mp = new MakePdf();
					mp.createAnmeldungSA(ausKl.getSelectedItem().toString(),
							inKl.getSelectedItem().toString(), Main.OutDir
									+ "listen/"
									+ "Anmeldungen_"
									+ ausKl.getSelectedItem().toString() + "_"
									+ inKl.getSelectedItem().toString()
									+ ".pdf");
				}else
				{
					JOptionPane.showMessageDialog(null,"Sie haben keine korrekte Auswahl getroffen.","Upps, eine Fehlermeldung!"
							,JOptionPane.ERROR_MESSAGE); 
				}	
			}
				
				
				try
				{
					if(probe.isSelected())
					{
					Runtime.getRuntime().exec( "evince "+ Main.OutDir
							+ "listen/"
							+ "Anmeldungen_"
							+ ausKl.getSelectedItem().toString() + "_"
							+ inKl.getSelectedItem().toString()
							+ "_probe.pdf");
				 
				}else
				{
					Runtime.getRuntime().exec( "evince "+ Main.OutDir
							+ "listen/"
							+ "Anmeldungen_"
							+ ausKl.getSelectedItem().toString() + "_"
							+ inKl.getSelectedItem().toString()
							+ ".pdf");
				 
				}
				}
				
				catch ( Exception /* IOException, URISyntaxException */ exc )
				{
				  exc.printStackTrace();
				}
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (probe.isSelected())
			{
				if (ausKl.getSelectedItem().toString()!="" && inKl.getSelectedItem().toString()!=""){
					
					makeXLSX.writeXLSXFile(ausKl.getSelectedItem().toString(),
							inKl.getSelectedItem().toString(), Main.OutDir
									+ "listen/"
									+ "Aufnahmeprüfung_"
									+ ausKl.getSelectedItem().toString() + "_"
									+ inKl.getSelectedItem().toString()
									+ "_Gym_50237.xlsx");
				}else
				{
					JOptionPane.showMessageDialog(null,"Sie haben keine korrekte Auswahl getroffen.","Upps, eine Fehlermeldung!"
							,JOptionPane.ERROR_MESSAGE); 
				}	
			}
		/*	else
			{
				if (ausKl.getSelectedItem().toString()!="" && inKl.getSelectedItem().toString()!=""){
					MakePdf mp = new MakePdf();
					mp.createAnmeldungSA(ausKl.getSelectedItem().toString(),
							inKl.getSelectedItem().toString(), Main.OutDir
									+ "/listen/"
									+ "Anmeldungen_"
									+ ausKl.getSelectedItem().toString() + "_"
									+ inKl.getSelectedItem().toString()
									+ ".pdf");
				}else
				{
					JOptionPane.showMessageDialog(null,"Sie haben keine korrekte Auswahl getroffen.","Upps, eine Fehlermeldung!"
							,JOptionPane.ERROR_MESSAGE); 
				}	
			}*/
				
				
				try
				{
					
					Runtime.getRuntime().exec( "soffice "+ Main.OutDir
							+ "listen/"
							+ "Aufnahmeprüfung_"
							+ ausKl.getSelectedItem().toString() + "_"
							+ inKl.getSelectedItem().toString()
							+ "_Gym_50237.xlsx");
				 
				}
				catch ( Exception /* IOException, URISyntaxException */ exc )
				{
				  exc.printStackTrace();
				}
			}
		});

		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Reserve", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Reserve", null, panel_2, null);
		//contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(
			//	new Component[] { tabbedPane }));
	}
}
