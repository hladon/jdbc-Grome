package hibernate.lesson2;

import hibernate.lesson1.Product;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        System.out.println(ProductDAO.findById(10));
        for (Product product:ProductDAO.findByName("test"))
            System.out.println(product);
        for (Product product:ProductDAO.findByContainetName("test"))
            System.out.println(product);
        for (Product product:ProductDAO.findByPrice(100,10))
            System.out.println(product);
        for (Product product:ProductDAO.findByNameSortedAsc("test"))
            System.out.println(product);
        for (Product product:ProductDAO.findByPriceSortedDesc(100,50))
            System.out.println(product);

//        Product product=new Product();
//        product.setName("table new!");
//        product.setDescription("grey&blue");
//        product.setPrice(70);
//
//        ProductDAO.save(product);
//
//        product.setPrice(90);
//        ProductDAO.update(product);
//        ProductDAO.delete(product);
//
//
//        Product product1=new Product();
//        product1.setName("table new!");
//        product1.setDescription("grey&blue");
//        product1.setPrice(70);
//
//        Product product2=new Product();
//        product2.setName("table new!");
//        product2.setDescription("grey&blue");
//        product2.setPrice(70);
//
//        Product product3=new Product();
//        product3.setName("table new!");
//        product3.setDescription("grey&blue");
//        product3.setPrice(70);
//
//        List<Product> products= Arrays.asList(product1,product2,product3);
//        ProductDAO.saveAll(products);
//
//        product1.setPrice(90);
//        product2.setPrice(90);
//        product3.setPrice(90);
//        List<Product> products2= Arrays.asList(product1,product2,product3);
//        ProductDAO.updateAll(products2);
//
//        ProductDAO.deleteAll(products);


    }
}
