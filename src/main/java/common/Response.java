package common;

import java.io.Serializable;
import java.util.List;

/**
 * Réponse du serveur
 *
 * @author David Lang
 * @author François Melkonian
 * @author Alexis Deslandes
 */
public class Response implements Serializable {
	protected List<?> responses;

	/**
	 * Crée une réponse vide
	 */
	public Response() {
	}

	/**
	 * Création de la réponse du serveur
	 *
	 * @param responses liste des objets renvoyés par le serveur
	 */
	public Response(List<?> responses) {
		this.responses = responses;
	}

	/**
	 * Récupère les objets renvoyés par le serveur
	 *
	 * @return objets renvoyés par le serveur
	 */
	public List<?> getResponses() {
		return responses;
	}

	public String toString() {
		return responses.toString();
	}
}
