//package mcxf_androidcom.com.mcx_android.Graph;
//
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.graphics.drawable.Drawable;
//import android.support.design.widget.NavigationView;
//import android.support.v4.content.ContextCompat;
//import android.support.v4.view.GravityCompat;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.Spinner;
//import android.widget.TextView;
//
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.VolleyLog;
//import com.android.volley.toolbox.JsonArrayRequest;
//import com.github.mikephil.charting.charts.BarChart;
//import com.github.mikephil.charting.components.Legend;
//import com.github.mikephil.charting.components.LimitLine;
//import com.github.mikephil.charting.components.XAxis;
//import com.github.mikephil.charting.components.YAxis;
//import com.github.mikephil.charting.data.BarData;
//import com.github.mikephil.charting.data.BarDataSet;
//import com.github.mikephil.charting.data.BarEntry;
//import com.github.mikephil.charting.data.Entry;
//import com.github.mikephil.charting.data.LineData;
//import com.github.mikephil.charting.data.LineDataSet;
//import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
//import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
//import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
//import com.github.mikephil.charting.renderer.YAxisRenderer;
//import com.github.mikephil.charting.utils.ColorTemplate;
//import com.github.mikephil.charting.utils.Utils;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import mcxf_androidcom.com.mcx_android.AboutUs;
//import mcxf_androidcom.com.mcx_android.AppController;
//import mcxf_androidcom.com.mcx_android.BhavCopy.BhavCopy_Details;
//import mcxf_androidcom.com.mcx_android.ContactUs;
//import mcxf_androidcom.com.mcx_android.MainMarketWatch.MainActivity;
//import mcxf_androidcom.com.mcx_android.MostActiveContractVolume.MostActivityVolume_Details;
//import mcxf_androidcom.com.mcx_android.MostActiveContractsValue.MostActiveContractsValue_Details;
//import mcxf_androidcom.com.mcx_android.R;
//import mcxf_androidcom.com.mcx_android.ScriptDet.Scriptdet_Details;
//import mcxf_androidcom.com.mcx_android.Top_Gainers.TopGainers;
//import mcxf_androidcom.com.mcx_android.Top_Losers.Top_Losers;
//
//
//public class LineChart1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//
//    Spinner spinner;
//    ArrayAdapter<CharSequence> adapter;
//    protected com.github.mikephil.charting.charts.LineChart mChart;
//    private static final String TAG = LinechartActivity.class.getSimpleName();
//    private static final String url = "http://10.0.2.2/graph1.php";
//    private static final String url1 ="http://10.0.2.2/graphhighest.php";
//
//    private ProgressDialog pDialog;
//    private List<Table> TableGraphlist = new ArrayList<Table>();;
//    private ListView listView;
//    private Table_Adapter adapter1;
//
//    //  private float[] pcp1;
//    private float[] ltp1;
//    //private float[] percentChange;
//    private String[] symbol;
//    private String[] Time;
//    String[] spinneritems = {"Silver","Gold"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        requestWindowFeature(Window.FEATURE_NO_TITLE);
////        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
////                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        setContentView(R.layout.activity_line_chart1);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        listView = (ListView) findViewById(R.id.listgraph);
////        ViewGroup headerView = (ViewGroup)getLayoutInflater().inflate(R.layout.header_table, listView,false);
////        listView.addHeaderView(headerView);
//        adapter1 = new Table_Adapter(this,TableGraphlist);
//        listView.setAdapter(adapter1);
//
//
//        spinner = (Spinner) findViewById(R.id.spinner);
//        spinner.setAdapter(new MyCustomerAdapter(LineChart1.this,R.layout.spinner_item,spinneritems));
////        adapter = ArrayAdapter.createFromResource(this,R.array.Graphs,android.R.layout.simple_spinner_item);
////        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
////        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 1) {
//                    Intent intent = new Intent(LineChart1.this, LinechartActivity.class);
//                    startActivity(intent);
//                }
////
//            }
//
//            @Override public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        mChart= (com.github.mikephil.charting.charts.LineChart) findViewById(R.id.linechart);
//        //  mChart.setOnChartGestureListener(this);
//        // mChart.setOnChartValueSelectedListener(this);
//        mChart.setDrawGridBackground(false);
//        mChart.setDescription("");
//        mChart.setNoDataTextDescription("You need to provide data for the chart.");
//        // enable touch gestures
//        mChart.setTouchEnabled(true);
//
//        // enable scaling and dragging
//        mChart.setDragEnabled(true);
//        mChart.setScaleEnabled(true);
//        // if disabled, scaling can be done on x- and y-axis separately
//        mChart.setPinchZoom(true);
//        mChart.setBackgroundColor(Color.WHITE);
//        mChart.animateX(2000);
//
//        XAxis xAxis = mChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
////        xAxis.setTypeface(mTf);
//        xAxis.setDrawGridLines(false);
//        xAxis.setSpaceBetweenLabels(4);
//
//
//        YAxis leftAxis = mChart.getAxisLeft();
////        leftAxis.setTypeface(mTf);
//        leftAxis.setLabelCount(6, false);
//        leftAxis.setEnabled(true);
////        leftAxis.setValueFormatter(custom);
//        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
//        // leftAxis.setSpaceTop(10f);
//        leftAxis.setAxisMinValue(41000f);
//        leftAxis.setAxisMaxValue(44000f);
//        // this replaces setStartAtZero(true)
//
//
//
////        YAxis leftAxis1 = mChart.getAxisLeft();
//////        leftAxis.setTypeface(mTf);
////        leftAxis1.setLabelCount(8, false);
//////        leftAxis.setValueFormatter(custom);
////        leftAxis1.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
////        leftAxis1.setSpaceTop(15f);
////        leftAxis1.setEnabled(true);
////        // leftAxis1.setAxisMaxValue(4f);
////        leftAxis1.setAxisMinValue(-2f); //
//
//
//
//        YAxis rightAxis = mChart.getAxisRight();
//        rightAxis.setEnabled(false);
////        rightAxis.setDrawGridLines(false);
////
//////        rightAxis.setTypeface(mTf);
////        rightAxis.setLabelCount(8, false);
////        rightAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
//////        rightAxis.setValueFormatter(custom);
////        rightAxis.setSpaceTop(15f);
////        rightAxis.setEnabled(true);
////        rightAxis.setAxisMinValue(-2f); // this replaces setStartAtZero(true)
//
//
//        Legend l = mChart.getLegend();
//        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
//        //  l.setForm(Legend.LegendForm.SQUARE);
//        l.setForm(Legend.LegendForm.LINE);
//        l.setFormSize(9f);
//        l.setTextSize(11f);
//        l.setXEntrySpace(4f);
//
//        addData();
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout11);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//    }
//
//    public class MyCustomerAdapter extends ArrayAdapter<String> {
//
//
//        public MyCustomerAdapter(Context context, int resource, String[] objects) {
//            super(context, resource, objects);
//
//        }
//
//        @Override
//        public View getDropDownView(int position, View convertView, ViewGroup parent) {
//            return getCustomView(position, convertView, parent);
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            return getCustomView(position, convertView, parent);
//        }
//
//        public View getCustomView(int position, View convertView, ViewGroup parent) {
//
//            LayoutInflater inflater = getLayoutInflater();
//            View row = inflater.inflate(R.layout.spinner_item, parent, false);
//            TextView gold = (TextView) row.findViewById(R.id.gold1);
//            gold.setText(spinneritems[position]);
//            if (position == 0) {
//                gold.setTextColor(Color.WHITE);
//            }
//            return row;
//        }
//    }
//
//        private void addData() {
//            JsonArrayRequest MarketWatchReq = new JsonArrayRequest(url,
//                    new Response.Listener<JSONArray>() {
//                        @Override
//                        public void onResponse(JSONArray response) {
//                            Log.d(TAG, response.toString());
//
//                            // float[] Pcp=new float[response.length()];
//                            float[] Ltp = new float[response.length()];
//                            // float[] pChange=new float[response.length()];
//                            //String[] Symbol=new String[response.length()];
//                            String[] Time = new String[response.length()];
//                            // Parsing json
//                            for (int i = 0; i < response.length(); i++) {
//                                try {
//
//                                    JSONObject obj = response.getJSONObject(i);
//                                    // Pcp[i] = Float.valueOf(obj.getString("PCP"));
//                                    Ltp[i] = Float.valueOf(obj.getString("LTP"));
//                                    //pChange[i]=Float.valueOf(obj.getString("PercentageChange"));
//                                    // Symbol[i]=obj.getString("Symbol");
//                                    Time[i] = obj.getString("Time");
//                                    //String product = obj.getString("Product");
////                                pcp1 = new Double[(int) Float.parseFloat(pcp)];
////                                ltp1 = new Double[Integer.parseInt(ltp)];
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//
//                            }
//                            // symbol=new String[Symbol.length];
//                            symbol = new String[Time.length];
//                            ArrayList<String> xVals = new ArrayList<String>();
//                            for (int j = 0; j < Time.length; j++) {
//
//                                xVals.add(Time[j]);
//                            }
//                            ltp1 = new float[Ltp.length];
//                            ArrayList<Entry> yVals1 = new ArrayList<Entry>();
//
//                            for (int k = 0; k < Ltp.length; k++) {
////
//                                // pcp1 = Double.parseDouble(pcp);
//                                ltp1[k] = Ltp[k];
//                                yVals1.add(new Entry(ltp1[k], k));
//
////                                    pcp1 = Double.parseDouble(pcp);
//                            }
//                            // create a dataset and give it a type
//                            LineDataSet set1 = new LineDataSet(yVals1, "LTP");
//                            set1.setAxisDependency(YAxis.AxisDependency.LEFT);
////                        set1.setColor(ColorTemplate.getHoloBlue());
////                        set1.setCircleColor(Color.WHITE);
////                        set1.setLineWidth(2f);
////                        set1.setCircleRadius(3f);
////                        set1.setFillAlpha(65);
////                        set1.setFillColor(ColorTemplate.getHoloBlue());
////                        set1.setHighLightColor(Color.rgb(244, 117, 117));
////                        set1.setDrawCircleHole(false);
//                            set1.enableDashedLine(10f, 5f, 0f);
//                            set1.enableDashedHighlightLine(10f, 5f, 0f);
//                            set1.setColor(Color.BLACK);
//                            set1.setCircleColor(Color.BLACK);
//                            set1.setLineWidth(1f);
//                            set1.setCircleRadius(3f);
//                            set1.setDrawCircleHole(false);
//                            set1.setValueTextSize(9f);
//                            set1.setDrawFilled(true);
//
//                            if(Utils.getSDKInt() >= 18) {
//                                // fill drawable only supported on api level 18 and above
//                                Drawable drawable = ContextCompat.getDrawable(LineChart1.this, R.color.Graph);
//                                set1.setFillDrawable(drawable);
//                            } else {
//                                set1.setFillColor(Color.BLACK);
//                            }
//
////                        ltp1=new float[Ltp.length];
////                        ArrayList<Entry> yVals2 = new ArrayList<Entry>();
////                        for (int k = 0; k < Ltp.length; k++) {
//////
////                            //ltp1 = Double.paseDouble(ltp);
////                            ltp1[k]=Ltp[k];
////                            yVals2.add(new Entry( ltp1[k],k));
//////                                    ltp1 = Double.parseDouble(ltp);
////                        }
////                        LineDataSet set2 = new LineDataSet(yVals2, "LTP");
////                        set2.setAxisDependency(YAxis.AxisDependency.LEFT);
////                        set2.setColor(Color.RED);
////                        set2.setCircleColor(Color.WHITE);
////                        set2.setLineWidth(2f);
////                        set2.setCircleRadius(3f);
////                        set2.setFillAlpha(65);
////                        set2.setFillColor(Color.RED);
////                        set2.setDrawCircleHole(false);
////                        set2.setHighLightColor(Color.rgb(244, 117, 117));
////
////                        percentChange=new float[pChange.length];
////                        ArrayList<Entry> yVals3=new ArrayList<Entry>();
////                        for(int m=0;m<pChange.length;m++)
////                        {
////                            percentChange[m]=pChange[m];
////                            yVals3.add(new Entry(percentChange[m],m));
////                        }
////                        LineDataSet set3 = new LineDataSet(yVals3, "Percentage Change");
////                        set3.setAxisDependency(YAxis.AxisDependency.RIGHT);
////                        set3.setColor(Color.GREEN);
////                        set3.setCircleColor(Color.WHITE);
////                        set3.setLineWidth(2f);
////                        set3.setCircleRadius(3f);
////                        set3.setFillAlpha(65);
////                        set3.setFillColor(Color.GREEN);
////                        set3.setDrawCircleHole(false);
////                        set3.setHighLightColor(Color.RED);
//
//
//                            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
//                            dataSets.add(set1);
////                        dataSets.add(set2);
////                        dataSets.add(set3);
//
//
//                            LineData data = new LineData(xVals, dataSets);
//                            data.setValueTextSize(10f);
////                                data.setValueTypeface(mTf);
//                            mChart.setData(data);
//                            mChart.setVisibleXRangeMaximum(4);
//                            mChart.invalidate();
//                            mChart.setBackgroundColor(getColor(R.color.graph));
//
//
//                            // notifying list adapter about data changes
//                            // so that it renders the list view with updated data
//
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    VolleyLog.d(TAG, "Error: " + error.getMessage());
//
//                }
//            });
//
//
//            // Adding request to request queue
//            AppController.getInstance().addToRequestQueue(MarketWatchReq);
//
//            JsonArrayRequest graphreq = new JsonArrayRequest(url1,
//                    new Response.Listener<JSONArray>() {
//                        @Override
//                        public void onResponse(JSONArray response) {
//                            Log.d(TAG, response.toString());
//                            for (int i = 0; i < response.length(); i++) {
//                                try {
//
//                                    JSONObject obj = response.getJSONObject(i);
//                                    Table table = new Table();
//
//                                    table.setExpiry(obj.getString("Expiry"));
//                                    table.setPCP(obj.getString("PCP"));
//                                    table.setLTP(obj.getString("LTP"));
//                                    table.setPercentagechange(obj.getString("PercentageChange"));
//                                    table.setTime(obj.getString("Time"));
//
//
//                                    // adding MarketWatch to marketwatch array
//                                    TableGraphlist.add(table);
//
//
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//
//                            }
//
//
//                            // notifying list adapter about data changes
//                            // so that it renders the list view with updated data
//                            adapter1.notifyDataSetChanged();
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    VolleyLog.d(TAG, "Error: " + error.getMessage());
//
//                }
//            });
//
//            AppController.getInstance().addToRequestQueue(graphreq);
//        }
//
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout11);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
//
//    public void MarketWatch(View item) {
//        if (item.getId() == R.id.MarketWatch) {
//            Intent intent = new Intent(LineChart1.this, MainActivity.class);
//            startActivity(intent);
//        } else {
//            if (item.getId() == R.id.macvalue) {
//                Intent intent = new Intent(LineChart1.this, MostActiveContractsValue_Details.class);
//                startActivity(intent);
//            } else {
//                if (item.getId() == R.id.macvolume) {
//                    Intent intent = new Intent(LineChart1.this, MostActivityVolume_Details.class);
//                    startActivity(intent);
//                } else if (item.getId() == R.id.topgain) {
//                    Intent intent = new Intent(LineChart1.this, TopGainers.class);
//                    startActivity(intent);
//                } else if (item.getId() == R.id.toplose) {
//
//                    Intent intent = new Intent(LineChart1.this, Top_Losers.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.Graphs) {
//
//                    Intent intent = new Intent(LineChart1.this, LinechartActivity.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.BhavCopy) {
//
//                    Intent intent = new Intent(LineChart1.this, BhavCopy_Details.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.scriptdet) {
//
//                    Intent intent = new Intent(LineChart1.this, Scriptdet_Details.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.aboutUs) {
//
//                    Intent intent = new Intent(LineChart1.this, AboutUs.class);
//                    startActivity(intent);
//
//                } else if (item.getId() == R.id.Contactus) {
//
//                    Intent intent = new Intent(LineChart1.this, ContactUs.class);
//                    startActivity(intent);
//                }
//                else if (item.getId() == R.id.homepage) {
//
//                    Intent intent = new Intent(LineChart1.this, MainActivity.class);
//                    startActivity(intent);
//                }
//                else if (item.getId() == R.id.imgLogo) {
//
//                    Intent intent = new Intent(LineChart1.this, MainActivity.class);
//                    startActivity(intent);
//                }
//            }
//        }
//    }
//
//}
//
//
