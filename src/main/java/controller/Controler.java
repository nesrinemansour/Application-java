package controller;

import org.apache.log4j.BasicConfigurator;

import modele.Eleve;
import service.EleveService;

public class Controler {
	public static void main(String args[]) {

		BasicConfigurator.configure();

		EleveService eleveservice = new EleveService();
		Eleve eleve;

		/*
		 * Eleve eleve2 = new Eleve(1, "Dupond", "Jean"); Eleve eleve3 = new
		 * Eleve(3, "Dupond", "Paul"); Eleve eleve4 = new Eleve(4, "Dupond",
		 * "François"); Eleve eleve5 = new Eleve(5, "Dupond", "Ariel");
		 * 
		 * /* eleveservice.ajouter(eleve2); eleveservice.ajouter(eleve3);
		 * eleveservice.ajouter(eleve4); eleveservice.ajouter(eleve5);
		 * System.out.println("ajout d'un éleve");
		 */
		// System.out.println("eleve ajouté");
		// eleveservice.deleteAll();
		// eleveservice.delete(2);
		eleve = eleveservice.findById(3);
		System.out.println("l'eleve concerné est " + eleve.toString());

		System.out.println(eleveservice.findAll());

	}
}