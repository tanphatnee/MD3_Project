package ra.controller;

import ra.model.Trademark;
import ra.service.TrademarkService;

import java.util.List;

public class TrademarkController  {
    private TrademarkService trademarkService;

    public TrademarkController() {
        trademarkService  = new TrademarkService();
    }


    public List<Trademark> findAll() {
        return trademarkService.findAll();
    }


    public void save(Trademark trademark) {
        trademarkService.save(trademark);
    }


    public void delete(Integer id) {
        trademarkService.delete(id);
    }


    public Trademark findById(Integer id) {
        return trademarkService.findById(id);
    }
    public int getNewId() {
        return trademarkService.getNewId();
    }
}
