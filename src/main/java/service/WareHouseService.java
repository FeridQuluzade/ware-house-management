package service;

import dto.WareHouseCreateDto;
import dto.WareHouseUpdateDto;


public interface WareHouseService {

    long create(WareHouseCreateDto wareHouseCreateDto);

    void update(WareHouseUpdateDto wareHouseUpdateDto);

}
