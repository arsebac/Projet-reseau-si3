package fr.unice.polytech.si3.reseau.serialisation;

import common.Response;

import java.io.ObjectInputStream;
import java.util.IllegalFormatException;

/**
 * @author François Melkonian
 */
public class DeserializeResponse {
	public static Response run(ObjectInputStream stream) throws IllegalFormatException {
		try {
			return  (Response) stream.readObject();
		}catch (Exception e){
			throw new IllegalStateException("Le serveur n'est pas compatible avec le client",e);
		}
	}
}
