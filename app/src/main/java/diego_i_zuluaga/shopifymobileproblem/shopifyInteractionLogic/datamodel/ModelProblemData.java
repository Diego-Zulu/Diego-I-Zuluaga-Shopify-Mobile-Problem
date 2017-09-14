package diego_i_zuluaga.shopifymobileproblem.shopifyInteractionLogic.datamodel;

import java.math.BigDecimal;
import java.text.DecimalFormatSymbols;

/**
 * Created by Zulu on 9/13/17.
 */

public class ModelProblemData {

    public ModelProblemData(ShopifyRequest data) {
        spentByNapoleon = BigDecimal.ZERO;

        String targetCustomerFirstName = "Napoleon";
        String targetCustomerLastName = "Batz";
        String targetItem = "Awesome Bronze Bag";

        for (Order oneOrder : data.getOrders()) {

            Customer actualCustomer = oneOrder.getCustomer();
            if (actualCustomer != null && targetCustomerFirstName.equals(actualCustomer.getFirstName())
                    && targetCustomerLastName.equals(actualCustomer.getLastName())) {
                char separator = DecimalFormatSymbols.getInstance().getGroupingSeparator();
                BigDecimal cost = new BigDecimal(oneOrder.getTotalPrice().replaceAll(separator + "", ""));
                spentByNapoleon = spentByNapoleon.add(cost);
            }

            for (LineItem item : oneOrder.getLinesItems()) {

                if (item.getTitle().equals(targetItem)) {
                    bagsSold++;
                }
            }
        }
    }

    private BigDecimal spentByNapoleon;
    private int bagsSold;

    public BigDecimal getSpentByNapoleon() {
        return spentByNapoleon;
    }

    public int getBagsSold() {
        return bagsSold;
    }
}
