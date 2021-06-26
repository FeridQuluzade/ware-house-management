package ware.house.product.backend.config;


import ware.house.product.backend.dto.WareHouseCreateDto;
import ware.house.product.backend.dto.WareHouseDto;
import ware.house.product.backend.dto.WareHouseUpdateDto;
import ware.house.product.backend.service.WareHouseService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class AutoFill {
    private final WareHouseService wareHouseService;
    private final Scanner scanner;

    public AutoFill(WareHouseService wareHouseService, Scanner scanner) {
        this.wareHouseService = wareHouseService;
        this.scanner = scanner;
    }

    public void findAll() {
        List<WareHouseDto> wareHouseDtos = wareHouseService
                .retrieveAll();
        System.out.println("ID" + " || " + "name" + "    || " + "count" + " || " + "buy rate" + " || " + "sell rate" + " || " + "earn money ");
        for (WareHouseDto w :
                wareHouseDtos) {
            findById(w.getId());
        }
    }

    public void findById() {
        System.out.print("Enter the id to search: ");

        WareHouseUpdateDto wareHouseUpdateDto = wareHouseService.retrieveById(scanner.nextLong());

        double d = (wareHouseUpdateDto.getSellRate() - wareHouseUpdateDto.getBuyRate()) * wareHouseUpdateDto.getCount();

        System.out.print("ID" + " || " + "name" + "    || " + "count" + " || " + "buy rate" + " || " + "sell rate" + " || " + "earn money ");
        System.out.println();
        System.out.println(wareHouseUpdateDto.getId() + "  || " + wareHouseUpdateDto.getName() + "   || " + wareHouseUpdateDto.getCount() + "    || "
                + wareHouseUpdateDto.getBuyRate() + "    ||  " + wareHouseUpdateDto.getSellRate() + "    ||  " + d);


    }

    public void findById(long id) {

        WareHouseUpdateDto wareHouseUpdateDto = wareHouseService.retrieveById(id);

        double d = (wareHouseUpdateDto.getSellRate() - wareHouseUpdateDto.getBuyRate()) * wareHouseUpdateDto.getCount();

        System.out.println(wareHouseUpdateDto.getId() + "  || " + wareHouseUpdateDto.getName() + "   || " + wareHouseUpdateDto.getCount() + "    || "
                + wareHouseUpdateDto.getBuyRate() + "    ||  " + wareHouseUpdateDto.getSellRate() + "    ||  " + d);
    }

    public void addItem() {
        WareHouseCreateDto wareHouseCreateDto = new WareHouseCreateDto();

        System.out.print("Enter product name:");
        wareHouseCreateDto.setName(scanner.next());


        System.out.print("Enter product's count:");
        wareHouseCreateDto.setCount(scanner.nextLong());


        System.out.print("Enter product' buy rate:");
        wareHouseCreateDto.setBuyRate(scanner.nextDouble());


        System.out.print("Enter product's sell rate:");
        wareHouseCreateDto.setSellRate(scanner.nextDouble());


        wareHouseCreateDto.setCreatedDate(LocalDateTime.now());


        System.out.println(("Successfully added this product ,product id:" + wareHouseService.create(wareHouseCreateDto)));
    }

    public void updateItem() {
        WareHouseUpdateDto wareHouseUpdateDto = new WareHouseUpdateDto();

        System.out.print("Enter the id of the product you want to change:");
        wareHouseUpdateDto.setId(scanner.nextLong());

        System.out.println("Enter the count of the product you want to change:");
        wareHouseUpdateDto.setCount(scanner.nextLong());

        System.out.println("Enter the sell rate of the product you want to change:");
        wareHouseUpdateDto.setSellRate(scanner.nextDouble());

        System.out.println("Enter the buy rate of the product you want to change:");
        wareHouseUpdateDto.setBuyRate(scanner.nextDouble());

        wareHouseUpdateDto.setUpdatedDate(LocalDateTime.now());

        wareHouseService.update(wareHouseUpdateDto);

        System.out.println(("Successfully updated this product, product id:" + wareHouseUpdateDto.getId()));
    }

    public void deleteItem() {
        System.out.print("Enter the id of the product you want to delete :");
        long id = scanner.nextLong();

        wareHouseService.deleteById(id);
        System.out.println(("Successfully deleted this product ,product id: " + id));
    }

}
