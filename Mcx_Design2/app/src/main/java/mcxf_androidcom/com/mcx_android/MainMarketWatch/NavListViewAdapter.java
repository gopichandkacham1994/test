package mcxf_androidcom.com.mcx_android.MainMarketWatch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mcxf_androidcom.com.mcx_android.R;

/**
 * Created by hp on 21-06-2016.
 */
public class NavListViewAdapter extends BaseAdapter {
    private String[] drawerNames={"Product Details","MAC Value","MAC Volume","Top Gainers","Top Losers","Graphs","BhavCopy","ScriptDet",
    "About Us","Contact Us"};
    private int[] Images={R.drawable.ic_marketwatch,R.drawable.ic_value,R.drawable.ic_volume,R.drawable.ic_high,
            R.drawable.ic_low,R.drawable.ic_graphs,R.drawable.ic_bhavcopy,R.drawable.ic_scriptdet,
            R.drawable.ic_about,R.drawable.ic_contactus};
    private Context context;
    private LayoutInflater inflater;


    public NavListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Images.length;
    }

    @Override
    public Object getItem(int position) {
        return Images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView== null)
        {
            convertView=inflater.inflate(R.layout.nav_list_item,parent,false);

            TextView names= (TextView) convertView.findViewById(R.id.navNames);
            ImageView images= (ImageView) convertView.findViewById(R.id.navImages);
            names.setText(drawerNames[position]);
            images.setImageResource(Images[position]);
        }
        return convertView;
    }
}
