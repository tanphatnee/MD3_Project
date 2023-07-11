package ra.controller;

import ra.model.Order;
import ra.service.OrderService;

import java.util.List;

public class OrderController {
    private OrderService orderService;

    public OrderController() {
        orderService= new OrderService();
    }
    public List<Order> findAll(){return orderService.findAll();}
    public void save(Order o){
        orderService.save(o);
    }
    public Order findById(int id){return orderService.findById(id);}
    public Order findALlById(int id){return orderService.findALlById(id);}
    public int getNewId(){
        return orderService.getNewId();
    }
    public List<Order> findOrderByUserId(){
        return orderService.findOrderByUserId();
    }

}
