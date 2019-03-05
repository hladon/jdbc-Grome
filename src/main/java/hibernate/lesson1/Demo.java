package hibernate.lesson1;


import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String[] args) {
        Session session=new Configuration().configure().buildSessionFactory().openSession();

        session.getTransaction().begin();

        Product product=new Product();
        product.setId(99);
        product.setName("table");
        product.setDescription("grey&blue70");
        product.setPrice(70);

        session.save(product);


        session.getTransaction().commit();

        System.out.println("Done");

        session.close();
    }
}
