package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import modele.Eleve;

public class EleveDAO {

	private Session currentSession;
	private Transaction currentTransaction;

	public EleveDAO() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void ajouter(Eleve eleve) {
		getCurrentSession().save(eleve);
	}

	public void update(Eleve eleve) {
		getCurrentSession().update(eleve);
	}

	public Eleve findById(int id) {
		Eleve eleve = (Eleve) getCurrentSession().get(Eleve.class, id);
		return eleve;
	}

	public void delete(Eleve eleve) {
		getCurrentSession().delete(eleve);
	}

	@SuppressWarnings("unchecked")
	public List<Eleve> findAll() {
		List<Eleve> eleve = getCurrentSession().createQuery("from Eleve").list();
		return eleve;
	}

	public void deleteAll() {
		List<Eleve> eleveList = findAll();
		for (Eleve eleve : eleveList) {
			delete(eleve);
		}
	}
}
