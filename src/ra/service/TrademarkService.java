package ra.service;
import ra.model.Trademark;
import ra.util.DataBase;
import java.util.ArrayList;
import java.util.List;

public class TrademarkService implements IGenericService<Trademark, Integer> {
    private List<Trademark> trademarks;
    private DataBase<Trademark> trademarkData = new DataBase();

    public TrademarkService() {
        List<Trademark> list = trademarkData.readFromFile(DataBase.TRADEMARH_PATH);
        if (list == null) {
            list = new ArrayList<>();
        }
        this.trademarks = list;// du lieu doc tu file
    }

    @Override
    public List<Trademark> findAll() {
        return trademarks;
    }

    @Override
    public void save(Trademark trademark) {
        if (findById(trademark.getId()) == null) {
            // add
            trademarks.add(trademark);
        } else {
            // update
            trademarks.set(trademarks.indexOf(findById(trademark.getId())), trademark);
        }
        // luu vao file
        trademarkData.writeToFile(trademarks, DataBase.TRADEMARH_PATH);
    }
    @Override
    public Trademark findById(Integer id) {
        for (Trademark u : trademarks) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        trademarks.remove(findById(id));
        trademarkData.writeToFile(trademarks, DataBase.TRADEMARH_PATH);
    }


    public int getNewId() {
        int max = 0;
        for (Trademark u : trademarks
        ) {
            if (u.getId() > max) {
                max = u.getId();
            }
        }
        return max + 1;
    }

}

