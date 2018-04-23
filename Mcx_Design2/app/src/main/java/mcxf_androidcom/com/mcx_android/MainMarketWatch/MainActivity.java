package mcxf_androidcom.com.mcx_android.MainMarketWatch;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import mcxf_androidcom.com.mcx_android.GraphFragment.GoldFragment;
import mcxf_androidcom.com.mcx_android.GraphFragment.GraphActivity;
import mcxf_androidcom.com.mcx_android.GraphFragment.SilverFragment;
import mcxf_androidcom.com.mcx_android.GroupItems;
import mcxf_androidcom.com.mcx_android.R;
import mcxf_androidcom.com.mcx_android.Top_Gainers.TopGainers;
import mcxf_androidcom.com.mcx_android.Top_Losers.Top_Losers;
import mcxf_androidcom.com.mcx_android.MostActiveContractVolume.MostActivityVolume_Details;
import mcxf_androidcom.com.mcx_android.MostActiveContractsValue.MostActiveContractsValue_Details;
import mcxf_androidcom.com.mcx_android.ScriptDet.Scriptdet_Details;
import mcxf_androidcom.com.mcx_android.ScriptMas.Scriptmas_Details;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    // MarketWatch json url
    private static final String url = "http://192.168.0.112:8888/Marketwatchnew.php";
    private ProgressDialog pDialog;
    private List<MainMarketwatch_Get_Set> MarketWatchlist = new ArrayList<MainMarketwatch_Get_Set>();
    private ListView listView;
    private MainMarketWatch_List adapter;
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
        setContentView(R.layout.activity_main);
         toolbar = (Toolbar) findViewById(R.id.toolbar);

        if(toolbar!=null)
        {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
        }
        TextView textView = (TextView) toolbar.findViewById(R.id.market);


        listView = (ListView) findViewById(R.id.main_List);
//        ViewGroup headerView = (ViewGroup) getLayoutInflater().inflate(R.layout.mainheader_marketwatch, listView, false);
//        listView.addHeaderView(headerView);
        adapter = new MainMarketWatch_List(this, MarketWatchlist);
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
                                MainMarketwatch_Get_Set marketWatch = new MainMarketwatch_Get_Set();

                                marketWatch.setProduct(obj.getString("Product"));
                                marketWatch.setExpiry(obj.getString("Expiry"));
                                //marketWatch.setTotalQtyTraded(obj.getString("TotalQtyTraded"));
                                marketWatch.setLTP(obj.getString("LTP"));
                                marketWatch.setPCP(String.format("%.2f", obj.getDouble("PCP")));
                                marketWatch.setPercentageChange(obj.getString("PercentageChange"));
                                marketWatch.setValue(obj.getString("Value"));
                                marketWatch.setPQU(obj.getString("PQU"));
                                marketWatch.setQL(obj.getString("QL"));
                                marketWatch.setChange(obj.getString("ChangeInOI"));


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
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        mDrawerList= (ExpandableListView) findViewById(R.id.navdrawer);
        ExpListItems = SetStandardGroups();
        ExpAdapter=new ExpandListAdapter(MainActivity.this,ExpListItems);
        mDrawerList.setAdapter(ExpAdapter);

        mDrawerList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if(groupPosition==1)
                {
                    if(childPosition==0)
                    {
                        Intent intent=new Intent(MainActivity.this,MostActiveContractsValue_Details.class);
                        startActivity(intent);
                    }
                    if(childPosition==1)
                    {
                        Intent intent=new Intent(MainActivity.this,MostActivityVolume_Details.class);
                        startActivity(intent);
                    }

                }
                if(groupPosition==2)
                {
                    if(childPosition==0)
                    {
                        Intent intent=new Intent(MainActivity.this,TopGainers.class);
                        startActivity(intent);
                    }
                    if(childPosition==1)
                    {
                        Intent intent=new Intent(MainActivity.this,Top_Losers.class);
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
                    Intent intent=new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);

                }
                if(groupPosition==3)
                {
                    Intent intent=new Intent(MainActivity.this,GraphActivity.class);
                    startActivity(intent);
                }
                if(groupPosition==4)
                {
                    Intent intent=new Intent(MainActivity.this,BhavCopy_Details.class);
                    startActivity(intent);
                }
                if(groupPosition==5)
                {
                    Intent intent=new Intent(MainActivity.this,Scriptdet_Details.class);
                    startActivity(intent);
                }
                if(groupPosition==6)
                {
                    Intent intent=new Intent(MainActivity.this,AboutUs.class);
                    startActivity(intent);
                }
                if(groupPosition==7)
                {
                    Intent intent=new Intent(MainActivity.this,ContactUs.class);
                    startActivity(intent);
                }

                return false;
            }
        });

//        NavListViewAdapter navAdapter=new NavListViewAdapter(this);
//        mDrawerList.setAdapter(navAdapter);
//
//        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position)
//                {
//                    case 0:
//                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                        startActivity(intent);
//                        break;
//                    case 1:
//                        Intent intent1 = new Intent(MainActivity.this, MostActiveContractsValue_Details.class);
//                        startActivity(intent1);
//                        break;
//                    case 2:
//                        Intent intent2 = new Intent(MainActivity.this, MostActivityVolume_Details.class);
//                        startActivity(intent2);
//                        break;
//                    case 3:
//                        Intent intent3 = new Intent(MainActivity.this, TopGainers.class);
//                        startActivity(intent3);
//                        break;
//                    case 4:
//                        Intent intent4 = new Intent(MainActivity.this, Top_Losers.class);
//                        startActivity(intent4);
//                        break;
//                    case 5:
//                        Intent intent5 = new Intent(MainActivity.this, GraphActivity.class);
//                        startActivity(intent5);
//                        break;
//                    case 6:
//                        Intent intent6 = new Intent(MainActivity.this, BhavCopy_Details.class);
//                        startActivity(intent6);
//                        break;
//                    case 7:
//                        Intent intent7 = new Intent(MainActivity.this, Scriptdet_Details.class);
//                        startActivity(intent7);
//                        break;
//                    case 8:
//                        Intent intent8 = new Intent(MainActivity.this, AboutUs.class);
//                        startActivity(intent8);
//                        break;
//                    case 9:
//                        Intent intent9 = new Intent(MainActivity.this, ContactUs.class);
//                        startActivity(intent9);
//                        break;
////                    default:
////                        Intent intent10 = new Intent(MainActivity.this, MainActivity.class);
////                        startActivity(intent10);
//
//
//                }
//            }
//        });
//
//
////        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
////        navigationView.setNavigationItemSelectedListener(this);

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

//    @Override
//    public void onBackPressed() {
////        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
////        if (drawer.isDrawerOpen(GravityCompat.START)) {
////            drawer.closeDrawer(GravityCompat.START);
////        } else {
////            super.onBackPressed();
////        }
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

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




    // On Click view to MarketWatch full Details

//       public void OnClickBarChart(View line){
//        if (line.getId() == R.id.BarChart) {
//            Intent intent = new Intent(MainActivity.this, SampleDynamicGraph.class);
//            startActivity(intent);
//        }
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
//          int id = item.getItemId();
//
//        if (id == R.id.MarketWatch) {
//
//            Intent intent = new Intent(MainActivity.this, MainActivity.class);
//            startActivity(intent);
//
//        } else if (id == R.id.MACValue) {
//
//            Intent intent = new Intent(MainActivity.this, MostActiveContractsValue_Details.class);
//            startActivity(intent);
//
//        } else if (id == R.id.MACVolume) {
//
//            Intent intent = new Intent(MainActivity.this, MostActivityVolume_Details.class);
//            startActivity(intent);
//
//        } else if (id == R.id.TopGainer) {
//
//            Intent intent = new Intent(MainActivity.this, TopGainers.class);
//            startActivity(intent);
//
//        } else if (id == R.id.TopLoser) {
//
//            Intent intent = new Intent(MainActivity.this, Top_Losers.class);
//            startActivity(intent);
//
//        } else if (id == R.id.Graphs) {
//
//            Intent intent = new Intent(MainActivity.this, LinechartActivity.class);
//            startActivity(intent);
//
//        } else if (id == R.id.BhavCopy){
//
//            Intent intent = new Intent(MainActivity.this, BhavCopy_Details.class);
//            startActivity(intent);
//
//        }else if (id == R.id.Scriptdet){
//
//            Intent intent = new Intent(MainActivity.this, Scriptdet_Details.class);
//            startActivity(intent);
//
//        }else if (id == R.id.Script_mas){
//
//            Intent intent = new Intent(MainActivity.this, Scriptmas_Details.class);
//            startActivity(intent);
//
//        }else if (id == R.id.Aboutus){
//
//            Intent intent = new Intent(MainActivity.this, AboutUs.class);
//            startActivity(intent);
//
//        }else if (id == R.id.ContactUs){
//
//            Intent intent = new Intent(MainActivity.this, ContactUs.class);
//            startActivity(intent);
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void MarketWatch(View item) {
//        if (item.getId() == R.id.MarketWatch) {
//            Intent intent = new Intent(MainActivity.this, MainActivity.class);
//            startActivity(intent);
//        } else {
//            if (item.getId() == R.id.macvalue) {
//                Intent intent = new Intent(MainActivity.this, MostActiveContractsValue_Details.class);
//                startActivity(intent);
//            } else
//            {
//                if (item.getId() == R.id.macvolume) {
//                    Intent intent = new Intent(MainActivity.this, MostActivityVolume_Details.class);
//                    startActivity(intent);
//                } else if (item.getId() == R.id.topgain) {
//                    Intent intent = new Intent(MainActivity.this, TopGainers.class);
//                    startActivity(intent);
//                } else if (item.getId() == R.id.toplose) {
//
//                    Intent intent = new Intent(MainActivity.this, Top_Losers.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.Graphs) {
//
//                    Intent intent = new Intent(MainActivity.this, GraphActivity.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.BhavCopy) {
//
//                    Intent intent = new Intent(MainActivity.this, BhavCopy_Details.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.scriptdet) {
//
//                    Intent intent = new Intent(MainActivity.this, Scriptdet_Details.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.aboutUs) {
//
//                    Intent intent = new Intent(MainActivity.this, AboutUs.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.Contactus) {
//
//                    Intent intent = new Intent(MainActivity.this, ContactUs.class);
//                    startActivity(intent);
//                }
                 if (item.getId() == R.id.homepage) {

                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else if (item.getId() == R.id.imgLogo) {

                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
           // }
       // }
    }

}