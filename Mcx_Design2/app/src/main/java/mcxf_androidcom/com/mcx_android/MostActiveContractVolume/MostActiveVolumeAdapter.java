package mcxf_androidcom.com.mcx_android.MostActiveContractVolume;



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

/**
 * Created by Krishna Karthik on 4/1/2016.
 */
public class MostActiveVolumeAdapter extends BaseAdapter {


        private Activity activity;
        private LayoutInflater inflater;
        private List<MostActiveVolume> VolumeContractItems;


        public MostActiveVolumeAdapter(Activity activity, List<MostActiveVolume> VolumeContractItems) {
            this.activity = activity;
            this.VolumeContractItems = VolumeContractItems;
        }

        @Override
        public int getCount() {
            return VolumeContractItems.size();
        }

        @Override
        public Object getItem(int location) {
            return VolumeContractItems.get(location);
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
                convertView = inflater.inflate(R.layout.list_volumecontract, null);

            if((position % 2 == 0)) {
                //convertView.setBackgroundColor(Color.rgb(110, 181, 192));
                convertView.setBackgroundColor(Color.rgb(250,250,250));
            }
            else{
               // convertView.setBackgroundColor(Color.rgb(226,232,228));
                convertView.setBackgroundColor(Color.rgb(234, 234, 234));
            }

            TextView product = (TextView) convertView.findViewById(R.id.Product);
            TextView expiry = (TextView) convertView.findViewById(R.id.Expiry);
            TextView pqu = (TextView) convertView.findViewById(R.id.PQU);
            TextView ql = (TextView) convertView.findViewById(R.id.QL);
            TextView ltp = (TextView) convertView.findViewById(R.id.LTP);
            TextView value = (TextView) convertView.findViewById(R.id.Value);


            if(position % 2 == 0){
                product.setTextColor(Color.BLACK);
                expiry.setTextColor(Color.BLACK);
                ltp.setTextColor(Color.BLACK);
                pqu.setTextColor(Color.BLACK);
                ql.setTextColor(Color.BLACK);
            }
            else
            {
                product.setTextColor(Color.BLACK);
                expiry.setTextColor(Color.BLACK);
                ltp.setTextColor(Color.BLACK);
                pqu.setTextColor(Color.BLACK);
                ql.setTextColor(Color.BLACK);

            }
            // getting BhavCopy data for the row
            MostActiveVolume b = VolumeContractItems.get(position);


            // PCP
            product.setText(b.getProduct());


            //Open
            expiry.setText(b.getExpiry());

            pqu.setText(b.getPQU());

            //ATP
            ql.setText(b.getQL());

            // Low Values
            ltp.setText(b.getLTP());

            //High value
//            value.setText(b.getValue());

            return convertView;
        }

    }

