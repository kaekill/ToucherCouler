package network;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import network.ApplicationClient;
import network.Param;

public class ClientSocket extends Socket implements Runnable {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ApplicationClient appliClient;
	
	
	public ClientSocket(ApplicationClient appliClient) throws UnknownHostException, IOException{
		super(Param.IP_SERVEUR,Param.NUM_PORT_DE_BASE);
		this.appliClient = appliClient;
		methodeCommuneAuxConstructeurs();
	}
	public ClientSocket(String ip, int port,ApplicationClient appliClient) throws UnknownHostException, IOException{
		super(ip,port);
		this.appliClient = appliClient;
		methodeCommuneAuxConstructeurs();
	}
	public void methodeCommuneAuxConstructeurs(){
		try {
			oos = new ObjectOutputStream(this.getOutputStream());
			ois = new ObjectInputStream(this.getInputStream());
			appliClient.setNum((int)ois.readObject());
			appliClient.setTitle("Client numéro "+appliClient.getNum());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	public void lireNonStop(){
		new Thread(this).start();
	}
	public void finalize(){
		try {
			this.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void ecrire(Object o){
		try {
			oos.writeObject(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object lire(){
		try {
			Object o = ois.readObject();
			appliClient.traiteObjetRecu(o);
			return o;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			try {
				this.close(); 
				// si on ne sait pas lire c'est que le serveur est fermé
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}
	public void run() {
		while (!this.isClosed()){
			Object o = this.lire();
		}
		
	}
}

