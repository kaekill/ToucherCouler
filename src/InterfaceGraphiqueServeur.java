package network;
import javax.swing.JFrame;

import javax.swing.JPanel;

import network.ApplicationServeur;
import network.Param;
import network.ClientCoteServeur;

public class InterfaceGraphiqueServeur extends JFrame {
	private JPanel jpanelServer;
	private ApplicationServeur ma;
	public InterfaceGraphiqueServeur(ApplicationServeur ma) {
		this.ma = ma;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Serveur");
		setBounds(
				Param.COIN_SUP_GAUCHE_SERVEUR_X, 
				Param.COIN_SUP_GAUCHE_SERVEUR_Y, 
				Param.LARGEUR_JFRAME_ACCUEIL_SERVEUR, 
				Param.HAUTEUR_JFRAME_ACCUEIL_SERVEUR
		);
		jpanelServer = new JPanelAccueilServeur(ma);
		setContentPane(jpanelServer);
		this.setVisible(true);
	}
	
	public void ajouteDansLaConsole(String s){
		JPanelPrincipalServeur jps = (JPanelPrincipalServeur) jpanelServer;
		jps.ajouteDansLaConsole(s);
	}
	public void ajouteClientJComboBox(ClientCoteServeur client){
		JPanelPrincipalServeur jps = (JPanelPrincipalServeur) jpanelServer;
		jps.ajouteClientJComboBox(client);
	}
	public void supprimeClientJComboBox(ClientCoteServeur client){
		JPanelPrincipalServeur jps = (JPanelPrincipalServeur) jpanelServer;
		jps.ajouteClientJComboBox(client);
	}
	public JPanel getJpanelServer() {
		return jpanelServer;
	}
	public void setJpanelServer(JPanel jpanelServer) {
		this.jpanelServer = jpanelServer;
	}
}
