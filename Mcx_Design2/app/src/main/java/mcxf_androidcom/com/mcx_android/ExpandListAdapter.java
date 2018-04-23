package mcxf_androidcom.com.mcx_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hp on 21-06-2016.
 */
public class ExpandListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<GroupItems> groups;

    public ExpandListAdapter(Context context, ArrayList<GroupItems> groups) {
        this.context = context;
        this.groups = groups;
    }


    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        ArrayList<ChildItems> chList = groups.get(groupPosition)
                .getItems();
        return chList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<ChildItems> chList = groups.get(groupPosition)
                .getItems();
        return chList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupItems groupItems= (GroupItems) getGroup(groupPosition);
        if(convertView==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.nav_list_item,parent,false);

        }
        TextView names= (TextView) convertView.findViewById(R.id.navNames);
        ImageView images= (ImageView) convertView.findViewById(R.id.navImages);
        ImageView image= (ImageView) convertView.findViewById(R.id.expand_icon);
        names.setText(groupItems.getName());
        images.setImageResource(groupItems.getImages());
        image.setImageResource(groupItems.getExpand_icon());



        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ChildItems childItems= (ChildItems) getChild(groupPosition,childPosition);
        if(convertView==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.child_item,parent,false);

        }
        TextView names= (TextView) convertView.findViewById(R.id.child_items);
        names.setText(childItems.getName());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
