package dto;

import shared.UpdateDto;

public class WareHouseUpdateDto extends UpdateDto {

    private long count;
    private double buyRate;
    private double sellRate;

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

    public WareHouseUpdateDto(long count, double buyRate, double sellRate) {
        this.count = count;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }

    @Override
    public String toString() {
        return "WareHouseUpdateDto{" +
                "count=" + count +
                ", buyRate=" + buyRate +
                ", sellRate=" + sellRate +
                '}';
    }
}
