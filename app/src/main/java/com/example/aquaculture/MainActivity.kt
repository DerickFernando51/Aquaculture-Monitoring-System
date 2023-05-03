package com.example.aquaculture

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {
    //@SuppressLint("MissingInflatedId")
    @SuppressLint("MissingInflatedId")
    private lateinit var temperatureDatabase: DatabaseReference
    private lateinit var pHDatabase: DatabaseReference
    private lateinit var TDSDatabase: DatabaseReference

    private var mValueEventListener: ValueEventListener? = null
    private var mValueEventListener2: ValueEventListener? = null
    private var mValueEventListener3: ValueEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        var historicalDataBtn: Button? = null
//        var patientName: java.util.ArrayList<String>? = null
//        var GetResultsButton: Button? = null
//        var mDatabase: DatabaseReference? = null
//        var patientSpinner: Spinner? = null
//        var patientAdapter: ArrayAdapter<String>? = null
//        var selected_patient: String? = null

        setContentView(R.layout.activity_main)


        // initialize Firebase database reference
        temperatureDatabase =
            FirebaseDatabase.getInstance().getReference("Aquaculture/0/Temperature")
        pHDatabase = FirebaseDatabase.getInstance().getReference("Aquaculture/0/pH")
        TDSDatabase = FirebaseDatabase.getInstance().getReference("Aquaculture/0/TDS")


        // add a value event listener to read data from Firebase
        mValueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // read the sensor value from Firebase
                val temperatureValue = dataSnapshot.getValue(String::class.java)

                // check if the sensor value is above the threshold
                if (Integer.parseInt(temperatureValue) > 75) {
                    // show an alert dialog
                    val builder = AlertDialog.Builder(this@MainActivity)
                    builder.setMessage("Temperature value is above the threshold")
                        .setTitle("Warning")
                        .setPositiveButton("OK", null)
                    val dialog = builder.create()
                    dialog.show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // handle database error
            }
        }

        // add a value event listener to read data from Firebase
        mValueEventListener2 = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // read the sensor value from Firebase
                val  pHValue = dataSnapshot.getValue(String::class.java)

                // check if the sensor value is above the threshold
                if (Integer.parseInt(pHValue) > 12) {
                    // show an alert dialog
                    val builder = AlertDialog.Builder(this@MainActivity)
                    builder.setMessage("pH value is above the threshold")
                        .setTitle("Warning")
                        .setPositiveButton("OK", null)
                    val dialog = builder.create()
                    dialog.show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // handle database error
            }
        }

        // add a value event listener to read data from Firebase
        mValueEventListener3 = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // read the sensor value from Firebase
                val  TDSValue = dataSnapshot.getValue(String::class.java)

                // check if the sensor value is above the threshold
                if (Integer.parseInt(TDSValue) > 1750) {
                    // show an alert dialog
                    val builder = AlertDialog.Builder(this@MainActivity)
                    builder.setMessage("TDS value is above the threshold")
                        .setTitle("Warning")
                        .setPositiveButton("OK", null)
                    val dialog = builder.create()
                    dialog.show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // handle database error
            }
        }

        val buttonClick1 = findViewById<Button>(R.id.temperatureGraphBtn)
        buttonClick1.setOnClickListener {
            val intent = Intent(this, TemperatureGraph::class.java)
            startActivity(intent)
        }

        val buttonClick2 = findViewById<Button>(R.id.TDSGraphBtn)
        buttonClick2.setOnClickListener {
            val intent = Intent(this, TDSGraph::class.java)
            startActivity(intent)
        }

        val buttonClick3 = findViewById<Button>(R.id.pHGraphBtn)
        buttonClick3.setOnClickListener {
            val intent = Intent(this,  pHGraph::class.java)
            startActivity(intent)
        }


        replaceFragment(Home())


//
//
//        mDatabase.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                patientName.clear()
//                patientName.add("---------")
//                for (ds in dataSnapshot.children) {
//                    patientName.add(ds.key.toString())
//                }
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {}
//        })
//
//        patientAdapter = ArrayAdapter<String>(
//            this@MainActivity,
//            android.R.layout.simple_spinner_dropdown_item,
//            patientName
//        )
//        patientSpinner.setAdapter(patientAdapter)
//
//        patientSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>,
//                view: View,
//                position: Int,
//                id: Long
//            ) {
//                selected_patient = parent.getItemAtPosition(position).toString()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {}
//        })
//
//        GetResultsButton.setOnClickListener(View.OnClickListener {
//            val ValuesIntent = Intent(this@MainActivity, ValuesActivity::class.java)
//            ValuesIntent.putExtra("patient_name", selected_patient)
//            startActivity(ValuesIntent)
//        })


    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }


    override fun onStart() {
        super.onStart()

        // start listening for value events from Firebase
        temperatureDatabase.addValueEventListener(mValueEventListener!!)
        pHDatabase.addValueEventListener(mValueEventListener2!!)
        TDSDatabase.addValueEventListener(mValueEventListener3!!)

    }

    override fun onStop() {
        super.onStop()

        // stop listening for value events from Firebase
        mValueEventListener?.let { temperatureDatabase.removeEventListener(it) }
        mValueEventListener2?.let {  pHDatabase.removeEventListener(it) }
        mValueEventListener3?.let {  TDSDatabase.removeEventListener(it) }


    }


}






























