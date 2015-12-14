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

import network.ApplicationServeur;
import network.ServeurSocket;

public class nouvellePartie extends JFrame implements ActionListener {
	/**
	 Variables
	 */
	private static final long serialVersionUID = 1L;
	private JTextField ip;
	private menu men;
	private JLabel txt;
	private JButton retour;
	private JLabel label;
	private JButton creation;
	private JLabel attenteJoueur;
	private ApplicationServeur srv = null;
	
	public nouvellePartie(menu men) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tailleEcran =  java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
		setBounds((largeur/2)-302, (hauteur/2)-213, 604, 426);
		setTitle("Nouvelle Partie");
		this.setResizable(false);
		this.men = men;
		
		/***** label*****/
		
		label = new JLabel(" ");
		label.setBounds(0, 0, 451, 345);
		setContentPane(label);
		
		/******* texte ******/
		
		txt = new JLabel("IP serveur : ");
		txt.setFont(new Font("Arial", Font.PLAIN, 20));
		txt.setForeground(Color.blue);
		txt.setBounds(30,40,200,25);
		label.add(txt);
		
		/******Champ texte******/
		
		ip = new JTextField("");
		ip.setBounds(235,40,150,25);
		label.add(ip);
		
		/******Bouton création*****/
		
		creation = new JButton("Création");
		creation.setBounds(255,80,100,25);
		creation.addActionListener(this);
		label.add(creation);
		
		/****** Bouton de retour******/
		
		retour = new JButton("Retour");
		retour.setBounds(255,365,100,25);
		retour.addActionListener(this);
		label.add(retour);
		
		attenteJoueur = new JLabel("En attente de connexion d'un joueur ...");
		attenteJoueur.setBounds(120, 130, 380, 30);
		attenteJoueur.setOpaque(true);
		attenteJoueur.setFont(new Font("Arial", Font.BOLD,20));
		attenteJoueur.setForeground(Color.blue);
		attenteJoueur.setVisible(false);
		label.add(attenteJoueur);
		
	}
	public void setAttenteJoueur(JLabel attenteJoueur) {
		this.attenteJoueur = attenteJoueur;
	}
	
	/*******let's move********/
	
	public void actionPerformed(ActionEvent e) {
		//bouton retour
		if(e.getSource() == retour)
		{
			men.setVisible(true);
			this.dispose();
		}
		//bouton creation
		if (e.getSource()== creation){
			if(this.ip.getText().compareTo("")==0){
				JOptionPane.showMessageDialog(null,"Tu dois mettre une bonne adresse IP" );
				
			}
			else{
				attenteJoueur.setVisible(true);
				srv = new ApplicationServeur();
					if(srv.getOK()==2){
						this.dispose();
					}
			}
		}
		
	}

}
