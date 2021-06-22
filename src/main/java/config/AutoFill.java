package config;


import dto.WareHouseCreateDto;
import dto.WareHouseUpdateDto;
import service.WareHouseService;
import service.WareHouseServiceImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

public class AutoFill {
    private final WareHouseService wareHouseService;
    private final Scanner scanner;

    public AutoFill() {
        wareHouseService = new WareHouseServiceImpl();
        scanner = new Scanner(System.in);
    }

    public String addItem() {
        WareHouseCreateDto wareHouseCreateDto = new WareHouseCreateDto();

        System.out.print("Enter product name:");
        wareHouseCreateDto.setName(scanner.nextLine());


        System.out.print("Enter product's count:");
        wareHouseCreateDto.setCount(scanner.nextLong());


        System.out.print("Enter product' buy rate:");
        wareHouseCreateDto.setBuyRate(scanner.nextDouble());


        System.out.print("Enter product's sell rate:");
        wareHouseCreateDto.setSellRate(scanner.nextDouble());

        wareHouseCreateDto.setCreatedDate(LocalDateTime.now());


       return "Successfully add this product ,product id:"+wareHouseService.create(wareHouseCreateDto);
    }

//    public String updateItem(){
//        WareHouseUpdateDto wareHouseUpdateDto= new WareHouseUpdateDto();
//
//    }


}
