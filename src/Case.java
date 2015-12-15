package gui;

import java.awt.Color;

import javax.swing.JButton;

public class Case extends JButton {
	
	private boolean cliquable;
	
	private int ligne;
	private int colonne;
	
	private int bateau = 0;
	private boolean touche = false;
	
	public int getLigne() {
		return ligne;
	}
	public int getColonne() {
		return colonne;
	}
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}
	public Case(int ligne, int colonne) {
		super();
		this.ligne = ligne;
		this.colonne = colonne;
		this.setOpaque(true);
	}
	public boolean isCliquable() {
		return cliquable;
	}
	public void setCliquable(boolean cliquable) {
		this.cliquable = cliquable;
	}
	public int getBateau() {
		return bateau;
	}
	public void setBateau(int bateau) {
		this.bateau = bateau;
	}

	
}