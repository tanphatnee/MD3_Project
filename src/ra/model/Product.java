package ra.model;

import ra.config.InputMethods;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private int productId;
    private String productName;
    private double productPrice;
    private String description;
    private int stock;
    private Trademark trademark;
    private boolean status = true;

    public Product() {
    }

    public Product(int productId, String productName, double productPrice, String description, int stock, Trademark trademark, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.stock = stock;
        this.trademark = trademark;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Trademark getTrademark() {
        return trademark;
    }

    public void setTrademark(Trademark trademark) {
        this.trademark = trademark;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void inputData(List<Trademark> list) {
        System.out.print("| Nhập tên sản phẩm: ");
        this.productName = InputMethods.getString();
        System.out.print("| Nhập giá sản phẩm(lớn hơn 0): ");
        this.productPrice = InputMethods.getPositiveInteger();
        System.out.print("| Nhập vào mô tả: ");
        this.description = InputMethods.getString();
        System.out.print("| Nhập vào số lượng sản phẩm bán(lớn hơn 10): ");
        this.stock = InputMethods.getStock();
        for (Trademark c : list) {
            System.out.println(c);
        }
        while (true) {
            boolean flag = false;
            System.out.print("| Vui lòng chọn ID danh mục: ");
            int id = InputMethods.getInteger();
            for (Trademark c : list) {
                if (c.getId() == id) {
                    this.trademark = c;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            } else {
                System.err.println("Danh mục không tồn tại, Vui lòng chọn lại! ");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-20s | %-10s | %-10s | %-10s | %-10s " ,
                "Mã sản phẩm", "Tên sản phẩm", "Giá", "Mô tả", "Sl trong kho", "Hãng")
                + "\n" + "-"
                + String.format("\n%-15s | %-20s | %-10s | %-10s | %-10s | %-10s",
                productId, productName, productPrice , description, stock , trademark.getTrademarkName())
                + "\n" + "-"
                + String.format("\nTình trạng: %s", status ? "Bán" : "hết hàng")
                + "\n" + "—";
    }



    public int compareTo(Product o) {
        return Double.compare(o.getProductPrice(), this.productPrice);
    }


}
