package diego_i_zuluaga.shopifymobileproblem.shopifyInteractionLogic.datamodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Zulu on 9/13/17.
 */

public class LineItem {

    @SerializedName("title")
    private String title;

    public String getTitle() {
        return title;
    }
}
