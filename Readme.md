// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Buy{
public int price;
public int quantity;
public int orders;
}

public class Depth{
public ArrayList<Buy> buy;
public ArrayList<Sell> sell;
}

public class Ohlc{
@JsonProperty("open")
public int myopen;
public double high;
public double low;
public double close;
}

public class Results{
public int average_price;
public int buy_quantity;
public Depth depth;
public int instrument_token;
public double last_price;
public int last_quantity;
public String last_trade_time;
public double lower_circuit_limit;
public int net_change;
public Ohlc ohlc;
public int oi;
public int oi_day_high;
public int oi_day_low;
public int sell_quantity;
public String timestamp;
public double upper_circuit_limit;
public int volume;
}

public class Root{
public Results results;
}

public class Sell{
public int price;
public int quantity;
public int orders;
}

