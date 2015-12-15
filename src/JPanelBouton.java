package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class JPanelBouton extends JPanel implements ActionListener {
	private JButton pa, torp, cr, sm1, sm2, reset, pret;

	public JPanelBouton() {
		pa = new JButton("Porte-Avion");
		pa.setBounds(60, 25, 100, 25);
		pa.addActionListener(this);
		this.add(pa);
		
		
		torp = new JButton("Torpilleur");
		torp.setBounds(170, 25, 100, 25);
		torp.addActionListener(this);
		this.add(torp);
		
		sm1 = new JButton("Sous-Marin Bravo");
		sm1.setBounds(280, 25, 150, 25);
		sm1.addActionListener(this);
		this.add(sm1);
		
		sm2 = new JButton("Sous-Marin Alpha");
		sm2.setBounds(440, 25, 150, 25);
		sm2.addActionListener(this);
		this.add(sm2);
		
		cr = new JButton("Croiseur");
		cr.setBounds(600, 25, 100, 25);
		cr.addActionListener(this);
		this.add(cr);
		
		reset = new JButton("Reset");
		reset.setBounds(770, 25, 130, 30);
		reset.addActionListener(this);
		reset.setLayout(null);
		this.add(reset);
		
		pret = new JButton("Prêt");
		pret.setBounds(905, 25, 130, 30);
		pret.addActionListener(this);
		pret.setLayout(null);
		this.add(pret);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== pa)System.out.println("porte-avion");
		if(e.getSource()== cr)System.out.println("croiseur");
		if(e.getSource()== sm1)System.out.println("sous-marin Bravo");
		if(e.getSource()== sm2)System.out.println("sous-marin Alpha");
		if(e.getSource()== torp)System.out.println("torpilleur");
		//if((Case)e.getSource()== pa)setBackground(Color.blue);
	}


}
