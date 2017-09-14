package diego_i_zuluaga.shopifymobileproblem.shopifyInteractionLogic;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestService {
    private static RequestService mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private RequestService(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();

    }

    public static synchronized RequestService getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RequestService(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
