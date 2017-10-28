package edu.selu.cgonzales.hammondddd.Utils;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import edu.selu.cgonzales.hammondddd.Data.Event;
import edu.selu.cgonzales.hammondddd.R;

public class EventsArrayAdapter extends ArrayAdapter<Event> {

    private final Activity context;
    private final List<Event> events;

    static class ViewHolder{
        public TextView eventDate;
        public TextView eventName;
        public TextView eventLocation;
        public TextView eventDescription;
    }

    public EventsArrayAdapter(Activity context, List<Event> events){
        super(context, R.layout.events_list_item, events);
        this.context = context;
        this.events = events;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View rowView = convertView;

        if (rowView == null){
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.events_list_item, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.eventDate = (TextView) rowView.findViewById(R.id.eventDate);
            viewHolder.eventName = (TextView) rowView.findViewById(R.id.eventName);
            viewHolder.eventLocation = (TextView) rowView.findViewById(R.id.eventLocation);
            viewHolder.eventDescription = (TextView) rowView.findViewById(R.id.eventDescription);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        Event event = events.get(position);
        holder.eventDate.setText(event.getEventDate().toString());
        holder.eventName.setText(event.getName());
        holder.eventLocation.setText(event.getLocation());
        holder.eventDescription.setText(event.getDescription());

        return rowView;
    }

}
