//package com.pvj.db;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.PersistenceContext;
//import javax.persistence.PersistenceUnit;
//import javax.transaction.Transactional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.pvj.model.User;
//
//@Repository
//@Transactional
//public class UserDB {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(UserDB.class);
//
//	@PersistenceUnit
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//	@PersistenceContext
//	EntityManager em = emf.createEntityManager();
//
//	public void insertUser(User user) {
//		em.getTransaction().begin();
//		em.persist(user);
//		em.getTransaction().commit();
//	}
//
//	public List<User> getAllUser() {
//		Query query =  em.createNamedQuery("SELECT a FROM User a", User.class);
//		LOGGER.info(list.toString());
//		list.stream().forEach(x->System.out.println(x.getUserName()));
//		return list;
//
//	}
//
//}
