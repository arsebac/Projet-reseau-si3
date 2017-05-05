package fr.unice.polytech.si3.reseau.serialisation;

import common.Request;

import java.io.ObjectInputStream;
import java.util.IllegalFormatException;

/**
 * @author François Melkonian
 */
public class DeserializeRequest {
	public static Request run(ObjectInputStream stream) throws IllegalFormatException {
		try {
			return (Request) stream.readObject();
		}catch (Exception e){
			throw new IllegalStateException("Le client n'est pas compatible avec le serveur",e);
		}
	}
}
