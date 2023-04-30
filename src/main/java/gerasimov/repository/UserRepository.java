package gerasimov.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gerasimov.model.User;

/**
 * Repository class.
 */
@Repository
public class UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Save entity User to BD.
     * @param user
     */
    public void save(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    /**
     * Get entity User without lazy fields from BD by id.
     * @param id
     * @return User.
     */
    public User getUserById(int id) {
        User user;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            user = session.createQuery("from User u where id =:id", User.class).setParameter("id", id).getSingleResult();
            session.getTransaction().commit();
            session.close();
        }
        return user;
    }

    /**
     * Get entity User with lazy fields from BD by id.
     * @param id
     * @return User.
     */
    public User getUserWithCardsById(int id) {
        User user;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            user = session.createQuery("from User u left join fetch u.cards where u.id =:id", User.class).setParameter("id", id).getSingleResult();
            session.getTransaction().commit();
            session.close();
        }
        return user;
    }
}

