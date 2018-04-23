package mcxf_androidcom.com.mcx_android.MostActiveContractVolume;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
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
import mcxf_androidcom.com.mcx_android.ChildItems;
import mcxf_androidcom.com.mcx_android.ContactUs;
import mcxf_androidcom.com.mcx_android.ExpandListAdapter;
import mcxf_androidcom.com.mcx_android.GraphFragment.GraphActivity;
import mcxf_androidcom.com.mcx_android.GroupItems;
import mcxf_androidcom.com.mcx_android.MainMarketWatch.MainActivity;
import mcxf_androidcom.com.mcx_android.MostActiveContractsValue.MostActiveContractsValue_Details;
import mcxf_androidcom.com.mcx_android.R;
import mcxf_androidcom.com.mcx_android.ScriptDet.Scriptdet_Details;
import mcxf_androidcom.com.mcx_android.ScriptMas.Scriptmas_Details;
import mcxf_androidcom.com.mcx_android.Top_Gainers.TopGainers;
import mcxf_androidcom.com.mcx_android.Top_Losers.Top_Losers;

public class MostActivityVolume_Details extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // Log tag
    private static final String TAG = MostActivityVolume_Details.class.getSimpleName();
    private JSONArray result;

    // MarketWatch json url
    private static final String url = "http://192.168.0.112:8888/MostActiveContractsVolume.php";
    private ProgressDialog pDialog;
    private List<MostActiveVolume> VolumeContractlist = new ArrayList<MostActiveVolume>();
    private ListView listView;
    private MostActiveVolumeAdapter adapter;
    private  DrawerLayout drawer;
    private  ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private ExpandableListView mDrawerList;
    private ExpandListAdapter ExpAdapter;
    private ArrayList<GroupItems> ExpListItems;
    ArrayList<GroupItems> group_list;
    ArrayList<ChildItems> child_list;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_activity_volume__details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // TextView textView= (TextView) toolbar.findViewById(R.id.macvolume1);
        if(toolbar!=null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
        }

        listView = (ListView) findViewById(R.id.list);
//        ViewGroup headerView = (ViewGroup)getLayoutInflater().inflate(R.layout.header_volumecontract, listView,false);
//        listView.addHeaderView(headerView);
        adapter = new MostActiveVolumeAdapter(this,VolumeContractlist);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // Creating volley request obj
        JsonArrayRequest VolumeContractReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                MostActiveVolume Volumevalue = new MostActiveVolume();

                                Volumevalue.setProduct(obj.getString("Product"));
                                Volumevalue.setExpiry(obj.getString("Expiry"));
                                Volumevalue.setPQU(obj.getString("PQU"));
                                Volumevalue.setQL(obj.getString("QL"));
                                Volumevalue.setLTP(obj.getString("LTP"));
                                Volumevalue.setValue(obj.getString("Value"));


                                // adding MarketWatch to marketwatch array
                               VolumeContractlist.add(Volumevalue);


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



//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(VolumeContractReq);

         drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
         toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
             public void onDrawerClosed(View view) {
                 super.onDrawerClosed(view);
                 invalidateOptionsMenu();
             }

             public void onDrawerOpened(View drawerView) {
                 super.onDrawerOpened(drawerView);
                 invalidateOptionsMenu();
             }
         };
        drawer.addDrawerListener(toggle);
        mDrawerList= (ExpandableListView) findViewById(R.id.navdrawer);
        ExpListItems = SetStandardGroups();
        ExpAdapter=new ExpandListAdapter(MostActivityVolume_Details.this,ExpListItems);
        mDrawerList.setAdapter(ExpAdapter);

        mDrawerList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if(groupPosition==1)
                {
                    if(childPosition==0)
                    {
                        Intent intent=new Intent(MostActivityVolume_Details.this,MostActiveContractsValue_Details.class);
                        startActivity(intent);
                    }
                    if(childPosition==1)
                    {
                        Intent intent=new Intent(MostActivityVolume_Details.this,MostActivityVolume_Details.class);
                        startActivity(intent);
                    }

                }
                if(groupPosition==2)
                {
                    if(childPosition==0)
                    {
                        Intent intent=new Intent(MostActivityVolume_Details.this,TopGainers.class);
                        startActivity(intent);
                    }
                    if(childPosition==1)
                    {
                        Intent intent=new Intent(MostActivityVolume_Details.this,Top_Losers.class);
                        startActivity(intent);
                    }
                }

                return false;
            }
        });


        mDrawerList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if(groupPosition==0)
                {
                    Intent intent=new Intent(MostActivityVolume_Details.this,MainActivity.class);
                    startActivity(intent);

                }
                if(groupPosition==3)
                {
                    Intent intent=new Intent(MostActivityVolume_Details.this,GraphActivity.class);
                    startActivity(intent);
                }
                if(groupPosition==4)
                {
                    Intent intent=new Intent(MostActivityVolume_Details.this,BhavCopy_Details.class);
                    startActivity(intent);
                }
                if(groupPosition==5)
                {
                    Intent intent=new Intent(MostActivityVolume_Details.this,Scriptdet_Details.class);
                    startActivity(intent);
                }
                if(groupPosition==6)
                {
                    Intent intent=new Intent(MostActivityVolume_Details.this,AboutUs.class);
                    startActivity(intent);
                }
                if(groupPosition==7)
                {
                    Intent intent=new Intent(MostActivityVolume_Details.this,ContactUs.class);
                    startActivity(intent);
                }

                return false;
            }
        });
    }
    public ArrayList<GroupItems> SetStandardGroups() {

        group_list = new ArrayList<GroupItems>();


        // Setting Group 1
        child_list = new ArrayList<ChildItems>();
        GroupItems gru1 = new GroupItems();
        gru1.setName("Product Details");
        gru1.setImages(R.drawable.ic_marketwatch);

        gru1.setItems(child_list);

//        ChildItems ch1_1 = new ChildItems();
//        ch1_1.setName("Iphone");
//        child_list.add(ch1_1);
//
//        ChildItems ch1_2 = new ChildItems();
//        ch1_2.setName("ipad");
//        child_list.add(ch1_2);
//
//        ChildItems ch1_3 = new ChildItems();
//        ch1_3.setName("ipod");
//        child_list.add(ch1_3);
//
//        gru1.setItems(child_list);

        // Setting Group 2
        child_list = new ArrayList<ChildItems>();
        GroupItems gru2 = new GroupItems();
        gru2.setName("MAC");
        gru2.setImages(R.drawable.ic_value);
        gru2.setExpand_icon(R.drawable.ic_expand_drawer);

        ChildItems ch2_1 = new ChildItems();
        ch2_1.setName("MAC Value");
        child_list.add(ch2_1);

        ChildItems ch2_2 = new ChildItems();
        ch2_2.setName("MAC Volume");
        child_list.add(ch2_2);

//        ChildItems ch2_3 = new ChildItems();
//        ch2_3.setName("Galaxy Mega");
//        child_list.add(ch2_3);

//        ChildItems ch2_4 = new ChildItems();
//        ch2_4.setName("Galaxy Neo");
//        child_list.add(ch2_4);

        gru2.setItems(child_list);

        child_list=new ArrayList<ChildItems>();
        GroupItems grp3=new GroupItems();
        grp3.setName("Gainers & Losers");
        grp3.setImages(R.drawable.ic_high);
        grp3.setExpand_icon(R.drawable.ic_expand_drawer);

        ChildItems ch3_1 = new ChildItems();
        ch3_1.setName("Top Gainers");
        child_list.add(ch3_1);

        ChildItems ch3_2 = new ChildItems();
        ch3_2.setName("Top Losers");
        child_list.add(ch3_2);

        grp3.setItems(child_list);

        child_list=new ArrayList<ChildItems>();
        GroupItems grp4=new GroupItems();
        grp4.setName("Graphs");
        grp4.setImages(R.drawable.ic_graphs);

//        ChildItems ch4_1 = new ChildItems();
//        ch4_1.setName("Gold");
//        child_list.add(ch4_1);
//
//        ChildItems ch4_2 = new ChildItems();
//        ch4_2.setName("Silver");
//        child_list.add(ch4_2);

        grp4.setItems(child_list);


        child_list = new ArrayList<ChildItems>();
        GroupItems grp5 = new GroupItems();
        grp5.setName("BhavCopy");
        grp5.setImages(R.drawable.ic_bhavcopy);

        grp5.setItems(child_list);

        child_list = new ArrayList<ChildItems>();
        GroupItems grp6 = new GroupItems();
        grp6.setName("Scriptdet");
        grp6.setImages(R.drawable.ic_scriptdet);

        grp6.setItems(child_list);

        child_list = new ArrayList<ChildItems>();
        GroupItems grp7 = new GroupItems();
        grp7.setName("About Us");
        grp7.setImages(R.drawable.ic_about);

        grp7.setItems(child_list);

        child_list = new ArrayList<ChildItems>();
        GroupItems grp8 = new GroupItems();
        grp8.setName("Contact Us");
        grp8.setImages(R.drawable.ic_contactus);

        grp8.setItems(child_list);



        //listing all groups
        group_list.add(gru1);
        group_list.add(gru2);
        group_list.add(grp3);
        group_list.add(grp4);
        group_list.add(grp5);
        group_list.add(grp6);
        group_list.add(grp7);
        group_list.add(grp8);


        return group_list;
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
    public void onBackPressed() {
      Intent intent=new Intent(MostActivityVolume_Details.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }




    public void MarketWatch(View item) {
//        if (item.getId() == R.id.MarketWatch) {
//            Intent intent = new Intent(MostActivityVolume_Details.this, MainActivity.class);
//            startActivity(intent);
//        } else {
//            if (item.getId() == R.id.macvalue) {
//                Intent intent = new Intent(MostActivityVolume_Details.this, MostActiveContractsValue_Details.class);
//                startActivity(intent);
//            } else {
//                if (item.getId() == R.id.macvolume) {
//                    Intent intent = new Intent(MostActivityVolume_Details.this, MostActivityVolume_Details.class);
//                    startActivity(intent);
//                } else if (item.getId() == R.id.topgain) {
//                    Intent intent = new Intent(MostActivityVolume_Details.this, TopGainers.class);
//                    startActivity(intent);
//                } else if (item.getId() == R.id.toplose) {
//
//                    Intent intent = new Intent(MostActivityVolume_Details.this, Top_Losers.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.Graphs) {
//
//                    Intent intent = new Intent(MostActivityVolume_Details.this, GraphActivity.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.BhavCopy) {
//
//                    Intent intent = new Intent(MostActivityVolume_Details.this, BhavCopy_Details.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.scriptdet) {
//
//                    Intent intent = new Intent(MostActivityVolume_Details.this, Scriptdet_Details.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.aboutUs) {
//
//                    Intent intent = new Intent(MostActivityVolume_Details.this, AboutUs.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.Contactus) {
//
//                    Intent intent = new Intent(MostActivityVolume_Details.this, ContactUs.class);
//                    startActivity(intent);
//                }
                 if (item.getId() == R.id.homepage) {

                    Intent intent = new Intent(MostActivityVolume_Details.this, MainActivity.class);
                    startActivity(intent);
                }
                else if (item.getId() == R.id.imgLogo2) {

                    Intent intent = new Intent(MostActivityVolume_Details.this, MainActivity.class);
                    startActivity(intent);
                }
         //   }
       // }
    }
}

