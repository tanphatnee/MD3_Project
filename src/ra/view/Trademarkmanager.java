package ra.view;
import ra.config.InputMethods;
import ra.controller.TrademarkController;
import ra.model.Trademark;

public class Trademarkmanager {
    private TrademarkController trademarkController;

    public Trademarkmanager(TrademarkController trademarkController) {
        this.trademarkController = trademarkController;
        while (true) {
            System.out.println("+--------------------------------------------------------------------------------------+");
            System.out.println("|                     ********** Quản Lý Thương Hiệu **********                        |");
            System.out.println("+-----+--------------------------------------------------------------------------------+");
            System.out.println("|  1  | Nhập số thương hiệu và và tên thuơng hiệu cần thêm.                            |");
            System.out.println("|  2  | Hiển thị thông tin tất cả các thương hiệu.                                     |");
            System.out.println("|  3  | Chỉnh sửa thông tin thương hiệu.                                               |");
            System.out.println("|  4  | Xóa danh mục theo mã thương hiệu sản phẩm.                                     |");
            System.out.println("|  5  | Tìm kiếm thương hiệu.                                                          |");
            System.out.println("|  6  | Quay lại trang Admin.                                                          |");
            System.out.println("+-----+--------------------------------------------------------------------------------+");
            System.out.println("| Nhập lựa chọn: ");
            int choose = InputMethods.getInteger();
            switch (choose) {
                case 1:
                    addNewTrademark();
                    break;
                case 2:
                    showListTrademark();
                    break;
                case 3:
                    editTrademark();
                    break;
                case 4:
                    deleteTrademark();
                    break;
                case 5:
                    searchTrademarkByName();
                    return;
                case 6:
                    return;
                default:
                    System.err.println("vui lòng nhập từ 1 đến 6");
                    break;
            }
        }
    }

    public void addNewTrademark() {
        System.out.print("| Bạn muốn thêm vào bao nhiêu thương hiệu: ");
        int n = InputMethods.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("| Danh mục thứ " + (i + 1));
            Trademark trademark = new Trademark();
            trademark.setId(trademarkController.getNewId());
            trademark.inputData();
            System.out.println("Thêm mới thành công !");
            trademarkController.save(trademark);
        }
    }

    public void showListTrademark() {
        if (trademarkController.findAll().size() == 0) {
            System.err.println("Chưa có thương hiệu nào !");
            return;
        }
        for (Trademark c : trademarkController.findAll()) {
            System.out.println(c);
        }
    }

    public void editTrademark() {
        System.out.print("| Bạn muốn sửa thương hệu có Id là : ");
        int id = InputMethods.getInteger();
        Trademark trademark = trademarkController.findById(id);
        if (trademark == null) {
            System.err.println("Không tìm thấy thương hiệu này.");
            return;
        }
        Trademark newtrademark = new Trademark();
        newtrademark.setId(trademark.getId());
        newtrademark.inputData();
        System.out.println("Sửa thành công !");
        trademarkController.save(newtrademark);
    }

    public void deleteTrademark() {
        System.out.print("| Bạn muốn xoá thương hiệu có Id là : ");
        int id = InputMethods.getInteger();
        System.out.println(" Xoá thành công!");
        trademarkController.delete(id);
    }
    public void searchTrademarkByName() {
        boolean flag = false;
        System.out.print("| Nhập vào tên thương hiệu cần tìm kiếm : ");
        String text = InputMethods.getString();
        for (Trademark tr : trademarkController.findAll()) {
            if (tr.getTrademarkName().toLowerCase().contains(text.toLowerCase())) {
                System.out.println(tr);
                flag = true;
            }
        }
        if (!flag) {
            System.err.println("Không tìm thấy thương hiệu này !");
        }
    }
}
