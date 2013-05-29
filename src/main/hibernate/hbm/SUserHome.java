package main.hibernate.hbm;

// Generated May 29, 2013 12:42:53 PM by Hibernate Tools 3.6.0

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class SUser.
 * @see main.hibernate.hbm.UserVO
 * @author Hibernate Tools
 */
public class SUserHome {

    private static final Log log = LogFactory.getLog(SUserHome.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
	try {
	    return (SessionFactory) new InitialContext()
		    .lookup("SessionFactory");
	} catch (Exception e) {
	    log.error("Could not locate SessionFactory in JNDI", e);
	    throw new IllegalStateException(
		    "Could not locate SessionFactory in JNDI");
	}
    }

    public void persist(UserVO transientInstance) {
	log.debug("persisting SUser instance");
	try {
	    sessionFactory.getCurrentSession().persist(transientInstance);
	    log.debug("persist successful");
	} catch (RuntimeException re) {
	    log.error("persist failed", re);
	    throw re;
	}
    }

    public void attachDirty(UserVO instance) {
	log.debug("attaching dirty SUser instance");
	try {
	    sessionFactory.getCurrentSession().saveOrUpdate(instance);
	    log.debug("attach successful");
	} catch (RuntimeException re) {
	    log.error("attach failed", re);
	    throw re;
	}
    }

    public void attachClean(UserVO instance) {
	log.debug("attaching clean SUser instance");
	try {
	    sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
	    log.debug("attach successful");
	} catch (RuntimeException re) {
	    log.error("attach failed", re);
	    throw re;
	}
    }

    public void delete(UserVO persistentInstance) {
	log.debug("deleting SUser instance");
	try {
	    sessionFactory.getCurrentSession().delete(persistentInstance);
	    log.debug("delete successful");
	} catch (RuntimeException re) {
	    log.error("delete failed", re);
	    throw re;
	}
    }

    public UserVO merge(UserVO detachedInstance) {
	log.debug("merging SUser instance");
	try {
	    UserVO result = (UserVO) sessionFactory.getCurrentSession().merge(
		    detachedInstance);
	    log.debug("merge successful");
	    return result;
	} catch (RuntimeException re) {
	    log.error("merge failed", re);
	    throw re;
	}
    }

    public UserVO findById(java.lang.Integer id) {
	log.debug("getting SUser instance with id: " + id);
	try {
	    UserVO instance = (UserVO) sessionFactory.getCurrentSession().get(
		    "main.hibernate.hbm.SUser", id);
	    if (instance == null) {
		log.debug("get successful, no instance found");
	    } else {
		log.debug("get successful, instance found");
	    }
	    return instance;
	} catch (RuntimeException re) {
	    log.error("get failed", re);
	    throw re;
	}
    }

    public List<UserVO> findByExample(UserVO instance) {
	log.debug("finding SUser instance by example");
	try {
	    List<UserVO> results = (List<UserVO>) sessionFactory
		    .getCurrentSession()
		    .createCriteria("main.hibernate.hbm.SUser")
		    .add(create(instance)).list();
	    log.debug("find by example successful, result size: "
		    + results.size());
	    return results;
	} catch (RuntimeException re) {
	    log.error("find by example failed", re);
	    throw re;
	}
    }
}
