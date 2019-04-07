package Drawing;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

import Config.Constants;
//import Panele.crosshairPanel;
//import Panele.mainMenu;

public class MenuFrame extends JFrame implements ActionListener {
	JButton start, celownik, nWyniki, pomoc, koniec, powrot;
	JPanel menuPanel, crosshairPanel;
	JSlider Csize,CThickness;
	public MenuFrame() {
		super(Constants.gameName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocation(50,50);
		setSize(Constants.mainMenuFrameHeight, Constants.mainMenuFrameWidth);
		//Layout
		//setLayout(new GridLayout(1,5));
		
		menuPanel= new JPanel();
		menuPanel.setSize(Constants.mainMenuFrameHeight, Constants.mainMenuFrameWidth);
		menuPanel.setLayout(new GridLayout(5,1));
		
		crosshairPanel = new JPanel();
		crosshairPanel.setSize(Constants.mainMenuFrameHeight, Constants.mainMenuFrameWidth);
		
		
		JButton start=new JButton("Start");
		JButton celownik=new JButton("Opcje Celownika");
		JButton nWynik=new JButton("Lista Najlepszych Wyników");
		JButton pomoc=new JButton("Pomoc");
		JButton koniec=new JButton("Zakoñcz dzia³anie programu");
		JButton powrot=new JButton("Powrot");
		//JSlider 
		
		
		start.setActionCommand("start");
		celownik.setActionCommand("celownik");
		nWynik.setActionCommand("nWynik");
		pomoc.setActionCommand("pomoc");
		koniec.setActionCommand("koniec");
		powrot.setActionCommand("powrot");
		
		start.addActionListener(this);
		celownik.addActionListener(this);
		nWynik.addActionListener(this);
		pomoc.addActionListener(this);
		koniec.addActionListener(this);
		powrot.addActionListener(this);
		
		menuPanel.add(start);
		menuPanel.add(celownik);
		menuPanel.add(nWynik);
		menuPanel.add(pomoc);
		menuPanel.add(koniec);
		crosshairPanel.add(powrot);
		add(menuPanel);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		if(source == "start") {
			System.out.println("start");
			
		}
		if(source == "celownik") {
			System.out.println("celownik");
			this.remove(menuPanel);
			//crosshairPanel = new crosshairPanel(2,1);
			this.add(crosshairPanel);
			this.revalidate();
            this.repaint();
		}
		if(source == "nWynik") {
			System.out.println("nWynik");
		}
		if(source == "pomoc") {
			System.out.println("pomoc");
		}
		if(source == "koniec") {
			System.out.println("koniec");
		}
		if(source == "powrot") {
			System.out.println("koniec");
			this.remove(crosshairPanel);
			this.add(menuPanel);
			this.revalidate();
            this.repaint();
		}
	}
}

