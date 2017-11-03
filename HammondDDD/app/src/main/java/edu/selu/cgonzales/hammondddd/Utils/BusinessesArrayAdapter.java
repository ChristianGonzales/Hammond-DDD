package edu.selu.cgonzales.hammondddd.Utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import edu.selu.cgonzales.hammondddd.Data.Business;
import edu.selu.cgonzales.hammondddd.Data.Event;
import edu.selu.cgonzales.hammondddd.R;

public class BusinessesArrayAdapter extends ArrayAdapter<Business> {

    private final Activity context;
    private final List<Business> businesses;

    static class ViewHolder{
        public TextView businessName;
        public TextView businessLocation;
        public TextView businessPhone;
    }

    public BusinessesArrayAdapter(Activity context, List<Business> businesses){
        super(context, R.layout.businesses_list_item, businesses);
        this.context = context;
        this.businesses = businesses;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View rowView = convertView;

        if (rowView == null){
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.businesses_list_item, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.businessName = (TextView) rowView.findViewById(R.id.eventDate);
            viewHolder.businessLocation = (TextView) rowView.findViewById(R.id.eventName);
            viewHolder.businessPhone = (TextView) rowView.findViewById(R.id.eventLocation);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        Business business = businesses.get(position);
        holder.businessName.setText(business.getName());
        holder.businessLocation.setText(business.getLocation());
        holder.businessPhone.setText(business.getPhoneNumber());

        return rowView;
    }

}
