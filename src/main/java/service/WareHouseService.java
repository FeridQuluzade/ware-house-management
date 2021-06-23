package service;

import dto.WareHouseCreateDto;
import dto.WareHouseDto;
import dto.WareHouseUpdateDto;

import java.util.List;


public interface WareHouseService {

    List<WareHouseDto> retrieveAll();

    WareHouseUpdateDto retrieveById(long id);

    long create(WareHouseCreateDto wareHouseCreateDto);

    void update(WareHouseUpdateDto wareHouseUpdateDto);

    void deleteById(long id);

}
