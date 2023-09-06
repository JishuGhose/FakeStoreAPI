package com.example.fakestoreapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreGetProductByIdDto
{
    /*
     *          id:1,
                title:'...',
                price:'...',
                category:'...',
                description:'...',
                image:'...'
    *
    *
    *
    * */

    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

}
