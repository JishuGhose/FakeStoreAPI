package com.example.fakestoreapi.thirdpartyclient.fakestoreadapter;

import com.example.fakestoreapi.dtos.GenericProductDto;
import com.example.fakestoreapi.exceptions.NotFoundException;
import com.example.fakestoreapi.thirdpartyclient.ThirdPartyAdaptorInterface;
import com.example.fakestoreapi.thirdpartyclient.fakestoreclient.ClientInterface;
import com.example.fakestoreapi.thirdpartyclient.fakestoreclient.FakeStoreAddProductDto;
import com.example.fakestoreapi.thirdpartyclient.fakestoreclient.FakeStoreGetProductByIdDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class FakeStoreAdapter implements ThirdPartyAdaptorInterface {

    private ClientInterface clientInterface;


    private GenericProductDto convertFakeStoreGetProductByIdObjectToGenericProduct(FakeStoreGetProductByIdDto fakeStoreGetProductByIdDto)
    {
        GenericProductDto product = new GenericProductDto();

        product.setId(fakeStoreGetProductByIdDto.getId());
        product.setTitle(fakeStoreGetProductByIdDto.getTitle());
        product.setCategory(fakeStoreGetProductByIdDto.getCategory());
        product.setPrice(fakeStoreGetProductByIdDto.getPrice());
        product.setImage(fakeStoreGetProductByIdDto.getImage());
        product.setDescription(fakeStoreGetProductByIdDto.getDescription());

        return product;
    }

    private GenericProductDto convertFakeStoreAddProductDtoToGenericProduct(FakeStoreAddProductDto fakeStoreAddProdcutdDto)
    {
        GenericProductDto product = new GenericProductDto();


        product.setId(fakeStoreAddProdcutdDto.getId());
        product.setTitle(fakeStoreAddProdcutdDto.getTitle());
        product.setCategory(fakeStoreAddProdcutdDto.getCategory());
        product.setPrice(fakeStoreAddProdcutdDto.getPrice());
        product.setImage(fakeStoreAddProdcutdDto.getImage());
        product.setDescription(fakeStoreAddProdcutdDto.getDescription());


        return product;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {

        FakeStoreGetProductByIdDto fakeStoreGetProductByIdDto = this.clientInterface.getProductById(id);
        return this.convertFakeStoreGetProductByIdObjectToGenericProduct(fakeStoreGetProductByIdDto);

    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        List<FakeStoreGetProductByIdDto> list = this.clientInterface.getAllProducts();
        List<GenericProductDto> genericProducts = new ArrayList<>();
        for(FakeStoreGetProductByIdDto fakeStoreGetProductByIdDto:list)
        {
            genericProducts.add(convertFakeStoreGetProductByIdObjectToGenericProduct(fakeStoreGetProductByIdDto));
        }
        return genericProducts;
    }

    @Override
    public GenericProductDto createProduct(FakeStoreAddProductDto fakeStoreAddProductDto) {

        return convertFakeStoreAddProductDtoToGenericProduct(this.clientInterface.createProduct(fakeStoreAddProductDto));

    }

    @Override
    public GenericProductDto updateProduct(FakeStoreAddProductDto fakeStoreAddProductDto, long id) {

        return convertFakeStoreAddProductDtoToGenericProduct(this.clientInterface.updateProduct(fakeStoreAddProductDto,id));
    }

    @Override
    public GenericProductDto deleteProductById(long id) {

        return convertFakeStoreAddProductDtoToGenericProduct(this.clientInterface.deleteProductById(id));
    }
}
