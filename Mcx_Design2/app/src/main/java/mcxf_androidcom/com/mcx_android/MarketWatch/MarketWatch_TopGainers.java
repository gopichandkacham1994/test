package mcxf_androidcom.com.mcx_android.MarketWatch;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ListView;

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

public class MarketWatch_TopGainers extends AppCompatActivity {
    // Log tag
    private static final String TAG = MarketWatch_TopGainers.class.getSimpleName();
    private JSONArray result;

    // MarketWatch_TopGainers json url
    private static final String url = "http://10.0.2.2/MarketWatchhigh.php";
    private ProgressDialog pDialog;
    private List<MarketWatch> MarketWatchlist = new ArrayList<MarketWatch>();
    private ListView listView;
    private MarketWatch_ListAdapter adapter;
    //String Prodcut = "";
    //private Table<marketwatch> = new



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_watch_top_gainers);

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
        JsonArrayRequest MarketWatch_TopGainersReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                MarketWatch marketWatch_gainers = new MarketWatch();

                                marketWatch_gainers.setProduct(obj.getString("Product"));
                               // marketWatch_gainers.setExpiry(obj.getString("Expiry"));
                                marketWatch_gainers.setLTP(obj.getString("LTP"));
//                                marketWatch_gainers.setOPEN(obj.getString("OPEN"));
//                                marketWatch_gainers.setHigh(obj.getString("High"));
//                                marketWatch_gainers.setLow(obj.getString("Low"));
//                                marketWatch_gainers.setClose(obj.getString("Close"));
                                marketWatch_gainers.setPercentageChange(obj.getString("PercentageChange"));

                                // adding MarketWatch to marketWatch_gainers array
                                MarketWatchlist.add(marketWatch_gainers);


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
        AppController.getInstance().addToRequestQueue(MarketWatch_TopGainersReq);
    }

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


}
