package lecture24.hibernate;


import lecture24.hibernate.dao.ProductDao;
import lecture24.hibernate.model.xml.Category;
import lecture24.hibernate.model.xml.Product;

public class AppXmlExample {
    public static void main(String[] args) {
        Product product = createProductWithCategory();

        ProductDao productDao = new ProductDao();
        productDao.createProduct(product);
    }

    private static Product createProductWithCategory() {
        Category category = new Category();
        category.setName("Phones");

        Product product = new Product();
        product.setName("Phone");
        product.setPrice(500);
        product.setCategory(category);

        return product;
    }
}
