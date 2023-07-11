package ra.service;
import ra.model.Order;
import ra.util.DataBase;
import ra.view.Navbar;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private DataBase<Order> orderData;
    private List<Order> orders;

    public OrderService() {
        orderData= new DataBase<>();
        orders = orderData.readFromFile(DataBase.ORDER_PATH);
    }
     public List<Order> findAll() {
        return orders;
    }
    public void save(Order o){
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == o.getId()){
                orders.set(i, o);
                orderData.writeToFile(orders,DataBase.ORDER_PATH);
                return;
            }
        }
        orders.add(o);
        orderData.writeToFile(orders,DataBase.ORDER_PATH);
    }
    public Order findById(int id){

        for (Order o: findOrderByUserId()
             ) {
            if(o.getId()==id){
                return o;
            }
        }
        return  null;
    }
    public Order findALlById(int id) {
        for (Order allOrder:orders) {
            if (allOrder.getId()==id)
                return allOrder;
        }
        return null;
    }
    public List<Order> findOrderByUserId(){
        List<Order> findList = new ArrayList<>();
        for (Order o: orders) {
            if(o.getUserId()== Navbar.userLogin.getId()){
                findList.add(o);
            }
        }
        return findList;
    }
    public int getNewId(){
        int max = 0;
        for (Order o : orders
        ) {
            if(o.getId() > max){
                max= o.getId();
            }
        }
        return max+1;
    }
}

