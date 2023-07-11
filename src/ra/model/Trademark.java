package ra.model;

import ra.config.InputMethods;

import java.io.Serializable;

public class Trademark  implements Serializable {
    private int id;
    private String trademarkName;

    public Trademark() {
    }

    public Trademark(int id, String trademarkName) {
        this.id = id;
        this.trademarkName = trademarkName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrademarkName() {
        return trademarkName;
    }

    public void setTrademarkName(String trademarkName) {
        this.trademarkName = trademarkName;
    }
    public  void inputData(){
        System.out.println("| Nhập tên hãng: ");
        this.trademarkName= InputMethods.getString();
    }

    @Override
    public String toString() {
        return "| Id : " + id + " | Tên thương hiệu :" + trademarkName;
    }
}
