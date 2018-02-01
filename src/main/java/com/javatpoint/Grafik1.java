package com.javatpoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Grafik1
{

	
	private JFrame frame;
	private JLabel lbl1, lbl2;
	private JTextField tf1, tf2;
	private JButton btnBeenden, btnKopieren, btnLoeschen;
	
	
	
	
	public Grafik1()
	{
		
		initializeComponents();
		
		
	}
	
	private void initializeComponents()
	{
		
		frame = new JFrame("Erstes Grafikprogramm");
		
		// Position des Frames in Pixeln
		//frame.setLocation(200, 100);
		
		// Grösse des Frames in Pixeln
		//frame.setSize(350, 150);
		
		// oder
		frame.setBounds(200, 100, 350, 150);
		
		// Keine Grössenänderung des Frames
		//frame.setResizable(false);
		
		
		// Muss angegeben werden, da sonst das Fenster nur geschlossen wird
		// (es wird unsichtbar), die Klasse selbst bleibt jedoch aktiv!
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Layout
		// Layouts sind Strukturen, welche grafische Elemente in einem JFrame
		// oder einer anderen Containerklasse so anordnen, wie man es gerne möchte.
		
		// Kein Layout
		frame.setLayout(null);
		
		// Beschriftung hinzufügen
		lbl1 = new JLabel("Eingabe");
		
		// Position und Grösse für den Label festlegen
//		lbl1.setLocation(10,  10);
//		lbl1.setSize(90, 20);
		
		// oder
		lbl1.setBounds(10,  10,  90,  20);
		
		
		// Zur Überprüfung von Breite und Höhe
		//lbl1.setBorder(LineBorder.createBlackLineBorder());
		
		// Den Label zum Frame hinzufügen
		frame.add(lbl1);
		
		// Textfeld hinzufügen
		tf1 = new JTextField();
		tf1.setBounds(100, 10, 200, 20);
		frame.add(tf1);
		
		
		// Beschriftung hinzufügen
		lbl2 = new JLabel("Kopie");
		lbl2.setBounds(10,  40,  90,  20);
		frame.add(lbl2);
		
		// Textfeld hinzufügen
		tf2 = new JTextField("Kopie");
		tf2.setBounds(100, 40, 200, 20);
		
		
		// Nicht editierbar, keine Eingabe möglich.
		// Der Hintergrund des Textfeldes bleibt unverändert, die Schriftfarbe
		// wird grau.
		// Die Komponente kann auch den Eingabefokus nicht erhalten.
		//tf2.setEnabled(false);
		
		// Der Hintergrund wird grau, die Schriftfarbe bleibt schwarz.
		// Die Komponente kann jedoch immer noch den Eingabefokus erhalten.
		//tf2.setEditable(false);
		
		// Hintergund- und Schriftfarbe bleiben unverändert, eine Eingabe ist
		// nicht möglich.
		// Die Komponente kann auch den Eingabefokus nicht erhalten.
		tf2.setFocusable(false);
		
		frame.add(tf2);
				
		btnKopieren = new JButton("Kopieren");
		btnKopieren.setBounds(10, 80, 100, 25);
		btnKopieren.addActionListener(new ButtonKopierenActionListener());
		frame.add(btnKopieren);
		
		btnLoeschen = new JButton("Löschen");
		btnLoeschen.setBounds(120, 80, 100, 25);
		btnLoeschen.addActionListener(new ButtonLoeschenActionListener());
		frame.add(btnLoeschen);
		
		btnBeenden = new JButton("Beenden");
		btnBeenden.setBounds(230, 80, 100, 25);
		btnBeenden.addActionListener(new ButtonBeendenActionListener());
		frame.add(btnBeenden);
		
		
	}
	
	
	public void showFrame()
	{
		frame.setVisible(true);
	}
	
	
	
	private class ButtonBeendenActionListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			
			System.out.println(((JButton)e.getSource()).getText() + ": Button gelickt");
			System.exit(0);
			
			
		}
		
	}
	
	private class ButtonKopierenActionListener implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e)
		{
			
			System.out.println(((JButton)e.getSource()).getText() + ": Button gelickt");
			
			tf2.setText(tf1.getText());
			tf1.setText(null);
			
			// requestFocus() setzt den Focus auf die anfordernde Komponente,
			// ist aber nicht plattformunabhängig.
			// Deshalb requestFocusInWindow() verwenden.
			tf1.requestFocusInWindow();
			
		}
		
	}
	
	private class ButtonLoeschenActionListener implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e)
		{
			
			System.out.println(((JButton)e.getSource()).getText() + ": Button gelickt");
			
			tf1.setText(null);
			tf2.setText(null);
			
			// requestFocus() setzt den Focus auf die anfordernde Komponente,
			// ist aber nicht plattformunabhängig.
			// Deshalb requestFocusInWindow() verwenden.
			tf1.requestFocusInWindow();
			
		}
		
	}
	
}
