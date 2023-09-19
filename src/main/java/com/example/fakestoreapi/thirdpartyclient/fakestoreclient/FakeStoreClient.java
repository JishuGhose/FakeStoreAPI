package com.example.fakestoreapi.thirdpartyclient.fakestoreclient;

import com.example.fakestoreapi.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreClient implements ClientInterface
{

    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.url}")
    private String fakeStoreURL;

    @Value("${fakestore.api.product}")
    private String product;


    private String getProductRequestUrl; //= "https://fakestoreapi.com/products/{id}";
    private String getAllProductRequestUrl = "https://fakestoreapi.com/products";

    private String createproductUrl = "https://fakestoreapi.com/products";
    private String updateproductUrl = "https://fakestoreapi.com/products/{id}";

    private String deleteproductUrl = "https://fakestoreapi.com/products/{id}";


    FakeStoreClient(RestTemplateBuilder restTemplateBuilder,
                    @Value("${fakestore.api.url}")
                    String fakeStoreURL,
                    @Value("${fakestore.api.product}")
                    String product
                    )
    {
        this.restTemplateBuilder = restTemplateBuilder;
       this.getProductRequestUrl = fakeStoreURL+product+"/{id}";
    }





    public FakeStoreGetProductByIdDto getProductById(Long id) throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreGetProductByIdDto> response =
                restTemplate.getForEntity(getProductRequestUrl, FakeStoreGetProductByIdDto.class,id);

        if( response.getBody()==null )
        {
            throw new NotFoundException("Product with Id: "+id +" not available");
        }

        return response.getBody();




    }


    public List<FakeStoreGetProductByIdDto> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();


        ResponseEntity<FakeStoreGetProductByIdDto[]> responseEntity =
                restTemplate.getForEntity(getAllProductRequestUrl,FakeStoreGetProductByIdDto[].class);




        List<FakeStoreGetProductByIdDto> products = new ArrayList<>();

        for(FakeStoreGetProductByIdDto fakeStoreGetProductByIdDto : responseEntity.getBody() )
        {

            products.add(fakeStoreGetProductByIdDto);

        }

        return products;




    }


    public FakeStoreAddProductDto createProduct(FakeStoreAddProductDto fakeStoreAddProductDto) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreAddProductDto> responseBody =
                restTemplate.postForEntity(createproductUrl,fakeStoreAddProductDto, FakeStoreAddProductDto.class);


        return responseBody.getBody();



    }




    public FakeStoreAddProductDto updateProduct(FakeStoreAddProductDto fakeStoreAddProductDto,long id) {

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


        return response.getBody();






    }


    public FakeStoreAddProductDto deleteProductById(long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreAddProductDto> response =
                restTemplate.exchange(deleteproductUrl,HttpMethod.DELETE,null,
                        FakeStoreAddProductDto.class,id);


        return response.getBody();



    }


}
