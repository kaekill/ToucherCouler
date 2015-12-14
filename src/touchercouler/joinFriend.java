package touchercouler;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import network.ClientCoteServeur;

public class joinFriend extends JFrame implements ActionListener {

	/**
	 Variables
	 */
	private static final long serialVersionUID = 1L;
	private menu men;
	private JLabel label;
	private JButton go;
	private JButton retour;
	private JLabel txt;
	private JTextField ctxt;
	private JButton pret;
	private ClientCoteServeur ccs;
	
	public joinFriend (menu men){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tailleEcran =  java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
		this.setBounds((largeur/2)-302, (hauteur/2)-213, 604, 426);
		this.setTitle("En attente due ton pote");
		this.setResizable(false);
		this.men = men;
		
		label = new JLabel(" ");
		label.setBounds(0, 0, 451, 345);
		this.setContentPane(label);
		
		/*****Bouton go*******/
		
		go = new JButton("Go");
		go.setBounds(410, 43, 50, 23);
		go.addActionListener(this);
		label.add(go);
		
		/*****Bouton prêt*****/
		
		pret = new JButton("Prêt");
		pret.setBounds(270, 90, 120, 30);
		pret.setEnabled(false);
		pret.addActionListener(this);
		label.add(pret);
		
		/******Bouton prêt*****/
		
		retour = new JButton("Retour");
		retour.setBounds(250,365,100,25);
		retour.addActionListener(this);
		label.add(retour);
		
		/******text*******/
		
		txt = new JLabel("IP ami : ");
		txt.setForeground(Color.blue);
		txt.setFont(new Font("Arial", Font.BOLD, 20));
		txt.setBounds(100, 40, 180, 30);
		label.add(txt);
		
		/*****champs texte*****/
		
		ctxt = new JTextField("");
		ctxt.setBounds(270, 40, 120, 30);
		label.add(ctxt);
	}
	public ClientCoteServeur getCL(){
		return ccs;
	}

		/*******Let's move*****/
	
	public void actionPerformed(ActionEvent e) {
		//bouton go
		if(e.getSource() == go){
			if(this.ctxt.getText().compareTo("")==0){
				JOptionPane.showMessageDialog(null,"Tu dois mettre une bonne adresse IP" );
			}
				else{
					ccs = new ClientCoteServeur(ctxt.getText());
					if(ccs.getOK() == 1)	pret.setEnabled(true);
					else{
						JOptionPane.showMessageDialog(null, "L'hôte n'a pas répondu");
						System.exit(1);
					}
				}
			}	
			
		
		//bouton retour
		if(e.getSource() == retour)
		{
			men.setVisible(true);
			this.dispose();
		}
		
	}

}
