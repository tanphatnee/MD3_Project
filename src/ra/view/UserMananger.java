package ra.view;
import ra.config.InputMethods;
import ra.controller.UserController;
import ra.model.User;

public class UserMananger {
    private UserController userController;

    public UserMananger(UserController userController) {
        this.userController = userController;
        while (true) {
            Navbar.menuAccountManager();
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    showAllAccount();
                    break;
                case 2:
                    changeStatus();
                    break;
                case 3:
                    Navbar.menuAdmin();
                    break;
                default:
                    System.err.println("Nhập lựa chọn từ 1 đến 3.");
            }
        }
    }

    public void showAllAccount() {
        for (User u : userController.findAll()) {
            System.out.println("+--------------------------------------------------------------------------------------+");            System.out.println(u);

        }
    }

    public void changeStatus() {
        // lấy ra userlogin để check quyền xem có được quyền khóa tài khoản kia không
        System.out.println("| Nhập Id tài khoản: ");
        int id = InputMethods.getInteger();
        if (id ==1){
            System.err.println("Tài khoản không tồn tại! ");
            return;
        }
        User user = userController.findById(id);
        if (user == null) {
            System.err.println("Id tài khoản không tồn tại! ");
        } else {
            if (user.isStatus() == false){
                System.out.println("Đã mở tài khoản !");
                user.setStatus(true);
                userController.save(user);
                return;
            }
            user.setStatus(!user.isStatus());
            System.err.println("Đã khoá tài khoản !");
            userController.save(user);
        }
    }
}
