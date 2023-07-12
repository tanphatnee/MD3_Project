package ra.view;
import com.sun.xml.internal.bind.v2.TODO;
import ra.config.InputMethods;
import ra.controller.OrderController;
import ra.controller.ProductController;
import ra.model.CartItem;
import ra.model.Order;
import ra.model.Product;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private OrderController orderController;
    public OrderManager() {
        orderController = new OrderController();
        while (true) {
            System.out.println("+--------------------------------------------------------------------------------------+");
            System.out.println("|                     ********** Lịch sử Đơn hàng **********                           |");
            System.out.println("+-----+--------------------------------------------------------------------------------+");
            System.out.println("|  1  | Hiển thị tất cả Đơn hàng.                                                      |");
            System.out.println("|  2  | Hiển thị Đơn hàng chờ xác nhận.                                                |");
            System.out.println("|  3  | Hiển thị Đơn hàng đã chấp nhận.                                                |");
            System.out.println("|  4  | Hiển thị Đơn hàng đã hủy.                                                      |");
            System.out.println("|  5  | Hiển thị Chi tiết Đơn hàng.                                                    |");
            System.out.println("|  6  | Quay lại .                                                                     |");
            System.out.println("+-----+--------------------------------------------------------------------------------+");
            System.out.println("| Nhập lựa chọn: ");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    // hiển thị tất cả
                    showAllOrder();
                    break;
                case 2:
                    // chờ xác nhận
                    showOrderByCode((byte) 0);
                    break;
                case 3:
                    showOrderByCode((byte) 1);
                    break;
                case 4:
                    showOrderByCode((byte) 2);
                    break;
                case 5:
                    // chi tiết hóa đơn
                    showOrderDetail();
                    break;
                case 6:
                    break;
                default:
                    System.err.println("Vui lòng nhập số từ 1 - 6");
            }
            if (choice == 6) {
                break;
            }
        }
    }

    public OrderManager(OrderController orderController) {
        this.orderController = orderController;
         while (true) {
            Navbar.menuOrderConfirmManager();
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                     // hiển thị tất cả các đơn đặt hàng của khách hàng
                    showAllOrderAllUser();
                    break;
                case 2:
                    // xác nhận trạng thái đơn hàng
                    OrderComfirm();
                    break;
                case 3:
                    //quay lại
                    Navbar.menuAdmin();
                    break;
                default:
                    System.err.println("Nhập lựa chọn từ 1 - 3");
            }

        }
    }
    public  void  showAllOrderAllUser(){
        for (Order od:  orderController.findAll()
             ) {
            System.out.println("+--------------------------------------------------------------------------------------+");
            System.out.println(od);
            System.out.println("+--------------------------------------------------------------------------------------+");
        }
    }

    public  void OrderComfirm(){
        System.out.println("| Nhâp mã đơn hàng: ");
        int ip=InputMethods.getInteger();
        Order comfirmOrder = orderController.findALlById(ip) ;
         if (comfirmOrder == null){
             System.err.println("Không tìm thấy mã đơn hàng! ");

         } else if (comfirmOrder.getStatus()==0) {
             System.out.println("| Bạn muốn xác nhận đơn hàng này chứ ?");
             System.out.println("1. Đồng ý");
             System.out.println("2. Không");
             int choice =InputMethods.getPositiveInteger();
             if (choice==1){
                 System.out.println("Đã xác nhận !");
                 comfirmOrder.setStatus((byte) 1);
              orderController.save(comfirmOrder);
              }
         }

    }

    public void showAllOrder() {
        List<Order> list = orderController.findOrderByUserId();

        if (list.isEmpty()) {
            System.err.println("Lịch sử đơn hàng trống! ");
            return;
        }
        for (Order o : list) {
            System.out.println(o);
        }
    }
    public void showOrderByCode(byte code) {
        List<Order> orders = orderController.findOrderByUserId();
        List<Order> filter = new ArrayList<>();
        for (Order o : orders) {
            if (o.getStatus() == code) {
                filter.add(o);
            }
        }
        if (filter.isEmpty()) {
            System.err.println("Đơn hàng trống! ");
            return;
        }
        for (Order o : filter) {
            System.out.println(o);
        }
    }

    public void showOrderDetail() {
        ProductController productController = new ProductController();
        System.out.println("| Nhập mã đơn hàng: ");
        int orderId = InputMethods.getInteger();
        Order order = orderController.findById(orderId);
        if (order == null) {
            System.err.println("Không tìm thấy mã đơn hàng!");
            return;
        }

        // in ra chi tiết hóa đơn
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("|                      ********** Chi tiết Đơn hàng **********                         |");
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("| Mã đơn hàng : " + order.getId());
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("+                        ********** Thông tin **********                               |");
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("| Người nhận : " + order.getReceiver() + " | Điện thoại : " + order.getPhoneNumber());
        System.out.println("| Email : " +order.getEmail() + "| Địa chỉ : " + order.getAddress());
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("+                         ********** Chi tiết **********                               +");
        System.out.println("+--------------------------------------------------------------------------------------+");
        for (CartItem ci : order.getOrderDetail()) {
            System.out.println(ci);
        }
        System.out.println("| Tổng cộng : " + order.getTotal());
        System.out.println("+--------------------------------------------------------------------------------------+");
        if (order.getStatus() == 0) {

            System.out.println("| Bạn chắc chắn muốn hủy đơn hàng này?");
            System.out.println("1. Đồng ý");
            System.out.println("2. Không đồng ý");
            System.out.println("| Nhập lựa chọn 1 hoặc 2: ");

            int choice = InputMethods.getInteger();
            if (choice == 1) {
                System.out.println("Đơn hàng đã bị huỷ! ");
                for (CartItem cartItem : order.getOrderDetail()) {
                    Product product = productController.findById(cartItem.getProduct().getProductId());
                    product.setStock(product.getStock() + cartItem.getQuantity());
                    productController.save(product);
                }
                order.setStatus((byte) 2);
                orderController.save(order);
            }
        }
    }
}
