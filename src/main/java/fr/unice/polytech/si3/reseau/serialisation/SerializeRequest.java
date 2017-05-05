package fr.unice.polytech.si3.reseau.serialisation;

import common.Request;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author François Melkonian
 */
public class SerializeRequest {

	public static void run(ObjectOutputStream stream, Request rep) {
		try {
			stream.writeObject(rep);
		} catch (IOException e) {
			throw new IllegalStateException("La réponse du serveur est invalide : "+rep.getParams(),e);
		}
	}
}
