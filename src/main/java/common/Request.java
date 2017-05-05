package common;

import java.io.Serializable;
import java.util.List;

/**
 * Requête envoyée au serveur
 *
 * @author David Lang
 * @author François Melkonian
 * @author Alexis Deslandes
 */
public class Request implements Serializable {
	private String code;
	protected List<?> params;

	/**
	 * Crée une requête sans arguments
	 *
	 * @param code Le nom de la requête utilisée
	 */
	public Request(String code) {
		this.code = code;
	}

	/**
	 * Crée une requête
	 *
	 * @param code   Le nom de la requête utilisée
	 * @param params La liste des paramètres utiles pour le traitement de la requête
	 */
	public Request(String code, List<?> params) {
		this(code);
		this.params = params;
	}

	/**
	 * Récupère le nom de la requête
	 *
	 * @return le nom de la requête
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Récupère la liste des paramètres
	 *
	 * @return Liste des paramètres
	 */
	public List<?> getParams() {
		return params;
	}

	public String toString() {
		return code + "\n" + params.toString();
	}
}
