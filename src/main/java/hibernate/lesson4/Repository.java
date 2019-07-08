package hibernate.lesson4;



import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.List;


public abstract class Repository <T> {

    private static SessionFactory sessionFactory;
    protected Class<T> type;

    public T findById(long id) throws Exception{
        try(Session session=createSessionFactory().openSession()) {
            T object=session.get(type,id);
            return object;
        }catch(Exception e){
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
            throw e;
        }
    }
    public  T save (T object){
        Transaction transaction=null;
        try(Session session=createSessionFactory().openSession()){
            transaction=session.getTransaction();
            transaction.begin();
            session.save(object);
            transaction.commit();
            System.out.println("Save is done");
        }catch (Exception e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (transaction != null)
                transaction.rollback();
        }
        return object;
    }

    public  void delete(T object) {
        Transaction tr = null;
        try(Session session=createSessionFactory().openSession()) {
            tr = session.getTransaction();
            tr.begin();
            session.delete(object);
            tr.commit();
            System.out.println("Delete is done");
        } catch (Exception e) {
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        }
    }

    public T update(T object) {
        Transaction tr = null;
        try (Session session=createSessionFactory().openSession()){
            tr = session.getTransaction();
            tr.begin();
            session.update(object);
            tr.commit();
            System.err.println("Update is done");
        } catch (Exception e) {
            System.err.println("Update is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        }
        return object;
    }
    public List<T> findByQuery(String searchQuery) throws Exception {
        try(Session session=createSessionFactory().openSession()){
            SQLQuery query = session.createSQLQuery(searchQuery);
            query.addEntity(type);
            List<T> list = query.list();
            return list;
        } catch (Exception e) {
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
            throw e;
        }
    }


    protected   static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }



}
