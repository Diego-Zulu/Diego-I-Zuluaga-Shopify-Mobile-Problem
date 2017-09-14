package diego_i_zuluaga.shopifymobileproblem.shopifyInteractionLogic.datamodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Zulu on 9/13/17.
 */

public class Customer {

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
