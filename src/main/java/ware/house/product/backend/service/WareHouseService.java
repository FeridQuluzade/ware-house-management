package ware.house.product.backend.service;

import ware.house.product.backend.dto.WareHouseCreateDto;
import ware.house.product.backend.dto.WareHouseDto;
import ware.house.product.backend.dto.WareHouseUpdateDto;

import java.util.List;


public interface WareHouseService {

    List<WareHouseDto> retrieveAll();

    WareHouseUpdateDto retrieveById(long id);

    long create(WareHouseCreateDto wareHouseCreateDto);

    void update(WareHouseUpdateDto wareHouseUpdateDto);

    void deleteById(long id);

}
