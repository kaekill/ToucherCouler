package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JFramePrincipale extends JFrame {

	private JPanel jPanelCentre;
	private JPanelBouton jpb = new JPanelBouton();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePrincipale frame = new JFramePrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFramePrincipale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 809);
		
		jPanelCentre = new JPanel();
		jPanelCentre.setBorder(new EmptyBorder(5, 5, 5, 5));
		jPanelCentre.setLayout(new BorderLayout(0, 0));
		setContentPane(jPanelCentre);
		setSize(1100,650);
		JPanel jPanelHaut = new JPanel();
		jPanelCentre.add(jPanelHaut, BorderLayout.NORTH);
		
		JPanel jPanelBas = new JPanel();
		jPanelCentre.add(jPanelBas, BorderLayout.SOUTH);
		
		
		Grille grilleAlliée = new Grille(Grille.TYPE_ALLIE);
		Grille grilleEnnemie = new Grille(Grille.TYPE_ENNEMI);
		 
		jPanelCentre.add(grilleAlliée, BorderLayout.WEST);
		jPanelCentre.add(grilleEnnemie, BorderLayout.EAST);
		jPanelBas.add(jpb);
		
		this.setVisible(true);
	}

}
