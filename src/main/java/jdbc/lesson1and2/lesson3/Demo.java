package jdbc.lesson1and2.lesson3;

public class Demo {
    public static void main(String[] args) {

//        ProductDAO productDAO=new ProductDAO();
//        Product product=new Product(10,"test","test description",99);
//
//        productDAO.save(product);
//
//        System.out.println(productDAO.getProducts());
//
//        Product product2=new Product(10,"test2","test description 2",70);
//
//        productDAO.update(product2);
//
//        productDAO.delete(10);
//        Solution solution=new Solution();
//
//        System.out.println(solution.findProductsByName("test"));
//        System.out.println(solution.findProductsByPrice(100,10));
//        System.out.println(solution.findProductsWithEmptyDescription());
        Solution2 solution2=new Solution2();
//        solution2.testSavePerfomance();
        System.out.println(solution2.testDeleteByIdPerfomance());
    }
}
