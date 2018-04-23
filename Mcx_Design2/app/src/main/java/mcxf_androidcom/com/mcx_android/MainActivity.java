package mcxf_androidcom.com.mcx_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


import mcxf_androidcom.com.mcx_android.BhavCopy.BhavCopy_Details;
import mcxf_androidcom.com.mcx_android.Graph.BarGraphActivity;
import mcxf_androidcom.com.mcx_android.Graph.SampleDynamicGraph;
import mcxf_androidcom.com.mcx_android.GraphFragment.GraphActivity;
import mcxf_androidcom.com.mcx_android.MarketWatch.MarketWatch_Details;
import mcxf_androidcom.com.mcx_android.Top_Gainers.TopGainers;
import mcxf_androidcom.com.mcx_android.Top_Losers.Top_Losers;
import mcxf_androidcom.com.mcx_android.MostActiveContractVolume.MostActivityVolume_Details;
import mcxf_androidcom.com.mcx_android.MostActiveContractsValue.MostActiveContractsValue_Details;
import mcxf_androidcom.com.mcx_android.ScriptDet.Scriptdet_Details;
import mcxf_androidcom.com.mcx_android.ScriptMas.Scriptmas_Details;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        int id = item.getItemId();

        if (id == R.id.Graphs) {

            Intent intent = new Intent(MainActivity.this, GraphActivity.class);
            startActivity(intent);

        } else if (id == R.id.MarketWatch) {

            Intent intent = new Intent(MainActivity.this, MarketWatch_Details.class);
            startActivity(intent);

        } else if (id == R.id.MACValue) {

            Intent intent = new Intent(MainActivity.this, MostActiveContractsValue_Details.class);
            startActivity(intent);

        } else if (id == R.id.MACVolume) {

            Intent intent = new Intent(MainActivity.this, MostActivityVolume_Details.class);
            startActivity(intent);

        } else if (id == R.id.TopGainer) {

            Intent intent = new Intent(MainActivity.this, TopGainers.class);
            startActivity(intent);

        } else if (id == R.id.TopLoser) {

            Intent intent = new Intent(MainActivity.this, Top_Losers.class);
            startActivity(intent);

        }else if (id == R.id.BhavCopy){

            Intent intent = new Intent(MainActivity.this, BhavCopy_Details.class);
            startActivity(intent);

        }else if (id == R.id.Scriptdet){

            Intent intent = new Intent(MainActivity.this, Scriptdet_Details.class);
            startActivity(intent);

        }else if (id == R.id.Scriptmas){

            Intent intent = new Intent(MainActivity.this, Scriptmas_Details.class);
            startActivity(intent);

        }else if (id == R.id.Aboutus){

            Intent intent = new Intent(MainActivity.this, AboutUs.class);
            startActivity(intent);

        }else if (id == R.id.ContactUs){

            Intent intent = new Intent(MainActivity.this, ContactUs.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}