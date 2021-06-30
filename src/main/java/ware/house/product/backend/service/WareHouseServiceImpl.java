package ware.house.product.backend.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ware.house.product.backend.dao.WareHouseRepository;
import ware.house.product.backend.dto.WareHouseCreateDto;
import ware.house.product.backend.dto.WareHouseDto;
import ware.house.product.backend.dto.WareHouseUpdateDto;
import ware.house.product.backend.exception.WareHouseProductNotFoundException;
import ware.house.product.backend.model.WareHouseProduct;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WareHouseServiceImpl implements WareHouseService {

    private final WareHouseRepository wareHouseRepository;
    private final ModelMapper modelMapper;


    public WareHouseServiceImpl(WareHouseRepository wareHouseRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.wareHouseRepository = wareHouseRepository;
    }

    @Override
    public List<WareHouseDto> retrieveAll() {
        return wareHouseRepository
                .retrieveAll()
                .stream()
                .map(wareHouseProduct -> modelMapper.map(wareHouseProduct, WareHouseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public WareHouseUpdateDto retrieveById(long id) {
        WareHouseProduct wareHouseProduct = wareHouseRepository
                .retrieveById(id)
                .orElseThrow(() -> new WareHouseProductNotFoundException("Product Not Found ! by Id"));

        return modelMapper.map(wareHouseProduct, WareHouseUpdateDto.class);
    }

    @Override
    public long create(WareHouseCreateDto wareHouseCreateDto) {
        WareHouseProduct wareHouseProduct = modelMapper.map(wareHouseCreateDto, WareHouseProduct.class);
        return wareHouseRepository.create(wareHouseProduct);
    }

    @Override
    public void update(WareHouseUpdateDto wareHouseUpdateDto) {
        Optional<WareHouseProduct> optionalWareHouseProduct = wareHouseRepository
                .retrieveById(wareHouseUpdateDto.getId())
                .stream()
                .findAny();

        if (optionalWareHouseProduct.isPresent()) {
            WareHouseProduct wareHouseProduct = modelMapper.map(wareHouseUpdateDto, WareHouseProduct.class);
            wareHouseRepository.update(wareHouseProduct);
        } else throw new WareHouseProductNotFoundException("Product is not exist !");
    }

    @Override
    public void deleteById(long id) {
        Optional<WareHouseProduct> optionalWareHouseProduct = wareHouseRepository
                .retrieveById(id)
                .stream()
                .findAny();

        if (optionalWareHouseProduct.isPresent()) {
            wareHouseRepository.deleteById(id);
        } else throw new WareHouseProductNotFoundException("Product is not exist !");
    }

}
