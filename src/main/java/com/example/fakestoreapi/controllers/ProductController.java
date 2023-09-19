package com.example.fakestoreapi.controllers;

import com.example.fakestoreapi.dtos.GenericProductDto;
import com.example.fakestoreapi.services.ProductService;
import com.example.fakestoreapi.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.fakestoreapi.thirdpartyclient.fakestoreclient.FakeStoreAddProductDto;

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
     public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException
     {
         return this.productService.getProductById(id);
     }

//     @ExceptionHandler(NotFoundException.class)
//     private ResponseEntity<NotFoundExceptionDto> handleNotFoundException(NotFoundException notFoundException)
//     {
//         return new ResponseEntity<>(
//                 new NotFoundExceptionDto(
//                         HttpStatus.NOT_FOUND,
//                         notFoundException.getMessage()
//                 ),HttpStatus.NOT_FOUND
//         );
//     }

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
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") long id)
     {
         return new ResponseEntity<>(
                 this.productService.deleteProductById(id),
                 HttpStatus.ACCEPTED
         );

     }


}
