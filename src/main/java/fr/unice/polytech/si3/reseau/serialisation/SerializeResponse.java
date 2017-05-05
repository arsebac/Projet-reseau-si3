package fr.unice.polytech.si3.reseau.serialisation;

import common.Response;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author François Melkonian
 */
public class SerializeResponse {

	public static void run(ObjectOutputStream stream, Response rep) {
		try {
			stream.writeObject(rep);
		} catch (IOException e) {
			throw new IllegalStateException("La réponse du serveur est invalide : "+rep.getResponses(),e);
		}
	}
}
