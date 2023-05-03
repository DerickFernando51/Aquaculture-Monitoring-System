package com.example.aquaculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;



import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    private Button GraphBackBtn;

    private LineGraphSeries<DataPoint> patientGraph;
    private double x_axis,y_axis;
    private GraphView graphView;
    private ArrayList<String> mValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        GraphBackBtn= findViewById(R.id.graph_back_btn);
        mValues = getIntent().getStringArrayListExtra("values");
        graphView = findViewById(R.id.graph_id);
        patientGraph = new LineGraphSeries<>();

        GraphBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ValuesIntent = new Intent(GraphActivity.this, ValuesActivity.class);
                startActivity(ValuesIntent);
            }
        });


        x_axis = 0;
        for(int i=0;i<mValues.size();i++)
        {
            x_axis =i;
            y_axis = Double.parseDouble(mValues.get(i));
            patientGraph.appendData(new DataPoint(x_axis,y_axis),true,100);
        }
        graphView.addSeries(patientGraph);







        //Set the appearance of the series curve .
        patientGraph.setColor ( Color.rgb(58,12,163)); //set the color of the curve
       // patientGraph . setTitle ( "Curve 1" ); // set the curve name for the legend
        //patientGraph. setDrawDataPoints ( true ); // draw points
        //patientGraph. setDataPointsRadius ( 5 ); // data point radius
        patientGraph. setThickness ( 4 ); //line thickness
//
//
//
        //The name of the graph
        graphView. setTitle ( "Previous readings" );
        graphView. setTitleTextSize ( 65 );
        graphView. setTitleColor ( Color . rgb(67,97,238)); //Legend
        graphView . getLegendRenderer (). setVisible ( true );
        graphView . getLegendRenderer (). setAlign ( LegendRenderer. LegendAlign . TOP );


        //Axis labels
        GridLabelRenderer gridLabel = graphView . getGridLabelRenderer ();
       // gridLabel . setHorizontalAxisTitle ("X Axis Title");
        //gridLabel . setVerticalAxisTitle ( "Y Axis Title" );

        //Increase/reduce and scroll // activate horizontal zooming and scrolling
        graphView . getViewport (). setScalable ( true ); // activate horizontal scrolling
        graphView . getViewport (). setScrollable ( true ); // activate horizontal and vertical zooming and scrolling
        graphView . getViewport (). setScalableY ( true ); // activate vertical scrolling
        graphView . getViewport (). setScrollableY ( true);


        //which part of the graph to display
        // set manual X bounds
        graphView . getViewport (). setXAxisBoundsManual ( true );
        graphView . getViewport (). setMinX ( 0 );
        graphView . getViewport (). setMaxX ( 120 );
        // set manual Y bounds
//        graphView . getViewport (). setYAxisBoundsManual ( true );
//        graphView . getViewport (). setMinY ( 0);
//        graphView . getViewport (). setMaxY ( 100 );


    }
}
