package hibernate.lesson4;



import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;




public abstract class Repository <T> {
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
        }catch (Exception e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        System.out.println("Save is done");
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            System.err.println("Update is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        System.out.println("Update is done");

        return object;
    }



    protected   static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }



}
