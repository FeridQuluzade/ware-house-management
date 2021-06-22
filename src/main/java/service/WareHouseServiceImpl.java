package service;

import dao.WareHouseRepository;
import dto.WareHouseCreateDto;
import dto.WareHouseDto;
import dto.WareHouseUpdateDto;
import exception.WareHouseProductNotFoundException;
import model.WareHouseProduct;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
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
            wareHouseRepository.deleteByİd(id);
        } else throw new WareHouseProductNotFoundException("Product is not exist !");
    }

}
