package ra.view;
import ra.config.InputMethods;
import ra.controller.OrderController;
import ra.controller.ProductController;
import ra.controller.TrademarkController;
import ra.controller.UserController;
import ra.model.RoleName;
import ra.model.User;
public class Navbar {
    private static UserController userController = new UserController();
    private static TrademarkController trademarkController = new TrademarkController();
    private static ProductController productController = new ProductController();
    public static User userLogin;
    public  static UserMananger userMananger ;
    public static void menuStore() {
        while (true) {
            System.out.println("+--------------------------------------------------------------------------------------+");
            System.out.println("|                                    SHOP ĐỒ CÂU                                       |");
            System.out.println("|---------------------|---------------------|------------------------|-----------------|");
            System.out.println("|    1. Đăng nhập     +      2. Đăng ký     +      3. Xem sản phẩm   +   4. Thoát      |");
            System.out.println("|---------------------|---------------------|------------------------|-----------------|");
            System.out.println("| Nhập lựa chọn : ");

            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    //Đăng nhập
                    login();
                    break;
                case 2:
                    //Đăng ký
                    register();
                    break;
                case 3:
                    // xem sản phẩm;
                    ProductManager.displayListProduct();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn số (1-4)! ");
            }

        }
    }


    public static void menuUser() {
        while (true) {
            System.out.println("+--------------------------------------------------------------------------------------+");
            System.out.println("|                            ********** Menu **********                                |");
            System.out.println("+-----+--------------------------------------------------------------------------------+");
            System.out.println("|  1  | Hiển thị danh sách sản phẩm.                                                   |");
            System.out.println("|  2  | Thêm vào giỏ hàng.                                                             |");
            System.out.println("|  3  | Xem giỏ hàng.                                                                  |");
            System.out.println("|  4  | Thay đổi mật khẩu.                                                             |");
            System.out.println("|  5  | Lịch sử đơn hàng.                                                              |");
            System.out.println("|  6  | Đăng xuất.                                                                     |");
            System.out.println("+-----+--------------------------------------------------------------------------------+");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    // hiển thị danh sách sản phẩm
                    ProductManager.displayListProduct();
                    break;
                case 2:
                    // mua hàng
                    CartManager.addToCart();
                    break;
                case 3:
                    // quan li gió hàng
                    new CartManager();
                    break;
                case 4:
                    //thay đổi mật khẩu
                    changeUserPassword();
                    break;
                case 5:
                    //lich sử đơn hàng
                    new OrderManager();
                    break;
                case 6:
                    logOut();
                    break;
                default:
                    System.err.println("Vui  lòng lựa chon (1-6)");
            }
            if (choice == 0) {
                break;
            }
        }
    }

    public static void menuAdmin() {
        while (true) {
            System.out.println("+--------------------------------------------------------------------------------------+");
            System.out.println("|                           ********** MenuAdmin **********                            |");
            System.out.println("+-----+--------------------------------------------------------------------------------+");
            System.out.println("|  1  | Quản lý tài khoản.                                                             |");
            System.out.println("|  2  | Quản lý thương hiệu.                                                           |");
            System.out.println("|  3  | Quản lý sản phẩm.                                                              |");
            System.out.println("|  4  | Quản lý đơn hàng.                                                              |");
            System.out.println("|  5  | Đăng xuất.                                                                     |");
            System.out.println("+-----+--------------------------------------------------------------------------------+");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    // Quản lí tài khoản người dùng
                    new UserMananger(userController);
                    break;
                case 2:
                    //Quản lý thương hiệu
                    new Trademarkmanager(trademarkController);
                    break;
                case 3:
                    //Quản lý sản phẩm
                    new ProductManager(productController);
                    break;
                case 4:
                    //Quản lý đơn hàng
                    new OrderManager(new  OrderController());
                    break;
                case 5:
                    // Đăng xuất
                    logOut();
                    break;
                default:
                    System.err.println("Vui lòng nhập số từ 0 đến 5");
            }
            if (choice == 0) {
                break;
            }
        }
    }

    public static void menuAccountManager() {
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("|                    ********** Menu Quản lý tài khoản **********                      |");
        System.out.println("+-----+--------------------------------------------------------------------------------+");
        System.out.println("|  1  | Hiển thị tất cả tài khoản.                                                     |");
        System.out.println("|  2  | Khóa/Mở khóa tài khoản.                                                        |");
        System.out.println("|  3  | Quay lại trang Admin.                                                          |");
        System.out.println("+-----+--------------------------------------------------------------------------------+");
    }
     public static void menuOrderConfirmManager() {
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("|                     ********** Menu Quản lý đơn hàng **********                      |");
        System.out.println("+-----+--------------------------------------------------------------------------------+");
        System.out.println("|  1  | Hiển thị tất cả các đơn hàng.                                                  |");
        System.out.println("|  2  | Xác nhận đơn hàng.                                                             |");
        System.out.println("|  3  | Quay lại.                                                                      |");
        System.out.println("+-----+--------------------------------------------------------------------------------+");
    }

    public static void menuCart() {
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("|                          ********** Menu Giỏ Hàng **********                         |");
        System.out.println("+-----+--------------------------------------------------------------------------------+");
        System.out.println("|  1  | Hiển thị Giỏ hàng.                                                             |");
        System.out.println("|  2  | Thay đổi số lượng.                                                             |");
        System.out.println("|  3  | Xóa sản phẩm.                                                                  |");
        System.out.println("|  4  | Xóa tất cả.                                                                    |");
        System.out.println("|  5  | Thủ tục thanh toán.                                                            |");
        System.out.println("|  6  | Quay lại.                                                                      |");
        System.out.println("+-----+--------------------------------------------------------------------------------+");

    }

    public static void login() {
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("|                         ********** Đăng Nhập **********                              |");
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("| Nhập tên đăng nhập: ");
        String username = InputMethods.getusename();
        System.out.println("| Nhập mật khẩu: ");
        String password = InputMethods.getpassword();
        User user = userController.login(username, password);
        if (user == null) {
            System.err.println("Đăng nhập thất bại! ");
        } else {
            if (user.getRoles().contains(RoleName.ADMIN)) {
                userLogin = user;
                System.out.println("Đăng nhập thành công! ");
                menuAdmin();

            } else {
                if (user.isStatus()) {
                    userLogin = user;
                    System.out.println("Đăng nhập thành công !");
                    menuUser();
                } else {
                    System.err.println("Tài khoản của bạn đã bị khóa !!!");
                    menuStore();
                }
            }
        }
    }

    public static void register() {
        System.out.println("+--------------------------------------------------------------------------------------+");
        System.out.println("|                           ********** Đăng Ký **********                              |");
        System.out.println("+--------------------------------------------------------------------------------------+");
        User user = new User();
        user.setId(userController.getNewId());
        System.out.println("| Nhập tên đầy đủ: ");
        user.setName(InputMethods.getString());
        System.out.println("| Nhập tên đăng nhập: ");
        user.setUsername(InputMethods.getusename());
        System.out.println("| Nhập mật khẩu: ");
        user.setPassword(InputMethods.getpassword());
        userController.save(user);
        System.out.println("Đăng ký thành công!");
        login();
    }

    public static void logOut() {
        userLogin = null;
        menuStore();
    }
    public static void changeUserPassword() {
        System.out.println("| Nhập lại mật khẩu cũ: ");
        String pw = InputMethods.getString();
        if (userLogin.getPassword().equals(pw)) {
            userLogin.setId(userLogin.getId());
            userLogin.inputUserData();
            System.out.println("Cập nhật mật khẩu thành công !");
            userController.save(userLogin);
        } else {
            System.err.println("Mật khẩu không đúng vui lòng nhập lại! ");
            changeUserPassword();
        }
    }
}
