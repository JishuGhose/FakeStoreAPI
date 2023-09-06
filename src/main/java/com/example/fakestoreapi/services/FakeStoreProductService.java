package com.example.fakestoreapi.services;

import com.example.fakestoreapi.FakeStoreApiApplication;
import com.example.fakestoreapi.dtos.FakeStoreAddProductDto;
import com.example.fakestoreapi.dtos.FakeStoreGetProductByIdDto;
import com.example.fakestoreapi.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String getAllProductRequestUrl = "https://fakestoreapi.com/products";

    private String createproductUrl = "https://fakestoreapi.com/products";
    private String updateproductUrl = "https://fakestoreapi.com/products/{id}";

    private String deleteproductUrl = "https://fakestoreapi.com/products/{id}";


    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public GenericProductDto getProductById(Long id) {

         RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreGetProductByIdDto> response =
         restTemplate.getForEntity(getProductRequestUrl, FakeStoreGetProductByIdDto.class,id);

        FakeStoreGetProductByIdDto fakeStoreGetProductByIdDto = response.getBody();

        GenericProductDto product = new GenericProductDto();

        product.setId(fakeStoreGetProductByIdDto.getId());
        product.setTitle(fakeStoreGetProductByIdDto.getTitle());
        product.setCategory(fakeStoreGetProductByIdDto.getCategory());
        product.setPrice(fakeStoreGetProductByIdDto.getPrice());
        product.setImage(fakeStoreGetProductByIdDto.getImage());
        product.setDescription(fakeStoreGetProductByIdDto.getDescription());

        return product;

    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ParameterizedTypeReference<List<FakeStoreGetProductByIdDto>> responseType =
                new ParameterizedTypeReference<List<FakeStoreGetProductByIdDto>>() {};


        ResponseEntity<List<FakeStoreGetProductByIdDto>> responseEntity =
                restTemplate.exchange(getAllProductRequestUrl, HttpMethod.GET, null, responseType);


        List<FakeStoreGetProductByIdDto> allProducts = responseEntity.getBody();

        List<GenericProductDto> products = new ArrayList<>();

        for(FakeStoreGetProductByIdDto fakeStoreGetProductByIdDto : allProducts )
        {
            GenericProductDto product = new GenericProductDto();
            product.setId(fakeStoreGetProductByIdDto.getId());
            product.setTitle(fakeStoreGetProductByIdDto.getTitle());
            product.setCategory(fakeStoreGetProductByIdDto.getCategory());
            product.setPrice(fakeStoreGetProductByIdDto.getPrice());
            product.setImage(fakeStoreGetProductByIdDto.getImage());
            product.setDescription(fakeStoreGetProductByIdDto.getDescription());
            products.add(product);

        }

        return products;




    }

    @Override
    public GenericProductDto createProduct(FakeStoreAddProductDto fakeStoreAddProductDto) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreAddProductDto> responseBody =
        restTemplate.postForEntity(createproductUrl,fakeStoreAddProductDto, FakeStoreAddProductDto.class);

        FakeStoreAddProductDto fakeStoreAddProdcutdDto = responseBody.getBody();

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
    public GenericProductDto updateProduct(FakeStoreAddProductDto fakeStoreAddProductDto,long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();



        HttpEntity<FakeStoreAddProductDto> request = new HttpEntity<>(
                fakeStoreAddProductDto);

        // Send the PUT method as a method parameter
        ResponseEntity<FakeStoreAddProductDto> response =
        restTemplate.exchange(
                updateproductUrl,
                HttpMethod.PUT,
                request,
                FakeStoreAddProductDto.class,
                id);


        FakeStoreAddProductDto fakeStoreAddProdcutdDto = response.getBody();

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
    public GenericProductDto deleteProductById(long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreAddProductDto> response =
        restTemplate.exchange(deleteproductUrl,HttpMethod.DELETE,null,
                FakeStoreAddProductDto.class,id);


        FakeStoreAddProductDto fakeStoreAddProdcutdDto = response.getBody();

        GenericProductDto product = new GenericProductDto();


        product.setId(fakeStoreAddProdcutdDto.getId());
        product.setTitle(fakeStoreAddProdcutdDto.getTitle());
        product.setCategory(fakeStoreAddProdcutdDto.getCategory());
        product.setPrice(fakeStoreAddProdcutdDto.getPrice());
        product.setImage(fakeStoreAddProdcutdDto.getImage());
        product.setDescription(fakeStoreAddProdcutdDto.getDescription());


        return product;


    }


}
