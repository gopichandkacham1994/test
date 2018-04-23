package mcxf_androidcom.com.mcx_android.Graph;

/**
 * Created by Krishna Karthik on 4/14/2016.
 */
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import mcxf_androidcom.com.mcx_android.AppController;
import mcxf_androidcom.com.mcx_android.R;

public class BarGraphActivity extends FragmentActivity
{
    private static final String url = "http://10.0.2.2/Marketwatchnew.php";
    private LinearLayout lay;
    HorizontalListView listview;
    private double highest;
    private int[] pcpheight;
    private int[] ltpheight;
    private int[] pcpheight1;
    private int[] ltpheight1;
  //  private Double[] pcp= {2023.0000,2023.0000,2173.0000,2174.0000,16200.0000,907.2000,492.0000,126.3000,2298.0000,2301.0000,136.6000,917.4000,494.0000,16320.0000,125.1500,313.6000,313.7000};
  // private Double[] ltp = {2216.00,2215.00,2360.00,2363.00,16490.00,940.10,487.20,127.05,127.00,2476.00,2480.00,132.30,950.00,486.80,16600.00,127.40,319.80,320.10};
    private Double[] pcp1;
    private Double[] ltp1;
    private String[] product = {"CRUDEOIL","CRUDEOILM","CRUDEOIL","CRUDEOILM","COTTON","MENTHAOIL","CPO","LEAD","LEADMINI","CRUDEOIL","CRUDEOILM","NATURALGAS","MENTAHOIL","CPO","COTTON","LEADMINI","COPPERM","COPPER"};


    public void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_bar_graph);
        lay = (LinearLayout)findViewById(R.id.linearlay);
        listview = (HorizontalListView) findViewById(R.id.listview);

        List<Double> b = Arrays.asList(pcp1);
       highest = (Collections.max(b));
        ltpheight= new int[ltp1.length];
        pcpheight= new int[pcp1.length];
        //updateSizeInfo();
        JsonArrayRequest MarketWatchReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                       // String pcpStr,ltpStr;
                         String[] pcpStr =new String[response.length()];
                         String[] ltpStr =new String[response.length()];

                        for (int i = 0; i < response.length(); i++)
                        {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                pcpStr[i]=obj.getString("PCP");
                                ltpStr[i]=obj.getString("LTP");
//                                double d1=Double.parseDouble(pcpStr);
//                                double d2=Double.parseDouble(ltpStr);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                       // Double[] PCP=null;
                        for(int j=0;j<pcpStr.length;j++)
                        {
                         //   PCP=new Double[Integer.parseInt(pcpStr[j])];
                            pcp1=new Double[Integer.parseInt(pcpStr[j])];
                            Log.i("pcpdata", String.valueOf(pcp1));
                        }
                       // Double[] LTP=null;
                        for(int k=0;k<ltpStr.length;k++)
                        {
                           // LTP=new Double[k];
                            ltp1=new Double[Integer.parseInt(ltpStr[k])];
                            Log.i("ltpdata", String.valueOf(ltp1));
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(MarketWatchReq);
    }

    public class bsAdapter extends BaseAdapter
    {
        Activity cntx;
        String[] array;
        public bsAdapter(Activity context,String[] arr)
        {
            // TODO Auto-generated constructor stub
            this.cntx=context;
            this.array = arr;

        }

        public int getCount()
        {
            // TODO Auto-generated method stub
            return array.length;
        }

        public Object getItem(int position)
        {
            // TODO Auto-generated method stub
            return array[position];
        }

        public long getItemId(int position)
        {
            // TODO Auto-generated method stub
            return array.length;
        }

        public View getView(final int position, View convertView, ViewGroup parent)
        {
            View row=null;
            LayoutInflater inflater=cntx.getLayoutInflater();
            row=inflater.inflate(R.layout.simplerow, null);

            DecimalFormat df = new DecimalFormat("#.##");
            final TextView title	=	(TextView)row.findViewById(R.id.title);
            TextView tvcol1	=	(TextView)row.findViewById(R.id.colortext01);
            TextView tvcol2	=	(TextView)row.findViewById(R.id.colortext02);

            TextView gt		=	(TextView)row.findViewById(R.id.text01);
            TextView nt		=	(TextView)row.findViewById(R.id.text02);

            tvcol1.setHeight(pcpheight[position]);
            tvcol2.setHeight(ltpheight[position]);
            title.setText(product[position]);
//
//            gt.setText(df.format(pcp[position]/100)+" k");
//            nt.setText(df.format(ltp[position]/100)+" k");
//            gt.setText(df.format(pcp[position]+"k"));
//            nt.setText(df.format(ltp[position]+"k"));

//            tvcol1.setOnClickListener(new OnClickListener() {
//
//                public void onClick(View v) {
//                    Toast.makeText(BarGraphActivity.this, "Month/Year: "+title.getText().toString()+"\nGross Sal: "+pcp[position], Toast.LENGTH_SHORT).show();
//                }
//            });
//
//            tvcol2.setOnClickListener(new OnClickListener() {
//
//                public void onClick(View v) {
//                    Toast.makeText(BarGraphActivity.this, "Month/Year: "+title.getText().toString()+"\nNet Sal: "+ltp[position], Toast.LENGTH_SHORT).show();
//                }
//            });

            return row;
        }
    }
//
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
        updateSizeInfo();
    }
    private void updateSizeInfo() {

        /** This is onWindowFocusChanged method is used to allow the chart to
         * update the chart according to the orientation.
         * Here h is the integer value which can be updated with the orientation
         */
        int h;
        if(getResources().getConfiguration().orientation == 1)
        {
            h = (int) (lay.getHeight()*0.3);
            if(h == 0)
            {
                h = 60;
            }
        }
        else
        {
            h = (int) (lay.getHeight()*0.2);
            if(h == 0)
            {
                h = 40;
            }
        }
        for(int i=0;i<pcp1.length;i++)
        {
            ltpheight[i] = (int)((h*ltp1[i])/highest);
            pcpheight[i] = (int)((h*pcp1[i])/highest);
            System.out.println("ltp width[i] "+ltpheight[i]+"pcp width[i] "+pcpheight[i]);
        }
        listview.setAdapter(new bsAdapter(this,product));
    }

}