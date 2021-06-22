package model;

public class WareHouseProduct extends BaseEntity{
    private long id;
    private String name;
    private long count;
    private double buyRate;
    private double sellRate;

    public WareHouseProduct() {
    }

    public WareHouseProduct(long id, String name, long count, double buyRate, double sellRate) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public double getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(double buyRate) {
        this.buyRate = buyRate;
    }

    public double getSellRate() {
        return sellRate;
    }

    public void setSellRate(double sellRate) {
        this.sellRate = sellRate;
    }

    @Override
    public String toString() {
        return "WareHouseProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", buyRate=" + buyRate +
                ", sellRate=" + sellRate +
                '}';
    }
}
