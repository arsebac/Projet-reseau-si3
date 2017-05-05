package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Représentation d'une idée de projets Innovation en SI4
 *
 * @author François Melkonian
 * @author David Lang
 * @author Alexis Deslandes
 */
public class Idea implements Serializable {
	private int id;
	private String description;
	private List<String> technologiesEnvisagees;
	private String etudiant;
	private String email;

	/**
	 * Création de l'idée
	 *
	 * @param description            Description textuelle de l'idée
	 * @param technologiesEnvisagees Liste des technologies utilisée pour l'idée de projet
	 * @param etudiant               Le nom de l'étudiant ayant proposé l'idée
	 * @param email                  L'email de l'étudiant ayant proposé l'idée
	 */
	public Idea(String description, List<String> technologiesEnvisagees, String etudiant, String email) {
		this.description = description;
		this.technologiesEnvisagees = technologiesEnvisagees;
		this.etudiant = etudiant;
		this.email = email;
	}

	/**
	 * Création d'une idée sans préciser les technologies utilisées
	 *
	 * @param description Description textuelle de l'idée
	 * @param etudiant    Le nom de l'étudiant ayant proposé l'idée
	 * @param email       L'email de l'étudiant ayant proposé l'idée
	 */
	public Idea(String description, String etudiant, String email) {
		this(description, new ArrayList<String>(), etudiant, email);
	}

	/**
	 * Permet de définir un identifiant à une idée
	 *
	 * @param id Le nouvel identifiant de l'idée
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return description + "\n" + etudiant + "<" + email + ">\n" + technologiesEnvisagees;
	}
}
