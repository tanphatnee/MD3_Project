package ra.controller;


import ra.model.User;
import ra.service.UserService;

import java.util.List;

public class UserController {
    private UserService userService;

    public UserController() {
        userService  = new UserService();
    }

    public List<User> findAll() {
        return userService.findAll();
    }
    public void save(User user) {
        userService.save(user);
    }


    public void delete(Integer id) {
       userService.delete(id);
    }


    public User findById(Integer id) {
        return userService.findById(id);
    }
    public void changeStatus(int idUser){
        userService.changeStatus(idUser);
    }
    public User login(String username, String password){
        return userService.login(username,password);
    }
    public int getNewId(){
        return userService.getNewId();
    }
}
