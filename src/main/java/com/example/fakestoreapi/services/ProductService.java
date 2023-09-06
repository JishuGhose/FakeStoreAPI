package com.example.fakestoreapi.services;

import com.example.fakestoreapi.dtos.FakeStoreAddProductDto;
import com.example.fakestoreapi.dtos.GenericProductDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService
{
    GenericProductDto getProductById( Long id );
    List<GenericProductDto> getAllProducts();

    GenericProductDto createProduct(FakeStoreAddProductDto fakeStoreAddProductDto);

    GenericProductDto updateProduct(FakeStoreAddProductDto fakeStoreAddProductDto,long id);

    GenericProductDto deleteProductById(long id);



}
