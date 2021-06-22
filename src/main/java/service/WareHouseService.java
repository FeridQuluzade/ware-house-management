package service;

import dto.WareHouseCreateDto;
import dto.WareHouseUpdateDto;


public interface WareHouseService {

    WareHouseUpdateDto retrieveById(long id);

    long create(WareHouseCreateDto wareHouseCreateDto);

    void update(WareHouseUpdateDto wareHouseUpdateDto);

    void deleteById(long id);

}
