package com.example.fakestoreapi.services;

import com.example.fakestoreapi.dtos.GenericProductDto;
import com.example.fakestoreapi.exceptions.NotFoundException;
import com.example.fakestoreapi.thirdpartyclient.fakestoreclient.FakeStoreAddProductDto;

import java.util.List;

public interface ProductService
{
    GenericProductDto getProductById( Long id ) throws NotFoundException;
    List<GenericProductDto> getAllProducts();

    GenericProductDto createProduct(FakeStoreAddProductDto fakeStoreAddProductDto);

    GenericProductDto updateProduct(FakeStoreAddProductDto fakeStoreAddProductDto, long id);

    GenericProductDto deleteProductById(long id);



}
