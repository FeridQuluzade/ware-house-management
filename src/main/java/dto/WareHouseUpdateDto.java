package dto;

import shared.UpdateDto;

public class WareHouseUpdateDto extends UpdateDto {
private long id;
    private long count;
    private double buyRate;
    private double sellRate;

    public WareHouseUpdateDto() {
    }

    public WareHouseUpdateDto(long id, long count, double buyRate, double sellRate) {
        this.id = id;
        this.count = count;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WareHouseUpdateDto{" +
                "id=" + id +
                ", count=" + count +
                ", buyRate=" + buyRate +
                ", sellRate=" + sellRate +
                '}';
    }
}
