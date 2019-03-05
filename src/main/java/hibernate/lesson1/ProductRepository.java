package hibernate.lesson1;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class ProductRepository {
     Session session=new Configuration().configure().buildSessionFactory().openSession();
    public void save(Product product){
        session.getTransaction().begin();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(long id){
        session.getTransaction().begin();
        Product product=new Product();
        product.setId(id);
        session.delete(product);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Product product){
        session.getTransaction().begin();
        session.update(product);
        session.getTransaction().commit();
        session.close();
    }
}
