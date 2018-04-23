package mcxf_androidcom.com.mcx_android.BhavCopy;

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

public class BhavCopyAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<BhavCopy> BhavCopyItems;


    public BhavCopyAdapter(Activity activity, List<BhavCopy> BhavCopyItems) {
        this.activity = activity;
        this.BhavCopyItems = BhavCopyItems;
    }

    @Override
    public int getCount() {
        return BhavCopyItems.size();
    }

    @Override
    public Object getItem(int location) {
        return BhavCopyItems.get(location);
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
            convertView = inflater.inflate(R.layout.list_bhavcopy, null);

        // setting alternative color to rows

        if((position % 2 == 0)) {

            //convertView.setBackgroundColor(Color.rgb(110, 181, 192));
            convertView.setBackgroundColor(Color.rgb(250,250,250));
        }
        else{
          //  convertView.setBackgroundColor(Color.rgb(226,232,228));
            convertView.setBackgroundColor(Color.rgb(234, 234, 234));
        }

        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView commodity = (TextView) convertView.findViewById(R.id.commodity);
        TextView expiry = (TextView) convertView.findViewById(R.id.Expiry);
        TextView close = (TextView) convertView.findViewById(R.id.Close);
        TextView pcp = (TextView) convertView.findViewById(R.id.PCP);
        TextView atp = (TextView) convertView.findViewById(R.id.ATP);
        TextView volume = (TextView) convertView.findViewById(R.id.volume);
        TextView value = (TextView) convertView.findViewById(R.id.Value);
        TextView oi = (TextView) convertView.findViewById(R.id.oi);



        //setting textcolor

            date.setTextColor(Color.BLACK);
            commodity.setTextColor(Color.BLACK);
            expiry.setTextColor(Color.BLACK);
            close.setTextColor(Color.BLACK);
            pcp.setTextColor(Color.BLACK);
            atp.setTextColor(Color.BLACK);
            volume.setTextColor(Color.BLACK);
            value.setTextColor(Color.BLACK);
            oi.setTextColor(Color.BLACK);


        // getting BhavCopy data for the row
        BhavCopy b = BhavCopyItems.get(position);

        //Date
        date.setText(b.getDate());

        //Commodity
        commodity.setText(b.getCommodity());

        //Expiry
        expiry.setText(b.getExpiry());

        //Close
        close.setText(b.getClose());

        // PCP
        pcp.setText(b.getPCP());

        //ATP
        atp.setText(b.getATP());

        //Volume
        volume.setText(b.getVolume());

        //Value
        value.setText(b.getValue());

        //OI
        oi.setText(b.getOI());

        return convertView;
    }

}

