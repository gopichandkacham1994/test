package mcxf_androidcom.com.mcx_android.MainMarketWatch;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mcxf_androidcom.com.mcx_android.MarketWatch.MarketWatch;
import mcxf_androidcom.com.mcx_android.R;

public class MainMarketWatch_List extends BaseAdapter {


    private Activity activity;
    private LayoutInflater inflater;
    private List<MainMarketwatch_Get_Set> MarketWatchesItems;



    public MainMarketWatch_List(Activity activity, List<MainMarketwatch_Get_Set> MarketWatchesItems) {
        this.activity = activity;
        this.MarketWatchesItems = MarketWatchesItems;
    }

    public MainMarketWatch_List() {
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
            convertView = inflater.inflate(R.layout.activity_main_market_watch__list, null);

        if((position % 2 == 0)) {
//            convertView.setBackgroundColor(Color.rgb(110, 181, 192));
            convertView.setBackgroundColor(Color.rgb(250,250,250 ));
        }
        else{
//            convertView.setBackgroundColor(Color.rgb(226,232,228));
            convertView.setBackgroundColor(Color.rgb(234, 234, 234));

        }

        TextView product = (TextView) convertView.findViewById(R.id.Product);
        TextView expiry = (TextView) convertView.findViewById(R.id.Expiry);
        // TextView totalqtyTraded = (TextView) convertView.findViewById(R.id.ToatalQtyTraded);
        TextView ltp = (TextView) convertView.findViewById(R.id.LTP);
        TextView pcp = (TextView) convertView.findViewById(R.id.PCP);
        TextView percentageChange = (TextView) convertView.findViewById(R.id.PercentageChange);
        TextView value = (TextView) convertView.findViewById(R.id.Value);
        TextView pqu = (TextView) convertView.findViewById(R.id.PQU);
        TextView ql = (TextView) convertView.findViewById(R.id.QL);
        TextView change = (TextView) convertView.findViewById(R.id.Change);

        if(position % 2 == 0){

            product.setTextColor(Color.BLACK);
            expiry.setTextColor(Color.BLACK);
            ltp.setTextColor(Color.BLACK);
            pcp.setTextColor(Color.BLACK);
            percentageChange.setTextColor(Color.BLACK);
            value.setTextColor(Color.BLACK);
            pqu.setTextColor(Color.BLACK);
            ql.setTextColor(Color.BLACK);
            change.setTextColor(Color.BLACK);
        }
        else
        {

            product.setTextColor(Color.BLACK);
            expiry.setTextColor(Color.BLACK);
            ltp.setTextColor(Color.BLACK);
            pcp.setTextColor(Color.BLACK);
            percentageChange.setTextColor(Color.BLACK);
            value.setTextColor(Color.BLACK);
            pqu.setTextColor(Color.BLACK);
            ql.setTextColor(Color.BLACK);
            change.setTextColor(Color.BLACK);
        }

        // getting MarketWatch data for the row
        MainMarketwatch_Get_Set m = MarketWatchesItems.get(position);

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


        pqu.setText(m.getPQU());

        //ATP
        ql.setText(m.getQL());

        value.setText(m.getValue());



        change.setText(m.getChange());

        //Setting negative and positive values
        if (Double.parseDouble(m.getPercentageChange())>=0) {
            percentageChange.setTextColor(Color.parseColor("#00FF00"));
        } else {

            percentageChange.setTextColor(Color.parseColor("#FF0000"));
        }

        if (Double.parseDouble(m.getChange())>=0) {
            change.setTextColor(Color.parseColor("#186e28"));
        } else {

            change.setTextColor(Color.parseColor("#670004"));
        }


        return convertView;
    }

}
