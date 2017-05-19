package service;

import java.util.List;

import dao.EleveDAO;
import modele.Eleve;

public class EleveService {

	private static EleveDAO elevedao;

	public EleveService() {
		elevedao = new EleveDAO();
	}

	public void ajouter(Eleve eleve) {
		elevedao.openCurrentSessionwithTransaction();
		elevedao.ajouter(eleve);
		elevedao.closeCurrentSessionwithTransaction();
	}

	public void update(Eleve eleve) {
		elevedao.openCurrentSessionwithTransaction();
		elevedao.update(eleve);
		elevedao.closeCurrentSessionwithTransaction();
	}

	public Eleve findById(int id) {
		elevedao.openCurrentSession();
		Eleve eleve = elevedao.findById(id);
		elevedao.closeCurrentSession();
		return eleve;
	}

	public void delete(int id) {
		elevedao.openCurrentSessionwithTransaction();
		Eleve eleve = elevedao.findById(id);
		elevedao.delete(eleve);
		elevedao.closeCurrentSessionwithTransaction();
	}

	public List<Eleve> findAll() {
		elevedao.openCurrentSession();
		List<Eleve> eleve = elevedao.findAll();
		elevedao.closeCurrentSession();
		return eleve;
	}

	public void deleteAll() {
		elevedao.openCurrentSessionwithTransaction();
		elevedao.deleteAll();
		elevedao.closeCurrentSessionwithTransaction();
	}

	public EleveDAO elevedao() {
		return elevedao;
	}
}
