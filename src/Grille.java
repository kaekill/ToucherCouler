package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;



import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import javax.swing.JButton;

public class Grille extends JPanel implements ActionListener{

	//private JPanel contentPane;
	public final static int TYPE_ENNEMI = 0;
	public final static int TYPE_ALLIE = 1;
	private int nbLignes=11;
	private int nbColonnes=11;
	private int largeurcolonnePixel = 50;
	private int hauterLignePixel = 50;
	private int pixelsEnPlusHauteur = 41;
	private int pixelsEnPlusLargeur = 19;
	private Case tabJButton[][] = new Case[nbLignes][nbLignes];
	private int type;

	public Grille(int type) {
		this.type = type;

		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[nbColonnes];
		gbl_contentPane.rowHeights = new int[nbLignes];
		gbl_contentPane.columnWeights = new double[nbColonnes];
		gbl_contentPane.rowWeights = new double[nbLignes];
		this.setLayout(gbl_contentPane);

		for (int l = 1; l < nbLignes; l++) {
			for (int c = 1; c < nbColonnes; c++) {
				tabJButton[l][c] = new Case(l,c);
				tabJButton[l][c].setPreferredSize(new Dimension(largeurcolonnePixel,hauterLignePixel));
				tabJButton[l][c].setMinimumSize(new Dimension(largeurcolonnePixel,hauterLignePixel));
				gbc.gridx = c;
				gbc.gridy = l;
				this.add(tabJButton[l][c], gbc);
				tabJButton[l][c].addActionListener(this);
			}	
		}

		setBounds(100, 100, 2*nbColonnes*largeurcolonnePixel+pixelsEnPlusLargeur, 2*nbLignes*hauterLignePixel+pixelsEnPlusHauteur);

	}
	

	public Case[][] getTabJButton() {
		return tabJButton;
	}


	public void setTabJButton(Case[][] tabJButton) {
		this.tabJButton = tabJButton;
	}


	public void actionPerformed(ActionEvent e) {

		(
				(Case)e.getSource()).setBackground(Color.red);
	}
}