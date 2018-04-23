package mcxf_androidcom.com.mcx_android.ScriptMas;

/**
 * Created by Krishna Karthik on 3/24/2016.
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

public class Scriptmas_ListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Scriptmas> ScriptmasItems;


    public  Scriptmas_ListAdapter(Activity activity, List<Scriptmas>ScriptmasItems) {
        this.activity = activity;
        this.ScriptmasItems =ScriptmasItems;
    }

    @Override
    public int getCount() {
        return ScriptmasItems.size();
    }

    @Override
    public Object getItem(int location) {
        return ScriptmasItems.get(location);
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
            convertView = inflater.inflate(R.layout.list_scriptmas, null);

        if((position % 2 == 0)) {

           // convertView.setBackgroundColor(Color.rgb(110, 181, 192));
            convertView.setBackgroundColor(Color.rgb(204,255,255));

        }
        else{
           // convertView.setBackgroundColor(Color.rgb(226,232,228));
            convertView.setBackgroundColor(Color.rgb(0, 153, 204));
        }


        TextView instrument_code = (TextView) convertView.findViewById(R.id.Instrument_Code);
        TextView lot_size = (TextView) convertView.findViewById(R.id.Lot_Size);
        TextView tick_size = (TextView) convertView.findViewById(R.id.Tick_Size);
        TextView instrument_description = (TextView) convertView.findViewById(R.id.Instrument_Description);
        TextView trading_unit = (TextView) convertView.findViewById(R.id.Trading_Unit);

        if(position % 2 == 0){

            instrument_code.setTextColor(Color.BLACK);
            lot_size.setTextColor(Color.BLACK);
            tick_size.setTextColor(Color.BLACK);
            instrument_description.setTextColor(Color.BLACK);
            trading_unit.setTextColor(Color.BLACK);
        }
        else {

            instrument_code.setTextColor(Color.WHITE);
            lot_size.setTextColor(Color.WHITE);
            tick_size.setTextColor(Color.WHITE);
            instrument_description.setTextColor(Color.WHITE);
            trading_unit.setTextColor(Color.WHITE);

        }

        // getting Script_mas data for the row
        Scriptmas sm =ScriptmasItems.get(position);

        //Instrumentcode
        instrument_code.setText(sm.getInstrument_Code());

        // lotsize
        lot_size.setText(sm.getLot_Size());

        //ticksize
        tick_size.setText(sm.getTick_Size());

        //instrumentdescription
       instrument_description.setText(sm.getInstrument_Description());

        //tradingunit
        trading_unit.setText(sm.getTrading_Unit());

        return convertView;
    }

}

