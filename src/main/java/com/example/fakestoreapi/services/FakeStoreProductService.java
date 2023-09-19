package com.example.fakestoreapi.services;

import com.example.fakestoreapi.dtos.GenericProductDto;
import com.example.fakestoreapi.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.fakestoreapi.thirdpartyclient.ThirdPartyAdaptorInterface;
import com.example.fakestoreapi.thirdpartyclient.fakestoreclient.FakeStoreAddProductDto;

import java.util.List;

@Service
@AllArgsConstructor
public class FakeStoreProductService implements ProductService{

    private ThirdPartyAdaptorInterface thirdPartyAdaptorInterface;

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
       return this.thirdPartyAdaptorInterface.getProductById(id);
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return this.thirdPartyAdaptorInterface.getAllProducts();
    }

    @Override
    public GenericProductDto createProduct(FakeStoreAddProductDto fakeStoreAddProductDto) {
        return this.thirdPartyAdaptorInterface.createProduct(fakeStoreAddProductDto);
    }

    @Override
    public GenericProductDto updateProduct(FakeStoreAddProductDto fakeStoreAddProductDto, long id) {
        return this.thirdPartyAdaptorInterface.updateProduct(fakeStoreAddProductDto,id);
    }

    @Override
    public GenericProductDto deleteProductById(long id) {
        return this.thirdPartyAdaptorInterface.deleteProductById(id);
    }
}
