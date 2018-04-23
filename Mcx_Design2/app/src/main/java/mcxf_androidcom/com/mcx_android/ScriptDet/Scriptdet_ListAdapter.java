package mcxf_androidcom.com.mcx_android.ScriptDet;

/**
 * Created by Krishna Karthik on 3/22/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

import mcxf_androidcom.com.mcx_android.R;

public class Scriptdet_ListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Scriptdet> ScriptdetItems;


    public  Scriptdet_ListAdapter(Activity activity, List<Scriptdet>ScriptdetItems) {
        this.activity = activity;
        this.ScriptdetItems =ScriptdetItems;

    }



    @Override
    public int getCount() {
        return ScriptdetItems.size();
    }

    @Override
    public Object getItem(int location) {
        return ScriptdetItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_scriptdet, null);

        if((position % 2 == 0)) {

           // convertView.setBackgroundColor(Color.rgb(110, 181, 192));
            convertView.setBackgroundColor(Color.rgb(250,250,250));

        }
        else{
            //convertView.setBackgroundColor(Color.rgb(226,232,228));
            convertView.setBackgroundColor(Color.rgb(234, 234, 234));
        }

        TextView product = (TextView) convertView.findViewById(R.id.Product);
        TextView expiry = (TextView) convertView.findViewById(R.id.Expiry);
        TextView ticksize = (TextView) convertView.findViewById(R.id.Tick_Size1);
        TextView unitoftrading = (TextView) convertView.findViewById(R.id.Trading_Unit1);
        TextView deliveryunit = (TextView) convertView.findViewById(R.id.DeliveryUnit1);
        TextView deliverycenter = (TextView) convertView.findViewById(R.id.Deliverycenter1);

//        TextView open = (TextView) convertView.findViewById(R.id.Open);
//        TextView high = (TextView) convertView.findViewById(R.id.High);
//        TextView low = (TextView) convertView.findViewById(R.id.Low);
//        TextView close = (TextView) convertView.findViewById(R.id.Close);
//        TextView value = (TextView) convertView.findViewById(R.id.Value);
//        TextView changeinOI = (TextView) convertView.findViewById(R.id.ChangeInOI);
//        TextView percentagechange = (TextView) convertView.findViewById(R.id.PercentageChange);



          product.setTextColor(Color.BLACK);
          expiry.setTextColor(Color.BLACK);
          ticksize.setTextColor(Color.BLACK);
          unitoftrading.setTextColor(Color.BLACK);
          deliveryunit.setTextColor(Color.BLACK);
          deliverycenter.setTextColor(Color.BLACK);


        // getting scriptdet data for the row
        Scriptdet s =ScriptdetItems.get(position);

        // Product
        product.setText(s.getProduct());

        // Expiry
        expiry.setText(s.getExpiry());

        //Tick_Size
        ticksize.setText(s.getTick_Size());

        //Unit of Trading
        unitoftrading.setText(s.getTrading_Unit());

        //Delivery_Unit
        deliveryunit.setText(s.getDelivery_Unit());

        //Delivery_center
        deliverycenter.setText(s.getDelivery_Center());


        //Open
//        open.setText(s.getOPEN());
//
//        //High value
//        high.setText(s.getHigh());
//
//        // Low Values
//        low.setText(s.getLow());
//
//        //Close
//        close.setText(s.getClose());
//
//        //value
//        value.setText(s.getValue());
//
//
//        //change in Oi
//        changeinOI.setText(s.getChangeInOI());
//
//        if (Double.parseDouble(s.getChangeInOI())>=0) {
//            changeinOI.setTextColor(Color.parseColor("#00FF00"));
//        } else {
//
//            changeinOI.setTextColor(Color.parseColor("#FF0000"));
//        }
//
//        //Percentage change
//        percentagechange.setText(s.getPercentageChange());
//
//        //Setting negative and positive values
//        if (Double.parseDouble(s.getPercentageChange())>=0) {
//            percentagechange.setTextColor(Color.parseColor("#00FF00"));
//        } else {
//
//            percentagechange.setTextColor(Color.parseColor("#FF0000"));
//        }


        return convertView;
    }

}

