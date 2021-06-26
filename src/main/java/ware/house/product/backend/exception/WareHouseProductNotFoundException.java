package ware.house.product.backend.exception;

public class WareHouseProductNotFoundException extends RuntimeException {
    public WareHouseProductNotFoundException(String message) {
        super(message);
    }
}
