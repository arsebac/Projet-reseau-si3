package fr.unice.polytech.si3.reseau.socket;


import fr.unice.polytech.si3.reseau.protocol.MyProtocol;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author François Melkonian
 */
public class Server {
	private MyProtocol protocol;
	private ServerSocket serverSocket;
	private Socket client;
	public Server() throws IOException {
		protocol = new MyProtocol();
		serverSocket = new ServerSocket(1234);

	}
	public void run() throws IOException {
		client = serverSocket.accept();
		new ServerThread(client,protocol).run();
		client.close();
	}

	public void close() throws IOException {
		serverSocket.close();
	}
}
