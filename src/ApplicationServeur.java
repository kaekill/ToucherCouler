package network;

import java.util.Calendar;


import network.InterfaceGraphiqueServeur;
import network.ClientCoteServeur;
import network.ServeurSocket;

public class ApplicationServeur {
	private int ok =0;
	private InterfaceGraphiqueServeur interfaceGraphiqueServeur;
	private ServeurSocket serveurSocket;
	public ApplicationServeur(){
		interfaceGraphiqueServeur = new InterfaceGraphiqueServeur(this);
	}
	public static void main(String[] args) {
		ApplicationServeur ma = new ApplicationServeur();
	}
	// Les méthodes utiles
	public void traiteClientConnecte(ClientCoteServeur ccs){
		getInterfaceGraphiqueServeur().ajouteDansLaConsole(
				Console.getInviteDeCommande()+"On a reçu le client numéro "+
				ccs.getNum()+"\n");
		getInterfaceGraphiqueServeur().ajouteClientJComboBox(ccs);
	}

	public void traiteObjetRecu(ClientCoteServeur ccs,Object object){
		Calendar cal = Calendar.getInstance();
		getInterfaceGraphiqueServeur().ajouteDansLaConsole(
				Console.getInviteDeCommande()+"> Reçu du client "+ 
				ccs.getNum()+" : "+object.toString()+"\n");
	}

	public void traiteObjetAEnvoyer(ClientCoteServeur ccs,Object o){
		getServeurSocket().ecrireSurUnClient(ccs, o);
	}

	public void traiteObjetAEnvoyerATousLesClients(Object o){
		getServeurSocket().ecrirSurTousLesClients(o);
	}

	public void traiteClientDeconnecte(ClientCoteServeur ccs){
		getInterfaceGraphiqueServeur().supprimeClientJComboBox(ccs);
	}

	// Les getteurs et les setteurs
	public InterfaceGraphiqueServeur getInterfaceGraphiqueServeur() {
		return interfaceGraphiqueServeur;
	}
	public void setInterfaceGraphiqueServeur(InterfaceGraphiqueServeur interfaceGraphiqueServeur) {
		this.interfaceGraphiqueServeur = interfaceGraphiqueServeur;
	}
	public ServeurSocket getServeurSocket() {
		return serveurSocket;
	}
	public void setServeurSocket(ServeurSocket serveurSocket) {
		this.serveurSocket = serveurSocket;
	}
	public int getOK(){
		return ok;
	}
}
