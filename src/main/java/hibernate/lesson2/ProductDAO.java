package hibernate.lesson2;

import hibernate.lesson1.Product;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;




import java.util.LinkedList;
import java.util.List;

public class ProductDAO {

    private static SessionFactory sessionFactory;

    public static Product findById(long id) {
        Session session = null;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("SELECT * FROM PRODUCT WHERE ID=:id");
            query.addEntity(Product.class);
            query.setParameter("id", id);
            List<Product> list = query.list();
            return (Product) list.get(0);
        } catch (HibernateException e) {
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }

    public static List<Product> findByName(String name) {
        Session session = null;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("SELECT * FROM PRODUCT WHERE NAME=:name");
            query.addEntity(Product.class);
            query.setParameter("name", name);
            List<Product> list = query.list();
            return list;
        } catch (HibernateException e) {
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }

    public static List<Product> findByContainetName(String name) {
        Session session = null;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("SELECT * FROM PRODUCT");
            query.addEntity(Product.class);
            List<Product> list = query.list();
            List<Product> resList = new LinkedList<>();
            for (Product product : list) {
                if (product.getName().contains(name))
                    resList.add(product);
            }
            return resList;
        } catch (HibernateException e) {
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }

    public static List<Product> findByPrice(int price, int delta) {
        Session session = null;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("SELECT * FROM PRODUCT WHERE PRICE BETWEEN :m AND :mx");
            query.addEntity(Product.class);
            query.setParameter("m", price - delta);
            query.setParameter("mx", price + delta);
            List<Product> list = query.list();
            return list;
        } catch (HibernateException e) {
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }

    public static List<Product> findByNameSortedAsc(String name) {
        Session session = null;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("SELECT * FROM PRODUCT WHERE NAME=:name ORDER BY NAME ASC");
            query.addEntity(Product.class);
            query.setParameter("name", name);
            List<Product> list = query.list();
            return list;
        } catch (HibernateException e) {
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }

    public static List<Product> findByNameSortedDesc(String name) {
        Session session = null;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("SELECT * FROM PRODUCT WHERE NAME=:name ORDER BY NAME DESC");
            query.addEntity(Product.class);
            query.setParameter("name", name);
            List<Product> list = query.list();
            return list;
        } catch (HibernateException e) {
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }

    public static List<Product> findByPriceSortedDesc(int price, int delta) {
        Session session = null;
        try {
            session = createSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("SELECT * FROM PRODUCT WHERE PRICE BETWEEN :m AND :mx ORDER BY PRICE DESC");
            query.addEntity(Product.class);
            query.setParameter("m", price - delta);
            query.setParameter("mx", price + delta);
            List<Product> list = query.list();
            return list;
        } catch (HibernateException e) {
            System.err.println("Search is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }

//    public static Product findById(long id){
//        Session session=null;
//        try {
//            session = createSessionFactory().openSession();
//            Query query=session.createQuery("FROM Product WHERE ID=:id");
//            query.setParameter("id",id);
//            List<Product> list=query.list();
//            return (Product)list.get(0);
//        }catch(HibernateException e){
//            System.err.println("Search is failed");
//            System.err.println(e.getMessage());
//        }finally {
//            if (session!=null)
//                session.close();
//        }
//        return null;
//    }
//
//    public static List<Product> findByName(String name){
//        Session session=null;
//        try {
//            session = createSessionFactory().openSession();
//            Query query=session.createQuery("FROM Product WHERE NAME=:name");
//            query.setParameter("name",name);
//            List<Product> list=query.list();
//            return list;
//        }catch(HibernateException e){
//            System.err.println("Search is failed");
//            System.err.println(e.getMessage());
//        }finally {
//            if (session!=null)
//                session.close();
//        }
//        return null;
//    }
//
//    public static List<Product> findByContainetName(String name){
//        Session session=null;
//        try {
//            session = createSessionFactory().openSession();
//            Query query=session.createQuery("FROM Product");
//            List<Product> list=query.list();
//            List<Product> resList=new LinkedList<>();
//            for (Product product:list){
//                if (product.getName().contains(name))
//                    resList.add(product);
//            }
//            return resList;
//        }catch(HibernateException e){
//            System.err.println("Search is failed");
//            System.err.println(e.getMessage());
//        }finally {
//            if (session!=null)
//                session.close();
//        }
//        return null;
//    }
//
//    public static List<Product> findByPrice(int price, int delta){
//        Session session=null;
//        try {
//            session = createSessionFactory().openSession();
//            Query query=session.createQuery("FROM Product");
//            List<Product> list=query.list();
//            List<Product> resList=new LinkedList<>();
//            for (Product product:list){
//                if ((price-delta)<product.getPrice()&& product.getPrice()< (price+delta))
//                    resList.add(product);
//            }
//            return resList;
//        }catch(HibernateException e){
//            System.err.println("Search is failed");
//            System.err.println(e.getMessage());
//        }finally {
//            if (session!=null)
//                session.close();
//        }
//        return null;
//    }
//
//    public static List<Product> findByNameSortedAsc(String name){
//        Session session=null;
//        try {
//            session = createSessionFactory().openSession();
//            Query query=session.createQuery("FROM Product P WHERE NAME=:name ORDER BY P.name ASC ");
//            query.setParameter("name",name);
//            List<Product> list=query.list();
//            return list;
//        }catch(HibernateException e){
//            System.err.println("Search is failed");
//            System.err.println(e.getMessage());
//        }finally {
//            if (session!=null)
//                session.close();
//        }
//        return null;
//    }
//
//    public static List<Product> findByNameSortedDesc(String name){
//        Session session=null;
//        try {
//            session = createSessionFactory().openSession();
//            Query query=session.createQuery("FROM Product P WHERE NAME=:name ORDER BY P.name DESC ");
//            query.setParameter("name",name);
//            List<Product> list=query.list();
//            return list;
//        }catch(HibernateException e){
//            System.err.println("Search is failed");
//            System.err.println(e.getMessage());
//        }finally {
//            if (session!=null)
//                session.close();
//        }
//        return null;
//    }
//
//    public static List<Product> findByPriceSortedDesc(int price, int delta){
//        Session session=null;
//        try {
//            session = createSessionFactory().openSession();
//            Query query=session.createQuery("FROM Product P ORDER BY P.price DESC");
//            List<Product> list=query.list();
//            List<Product> resList=new LinkedList<>();
//            for (Product product:list){
//                if ((price-delta)<product.getPrice()&& product.getPrice()< (price+delta))
//                    resList.add(product);
//            }
//            return resList;
//        }catch(HibernateException e){
//            System.err.println("Search is failed");
//            System.err.println(e.getMessage());
//        }finally {
//            if (session!=null)
//                session.close();
//        }
//        return null;
//    }

    public static void saveAll(List<Product> products) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            for (Product product : products) {
                session.save(product);
            }

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        System.out.println("Save is done");
    }

    public static void save(Product product) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.save(product);

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        System.out.println("Save is done");
    }

    public static void update(Product product) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.update(product);

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
        System.out.println("Update is done");
    }

    public static void delete(Product product) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.delete(product);

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

    public static void updateAll(List<Product> products) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            for (Product product : products) {
                session.update(product);
            }

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
        System.out.println("Update is done");
    }

    public static void deleteAll(List<Product> products) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            for (Product product : products) {
                session.delete(product);
            }

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

    public static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
