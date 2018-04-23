package mcxf_androidcom.com.mcx_android;

/**
 * Created by Krishna Karthik on 3/25/2016.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

public class DirectorsListViewAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final Integer[] imageId;
    private final String[] Directorname;
    private final String[] Directordetails;


    public DirectorsListViewAdapter(Activity context,
                                 String[] Directorname, String[] Directordetails, Integer[] imageId) {
        super(context, R.layout.list_directors, Directorname);
        this.context = context;
        this.imageId = imageId;
        this.Directorname = Directorname;
        this.Directordetails = Directordetails;


    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_directors, null, true);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.director);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.director_name);
        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.director_details);

        imageView.setImageResource(imageId[position]);
        txtTitle.setText(Directorname[position]);
        txtTitle1.setText(Directordetails[position]);

        return rowView;
    }

}