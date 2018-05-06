package sdv;
//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
//import javax.swing.border.TitledBorder;
import javax.swing.JButton;
//import javax.swing.JTabbedPane;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
//import java.awt.Component;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.BoxLayout;
//import javax.swing.SwingConstants;
//import javax.swing.JCheckBox;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class Klassenlisten extends JFrame {
	/**
	 * 
	 */

//	private JComboBox klasse;
	private JPanel contentPane;
	
	public Klassenlisten(){
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	setTitle("Klassenlisten");
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[][][][][][][][grow][grow]", "[][][][][][][][]"));
	
	JLabel lblNewLabel = new JLabel("Klasse");
	contentPane.add(lblNewLabel, "cell 5 1");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	final JComboBox comboBoxKlasse = new JComboBox(Main.VBGKLASSE);
	contentPane.add(comboBoxKlasse, "cell 7 1,growx");
	
	JLabel lblNewLabel_1 = new JLabel("Listentyp");
	contentPane.add(lblNewLabel_1, "cell 5 2");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	final JComboBox comboBoxListenTyp = new JComboBox(Main.KLASSENLISTENTYP);
	contentPane.add(comboBoxListenTyp, "cell 7 2,growx");
	
	JButton btnKlassenlisteErstellen = new JButton("Liste erstellen");
	contentPane.add(btnKlassenlisteErstellen, "cell 8 7");
	
	btnKlassenlisteErstellen.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			if (comboBoxListenTyp.getSelectedItem().toString() == "kurz")
			{
				MakePdf mp = new MakePdf();
				mp.createKlassenlisteKurz(comboBoxKlasse.getSelectedItem().toString(),Main.OutDir
						+ "/listen/"
						+ "Klassenliste_"
						+ comboBoxKlasse.getSelectedItem().toString() + "_"
						+ ".pdf");
			}
			
			if (comboBoxListenTyp.getSelectedItem().toString() == "lang")
			{
				MakePdf mp = new MakePdf();
				mp.createKlassenlisteLang(comboBoxKlasse.getSelectedItem().toString(),Main.OutDir
						+ "/listen/"
						+ "Klassenliste_lang_"
						+ comboBoxKlasse.getSelectedItem().toString() + "_"
						+ ".pdf");
			}
		}
	});
	}
}
		
	
	

