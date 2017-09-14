package diego_i_zuluaga.shopifymobileproblem.shopifyInteractionLogic;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import diego_i_zuluaga.shopifymobileproblem.MainActivity;
import diego_i_zuluaga.shopifymobileproblem.shopifyInteractionLogic.datamodel.ModelProblemData;
import diego_i_zuluaga.shopifymobileproblem.shopifyInteractionLogic.datamodel.ShopifyRequest;

/**
 * Created by Zulu on 9/13/17.
 */

public class ShopifyService {

        private String API_END_POINT = "https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6";

        private Gson gson = new GsonBuilder().create();
        private final RequestService requestService;

        public ShopifyService(Context context) {
            requestService = RequestService.getInstance(context);
        }

        public void getMobileProblemData(final MainActivity notifyAct) {

            StringRequest stringRequest = buildMobileProblemStringRequest(API_END_POINT, notifyAct);
            requestService.addToRequestQueue(stringRequest);
        }

        private StringRequest buildMobileProblemStringRequest(String uri, final MainActivity notifyAct) {

            return new StringRequest(Request.Method.GET, uri,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            ModelProblemData result;
                            try {
                                ShopifyRequest receivedData = gson.fromJson(response, ShopifyRequest.class);
                                result = new ModelProblemData(receivedData);
                            } catch (JsonSyntaxException | JsonIOException e) {
                                result = null;
                            }
                            notifyAct.showMobileProblemInfo(result);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            notifyAct.showMobileProblemInfo(null);
                        }
                    }
            );
        }
}
