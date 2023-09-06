package com.example.fakestoreapi.controllers;

import com.example.fakestoreapi.dtos.FakeStoreAddProductDto;
import com.example.fakestoreapi.dtos.GenericProductDto;
import com.example.fakestoreapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{

    private ProductService productService;

    @Autowired
    ProductController(ProductService productService)
    {
        this.productService = productService;
    }



     @GetMapping("{id}")
     public GenericProductDto getProductById(@PathVariable("id") Long id)
     {
         return this.productService.getProductById(id);
     }

     @GetMapping
    public List<GenericProductDto> getAllProducts()
     {
         return this.productService.getAllProducts();
     }


     @PostMapping
     public GenericProductDto createProduct(@RequestBody FakeStoreAddProductDto fakeStoreAddProductDto)
     {
            return  this.productService.createProduct(fakeStoreAddProductDto);
     }

     @PutMapping("{id}")
     public GenericProductDto updateProduct(@RequestBody FakeStoreAddProductDto fakeStoreAddProductDto,
                                            @PathVariable("id") long id)
     {
         return this.productService.updateProduct(fakeStoreAddProductDto,id);

     }

     @DeleteMapping("{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") long id)
     {
         return this.productService.deleteProductById(id);
     }


}
