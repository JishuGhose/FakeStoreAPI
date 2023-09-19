package com.example.fakestoreapi.thirdpartyclient.fakestoreclient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreAddProductDto {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
