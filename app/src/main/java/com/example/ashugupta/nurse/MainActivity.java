package com.example.ashugupta.nurse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Document> listData;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listData = new ArrayList<>();
        listData.add(new Document("Dr. Nishith Chandra","Physician","4.2",R.drawable.doc10,"Dr Nishith Chandra, MD, DM, FSCAI (USA) has more than 22 Years of experience at the prestigious Fortis Escorts Heart Institute & Research Centre, New Delhi, India. He is a Director in Interventional Cardiology here, and deals with all sorts of complex Coronary, Carotid, Renal, Peripheral Interventions. He has been the incharge of Emergency services and Heart Command Centre of Escorts Heart Institute, for last 20 Years. " + "\n"));
        listData.add(new Document("Dr. Sumitra","Cardiologist","4.9",R.drawable.doc2,"Dr. Sumitra is considered as the pioneer of Pain Management in India. He started Pain Management Services at All India Institute of Medical Sciences (AIIMS) in 1986 and developed them to the highest international standards. He served for more than 20 years at AIIMS, till 2005, when he set up Delhi Pain Management Centre."));
        listData.add(new Document("Dr. Aditya Jayaraman","Diabetologist","4.8",R.drawable.doc7,"Dr. Aditya jayaraman has an experience of 10 years in this field. He completed m.B.B.S from manipal university in 2007. Followed by fellowship training in usa, and mrcp(ireland) he returned back to india to pursue clinical medicine. He was formerly associated with max hospital, patparganj from 2012 to 2015."));
        listData.add(new Document("Dr. Seema Sharma","D - Obstetrics & Gynaecology","4.6",R.drawable.doc9,"Dr. Seema Sharma is known for her sincerity, excellent bed side manners and clinical acumen for diagnosing women’s problems. She believes in a holistic approach to a women and understands how her mental status and family situation may affect her physical well being. "));

        recyclerView = (RecyclerView) findViewById(R.id.recycleView_subject);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Adapter adapter = new Adapter(listData,this);
        Log.i(TAG, "onCreate: list size" + listData.size());
        recyclerView.setAdapter(adapter);

    }
}
