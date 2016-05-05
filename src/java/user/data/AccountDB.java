package user.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import user.account.Account;

public class AccountDB {

    public static void insert (Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }

    }
/*
    public static void delete(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(account));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }

    }

    public static Account selectAccount(String userName, Account.Type type) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Account> q = em.createQuery("SELECT a FROM Account a WHERE a.user.username = :username AND a.type = :accType", Account.class);
        q.setParameter("userName", userName);
        q.setParameter("accType", type);
        try {
            List<Account> accounts = q.getResultList();
            return accounts.get(0);
        } catch (IndexOutOfBoundsException iobe) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean userNameExists(String userName) {
        if (selectAccount(userName, Account.Type.Checking) != null) {
            return true;
        } else {
            return selectAccount(userName, Account.Type.Savings) != null;
        }
    }

    public static boolean userNameExists(String userName, Account.Type type) {
        return selectAccount(userName, type) != null;
    }
*/
}
