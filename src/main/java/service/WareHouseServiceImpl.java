package service;

import dao.WareHouseRepository;
import dto.WareHouseCreateDto;
import dto.WareHouseDto;
import dto.WareHouseUpdateDto;
import exception.WareHouseProductNotFoundException;
import model.WareHouseProduct;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class WareHouseServiceImpl implements WareHouseService {

    private final WareHouseRepository wareHouseRepository;
    private final ModelMapper modelMapper;

    public WareHouseServiceImpl() {
        wareHouseRepository = new WareHouseRepository();
        modelMapper = new ModelMapper();
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
        WareHouseProduct wareHouseProduct = modelMapper.map(wareHouseUpdateDto, WareHouseProduct.class);
        wareHouseRepository.update(wareHouseProduct);
    }

    @Override
    public void deleteById(long id) {
        wareHouseRepository.deleteByİd(id);
    }

}
