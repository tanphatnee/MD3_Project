package ra.config;

public class Message {
    public static String getStatusByCode(byte code){
        switch (code){
            case 0 :
                return "Đang chờ xác nhận ";
            case 1:
                return " Đã được xác nhận ";
            case 2:
                return " Đã huỷ ! ";
            default:
                return  " Không hợp lệ !";
        }
    }
}
