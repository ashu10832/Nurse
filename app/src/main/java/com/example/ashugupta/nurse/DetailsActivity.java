package com.example.ashugupta.nurse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

     public static Document EXTRA_CONTACT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView image = (ImageView) findViewById(R.id.ivProfile);
        int imageId = getIntent().getIntExtra("Image",0);
        image.setImageResource(imageId);
        TextView rating = (TextView) findViewById(R.id.rating) ;
        String Rating = "Rating: " + getIntent().getStringExtra("Rating");
        rating.setText(Rating);
        TextView name = (TextView) findViewById(R.id.name);
        String Name = getIntent().getStringExtra("Name");
        String desc = getIntent().getStringExtra("desc");
        name.setText(Name);
        TextView Desc = (TextView) findViewById(R.id.description);
        Desc.setText(desc);
    }
}
