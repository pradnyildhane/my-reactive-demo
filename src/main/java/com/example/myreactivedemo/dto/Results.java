package com.example.myreactivedemo.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Results{
    @JsonProperty("ohlc")
    public Object Ohlc;
    public int average_price;
    public int buy_quantity;
    @JsonProperty("depth")
    public Object Depth;
    public int instrument_token;
    public double last_price;
    public int last_quantity;
    public String last_trade_time;
    public double lower_circuit_limit;
    public int net_change;
    //	@JsonProperty("ohlc")
//	public Object Ohlc;
    public int oi;
    public int oi_day_high;
    public int oi_day_low;
    public int sell_quantity;
    public String timestamp;
    public double upper_circuit_limit;
    public int volume;
}