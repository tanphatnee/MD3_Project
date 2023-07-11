package ra.service;
import ra.model.Product;
import ra.util.DataBase;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IGenericService<Product, Integer> {
    private List<Product> products;
    private DataBase<Product> productDataBase = new DataBase<>();

    public ProductService() {
        List<Product> list = productDataBase.readFromFile(DataBase.PRODUCT_PATH);
        if (list == null) {
            list = new ArrayList<>();
        }
        this.products = list;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getProductId()) == null) {
            products.add(product);
        } else {
            int index = -1;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getProductId() == (product.getProductId())) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                products.set(index, product);
            }
        }
        productDataBase.writeToFile(products, DataBase.PRODUCT_PATH);
    }

    @Override
    public Product findById(Integer id) {
        for (Product p : products) {
            if (p.getProductId() == (id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Product product = findById(id);
        if (product != null) {
            products.remove(product);
            productDataBase.writeToFile(products, DataBase.PRODUCT_PATH);
        }
    }

    public int getNewId() {
        int max = 0;
        for (Product p : products
        ) {
            if (p.getProductId() > max) {
                max = p.getProductId();
            }
        }
        return max + 1;
    }
}
