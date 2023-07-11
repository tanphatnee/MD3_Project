package ra.model;

import java.io.Serializable;

public class CartItem implements Serializable {
    private int id;
    private Product product;
    private int quantity;

    public CartItem() {
    }

    public CartItem(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ID : "+id + "| Tên sản phẩm : " +product.getProductName()+ " | Giá : "+product.getProductPrice() + "| Số lượng : "+quantity;
    }
}
