package mcxf_androidcom.com.mcx_android.Top_Gainers;

/**
 * Created by Krishna Karthik on 4/1/2016.
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

public class TopGains_ListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<TopGainlist> TopGainItems;



    public TopGains_ListAdapter(Activity activity, List<TopGainlist> TopGainItems) {
        this.activity = activity;
        this.TopGainItems = TopGainItems;
    }

    @Override
    public int getCount() {
        return TopGainItems.size();
    }

    @Override
    public Object getItem(int location) {
        return TopGainItems.get(location);
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
            convertView = inflater.inflate(R.layout.list_topgains, null);


        if((position % 2 == 0)) {
            //convertView.setBackgroundColor(Color.rgb(110, 181, 192));
            convertView.setBackgroundColor(Color.rgb(250,250,250));
        }
        else{
            //convertView.setBackgroundColor(Color.rgb(226,232,228));
            convertView.setBackgroundColor(Color.rgb(234,234,234));
        }

        TextView product = (TextView) convertView.findViewById(R.id.Product);
        TextView expiry = (TextView) convertView.findViewById(R.id.Expiry);
        TextView ltp = (TextView) convertView.findViewById(R.id.LTP);
        TextView pcp = (TextView) convertView.findViewById(R.id.PCP);
        TextView percentagechange = (TextView) convertView.findViewById(R.id.PercentageChange);
        TextView change = (TextView) convertView.findViewById(R.id.change);


            product.setTextColor(Color.BLACK);
            expiry.setTextColor(Color.BLACK);
            ltp.setTextColor(Color.BLACK);
            pcp.setTextColor(Color.BLACK);
            percentagechange.setTextColor(Color.BLACK);
            change.setTextColor(Color.BLACK);


        // getting MarketWatch data for the row
        TopGainlist m =TopGainItems.get(position);


        // Product
        product.setText(m.getProduct());


        //expiry
        expiry.setText(m.getExpiry());

        //pcp
        pcp.setText(m.getPCP());

        //LTP
        ltp.setText(m.getLTP());

        //PercentageChange
        percentagechange.setText(m.getPercentageChange());

        //Setting negative and positive values
        if (Double.parseDouble(m.getPercentageChange())>=0) {
            percentagechange.setTextColor(Color.parseColor("#186e28"));
        } else {

            percentagechange.setTextColor(Color.parseColor("#670004"));
        }

        //Change
        change.setText(m.getPercentageChange());

        //Setting negative and positive values
        if (Double.parseDouble(m.getPercentageChange())>=0) {
            percentagechange.setTextColor(Color.parseColor("#186e28"));
        } else {

            percentagechange.setTextColor(Color.parseColor("#670004"));
        }


        return convertView;
    }
}

