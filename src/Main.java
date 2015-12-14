package network;

public class Main {
	public static void main(String[] args) {
		ApplicationServeur appliServeur = new ApplicationServeur();
		ApplicationClient appliClient[] = new ApplicationClient[Param.NB_CLIENTS];
		for (int i = 0 ; i < appliClient.length ; i++){
			appliClient[i] = new ApplicationClient();
		}
	}
}