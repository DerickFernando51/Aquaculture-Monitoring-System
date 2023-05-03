package com.example.aquaculture;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class TDSGraph extends AppCompatActivity {

    private Button TDSBackBtn;


    private DatabaseReference mDatabaseRef;
    private LineChart mLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdsgraph);

        TDSBackBtn= findViewById(R.id.TDS_btn);
        mLineChart = findViewById(R.id.TDS_chart);
        mLineChart.setDragEnabled(true);
        mLineChart.setScaleEnabled(true);

        TDSBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ValuesIntent = new Intent(TDSGraph.this,  MainActivity.class);
                startActivity(ValuesIntent);
            }
        });


        XAxis Axis = mLineChart.getXAxis();
        // Enable X-axis labels to be drawn
        Axis.setDrawLabels(true);

        // Set the position of the X-axis labels
        Axis.setPosition(XAxis.XAxisPosition.BOTTOM);



        // Set axes titles
        Description description = new Description();
        description.setText(" "); // Set X axis title
        mLineChart.setDescription(description);






        YAxis leftAxis = mLineChart.getAxisLeft();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setAxisMaximum(2000f); // Set Y axis max value
        leftAxis.setAxisMinimum(0f); // Set Y axis min value
        description.setYOffset(0); // Set Y axis title offset
        description.setTextAlign(Paint.Align.LEFT); // Set Y axis title align
        //description.setText("Temperature reading"); // Set Y axis title

        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("TDS");

        final ArrayList<Entry> entries = new ArrayList<>();

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String timeValue = dataSnapshot.child("Time").getValue().toString();
                    float yValue = Float.parseFloat(dataSnapshot.child("Value").getValue().toString());
                    Date date = parseDate(timeValue);
                    long xValue = date.getTime();
                    entries.add(new Entry(xValue, yValue));
                }
                showChart(entries);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "onCancelled: " + error);
            }
        });

        // Set x-axis value formatter
        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            private final SimpleDateFormat mFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return mFormat.format(new Date((long) value));
            }
        });
    }

    private void showChart(ArrayList<Entry> entries) {
        LineDataSet dataSet = new LineDataSet(entries, "");
        dataSet.setColor(Color.RED);
        dataSet.setValueTextColor(Color.BLUE);
        dataSet.setLineWidth(2f);
        dataSet.setValueTextSize(10f);

        LineData lineData = new LineData(dataSet);
        mLineChart.setData(lineData);
        mLineChart.animateX(1500);
        mLineChart.invalidate();
    }


    private Date parseDate(String dateString) {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}