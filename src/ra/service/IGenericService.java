package ra.service;
import java.util.List;

public interface IGenericService  <T,E> {
    List<T> findAll();
    void save(T t); // add , update
    void delete(E id);
    T findById(E id);
}
