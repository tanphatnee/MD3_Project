package ra.view;
import ra.model.RoleName;
import ra.model.User;
import ra.service.UserService;
import ra.util.DataBase;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Set<RoleName> set = new HashSet<>();
        Set<RoleName> set2 = new HashSet<>();
        set2.add(RoleName.ADMIN);
        set.add(RoleName.USER);
        User admin = new User();
        admin.setId(1);
        admin.setStatus(true);
        admin.setName("ADMIN");
        admin.setUsername("admin1");
        admin.setPassword("admin123");
        admin.setRoles(set2);
        userService.save(admin);
        DataBase<User> data = new DataBase<>();
        for (User u : data.readFromFile(DataBase.USER_PATH)) {
            System.out.println("+--------------------------------------------------------------------------------------+");
            System.out.println(u);
        }
    }

}
