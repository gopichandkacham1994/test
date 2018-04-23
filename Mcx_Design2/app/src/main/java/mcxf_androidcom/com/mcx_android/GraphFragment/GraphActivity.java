package mcxf_androidcom.com.mcx_android.GraphFragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import mcxf_androidcom.com.mcx_android.AboutUs;
import mcxf_androidcom.com.mcx_android.BhavCopy.BhavCopy_Details;
import mcxf_androidcom.com.mcx_android.ChildItems;
import mcxf_androidcom.com.mcx_android.ContactUs;
import mcxf_androidcom.com.mcx_android.ExpandListAdapter;
import mcxf_androidcom.com.mcx_android.GroupItems;
import mcxf_androidcom.com.mcx_android.MainMarketWatch.MainActivity;
import mcxf_androidcom.com.mcx_android.MostActiveContractVolume.MostActivityVolume_Details;
import mcxf_androidcom.com.mcx_android.MostActiveContractsValue.MostActiveContractsValue_Details;
import mcxf_androidcom.com.mcx_android.R;
import mcxf_androidcom.com.mcx_android.ScriptDet.Scriptdet_Details;
import mcxf_androidcom.com.mcx_android.Top_Gainers.TopGainers;
import mcxf_androidcom.com.mcx_android.Top_Losers.Top_Losers;

public class GraphActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
protected Spinner spin;

    private  DrawerLayout drawer;
    private  ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private ExpandableListView mDrawerList;
    private ExpandListAdapter ExpAdapter;
    private ArrayList<GroupItems> ExpListItems;
    ArrayList<GroupItems> group_list;
    ArrayList<ChildItems> child_list;


    //ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar!=null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
        }



         drawer = (DrawerLayout) findViewById(R.id.drawer_layout10);
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
        ExpAdapter=new ExpandListAdapter(GraphActivity.this,ExpListItems);
        mDrawerList.setAdapter(ExpAdapter);

        mDrawerList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if(groupPosition==1)
                {
                    if(childPosition==0)
                    {
                        Intent intent=new Intent(GraphActivity.this,MostActiveContractsValue_Details.class);
                        startActivity(intent);
                    }
                    if(childPosition==1)
                    {
                        Intent intent=new Intent(GraphActivity.this,MostActivityVolume_Details.class);
                        startActivity(intent);
                    }

                }
                if(groupPosition==2)
                {
                    if(childPosition==0)
                    {
                        Intent intent=new Intent(GraphActivity.this,TopGainers.class);
                        startActivity(intent);
                    }
                    if(childPosition==1)
                    {
                        Intent intent=new Intent(GraphActivity.this,Top_Losers.class);
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
                    Intent intent=new Intent(GraphActivity.this,MainActivity.class);
                    startActivity(intent);

                }
                if(groupPosition==3)
                {
                    Intent intent=new Intent(GraphActivity.this,GraphActivity.class);
                    startActivity(intent);
                }
                if(groupPosition==4)
                {
                    Intent intent=new Intent(GraphActivity.this,BhavCopy_Details.class);
                    startActivity(intent);
                }
                if(groupPosition==5)
                {
                    Intent intent=new Intent(GraphActivity.this,Scriptdet_Details.class);
                    startActivity(intent);
                }
                if(groupPosition==6)
                {
                    Intent intent=new Intent(GraphActivity.this,AboutUs.class);
                    startActivity(intent);
                }
                if(groupPosition==7)
                {
                    Intent intent=new Intent(GraphActivity.this,ContactUs.class);
                    startActivity(intent);
                }

                return false;
            }
        });





//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

       // TextView textView= (TextView) findViewById(R.id.items);

      spin= (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(GraphActivity.this,
                R.array.Graphs, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        Fragment fragment=new GoldFragment();
                        FragmentTransaction transaction=getFragmentManager().beginTransaction().replace(R.id.frag_container,new GoldFragment());
                        transaction.commit();
                        break;
                    case 1:
                        Fragment fragment1=new SilverFragment();
                        FragmentTransaction transaction1=getFragmentManager().beginTransaction().replace(R.id.frag_container,new SilverFragment());
                        transaction1.commit();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(GraphActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void MarketWatch(View item) {
//        if (item.getId() == R.id.MarketWatch) {
//            Intent intent = new Intent(GraphActivity.this, MainActivity.class);
//            startActivity(intent);
//        } else {
//            if (item.getId() == R.id.macvalue) {
//                Intent intent = new Intent(GraphActivity.this, MostActiveContractsValue_Details.class);
//                startActivity(intent);
//            } else {
//                if (item.getId() == R.id.macvolume) {
//                    Intent intent = new Intent(GraphActivity.this, MostActivityVolume_Details.class);
//                    startActivity(intent);
//                } else if (item.getId() == R.id.topgain) {
//                    Intent intent = new Intent(GraphActivity.this, TopGainers.class);
//                    startActivity(intent);
//                } else if (item.getId() == R.id.toplose) {
//
//                    Intent intent = new Intent(GraphActivity.this, Top_Losers.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.Graphs) {
//
//                    Intent intent = new Intent(GraphActivity.this,GraphActivity.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.BhavCopy) {
//
//                    Intent intent = new Intent(GraphActivity.this, BhavCopy_Details.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.scriptdet) {
//
//                    Intent intent = new Intent(GraphActivity.this, Scriptdet_Details.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.aboutUs) {
//
//                    Intent intent = new Intent(GraphActivity.this, AboutUs.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.Contactus) {
//
//                    Intent intent = new Intent(GraphActivity.this, ContactUs.class);
//                    startActivity(intent);
//                }
                 if (item.getId() == R.id.homepage) {

                    Intent intent = new Intent(GraphActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                 if (item.getId() == R.id.imgLogo) {

                    Intent intent = new Intent(GraphActivity.this, MainActivity.class);
                    startActivity(intent);
                }
          //  }
        //}
    }

}
