package touchercouler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class menu extends JFrame implements ActionListener {
	/**
	 Variables
	 */
	private static final long serialVersionUID = 1L;// add par default 
	private JButton quitter = new JButton("Quitter"); //bouton pour quitter
	private JButton creer = new JButton("Nouvelle Partie"); // bouton création de la partie
	private JButton rejoindre = new JButton("Jouer avec un ami");//rejoindre une partie via adresse ip
	private JLabel label = new JLabel(" ");	
	private JLabel titre = new JLabel("Toucher Couler");
	private JLabel mb = new JLabel("made by ");
	private JLabel noms = new JLabel("Kaeses Killian, Burduja Claudiu, Gregoire Jeremy");
	private nouvellePartie np;
	private joinFriend jf;
	
	/************launcher****************/
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*********Construction************/
	
	public menu (){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tailleEcran =  java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int hauteur = (int)tailleEcran.getHeight();
		int largeur = (int)tailleEcran.getWidth();
		setBounds((largeur/2)-228, (hauteur/2)-228, 456, 456);
		setTitle("Toucher Couler");
		this.setResizable(false); //pas de modif de taille
		
		label.setBounds(0, 0, 451, 345);
		setContentPane(label);
		
		/*********titre*********/
		
		titre.setForeground(new Color(0, 0, 255));
		titre.setFont(new Font("Arial", Font.BOLD, 30));
		titre.setBounds(115, 50, 250, 60);
		label.add(titre);
		
		/*******made by********/
		
		mb.setBounds(175, 370, 100, 20);
		mb.setForeground(Color.black);
		mb.setFont(new Font("Arial", Font.PLAIN, 12));
		label.add(mb);
		
		/*******noms**********/
		
		noms.setBounds(80, 390, 350, 20);
		noms.setForeground(Color.black);
		noms.setFont(new Font("Arial", Font.PLAIN, 12));
		label.add(noms);
		
		/*******Bouton créer********/
		
		creer.setBounds(138, 170, 150, 35);
		label.add(creer);
		creer.addActionListener(this);
		
		/******Bouton jouer avec des amis *****/
		
		rejoindre.setBounds(130, 230, 170, 35);
		label.add(rejoindre);
		rejoindre.addActionListener(this);
		
		/*******Bouton quitter******/
		
		
		quitter.setBounds(165, 290, 100, 35);
		label.add(quitter);
		quitter.addActionListener(this);
	}
	
	/******** let's move**********/
	
	public void actionPerformed(ActionEvent e) {
		//creer
		if (e.getSource() == creer)
		{
			np = new nouvellePartie(this);
			np.setVisible(true);
			this.setVisible(false);
		}
		//quitter
		if(e.getSource() == quitter)
		{
				System.exit(0);
		}
		//rejoindre
		if(e.getSource() == rejoindre)
		{
			jf = new joinFriend(this);
			jf.setVisible(true);
			this.setVisible(false);
		}
		
	}

}



