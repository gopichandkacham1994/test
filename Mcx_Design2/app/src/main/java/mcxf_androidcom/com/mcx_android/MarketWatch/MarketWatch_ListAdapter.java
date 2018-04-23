package mcxf_androidcom.com.mcx_android.MarketWatch;

/**
 * Created by Krishna Karthik on 3/22/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;

import mcxf_androidcom.com.mcx_android.MarketWatch.MarketWatch;
import mcxf_androidcom.com.mcx_android.R;

public class MarketWatch_ListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<MarketWatch> MarketWatchesItems;



    public MarketWatch_ListAdapter(Activity activity, List<MarketWatch> MarketWatchesItems) {
        this.activity = activity;
        this.MarketWatchesItems = MarketWatchesItems;
    }

    @Override
    public int getCount() {
        return MarketWatchesItems.size();
    }

    @Override
    public Object getItem(int location) {
        return MarketWatchesItems.get(location);
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
            convertView = inflater.inflate(R.layout.list_marketwatch, null);

        if((position % 2 == 0)) {

            convertView.setBackgroundColor(Color.rgb(110, 181, 192));

        }
            else{
                convertView.setBackgroundColor(Color.rgb(226,232,228));
            }




        TextView product = (TextView) convertView.findViewById(R.id.Product);
        TextView expiry = (TextView) convertView.findViewById(R.id.Expiry);
       // TextView totalqtyTraded = (TextView) convertView.findViewById(R.id.ToatalQtyTraded);
        TextView ltp = (TextView) convertView.findViewById(R.id.LTP);
        TextView pcp = (TextView) convertView.findViewById(R.id.PCP);
        TextView percentageChange = (TextView) convertView.findViewById(R.id.PercentageChange);
        TextView buyprice1 = (TextView) convertView.findViewById(R.id.BuyPrice1);
        TextView buyqty1 = (TextView) convertView.findViewById(R.id.BuyQty1);
        TextView sellprice1 = (TextView) convertView.findViewById(R.id.SellPrice1);
        TextView sellqty1 = (TextView) convertView.findViewById(R.id.SellQty1);

        // getting MarketWatch data for the row
        MarketWatch m = MarketWatchesItems.get(position);

        // Product
        product.setText(m.getProduct());


        //expiry
        expiry.setText(m.getExpiry());


        //TotalQtyTraded
      //  totalqtyTraded.setText(m.getTotalQtyTraded());


        //LTP
        ltp.setText(m.getLTP());

        //pcp
        pcp.setText(m.getPCP());

        //PercentageChange
        percentageChange.setText(m.getPercentageChange());

        buyprice1.setText(m.getBuyPrice1());


        buyqty1.setText(m.getBuyQty1());

        sellprice1.setText(m.getSellPrice1());

        sellqty1.setText(m.getSellQty1());

        //Setting negative and positive values
        if (Double.parseDouble(m.getPercentageChange())>=0) {
            percentageChange.setTextColor(Color.parseColor("#00FF00"));
        } else {

            percentageChange.setTextColor(Color.parseColor("#FF0000"));
        }


        return convertView;
    }

  }

