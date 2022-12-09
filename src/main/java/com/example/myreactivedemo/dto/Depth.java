package com.example.myreactivedemo.dto;

import com.example.myreactivedemo.dto.Buy;
import com.example.myreactivedemo.dto.Sell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depth{
    public ArrayList<Buy> buy;
    public ArrayList<Sell> sell;
}