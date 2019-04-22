package sdv;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
//import javax.swing.event.*;
import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
//import java.awt.FlowLayout;
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
//import java.io.IOException;

import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

public class Main extends JFrame {
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = -1623844613461526099L;
	public static String csvDatei = System.getProperty("user.home").concat("/sdv/gedeonListen.csv");
	public static String klassenliste_long = System.getProperty("user.home").concat("/sdv/listen/klassenliste_long.tex");
	public static String klassenliste_short = System.getProperty("user.home").concat("/sdv/listen/klassenliste_short.tex");
	public static String klassenbuch = System.getProperty("user.home").concat("/sdv/listen/klassenbuch.tex");
	public static String notenbuch = System.getProperty("user.home").concat("/sdv/listen/notenbuch.tex");
	public static String OutDir = System.getProperty("user.home").concat("/sdv/");
	
	JPanel panel1;
	JPanel panel2;
	public static JTextField kvorname; // 0
	public static JTextField kbeiname; // 1
	public static JTextField kname;//2
	public static JTextField kgeburtstag; // 3
	public static JTextField kgeburtsort; // 4
	public static JTextField kreligion; // 5
	public static JTextField kstrasse; // 6
	public static JTextField kplz; // 7
	public static JTextField kwohnort; // 8
	public static JTextField kOT;// 9
	public static JTextField kstaat; // 10
	public static JTextField kkrankenkasse; // 11
	public static JTextField khausarzt; // 12
	public static JTextField mname; // 13
	public static JTextField mvorname; // 14
	public static JTextField mstrasse; // 15
	public static JTextField mplz; // 16
	public static JTextField mwohnort; // 17
	public static JTextField mtelpriv; // 18
	public static JTextField mteldienst; // 19
	public static JTextField memail; // 20
	public static JTextField vname; // 21
	public static JTextField vvorname; // 22
	public static JTextField vstrasse; // 23
	public static JTextField vplz; // 24
	public static JTextField vwohnort; // 25
	public static JTextField vtelpriv; // 26
	public static JTextField vteldienst; // 27
	public static JTextField vemail; // 28
	public static JTextField oname; // 29
	public static JTextField ovorname; // 30
	public static JTextField otel; // 31
	public static JTextField oplz; // 32
	public static JTextField owohnort; // 33
	public static JTextField ostrasse; // 34
	public static JTextField kstammschule; // 35
	public static JTextField geschwistername;// 36
	public static JTextField anzahl_geschwister;//37
	public static JTextArea bemerkungen; // 0
	public static JComboBox<String> zugangsvoraussetzung;// 0
	public static JComboBox<String> sorgeberechtigung;// 0
	public static JComboBox<String> ausklasse;// 1
	public static JComboBox<String> inklasse;// 2
	public static JComboBox<String> klasse;//3
	public static JComboBox<String> zweiteFremdsprache;//4
	public static JComboBox<String> tag_ersteinschulung;//5
	public static JComboBox<String> monat_ersteinschulung;//6
	public static JComboBox<String> jahr_ersteinschulung;//7
	public static JComboBox<String> rolle_als_sorgeberechtigter1;
	public static JComboBox<String> rolle_als_sorgeberechtigter2;
	public static JRadioButton maennlich;// sex 0
	public static JRadioButton weiblich;
	public static JRadioButton geschwister_ja;// geschwister 1
	public static JRadioButton geschwister_nein;
	public static JRadioButton landkreis_ja;// landkreis 2
	public static JRadioButton landkreis_nein;
	public static JRadioButton religion;// religion oder ethik 3
	public static JRadioButton ethik;
	public static JRadioButton oga_ja;// ob oga 4
	public static JRadioButton oga_nein;
	public static JRadioButton doppel_ja; // ob doppelanmeldung 5
	public static JRadioButton doppel_nein;

	//TODO Add exeption handling for missing configFile
	public static ConfigurationData configData = new ConfigurationData();
	//private static final String AKTUELLER_TERM = Main.configD
	private static final String[] ROLLE_ALS_SORGEBERECHTIGTER1 = Main.configData.ROLLE_ALS_SORGEBERECHTIGTER1;
	private static final String[] ROLLE_ALS_SORGEBERECHTIGTER2 = Main.configData.ROLLE_ALS_SORGEBERECHTIGTER2;
	private static final String[] SORGEBERECHTIGUNGEN = Main.configData.ART_DER_SORGEBERECHTIGUNG;
	private static final String[] ZUGANGSVORAUSSETZUNGEN = Main.configData.ART_DER_ZUGANGSVORAUSSETZUNG;
	public static final String[] KLASSE = {"", "4", "5", "6", "7", "8", "9",
			"10", "11", "12" };
	public static final String[]  VBGKLASSE= {"","5a", "5b", "5c"};
	public static final String[] KLASSENLISTENTYP = {"kurz","lang"};
	private static final String[] FREMDSPRACHE = {"","Latein", "Französisch"};
	private static final String[] TAG_ERSTEINSCHULUNG = {"","01", "02","03","04","05","06",
		"07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24",
		"25", "26", "27","28","29","30","31"};
	private static final String[] MONAT_ERSTEINSCHULUNG = {"","01", "02","03","04","05","06","07",
		"08","09","10","11","12"};
	private static final String[] JAHR_ERSTEINSCHULUNG = {"","2008","2009","2010","2011","2012","2013","2014","2015","2016", "2017", "2018", "2019","2020"};
	//static String anzeigeName = "";  // anzeige variable werden auf dem 2. Panel angezeigt
	//static String anzeigeVorname = "";// um die Uebersichtlichkeit zu verbessern
	//static String anzeigeOrt = "";
	public static JLabel lblNewLabel_45;
	public static JLabel lblNewLabel_46;
	public static JLabel lblNewLabel_47;
	
	
	// Objekte in Arrays für Abfrage per Schleife
	static JTextField[] persDaten = new JTextField[38];
	@SuppressWarnings("rawtypes")
	static JComboBox[] divDaten = new JComboBox[11];
	static JTextArea[] bemerk = new JTextArea[1];
	static JRadioButton[] booli = new JRadioButton[12];
	static ButtonGroup[]  boolgroups = new ButtonGroup[6];//wird zum clearen gebraucht
	// ButtonModel a; // was ist das??, k.A.
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
		}
	
	
	
	
	public Main() {
	
		new File(System.getProperty("user.home").concat("/sdv/listen/")).mkdirs();
		new File(System.getProperty("user.home").concat("/sdv/schülerdatenblätter/")).mkdirs();
		setTitle("Anmeldung an das von-Bülow-Gymnasium, Neudietendorf -- Datenerfassung gemäß § 136 ThürSchO");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent event) {
                  closeApp();
          }
      }
   );    
			
		setBounds(0, 0, 1000, 700);

		JButton allesSpeichernBtn = new JButton("Eingaben speichern");

		JButton schuelerAuswahlMenueBtn = new JButton("Schüler auswählen");

		JButton schuelerDatenblattAusdruckBtn = new JButton("Schülerdatenblatt ausdrucken");

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Schüler");
		JMenu mnNewMenu_1 = new JMenu("Listen");
		JMenu mnNewMenu_2 = new JMenu("Datenexport");
		
	if (Main.configData.USER_HAS_PERMISSION == true)
	{
		menuBar.add(mnNewMenu);
		menuBar.add(mnNewMenu_1);
		menuBar.add(mnNewMenu_2);
	}
	else{}
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Klassenlisten");
		mnNewMenu_1.add(mntmNewMenuItem_11);
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			Klassenlisten kl = new Klassenlisten();
			kl.setVisible(true);
		
			}
		});
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Listen für SA");
		mnNewMenu_1.add(mntmNewMenuItem_12);
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			//	some code
		MakeListen ml = new MakeListen();
		ml.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Datenexport für PrimeLine");
		mnNewMenu_2.add(mntmNewMenuItem_13);
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			//	some code
		MakeExportFile export = new MakeExportFile();
		export.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Datenexport für Ilias Benutzeranmeldung");
		mnNewMenu_2.add(mntmNewMenuItem_14);
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			//	some code
		MakeIliasUserInsertFile ilias = new MakeIliasUserInsertFile();
		ilias.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem = new JMenuItem("Auswahl eine Schuelers");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				
				AuswahlSchueler as = new AuswahlSchueler();
				as.setVisible(true);
			
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Statistik");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				Klassenzusammensetzung stat = new Klassenzusammensetzung();
				stat.klassenzusammensetzung();
			}
		});

		getContentPane().setLayout(new MigLayout());
		getContentPane().add(tabbedPane, "cell 0 0 5 1,grow");

		JPanel panel1 = new JPanel();

		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout());
		tabbedPane.addTab("Wird von den Eltern ausgefüllt", null, panel, null);
		tabbedPane.addTab("Wird von der Schule ausgefüllt", null, panel1, null);
		JPanel panela = new JPanel();
		panel.add(panela, "wrap");
		panela.setBorder(new TitledBorder(null, "Kind", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panela.setLayout(new MigLayout("", "[][][][][][grow][][]", "[][][][][]"));
		
		// ////////////////////////////////////////////
		JLabel lblNewLabel_1 = new JLabel("1. Vorname(Rufname)");
		panela.add(lblNewLabel_1, "cell 0 0");

		kvorname = new JTextField();
		panela.add(kvorname, "cell 1 0");
		kvorname.setColumns(20);
		kvorname.setName("kvorname");
		persDaten[0] = kvorname;
		// /////////////////////////////////
		JLabel lblNewLabel_2 = new JLabel("2.Vorname");
		panela.add(lblNewLabel_2, "cell 2 0");

		kbeiname = new JTextField();
		panela.add(kbeiname, "cell 3 0");
		kbeiname.setColumns(20);
		kbeiname.setName("kbeiname");
		persDaten[1] = kbeiname;
		//ButtonGroup group = new ButtonGroup();
		
		JLabel lblNewLabel = new JLabel("Nachname");
		panela.add(lblNewLabel, "cell 4 0,alignx trailing");
		
		kname = new JTextField();
		panela.add(kname, "cell 5 0,growx");
		kname.setColumns(10);
		kname.setName("kname");
		persDaten[2] = kname;
		// /////////////////////////////////
		ButtonGroup group = new ButtonGroup();
		maennlich = new JRadioButton("männlich");
		group.add(maennlich);
		boolgroups[0] = group;
		panela.add(maennlich, "cell 6 0");
		weiblich = new JRadioButton("weiblich");
		group.add(weiblich);
		panela.add(weiblich, "cell 7 0");
		maennlich.setName("maennlich");
		weiblich.setName("weiblich");
		booli[0] = maennlich;
		booli[1] = weiblich;
		// ///////////////////////////////////
		JLabel lblNewLabel_3 = new JLabel("Geburtstag");
		panela.add(lblNewLabel_3, "cell 0 1");

		kgeburtstag = new JTextField();
		panela.add(kgeburtstag, "cell 1 1");
		kgeburtstag.setColumns(10);
		kgeburtstag.setName("kgeburtstag");
		persDaten[3] = kgeburtstag;
		// ///////////////////////////////////////
		JLabel lblNewLabel_4 = new JLabel("Geburtsort");
		panela.add(lblNewLabel_4, "cell 2 1");

		kgeburtsort = new JTextField();
		panela.add(kgeburtsort, "cell 3 1");
		kgeburtsort.setColumns(15);
		kgeburtsort.setName("kgeburtsort");
		persDaten[4] = kgeburtsort;
		// ////////////////////////////////////////
		JLabel lblNewLabel_5 = new JLabel("Religion");
		panela.add(lblNewLabel_5, "cell 4 1");

		kreligion = new JTextField();
		kreligion.setToolTipText("Hier bitte die Religion des Kindes eintragen");
		panela.add(kreligion, "cell 5 1");
		kreligion.setColumns(20);
		kreligion.setName("kreligion");
		persDaten[5] = kreligion;
		// ///////////////////////////////////
		JLabel lblNewLabel_9 = new JLabel("Staatsangehörigkeit");
		panela.add(lblNewLabel_9, "cell 6 1");

		kstaat = new JTextField();
		kstaat.setToolTipText("Hier bitte die Staatsangehoerigkeit des Kindes eintragen");
		panela.add(kstaat, "cell 7 1");
		kstaat.setColumns(20);
		kstaat.setName("kstaat");
		persDaten[10] = kstaat;
		// ///////////////////////////////////////////
		JLabel lblNewLabel_6 = new JLabel("Straße Nr.");
		panela.add(lblNewLabel_6, "cell 0 2");

		kstrasse = new JTextField();
		panela.add(kstrasse, "cell 1 2");
		kstrasse.setColumns(15);
		kstrasse.setName("kstrasse");
		persDaten[6] = kstrasse;
		// ////////////////////////////////////////
		JLabel lblNewLabel_7 = new JLabel("PLZ");
		panela.add(lblNewLabel_7, "cell 2 2");

		kplz = new JTextField();
		panela.add(kplz, "cell 3 2");
		kplz.setColumns(5);
		kplz.setName("kplz");
		persDaten[7] = kplz;
		// ///////////////////////////////////////
		JLabel lblNewLabel_8 = new JLabel("Stadt/Gemeinde");
		panela.add(lblNewLabel_8, "cell 4 2");

		kwohnort = new JTextField();
		panela.add(kwohnort, "flowx,cell 5 2");
		kwohnort.setColumns(40);
		kwohnort.setName("kwohnort");
		persDaten[8] = kwohnort;
		// /////////////////////////////////////////

		JLabel lblNewLabel_10 = new JLabel("Krankenkasse");
		panela.add(lblNewLabel_10, "cell 0 3");

		kkrankenkasse = new JTextField();
		panela.add(kkrankenkasse, "cell 1 3");
		kkrankenkasse.setColumns(20);
		kkrankenkasse.setName("kkrankenkasse");
		persDaten[11] = kkrankenkasse;
		// ///////////////////////////////////////
		JLabel lblNewLabel_11 = new JLabel("Hausarzt");
		panela.add(lblNewLabel_11, "cell 2 3");

		khausarzt = new JTextField();
		panela.add(khausarzt, "cell 3 3 5 1");
		khausarzt.setColumns(60);
		khausarzt.setName("khausarzt");
		persDaten[12] = khausarzt;
		JLabel lblNewLabel_34 = new JLabel("vorherige Schule");
		panela.add(lblNewLabel_34, "cell 0 4");
		
		JLabel lblNewLabel_50 = new JLabel("Einschulungsdatum");
		panela.add(lblNewLabel_50, "cell 0 5");

	
		
		tag_ersteinschulung = new JComboBox<String>(TAG_ERSTEINSCHULUNG);
		panela.add(tag_ersteinschulung);
		tag_ersteinschulung.setName("tag_ersteinschulung");
		divDaten[6] = tag_ersteinschulung;
		tag_ersteinschulung.setSelectedItem(Main.configData.TAG_ERSTEINSCHULUNG);
		
		monat_ersteinschulung = new JComboBox<String>(MONAT_ERSTEINSCHULUNG);
		panela.add(monat_ersteinschulung);
		monat_ersteinschulung.setName("monat_ersteinschulung");
		divDaten[7] = monat_ersteinschulung;
		monat_ersteinschulung.setSelectedItem(Main.configData.MONAT_ERSTEINSCHULUNG);
		
		jahr_ersteinschulung = new JComboBox<String>(JAHR_ERSTEINSCHULUNG);
		panela.add(jahr_ersteinschulung);
		jahr_ersteinschulung.setName("jahr_ersteinschulung");
		divDaten[8] = jahr_ersteinschulung;
		jahr_ersteinschulung.setSelectedItem(Main.configData.JAHR_ERSTEINSCHULUNG);
		
		kstammschule = new JTextField();
		panela.add(kstammschule, "cell 1 4 8 1");
		kstammschule.setColumns(100);
		kstammschule.setName("kstammschule");
		persDaten[35] = kstammschule;
		JLabel lblOt = new JLabel("ggf. Ortsteil");
		lblOt.setHorizontalAlignment(SwingConstants.LEFT);
		panela.add(lblOt, "cell 6 2");
		
		kOT = new JTextField();
		panela.add(kOT, "cell 7 2");
		kOT.setColumns(10);
		kOT.setName("kOT");
		persDaten[9] = kOT;
		/*
		 * Ab hier folgen die Felder fuer die Angaben zu den Eltern beginnend
		 * mit der Mutter
		 */
		JPanel elternPanel = new JPanel();
		panel.add(elternPanel, "wrap");
		elternPanel.setBorder(new TitledBorder(null, "Angaben zu den Sorgeberechtigten",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		elternPanel.setLayout(new MigLayout());

		JPanel mutterPanel = new JPanel();
		elternPanel.add(mutterPanel);
		mutterPanel.setBorder(new TitledBorder(null, "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mutterPanel.setLayout(new MigLayout());
		// ////////////////////////////////////////////
		JLabel lblNewLabel_13a = new JLabel("Rolle des Sorgeberechtigten");
		mutterPanel.add(lblNewLabel_13a);
		rolle_als_sorgeberechtigter1 = new JComboBox<String>(ROLLE_ALS_SORGEBERECHTIGTER1);
		mutterPanel.add(rolle_als_sorgeberechtigter1, "wrap");
		rolle_als_sorgeberechtigter1.setName("rolle_als_sorgeberechtigter1");
		divDaten[9] = rolle_als_sorgeberechtigter1;
		
		JLabel lblNewLabel_12 = new JLabel("Name");
		mutterPanel.add(lblNewLabel_12);
		mname = new JTextField();
		mutterPanel.add(mname, "wrap");
		mname.setColumns(20);
		mname.setName("mname");
		persDaten[13] = mname;
		// /////////////////////////////////
		JLabel lblNewLabel_13 = new JLabel("Vorname");
		mutterPanel.add(lblNewLabel_13);

		mvorname = new JTextField();
		mutterPanel.add(mvorname, "wrap");
		mvorname.setColumns(20);
		mvorname.setName("mvorname");
		persDaten[14] = mvorname;
		// ///////////////////////////////////
		JLabel lblNewLabel_14 = new JLabel("Straße Nr.");
		mutterPanel.add(lblNewLabel_14);

		mstrasse = new JTextField();
		mutterPanel.add(mstrasse, "wrap");
		mstrasse.setColumns(20);
		mstrasse.setName("mstrasse");
		persDaten[15] = mstrasse;
		// ///////////////////////////////////////
		JLabel lblNewLabel_15 = new JLabel("PLZ");
		mutterPanel.add(lblNewLabel_15);

		mplz = new JTextField();
		mutterPanel.add(mplz, "wrap");
		mplz.setColumns(20);
		mplz.setName("mplz");
		persDaten[16] = mplz;
		// ////////////////////////////////////////
		JLabel lblNewLabel_16 = new JLabel("Wohnort");
		mutterPanel.add(lblNewLabel_16);

		mwohnort = new JTextField();
		mwohnort.setToolTipText("");
		mutterPanel.add(mwohnort, "wrap");
		mwohnort.setColumns(20);
		mwohnort.setName("mwohnort");
		persDaten[17] = mwohnort;
		// ///////////////////////////////////
		JLabel lblNewLabel_17 = new JLabel("Tel. priv.");
		mutterPanel.add(lblNewLabel_17);

		mtelpriv = new JTextField();
		mtelpriv.setToolTipText("");
		mutterPanel.add(mtelpriv, "wrap");
		mtelpriv.setColumns(20);
		mtelpriv.setName("mtelpriv");
		persDaten[18] = mtelpriv;
		// ///////////////////////////////////////////
		JLabel lblNewLabel_18 = new JLabel("Tel. dienstl.");
		mutterPanel.add(lblNewLabel_18);

		mteldienst = new JTextField();
		mutterPanel.add(mteldienst, "wrap");
		mteldienst.setColumns(20);
		mteldienst.setName("mteldienst");
		persDaten[19] = mteldienst;
		// /////////////////////////////////////
		JLabel lblNewLabel_19 = new JLabel("E-Mail");
		mutterPanel.add(lblNewLabel_19);

		memail = new JTextField();
		mutterPanel.add(memail, "wrap");
		memail.setColumns(20);
		memail.setName("memail");
		persDaten[20] = memail;
		/*
		 * Daten zum Vater
		 */

		JPanel vaterPanel = new JPanel();
		elternPanel.add(vaterPanel);
		vaterPanel.setBorder(new TitledBorder(null, "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		vaterPanel.setLayout(new MigLayout());
		// ////////////////////////////////////////////
		
		JLabel lblNewLabel_13b = new JLabel("Rolle des Sorgeberechtigten");
		vaterPanel.add(lblNewLabel_13b);
		rolle_als_sorgeberechtigter2 = new JComboBox<String>(ROLLE_ALS_SORGEBERECHTIGTER2);
		vaterPanel.add(rolle_als_sorgeberechtigter2, "wrap");
		rolle_als_sorgeberechtigter2.setName("rolle_als_sorgeberechtigter2");
		divDaten[10] = rolle_als_sorgeberechtigter2;
		
		JLabel lblNewLabel_20 = new JLabel("Name");
		vaterPanel.add(lblNewLabel_20);

		vname = new JTextField();
		vaterPanel.add(vname, "wrap");
		vname.setColumns(20);
		vname.setName("vname");
		persDaten[21] = vname;
		// /////////////////////////////////
		JLabel lblNewLabel_21 = new JLabel("Vorname");
		vaterPanel.add(lblNewLabel_21);

		vvorname = new JTextField();
		vaterPanel.add(vvorname, "wrap");
		vvorname.setColumns(20);
		vvorname.setName("vvorname");
		persDaten[22] = vvorname;
		// ///////////////////////////////////
		JLabel lblNewLabel_22 = new JLabel("Straße Nr.");
		vaterPanel.add(lblNewLabel_22);

		vstrasse = new JTextField();
		vaterPanel.add(vstrasse, "wrap");
		vstrasse.setColumns(20);
		vstrasse.setName("vstrasse");
		persDaten[23] = vstrasse;
		// ///////////////////////////////////////
		JLabel lblNewLabel_23 = new JLabel("PLZ");
		vaterPanel.add(lblNewLabel_23);

		vplz = new JTextField();
		vaterPanel.add(vplz, "wrap");
		vplz.setColumns(20);
		vplz.setName("vplz");
		persDaten[24] = vplz;
		// ////////////////////////////////////////
		JLabel lblNewLabel_24 = new JLabel("Wohnort");
		vaterPanel.add(lblNewLabel_24);

		vwohnort = new JTextField();
		vwohnort.setToolTipText("");
		vaterPanel.add(vwohnort, "wrap");
		vwohnort.setColumns(20);
		vwohnort.setName("vwohnort");
		persDaten[25] = vwohnort;
		// ///////////////////////////////////
		JLabel lblNewLabel_25 = new JLabel("Tel. priv.");
		vaterPanel.add(lblNewLabel_25);

		vtelpriv = new JTextField();
		vtelpriv.setToolTipText("");
		vaterPanel.add(vtelpriv, "wrap");
		vtelpriv.setColumns(20);
		vtelpriv.setName("vtelpriv");
		persDaten[26] = vtelpriv;

		// ///////////////////////////////////////////
		JLabel lblNewLabel_26 = new JLabel("Tel. dienstl.");
		vaterPanel.add(lblNewLabel_26);

		vteldienst = new JTextField();
		vaterPanel.add(vteldienst, "wrap");
		vteldienst.setColumns(20);
		vteldienst.setName("vteldienst");
		persDaten[27] = vteldienst;
		// /////////////////////////////////////
		JLabel lblNewLabel_27 = new JLabel("E-Mail");
		vaterPanel.add(lblNewLabel_27);

		vemail = new JTextField();
		vaterPanel.add(vemail, "wrap");
		vemail.setColumns(20);
		vemail.setName("vemail");
		persDaten[28] = vemail;
		/*
		 * Bereich fuer die Daten der Vertrauensperson, genannt oma
		 */

		JPanel omaPanel = new JPanel();
		panel.add(omaPanel);
		omaPanel.setBorder(new TitledBorder(null, "Vertrauensperson",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		omaPanel.setLayout(new MigLayout());

		JLabel lblNewLabel_28 = new JLabel("Name");
		omaPanel.add(lblNewLabel_28);
		
		oname = new JTextField();
		omaPanel.add(oname);
		oname.setColumns(20);
		oname.setName("oname");
		persDaten[29] = oname;
		// /////////////////////////////////
		JLabel lblNewLabel_29 = new JLabel("Vorname");
		omaPanel.add(lblNewLabel_29);

		ovorname = new JTextField();
		omaPanel.add(ovorname);
		ovorname.setColumns(20);
		ovorname.setName("ovorname");
		persDaten[30] = ovorname;
		// ///////////////////////////////////
		JLabel lblNewLabel_30 = new JLabel("Tel.");
		omaPanel.add(lblNewLabel_30);

		otel = new JTextField();
		omaPanel.add(otel, "wrap");
		otel.setColumns(20);
		otel.setName("otel");
		persDaten[31] = otel;
		// ///////////////////////////////////////
		JLabel lblNewLabel_31 = new JLabel("PLZ");
		omaPanel.add(lblNewLabel_31);

		oplz = new JTextField();
		omaPanel.add(oplz);
		oplz.setColumns(20);
		oplz.setName("oplz");
		persDaten[32] = oplz;
		// ////////////////////////////////////////
		JLabel lblNewLabel_32 = new JLabel("Wohnort");
		omaPanel.add(lblNewLabel_32);

		owohnort = new JTextField();
		owohnort.setToolTipText("");
		omaPanel.add(owohnort);
		owohnort.setColumns(20);
		owohnort.setName("owohnort");
		persDaten[33] = owohnort;
		// ///////////////////////////////////
		JLabel lblNewLabel_33 = new JLabel("Straße Nr.");
		omaPanel.add(lblNewLabel_33);

		ostrasse = new JTextField();
		ostrasse.setToolTipText("");
		omaPanel.add(ostrasse, "wrap");
		ostrasse.setColumns(20);
		ostrasse.setName("ostrasse");
		persDaten[34] = ostrasse;
		/*
		 * Panel fuer die Angaben der Schule, 2. Tab
		 */

		JPanel panelb = new JPanel();
		panel1.add(panelb);
		panelb.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelb.setLayout(new MigLayout());
		
		 lblNewLabel_45 = new JLabel();
		 lblNewLabel_45.setForeground(Color.blue);
		panelb.add(lblNewLabel_45,"split 2");

		lblNewLabel_46 = new JLabel();
		lblNewLabel_46.setForeground(Color.blue);
		panelb.add(lblNewLabel_46,"split 2");
		
		lblNewLabel_47 = new JLabel();
		lblNewLabel_47.setForeground(Color.blue);
		panelb.add(lblNewLabel_47,"wrap");
		
		JLabel lblNewLabel_35 = new JLabel("Zugangsvoraussetzung");
		panelb.add(lblNewLabel_35);

		zugangsvoraussetzung = new JComboBox<String>(ZUGANGSVORAUSSETZUNGEN);
		panelb.add(zugangsvoraussetzung, "wrap");
		zugangsvoraussetzung.setName("zugangsvoraussetzung");
		divDaten[0] = zugangsvoraussetzung;
		
		
		
		// ////////////////////////////////////////////////////
		JLabel lblNewLabel_36 = new JLabel("Sorgeberechtigt");
		panelb.add(lblNewLabel_36);

		sorgeberechtigung = new JComboBox<String>(SORGEBERECHTIGUNGEN);
		panelb.add(sorgeberechtigung, "wrap");
		sorgeberechtigung.setName("sorgeberechtigung");
		divDaten[1] = sorgeberechtigung;
		// ////////////////////////////////////////////////////
		
		JLabel lblNewLabel_37a = new JLabel("Anzahl der Geschwister");
		panelb.add(lblNewLabel_37a);
		anzahl_geschwister = new JTextField();
		anzahl_geschwister.setToolTipText("");
		anzahl_geschwister.setColumns(3);
		anzahl_geschwister.setName("anzahl_geschwister");
		persDaten[37] = anzahl_geschwister;
		panelb.add(anzahl_geschwister, "wrap");

		JLabel lblNewLabel_37 = new JLabel("Geschwister am vBG, ggf. Namen");
		panelb.add(lblNewLabel_37);

		geschwister_ja = new JRadioButton("Ja");
		geschwister_nein = new JRadioButton("Nein");

		ButtonGroup group_1 = new ButtonGroup();
		boolgroups[1] = group_1;
		group_1.add(geschwister_ja);
		group_1.add(geschwister_nein);
		geschwister_ja.setName("geschwister_ja");
		geschwister_nein.setName("geschwister_nein");
		booli[2] = geschwister_ja;
		booli[3] = geschwister_nein;
		// a = group_1.getSelection();
		geschwistername = new JTextField();
		geschwistername.setToolTipText("");
		geschwistername.setColumns(30);
		geschwistername.setName("geschwistername");
		persDaten[36] = geschwistername;
		panelb.add(geschwister_ja, "split 3");
		panelb.add(geschwister_nein);
		panelb.add(geschwistername, "wrap");

		// /////////////////////////////////////////////////////
		JLabel lblNewLabel_38 = new JLabel("Schüler wohnt im Landkreis Gotha");
		panelb.add(lblNewLabel_38);

		landkreis_ja = new JRadioButton("Ja");
		landkreis_nein = new JRadioButton("nein");
		ButtonGroup group_2 = new ButtonGroup();
		boolgroups[2] = group_2;
		group_2.add(landkreis_ja);
		group_2.add(landkreis_nein);

		panelb.add(landkreis_ja, "split 3");
		panelb.add(landkreis_nein, "wrap");
		landkreis_ja.setName("landkreis_ja");
		landkreis_nein.setName("landkreis_nein");
		booli[4] = landkreis_ja;
		booli[5] = landkreis_nein;
		
		// //////////////////////////////////////////////////
		JLabel lblNewLabel_39 = new JLabel("Teilnahme ev. Religion oder Ethik");
		panelb.add(lblNewLabel_39);

		religion = new JRadioButton("ev. Religion");
		ethik = new JRadioButton("Ethik");
		ButtonGroup group_3 = new ButtonGroup();
		boolgroups[3] = group_3;
		group_3.add(religion);
		group_3.add(ethik);
		religion.setName("religion");
		ethik.setName("ethik");
		booli[6] = religion;
		booli[7] = ethik;
		panelb.add(religion, "split 3");
		panelb.add(ethik, "wrap");
		// /////////////////////////////////////////////
		JLabel lblNewLabel_40 = new JLabel("Teilnahme am GA");
		panelb.add(lblNewLabel_40);

		oga_ja = new JRadioButton("Ja");
		oga_nein = new JRadioButton("Nein");
		ButtonGroup group_4 = new ButtonGroup();
		boolgroups[4] = group_4;
		group_4.add(oga_ja);
		group_4.add(oga_nein);
		oga_ja.setName("oga_ja");
		oga_nein.setName("oga_nein");
		booli[8] = oga_nein;
		booli[9] = oga_ja;
		panelb.add(oga_ja, "split 3");
		panelb.add(oga_nein, "wrap");
		// /////////////////////////////////////////////

		JLabel lblNewLabel_41 = new JLabel("Doppelanmeldung");
		panelb.add(lblNewLabel_41);

		doppel_ja = new JRadioButton("Ja");
		doppel_nein = new JRadioButton("Nein");
		ButtonGroup group_5 = new ButtonGroup();
		boolgroups[5] = group_5;
		group_5.add(doppel_ja);
		group_5.add(doppel_nein);
		doppel_ja.setName("doppel_ja");
		doppel_nein.setName("doppel_nein");
		booli[10] = doppel_ja;
		booli[11] = doppel_nein;
		panelb.add(doppel_ja, "split 3");
		panelb.add(doppel_nein, "wrap");

		// /////////////////////////////////////////

		JLabel lblNewLabel_42 = new JLabel("Übergang ans vBG aus Klasse");
		panelb.add(lblNewLabel_42);

		ausklasse = new JComboBox<String>(KLASSE);
		panelb.add(ausklasse, "split 3");
		ausklasse.setName("ausklasse");
		divDaten[2] = ausklasse;
		JLabel lblNewLabel_43 = new JLabel("in Klasse");
		panelb.add(lblNewLabel_43);

		inklasse = new JComboBox<String>(KLASSE);
		panelb.add(inklasse, "wrap");
		inklasse.setName("inklasse");
		divDaten[3] = inklasse;
		// ////////////////////////////////////////

		JLabel lblNewLabel_44 = new JLabel("Bemerkungen/Hinweise");
		panelb.add(lblNewLabel_44);

		bemerkungen = new JTextArea();
		panelb.add(bemerkungen,"wrap");
		bemerkungen.setRows(5);
		bemerkungen.setColumns(40);
		bemerkungen.setName("bemerkungen");
		bemerk[0] = bemerkungen;
	
		
		
		JLabel lblNewLabel_48 = new JLabel("Kommt in Klasse:");
		panelb.add(lblNewLabel_48);

		klasse = new JComboBox<String>(VBGKLASSE);
		panelb.add(klasse, "wrap");
		klasse.setName("klasse");
		divDaten[4] = klasse;
		JLabel lblNewLabel_49 = new JLabel("2. Fremdsprache ab Klasse 6");
		panelb.add(lblNewLabel_49);

		zweiteFremdsprache = new JComboBox<String>(FREMDSPRACHE);
		panelb.add(zweiteFremdsprache, "wrap");
		zweiteFremdsprache.setName("zweiteFremdsprache");
		divDaten[5] = zweiteFremdsprache;
		

		getContentPane().add(allesSpeichernBtn, "cell 3 1,alignx right,aligny top");
		
		if (Main.configData.USER_HAS_PERMISSION == true)
		{
		getContentPane().add(schuelerAuswahlMenueBtn, "cell 0 1,alignx left,aligny top");//fuer Eltern abgeschaltet
		}
		else{}
		//getContentPane().add(schuelerDatenblattAusdruckBtn, "cell 0 1,alignx left,aligny top");

		allesSpeichernBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int antwort = JOptionPane
						.showConfirmDialog(
								null,

								"Wenn Sie die Eingabe beenden und die Daten speichern möchten,"
								+"\n dann klicken Sie bitte auf OK. Möchten Sie die Eingabe"
								+" fortsetzen \n klicken Sie bitte auf Abbrechen!",
								"Daten speichern", JOptionPane.OK_CANCEL_OPTION);

				if (antwort == JOptionPane.OK_OPTION) {

					DBConnection.createTables();
					GuiDatenInDB.werteInDB();
					

				}

			}
		});

		schuelerAuswahlMenueBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				AuswahlSchueler as = new AuswahlSchueler();
				as.setVisible(true);	
			
				
			}
		});

		schuelerDatenblattAusdruckBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				//System.out.println(texOutDir);
				//JOptionPane.showMessageDialog(null,"Das ist doch der Reservebutton 2, \n den brauchst Du nicht zu drücken. \n Das bringt nix!");	

				//DBDatenInGui.werteausDB();
			}
		});



	}
	/**
	 * Leert nach dem Speichern der Eingaben die Eingabefelder der Gui
	 */
	public static void clearGui(){
		for (int i = 0;i<38;i++){
			persDaten[i].setText("");
		}
		for (int i = 0;i<6;i++){
			boolgroups[i].clearSelection();
		}
		
		for (int i = 0;i<9;i++){
			divDaten[i].setSelectedItem("");
			divDaten[9].setSelectedItem("Mutter");
			divDaten[10].setSelectedItem("Vater");
		}
		
		bemerk[0].setText("");
		
		lblNewLabel_45.setText("");
		lblNewLabel_46.setText("");
		lblNewLabel_47.setText("");
		
		tag_ersteinschulung.setSelectedItem(Main.configData.TAG_ERSTEINSCHULUNG);
		monat_ersteinschulung.setSelectedItem(Main.configData.MONAT_ERSTEINSCHULUNG);
		jahr_ersteinschulung.setSelectedItem(Main.configData.JAHR_ERSTEINSCHULUNG);
	}
	public void closeApp() {
	     int ende = JOptionPane.showConfirmDialog(this, "Soll das Programm wirklich beendet werden?", "Beenden", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	     if(ende == 0) {
	         System.exit(1);
	     }    
	 }
	
	
}

