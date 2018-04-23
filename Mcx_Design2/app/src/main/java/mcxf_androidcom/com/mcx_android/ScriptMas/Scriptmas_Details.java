package mcxf_androidcom.com.mcx_android.ScriptMas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
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


import mcxf_androidcom.com.mcx_android.AboutUs;
import mcxf_androidcom.com.mcx_android.AppController;
import mcxf_androidcom.com.mcx_android.BhavCopy.BhavCopy_Details;
import mcxf_androidcom.com.mcx_android.ContactUs;
import mcxf_androidcom.com.mcx_android.GraphFragment.GraphActivity;
import mcxf_androidcom.com.mcx_android.MainMarketWatch.MainActivity;
import mcxf_androidcom.com.mcx_android.MostActiveContractVolume.MostActivityVolume_Details;
import mcxf_androidcom.com.mcx_android.MostActiveContractsValue.MostActiveContractsValue_Details;
import mcxf_androidcom.com.mcx_android.R;
import mcxf_androidcom.com.mcx_android.ScriptDet.Scriptdet_Details;
import mcxf_androidcom.com.mcx_android.Top_Gainers.TopGainers;
import mcxf_androidcom.com.mcx_android.Top_Losers.Top_Losers;

public class Scriptmas_Details extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    // Log tag
    private static final String TAG = Scriptmas_Details.class.getSimpleName();
    private JSONArray result;

    // Script_mas json url
    private static final String url = "http://10.0.2.2/scriptmas.php";
    private ProgressDialog pDialog;
    private List<Scriptmas> Scriptmaslist = new ArrayList<Scriptmas>();
    private ListView listView;
    private Scriptmas_ListAdapter adapter;
    String Prodcut = "";
    //private Table<marketwatch> = new



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scriptmas__details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textView= (TextView) toolbar.findViewById(R.id.scriptmas);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.list);
        adapter = new Scriptmas_ListAdapter(this, Scriptmaslist);
        ViewGroup headerView = (ViewGroup)getLayoutInflater().inflate(R.layout.header_scriptmas, listView,false);
        listView.addHeaderView(headerView);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // Creating volley request obj
        JsonArrayRequest ScriptmasReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Scriptmas scriptmas = new Scriptmas();

                                scriptmas.setInstrument_Code(obj.getString("Instrument_Code"));
                                scriptmas.setLot_Size(obj.getString("Lot_Size"));
                                scriptmas.setTick_Size(obj.getString("Tick_Size"));
                                scriptmas.setInstrument_Description(obj.getString("Instrument_Description"));
                                scriptmas.setTrading_Unit(obj.getString("Trading_Unit"));

                                // adding Script_mas to scriptmas array
                                Scriptmaslist.add(scriptmas);


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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout7);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(ScriptmasReq);
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


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout7);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void MarketWatch(View item) {
        if (item.getId() == R.id.MarketWatch) {
            Intent intent = new Intent(Scriptmas_Details.this, MainActivity.class);
            startActivity(intent);
        } else {
            if (item.getId() == R.id.macvalue) {
                Intent intent = new Intent(Scriptmas_Details.this, MostActiveContractsValue_Details.class);
                startActivity(intent);
            } else {
                if (item.getId() == R.id.macvolume) {
                    Intent intent = new Intent(Scriptmas_Details.this, MostActivityVolume_Details.class);
                    startActivity(intent);
                } else if (item.getId() == R.id.topgain) {
                    Intent intent = new Intent(Scriptmas_Details.this, TopGainers.class);
                    startActivity(intent);
                } else if (item.getId() == R.id.toplose) {

                    Intent intent = new Intent(Scriptmas_Details.this, Top_Losers.class);
                    startActivity(intent);

                } else if (item.getId() == R.id.Graphs) {

                    Intent intent = new Intent(Scriptmas_Details.this,GraphActivity.class);
                    startActivity(intent);

                } else if (item.getId() == R.id.BhavCopy) {

                    Intent intent = new Intent(Scriptmas_Details.this, BhavCopy_Details.class);
                    startActivity(intent);

                } else if (item.getId() == R.id.scriptdet) {

                    Intent intent = new Intent(Scriptmas_Details.this, Scriptdet_Details.class);
                    startActivity(intent);

                } else if (item.getId() == R.id.scriptmas) {

                    Intent intent = new Intent(Scriptmas_Details.this, Scriptmas_Details.class);
                    startActivity(intent);

                } else if (item.getId() == R.id.aboutUs) {

                    Intent intent = new Intent(Scriptmas_Details.this, AboutUs.class);
                    startActivity(intent);

                } else if (item.getId() == R.id.Contactus) {

                    Intent intent = new Intent(Scriptmas_Details.this, ContactUs.class);
                    startActivity(intent);
                }
                else if (item.getId() == R.id.homepage) {

                    Intent intent = new Intent(Scriptmas_Details.this, MainActivity.class);
                    startActivity(intent);
                }
                else if (item.getId() == R.id.imgLogo) {

                    Intent intent = new Intent(Scriptmas_Details.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        }
    }

}
