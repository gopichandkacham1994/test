package mcxf_androidcom.com.mcx_android.Graph;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mcxf_androidcom.com.mcx_android.R;


/**
 * Created by Krishna Karthik on 5/11/2016.
 */
public class Table_Adapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Table> Tablegraph;

    public Table_Adapter(Activity activity, List<Table> Tablegraph) {
        this.activity = activity;
        this.Tablegraph = Tablegraph;
    }



    @Override
    public int getCount() {
        return Tablegraph.size();
    }

    @Override
    public Object getItem(int position) {
        return Tablegraph.get(position);
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
            convertView = inflater.inflate(R.layout.list_table, null);

        TextView expiry = (TextView) convertView.findViewById(R.id.Expiry);
        TextView pcp = (TextView) convertView.findViewById(R.id.PCP);
        TextView ltp = (TextView) convertView.findViewById(R.id.LTP);
        TextView percentagechange = (TextView) convertView.findViewById(R.id.PercentageChange);
        TextView time = (TextView) convertView.findViewById(R.id.Time);


        Table t = Tablegraph.get(position);

        expiry.setText(t.getExpiry());

        pcp.setText(t.getPCP());

        ltp.setText(t.getLTP());

        percentagechange.setText(t.getPercentagechange());

        time.setText(t.getTime());

        return convertView;
    }
}
