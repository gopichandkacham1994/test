package mcxf_androidcom.com.mcx_android.GraphFragment;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import mcxf_androidcom.com.mcx_android.AppController;
import mcxf_androidcom.com.mcx_android.Graph.Table;
import mcxf_androidcom.com.mcx_android.Graph.Table_Adapter;
import mcxf_androidcom.com.mcx_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SilverFragment extends Fragment {
    protected com.github.mikephil.charting.charts.LineChart mChart;
    private static final String TAG=SilverFragment.class.getSimpleName();
    private static final String url = "http://192.168.0.112:8888/graph1.php";
    private static final String url1 ="http://192.168.0.112:8888/graph1highest.php";
    private List<Table> TableGraphlist = new ArrayList<Table>();;
    private ListView listView;
    private Table_Adapter adapter1;
    private float[] ltp1;
    private String[] symbol;
    private int preval=0;
    public SilverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_silver, container, false);
        mChart= (LineChart) v.findViewById(R.id.silver_frag);

        listView= (ListView) v.findViewById(R.id.list_frag_silver);
        adapter1 = new Table_Adapter(getActivity(),TableGraphlist);
        listView.setAdapter(adapter1);


        mChart.setDrawGridBackground(false);
        mChart.setDescription("");
        mChart.setNoDataTextDescription("You need to provide data for the chart.");
        // enable touch gestures
        mChart.setTouchEnabled(true);

        // enable scaling and dragging
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        // if disabled, scaling can be done on x- and y-axis separately
        mChart.setPinchZoom(true);
        mChart.setBackgroundColor(Color.WHITE);
        mChart.animateX(2000);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setTypeface(mTf);
        xAxis.setDrawGridLines(false);
        xAxis.setSpaceBetweenLabels(1);


        YAxis leftAxis = mChart.getAxisLeft();
//        leftAxis.setTypeface(mTf);
        leftAxis.setLabelCount(6, false);
        leftAxis.setEnabled(true);
//        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        // leftAxis.setSpaceTop(10f);
        leftAxis.setAxisMinValue(40500f);
        leftAxis.setAxisMaxValue(44000f);


        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setEnabled(false);


        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        //  l.setForm(Legend.LegendForm.SQUARE);
        l.setForm(Legend.LegendForm.LINE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);

        addData();

        return v;
    }

    private void addData() {
        JsonArrayRequest MarketWatchReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        // float[] Pcp=new float[response.length()];
                        float[] Ltp = new float[response.length()];
                        // float[] pChange=new float[response.length()];
                        // String[] Symbol=new String[response.length()];
                        String[] Time = new String[response.length()];
                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                // Pcp[i] = Float.valueOf(obj.getString("PCP"));
                                Ltp[i] = Float.valueOf(obj.getString("LTP"));
                                //pChange[i]=Float.valueOf(obj.getString("PercentageChange"));
                                //Symbol[i]=obj.getString("Symbol");
                                Time[i] = obj.getString("Time");
                                //String product = obj.getString("Product");
//                                pcp1 = new Double[(int) Float.parseFloat(pcp)];
//                                ltp1 = new Double[Integer.parseInt(ltp)];
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        symbol = new String[Time.length];
                        ArrayList<String> xVals = new ArrayList<String>();
                        for (int j = 0; j < Time.length; j++) {
                            String tt = Time[j].substring(0, 2);
                            int td = Integer.valueOf(tt);

                            if (td == preval) {
                                Log.i(String.valueOf(td), "data1");
                                xVals.add("");
                            } else {

                                preval = td;
                                Log.i(String.valueOf(preval), "data2");
                                Log.i(String.valueOf(td), "data3");
                                xVals.add(Time[j]);
                            }
                        }

                            ltp1 = new float[Ltp.length];
                        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

                        for (int k = 0; k < Ltp.length; k++) {
//
                            // pcp1 = Double.parseDouble(pcp);
                            ltp1[k] = Ltp[k];
                            yVals1.add(new Entry(ltp1[k], k));

//                                    pcp1 = Double.parseDouble(pcp);
                        }
                        // create a dataset and give it a type
                        LineDataSet set1 = new LineDataSet(yVals1, "LTP");
                        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
//                        set1.setColor(ColorTemplate.getHoloBlue());
//                        set1.setCircleColor(Color.WHITE);
//                        set1.setLineWidth(2f);
//                        set1.setCircleRadius(3f);
//                        set1.setFillAlpha(65);
//                        set1.setFillColor(ColorTemplate.getHoloBlue());
//                        set1.setHighLightColor(Color.rgb(244, 117, 117));
//                        set1.setDrawCircleHole(false);
                        set1.enableDashedLine(10f, 5f, 0f);
                        set1.enableDashedHighlightLine(10f, 5f, 0f);
                        set1.setColor(Color.BLACK);
                        set1.setCircleColor(Color.BLACK);
                        set1.setLineWidth(1f);
                        set1.setCircleRadius(3f);
                        set1.setDrawCircleHole(false);
                        set1.setValueTextSize(9f);
                        set1.setDrawValues(false);
                        set1.setDrawFilled(true);


                        if (Utils.getSDKInt() >= 18) {
                            // fill drawable only supported on api level 18 and above
                            Drawable drawable = ContextCompat.getDrawable(getActivity(), R.color.Graph);
                            set1.setFillDrawable(drawable);
                        } else {
                            set1.setFillColor(Color.BLACK);
                        }
//                        ltp1=new float[Ltp.length];
//                        ArrayList<Entry> yVals2 = new ArrayList<Entry>();
//                        for (int k = 0; k < Ltp.length; k++) {
////
//                            //ltp1 = Double.paseDouble(ltp);
//                            ltp1[k]=Ltp[k];
//                            yVals2.add(new Entry( ltp1[k],k));
////                                    ltp1 = Double.parseDouble(ltp);
//                        }
//                        LineDataSet set2 = new LineDataSet(yVals2, "LTP");
//                        set2.setAxisDependency(YAxis.AxisDependency.LEFT);
//                        set2.setColor(Color.RED);
//                        set2.setCircleColor(Color.WHITE);
//                        set2.setLineWidth(2f);
//                        set2.setCircleRadius(3f);
//                        set2.setFillAlpha(65);
//                        set2.setFillColor(Color.RED);
//                        set2.setDrawCircleHole(false);
//                        set2.setHighLightColor(Color.rgb(244, 117, 117));
//
//                        percentChange=new float[pChange.length];
//                        ArrayList<Entry> yVals3=new ArrayList<Entry>();
//                        for(int m=0;m<pChange.length;m++)
//                        {
//                            percentChange[m]=pChange[m];
//                            yVals3.add(new Entry(percentChange[m],m));
//                        }
//                        LineDataSet set3 = new LineDataSet(yVals3, "Percentage Change");
//                        set3.setAxisDependency(YAxis.AxisDependency.RIGHT);
//                        set3.setColor(Color.GREEN);
//                        set3.setCircleColor(Color.WHITE);
//                        set3.setLineWidth(2f);
//                        set3.setCircleRadius(3f);
//                        set3.setFillAlpha(65);
//                        set3.setFillColor(Color.GREEN);
//                        set3.setDrawCircleHole(false);
//                        set3.setHighLightColor(Color.RED);


                        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
                        dataSets.add(set1);
//                        dataSets.add(set2);
//                        dataSets.add(set3);


                        LineData data = new LineData(xVals, dataSets);
                        data.setValueTextSize(10f);
//                                data.setValueTypeface(mTf);
                        mChart.setData(data);
                        mChart.setVisibleXRangeMaximum(20);
                        mChart.invalidate();
                        mChart.setBackgroundColor(Color.WHITE);


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



        JsonArrayRequest graphreq = new JsonArrayRequest(url1,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Table table = new Table();

                                table.setExpiry(obj.getString("Expiry"));
                                table.setPCP(obj.getString("PCP"));
                                table.setLTP(obj.getString("LTP"));
                                table.setPercentagechange(obj.getString("PercentageChange"));
                                table.setTime(obj.getString("Time"));


                                // adding MarketWatch to marketwatch array
                                TableGraphlist.add(table);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }


                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter1.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }
        });

        AppController.getInstance().addToRequestQueue(graphreq);
    }

}
