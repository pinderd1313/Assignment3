package com.f19.customadapterdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter extends ArrayAdapter {

    private List<Students> students;
    private final LayoutInflater layoutInflater;
    private final int layoutResource;


    public StudentAdapter(@NonNull Context context, int resource, List<Students> students) {
        super(context, resource);
        this.students =students ;
        this.layoutInflater = LayoutInflater.from(context);
        this.layoutResource = resource;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null)
            v = layoutInflater.inflate(layoutResource, parent, false);
        TextView nameText = v.findViewById(R.id.name);
        TextView idText = v.findViewById(R.id.id);
        TextView emailText = v.findViewById(R.id.email);


        nameText.setText(students.get(position).name);
        idText.setText(String.valueOf(students.get(position).id));
        emailText.setText(students.get(position).email);



        return v;
    }
}
