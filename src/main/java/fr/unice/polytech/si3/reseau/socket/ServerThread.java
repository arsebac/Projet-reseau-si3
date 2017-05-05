package fr.unice.polytech.si3.reseau.socket;

import common.Request;
import common.Response;
import fr.unice.polytech.si3.reseau.protocol.MyProtocol;
import fr.unice.polytech.si3.reseau.serialisation.DeserializeRequest;
import fr.unice.polytech.si3.reseau.serialisation.SerializeResponse;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author François Melkonian
 */
public class ServerThread extends Thread {
	private Socket socket;
	private MyProtocol protocol;

	public ServerThread(Socket socket, MyProtocol protocol) {
		super("ServerThread");
		this.protocol = protocol;
		this.socket = socket;
	}

	public Request decode() throws IOException {
		ObjectInputStream stream = new ObjectInputStream(socket.getInputStream());
		Request req = DeserializeRequest.run(stream);
		return req;
	}

	@Override
	public void run() {

		Request requete = null;
		try {
			requete = decode();
			Response rep = protocol.respond(requete);
			System.out.println("envoye :" + rep);
			sendResponse(rep, true);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendResponse(Response rep, boolean lastCommand) throws IOException {
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		ObjectOutputStream stream = new ObjectOutputStream(output);
		SerializeResponse.run(stream, rep);
		if (lastCommand) {
			//socket.close();
		}
	}
}
