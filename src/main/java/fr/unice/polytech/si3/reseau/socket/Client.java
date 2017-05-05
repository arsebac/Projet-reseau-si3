package fr.unice.polytech.si3.reseau.socket;

import common.Code;
import common.Idea;
import common.Request;
import common.Response;
import fr.unice.polytech.si3.reseau.serialisation.DeserializeResponse;
import fr.unice.polytech.si3.reseau.serialisation.SerializeRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static common.Code.ADD_IDEA;
import static common.Code.GET_IDEA;

/**
 * @author François Melkonian
 */
public class Client {
	private final Socket connection;
	private String req;

	public Client(Code code) throws IOException {
		connection = new Socket("127.0.0.1", 1234);
		req = code.name();
	}

	public void start() throws IOException {
		Idea i = new Idea("desc", "etudiant", "mail@g.com");
		List<Object> liste = new ArrayList<>();
		liste.add(i);
		Request request = new Request(req, liste);
		ObjectOutputStream stream = new ObjectOutputStream(connection.getOutputStream());
		SerializeRequest.run(stream, request);
		ObjectInputStream data = new ObjectInputStream(connection.getInputStream());
		Response r = DeserializeResponse.run(data);
		System.out.println(r.getResponses());

	}


	public static void main(String[] args) throws IOException {
		System.out.println("Quelle est la requête à envoyer ?");
		System.out.println("1 - Ajouter une idée");
		System.out.println("2 - Récupère la liste des idées");
		System.out.println("3 - Quitter");
		System.out.print("Votre choix : ");
		Scanner scanner = new Scanner(System.in);
		int choix = scanner.nextInt();
		if(choix == 1){
			Client c = null;
			try {
				c = new Client(ADD_IDEA);
				c.start();
			} catch (IOException e) {
				System.err.println("Le serveur est injoignable");
				System.exit(1);
			}
			main(args);
		}else if(choix == 2){
			Client d = null;
			try {
				d = new Client(GET_IDEA);
			} catch (IOException e) {
				System.err.println("Le serveur est injoignable");
				System.exit(1);
			}

			d.start();
			main(args);
		}else{
			System.exit(0);
		}


	}
}
