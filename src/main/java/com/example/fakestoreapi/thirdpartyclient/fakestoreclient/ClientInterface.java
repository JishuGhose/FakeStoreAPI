package com.example.fakestoreapi.thirdpartyclient.fakestoreclient;

import com.example.fakestoreapi.exceptions.NotFoundException;

import java.util.List;

public interface ClientInterface
{
    FakeStoreGetProductByIdDto getProductById(Long id ) throws NotFoundException;
    List<FakeStoreGetProductByIdDto> getAllProducts();

    FakeStoreAddProductDto createProduct(FakeStoreAddProductDto fakeStoreAddProductDto);

    FakeStoreAddProductDto updateProduct(FakeStoreAddProductDto fakeStoreAddProductDto, long id);

    FakeStoreAddProductDto deleteProductById(long id);
}
