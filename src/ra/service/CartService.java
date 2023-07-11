package ra.service;
import ra.model.CartItem;
import ra.model.User;
import java.util.ArrayList;
import java.util.List;

public class CartService implements IGenericService<CartItem,Integer> {
    private User userLogin ;
    private UserService userService;

    public CartService(User userLogin) {
        this.userLogin = userLogin;
        userService= new UserService();
    }

    @Override
    public List<CartItem> findAll() {
        return userLogin.getCart();
    }

    @Override
    public void save(CartItem cartItem) {
        List<CartItem> cart = userLogin.getCart();
        if(findById(cartItem.getId())==null){ // cartitem
//             thêm mơi

            CartItem ci= findByProductId(cartItem.getProduct().getProductId());
            if(ci !=null){
                // đã có sp này trông giỏ hàng
                ci.setQuantity(ci.getQuantity()+ cartItem.getQuantity());
            }else {
                // chưa co trong giỏ hàng
                cart.add(cartItem);
            }

        }else{
            // sửa giỏ hàng

            cart.set(cart.indexOf(findById(cartItem.getId())),cartItem);
        }
        // lưu vào db
        userService.save(userLogin);
    }

    @Override
    public void delete(Integer id) {
        userLogin.getCart().remove(findById(id));
        userService.save(userLogin);
    }

    @Override
    public CartItem findById(Integer id) {
        for (CartItem ci : userLogin.getCart()) {
            if(ci.getId()==id){
                return  ci;
            }
        }
        return  null;
    }
    public CartItem findByProductId(Integer productId){
        for (CartItem ci : userLogin.getCart()) {
            if(ci.getProduct().getProductId()==productId){
                return  ci;
            }
        }
        return  null;
    }
    public int getNewId(){
        int max = 0;
        for (CartItem ci: userLogin.getCart()
        ) {
            if(ci.getId() > max){
                max= ci.getId();
            }
        }
        return max+1;
    }
    public  void clearAll(){
        userLogin.setCart(new ArrayList<>());
        userService.save(userLogin);
    }
}
