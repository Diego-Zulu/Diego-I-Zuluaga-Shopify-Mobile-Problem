package diego_i_zuluaga.shopifymobileproblem;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

import diego_i_zuluaga.shopifymobileproblem.shopifyInteractionLogic.ShopifyService;
import diego_i_zuluaga.shopifymobileproblem.shopifyInteractionLogic.datamodel.ModelProblemData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSwipeLayout();
        getShopifyData();

    }

    private void setSwipeLayout(){
        setLoadingGif();
        final SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout) this.findViewById(R.id.swipe_refresh_layout);
        swipeLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        getShopifyData();
                    }
                });
    }

    private void setLoadingGif(){
        ImageView imageView = (ImageView) this.findViewById(R.id.shopify_icon);
        DrawableImageViewTarget imageViewTarget = new DrawableImageViewTarget(imageView);
        Glide.with(this).load(R.drawable.loading).into(imageViewTarget);
    }

    private void getShopifyData(){

        ShopifyService service = new ShopifyService(this);
        service.getMobileProblemData(this);
    }

    public void showMobileProblemInfo(ModelProblemData result) {

        if(result == null) {
            manageCantGetMobileProblemInfoError(this);
            setErrorIcon();
        }else {
            setInformationInUI(result);
        }
    }

    private void setErrorIcon(){
        ImageView icon = (ImageView) this.findViewById(R.id.shopify_icon);
        DrawableImageViewTarget imageViewTarget = new DrawableImageViewTarget(icon);
        Glide.with(this).clear(imageViewTarget);
        icon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.error));
    }

    public static void manageCantGetMobileProblemInfoError(Activity thisAct) {
        Toast.makeText(thisAct, thisAct.getResources().getString(R.string.connection_problem), Toast.LENGTH_SHORT).show();
        SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout) thisAct.findViewById(R.id.swipe_refresh_layout);
        swipeLayout.setRefreshing(false);

    }



    private void setInformationInUI(ModelProblemData result){
        SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout) this.findViewById(R.id.swipe_refresh_layout);
        swipeLayout.setRefreshing(false);

        ImageView icon = (ImageView) this.findViewById(R.id.shopify_icon);
        Glide.with(this).clear(icon);
        icon.setImageResource(R.drawable.shop_logo_1);

        TextView napoleonSpent = (TextView) this.findViewById(R.id.napoleon_spent);
        napoleonSpent.setText(result.getSpentByNapoleon().toString());

        TextView bagsAmount = (TextView) this.findViewById(R.id.awesome_bronze_bags_amount);
        bagsAmount.setText(result.getBagsSold() + "");


    }

}
