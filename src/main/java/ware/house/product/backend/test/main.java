package ware.house.product.backend.test;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ware.house.product.backend.config.AutoFill;
import ware.house.product.backend.dao.WareHouseRepository;
import ware.house.product.backend.dto.WareHouseUpdateDto;
import ware.house.product.backend.service.*;

import java.time.LocalDateTime;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        WareHouseUpdateDto wareHouseUpdateDto= new WareHouseUpdateDto();
//        wareHouseUpdateDto.setName("Floor");
//        wareHouseUpdateDto.setCount(5);
//        wareHouseUpdateDto.setBuyRate(10);
//        wareHouseUpdateDto.setSellRate(12);
//        wareHouseUpdateDto.setId(5);
//        wareHouseUpdateDto.setUpdatedDate(LocalDateTime.now());
//        DbService dbService= new PostgreDbServiceImpl();
//       WareHouseRepository wareHouseRepository= new WareHouseRepository(dbService);
//       ModelMapper modelMapper= new ModelMapper();
//        WareHouseService wareHouseService= new WareHouseServiceImpl(wareHouseRepository,modelMapper);
//        wareHouseService.update(wareHouseUpdateDto);


        DbService dbService = new PostgreDbServiceImpl();

        ModelMapper modelMapper = new ModelMapper();

        WareHouseRepository wareHouseRepository = new WareHouseRepository(dbService);

        WareHouseService wareHouseService = new WareHouseServiceImpl(wareHouseRepository, modelMapper);

        AutoFill autoFill = new AutoFill(wareHouseService, scanner);

        MenuService menuService = new MenuServiceImpl(autoFill, scanner);

        menuService.menuItem();


    }
}
