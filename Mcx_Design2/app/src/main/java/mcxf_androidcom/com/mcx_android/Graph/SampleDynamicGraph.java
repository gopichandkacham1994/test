package mcxf_androidcom.com.mcx_android.Graph;

import android.graphics.Color;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import mcxf_androidcom.com.mcx_android.AppController;
import mcxf_androidcom.com.mcx_android.MarketWatch.MarketWatch;
import mcxf_androidcom.com.mcx_android.R;

public class SampleDynamicGraph extends AppCompatActivity {

    protected BarChart mChart;
    private static final String TAG = SampleDynamicGraph.class.getSimpleName();

    // MarketWatch json url
    private static final String url = "http://10.0.2.2/Marketwatchnew.php";
  //  private List<Double> bardata = new ArrayList<Double>();
    //private List<MarketWatch> MarketWatchlist = new ArrayList<MarketWatch>();
  //  private String[] product = {"CRUDEOIL", "CRUDEOILM", "CRUDEOIL", "CRUDEOILM", "COTTON", "MENTHAOIL", "CPO", "LEAD", "LEADMINI", "CRUDEOIL", "CRUDEOILM", "NATURALGAS", "MENTAHOIL", "CPO", "COTTON", "LEADMINI", "COPPERM", "COPPER"};
    private float[] pcp1;
    private float[] ltp1;
    private String[] product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sample_dynamic_graph);


        mChart = (BarChart) findViewById(R.id.chart1);

        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);

        mChart.setDescription("");
        mChart.animateXY(2000,2000);


        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mChart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);

        mChart.setDrawGridBackground(false);
        // mChart.setDrawYLabels(false);
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setTypeface(mTf);
        xAxis.setDrawGridLines(false);
        xAxis.setSpaceBetweenLabels(2);

//        YAxisValueFormatter custom = new MyYAxisValueFormatter();

        YAxis leftAxis = mChart.getAxisLeft();
//        leftAxis.setTypeface(mTf);
        leftAxis.setLabelCount(8, false);
//        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
//        rightAxis.setTypeface(mTf);
        rightAxis.setLabelCount(8, false);
//        rightAxis.setValueFormatter(custom);
        rightAxis.setSpaceTop(15f);
        rightAxis.setEnabled(false);
        rightAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);
        // l.setExtra(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
        // "def", "ghj", "ikl", "mno" });
        // l.setCustom(ColorTemplate.VORDIPLOM_COLORS, new String[] { "abc",
        // "def", "ghj", "ikl", "mno" });

        addData();


    }

    private void addData() {
        JsonArrayRequest MarketWatchReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                            float[] Pcp=new float[response.length()];
                            float[] Ltp=new float[response.length()];
                            String[] Product=new String[response.length()];
                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                 Pcp[i] = Float.valueOf(obj.getString("PCP"));
                                 Ltp[i] = Float.valueOf(obj.getString("LTP"));
                                Product[i]=obj.getString("Product");
                                //String product = obj.getString("Product");
//                                pcp1 = new Double[(int) Float.parseFloat(pcp)];
//                                ltp1 = new Double[Integer.parseInt(ltp)];
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                                product=new String[Product.length];
                                ArrayList<String> xVals = new ArrayList<String>();
                                for (int j = 0; j < Product.length ;j++) {

                                    xVals.add(Product[j]);
                                }
                        pcp1=new float[Pcp.length];
                        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

                                for (int k = 0; k < Pcp.length; k++) {
//
                                  // pcp1 = Double.parseDouble(pcp);
                                    pcp1[k] = Pcp[k];
                                    yVals1.add(new BarEntry(pcp1[k],k));

//                                    pcp1 = Double.parseDouble(pcp);
                                }

                            ltp1=new float[Ltp.length];
                                ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();
                                for (int k = 0; k < Ltp.length; k++) {
//
                                    //ltp1 = Double.parseDouble(ltp);
                                    ltp1[k]=Ltp[k];
                                    yVals2.add(new BarEntry( ltp1[k],k));
//                                    ltp1 = Double.parseDouble(ltp);
                                }

                                BarDataSet set1 = new BarDataSet(yVals1, "PCP");
                                set1.setColor(Color.RED);
                                set1.setBarSpacePercent(35f);

                                BarDataSet set2 = new BarDataSet(yVals2, "LTP");
                                set2.setColor(Color.BLUE);
                                set2.setBarSpacePercent(35f);

                                ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
                                dataSets.add(set1);
                                dataSets.add(set2);


                                BarData data = new BarData(xVals, dataSets);
                                data.setValueTextSize(10f);
//                                data.setValueTypeface(mTf);
                                data.setGroupSpace(80f);
                                mChart.setData(data);
                                mChart.setVisibleXRangeMaximum(8);
                                mChart.invalidate();





                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }
        });


        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(MarketWatchReq);
    }

    }



