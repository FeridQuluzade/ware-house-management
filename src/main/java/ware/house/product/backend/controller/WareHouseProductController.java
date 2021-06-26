package ware.house.product.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ware.house.product.backend.dto.WareHouseCreateDto;
import ware.house.product.backend.dto.WareHouseDto;
import ware.house.product.backend.dto.WareHouseUpdateDto;
import ware.house.product.backend.service.WareHouseService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/ware-products")
public class WareHouseProductController {
    private WareHouseService wareHouseService;

    @Autowired
    public WareHouseProductController(WareHouseService wareHouseService) {
        this.wareHouseService = wareHouseService;
    }

    @GetMapping(value = "/retrieve-all")
    @ResponseBody
    public List<WareHouseDto> retrieveAll() {
        return wareHouseService.retrieveAll();
    }

    @GetMapping(value = "/retrieve-by-id/{id}")
    @ResponseBody
    public WareHouseUpdateDto retrieveById(@PathVariable Long id) {
        return wareHouseService.retrieveById(id);
    }

    @PostMapping(value = "/create")
    public long create(@Valid @RequestBody WareHouseCreateDto wareHouseCreateDto) {
        wareHouseCreateDto.setCreatedDate(LocalDateTime.now());
        return wareHouseService.create(wareHouseCreateDto);
    }

    @PutMapping(value = "/update")
    public void update(@Valid @RequestBody WareHouseUpdateDto wareHouseUpdateDto) {
        wareHouseUpdateDto.setUpdatedDate(LocalDateTime.now());
        wareHouseService.update(wareHouseUpdateDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        wareHouseService.deleteById(id);
    }

}