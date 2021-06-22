package service;

import dao.WareHouseRepository;
import dto.WareHouseCreateDto;
import dto.WareHouseUpdateDto;
import exception.WareHouseProductNotFoundException;
import model.WareHouseProduct;
import org.modelmapper.ModelMapper;

public class WareHouseServiceImpl implements WareHouseService {

    private final WareHouseRepository wareHouseRepository;
    private final ModelMapper modelMapper;

    public WareHouseServiceImpl() {
        wareHouseRepository = new WareHouseRepository();
        modelMapper = new ModelMapper();
    }

    @Override
    public WareHouseUpdateDto retrieveById(long id) {
      WareHouseProduct wareHouseProduct=wareHouseRepository
              .retrieveById(id)
              .orElseThrow(()-> new WareHouseProductNotFoundException("Product Not Found ! by Id"));

      return modelMapper.map(wareHouseProduct,WareHouseUpdateDto.class);
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
