package diego_i_zuluaga.shopifymobileproblem.shopifyInteractionLogic.datamodel;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Zulu on 9/13/17.
 */

public class ShopifyRequest {

    @SerializedName("orders")
    private ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
