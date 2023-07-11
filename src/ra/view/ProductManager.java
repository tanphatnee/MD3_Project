package ra.view;
import ra.config.InputMethods;
import ra.controller.ProductController;
import ra.controller.TrademarkController;
 import ra.model.Product;

import java.util.Collections;

public class ProductManager  {
    private  ProductController productController ;
    private TrademarkController trademarkController = new TrademarkController();

    public ProductManager(ProductController productController) {
        this.productController = productController;

         while (true) {
             System.out.println("+--------------------------------------------------------------------------------------+");
             System.out.println("|                       ********** Quản Lý Sản Phẩm **********                         |");
             System.out.println("+-----+--------------------------------------------------------------------------------+");
             System.out.println("|  1  | Nhập số lượng và sản phẩm cần thêm.                                            |");
             System.out.println("|  2  | Hiển thị thông tin các sản phẩm.                                               |");
             System.out.println("|  3  | Sắp xếp sản phẩm theo giá tăng dần.                                            |");
             System.out.println("|  4  | Xóa sản phẩm theo mã sản phẩm.                                                 |");
             System.out.println("|  5  | Tìm kiếm sản phẩm theo tên sản phẩm.                                           |");
             System.out.println("|  6  | Chỉnh sửa thông tin sản phẩm.                                                  |");
             System.out.println("|  7  | Quay lại.                                                                      |");
             System.out.println("+-----+--------------------------------------------------------------------------------+");
             System.out.print("Mời bạn lựa chọn: ");
            int choose = InputMethods.getInteger();
            switch (choose) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    displayListProduct();
                    break;
                case 3:
                  sortProductByPrice();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    searchProductByName();
                    break;
                case 6:
                    editProduct();
                    break;
                case 7:
                    return;
                default:
                    System.err.println("vui lòng nhập từ 0 đến 7.");
                    break;
            }
        }
    }
    public  static void displayListProduct(){
        ProductController productController1 = new ProductController();
         for (Product p: productController1.findAll()) {
             if (p.getStock()==0){
                 p.setStatus(false);
                 System.out.println(p);
             }
            if(p.isStatus()){
                System.out.println(p);
            }
        }
    }

    public void addNewProduct() {
        System.out.print("| Bạn muốn nhập vào  nhiêu sản phẩm: ");
        int n = InputMethods.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("Sản phẩm thứ " + (i + 1));
            Product product = new Product();
            product.setProductId(productController.getNewId());
            product.inputData(trademarkController.findAll());
            System.out.println("Thêm thành công.");
            productController.save(product);
        }
    }


    public void deleteProduct() {
        System.out.print("| Nhập vào Mã sản phẩm: ");
        int id = InputMethods.getInteger();
        System.out.println(" Xóa thành công.");
        productController.delete(id);
    }
    public  void  sortProductByPrice(){
        Collections.sort(productController.findAll(),(p1,p2) ->Double.compare(p1.getProductPrice(), p2.getProductPrice()));
        System.out.println("Sản phẩm đã được sắp xếp theo thứ tự  tăng. ");
    }

    public void searchProductByName() {
        boolean flag = false;
        System.out.print("| Nhập vào tên sản phẩm cần tìm kiếm : ");
        String text = InputMethods.getString();
        for (Product p : productController.findAll()) {
            if (p.getProductName().toLowerCase().contains(text.toLowerCase())) {
                System.out.println(p);
                flag = true;
            }
        }
        if (!flag) {
            System.err.println("Không có sản phẩm nào. ");
        }
    }

    public void editProduct() {
        System.out.print("| Nhập vào mã sản phẩm cần sửa: ");
        int id = InputMethods.getInteger();
        Product product = productController.findById(id);
        if (product == null) {
            System.err.println("Không có sản phẩm bạn muốn tìm.");
            return;
        }
        Product newProduct = new Product();
        newProduct.setProductId(product.getProductId());
        newProduct.inputData(trademarkController.findAll());
        System.out.println(" Sửa thành công.");
        productController.save(newProduct);
    }


}
