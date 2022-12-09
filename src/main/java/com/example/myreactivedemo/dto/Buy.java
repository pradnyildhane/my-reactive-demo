package com.example.myreactivedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buy{
    public int price;
    public int quantity;
    public int orders;
}