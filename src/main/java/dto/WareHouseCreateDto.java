package dto;

import shared.CreateDto;

public class WareHouseCreateDto extends CreateDto {
    private String name;
    private long count;
    private double buyRate;
    private double sellRate;

    public WareHouseCreateDto() {
    }

    public WareHouseCreateDto(String name, long count, double buyRate, double sellRate) {
        this.name = name;
        this.count = count;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
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
        return "WareHouseCreateDto{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", buyRate=" + buyRate +
                ", sellRate=" + sellRate +
                '}';
    }
}
