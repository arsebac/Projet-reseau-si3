package fr.unice.polytech.si3.reseau;


import fr.unice.polytech.si3.reseau.socket.Server;

/**
 * @author François Melkonian
 */
public class Main {
	public static void main(String[] args) throws Exception {
					runServer();
	}
	private static void runServer() throws Exception{
		Server server = new Server();
		while (true){
			server.run();
		}
	}
}