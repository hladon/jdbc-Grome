package hibernate.lesson3;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;


import java.util.List;


public abstract class DAO <T>{
    private static SessionFactory sessionFactory;

    public  T save (T object){
        Session session=null;
        Transaction transaction=null;
        try{
            session=createSessionFactory().openSession();
            transaction=session.getTransaction();
            transaction.begin();
            session.save(object);
            transaction.commit();
        }catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return object;
    }

    public  void delete(T object) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.delete(object);

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        System.out.println("Delete is done");
    }
    public T update(T object) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.update(object);

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Update is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return object;
    }

        public T findByIdObject(long id,String table){
        Session session=null;
        String statment="SELECT * FROM "+table+" WHERE ID="+id;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery(statment);
            List<T> list=query.list();
            if(list.isEmpty())
                return null;

            return (T)list.get(0);
        }catch(HibernateException e){
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        }finally {
            if (session!=null)
                session.close();
        }
        return null;
    }

    public static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}