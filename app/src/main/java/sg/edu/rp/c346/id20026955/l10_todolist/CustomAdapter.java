package sg.edu.rp.c346.id20026955.l10_todolist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter<ToDoItem> {

    Context pContext;
    int layout_id;
    ArrayList<ToDoItem> list;

    public CustomAdapter(Context context, int resource, ArrayList<ToDoItem> objects) {
        super(context, resource, objects);

        pContext = context;
        layout_id = resource;
        list = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                pContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTask = rowView.findViewById(R.id.tvTask);
        TextView tvDate = rowView.findViewById(R.id.tvDate);

        // Obtain the Android Version information based on the position
        ToDoItem currentVersion = list.get(position);

        // Set values to the TextView to display the corresponding information
        tvTask.setText(currentVersion.getTitle());
        tvDate.setText(list.get(position).toString());

        if (currentVersion.getDate().get(Calendar.YEAR)< 2022){
            tvDate.setTextColor(Color. RED);
        }

        return rowView;
    }

}
