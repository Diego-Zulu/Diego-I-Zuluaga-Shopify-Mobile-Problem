package diego_i_zuluaga.shopifymobileproblem.shopifyInteractionLogic.datamodel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Zulu on 9/13/17.
 */

public class Order {

    @SerializedName("currency")
    private String currency;

    @SerializedName("customer")
    Customer customer;

    @SerializedName("line_items")
    private ArrayList<LineItem> linesItems = new ArrayList<>();

    @SerializedName("total_price")
    private String totalPrice;

    public String getCurrency() {
        return currency;
    }

    public Customer getCustomer() {

        return customer;
    }

    public ArrayList<LineItem> getLinesItems() {
        return linesItems;
    }

    public String getTotalPrice() {
        return totalPrice;
    }
}
