package mcxf_androidcom.com.mcx_android.MarketWatch;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.VolleyLog;
        import com.android.volley.toolbox.JsonArrayRequest;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.List;


        import mcxf_androidcom.com.mcx_android.AppController;
import mcxf_androidcom.com.mcx_android.R;

public class MarketWatch_Details extends AppCompatActivity {
    // Log tag
    private static final String TAG = MarketWatch_Details.class.getSimpleName();

    // MarketWatch json url
    private static final String url = "http://10.0.2.2/Marketwatchnew.php";
    private ProgressDialog pDialog;
    private List<MarketWatch> MarketWatchlist = new ArrayList<MarketWatch>();
    private ListView listView;
    private MarketWatch_ListAdapter adapter;




  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_watch_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.list);
        ViewGroup headerView = (ViewGroup)getLayoutInflater().inflate(R.layout.header_marketwatch, listView,false);
        listView.addHeaderView(headerView);
        adapter = new MarketWatch_ListAdapter(this, MarketWatchlist);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // Creating volley request obj
        JsonArrayRequest MarketWatchReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                MarketWatch marketWatch = new MarketWatch();

                                marketWatch.setProduct(obj.getString("Product"));
                                marketWatch.setExpiry(obj.getString("Expiry"));
                                //marketWatch.setTotalQtyTraded(obj.getString("TotalQtyTraded"));
                                marketWatch.setLTP(obj.getString("LTP"));
                                marketWatch.setPCP(obj.getString("PCP"));
                                marketWatch.setPercentageChange(obj.getString("PercentageChange"));
                                marketWatch.setBuyPrice1(obj.getString("BuyPrice1"));
                                marketWatch.setBuyQty1(obj.getString("BuyQty1"));
                                marketWatch.setSellPrice1(obj.getString("SellPrice1"));
                                marketWatch.setSellQty1(obj.getString("SellQty1"));


                                // adding MarketWatch to marketwatch array
                                MarketWatchlist.add(marketWatch);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }


                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();
            }
        });


        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(MarketWatchReq);
    }
//

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
    }
}

