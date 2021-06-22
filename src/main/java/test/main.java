package test;

import dto.WareHouseCreateDto;
import service.WareHouseService;
import service.WareHouseServiceImpl;
import shared.CreateDto;

import java.time.LocalDateTime;

public class main {
    public static void main(String[] args) {
        WareHouseService wareHouseService = new WareHouseServiceImpl();

        WareHouseCreateDto wareHouseCreateDto = new WareHouseCreateDto();

        wareHouseCreateDto.setName("Floor");
        wareHouseCreateDto.setCount(22L);
        wareHouseCreateDto.setSellRate(200);
        wareHouseCreateDto.setBuyRate(190);
        wareHouseCreateDto.setCreatedDate(LocalDateTime.now());
        wareHouseService.create(wareHouseCreateDto);

    }
}
