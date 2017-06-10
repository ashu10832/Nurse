package com.example.ashugupta.nurse;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.util.List;

import static android.content.Context.DOWNLOAD_SERVICE;
import static com.example.ashugupta.nurse.R.id.ivProfile;

/**
 * Created by ashugupta on 04/02/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    private static final String TAG = "CustomAdapter";
    private List<Document> documentList;
    public BroadcastReceiver receiver ;
    public IntentFilter filter;
    Document doc;
    Activity context;


    Adapter(List<Document> list,Activity context)
    {
        this.documentList = list;
        receiver = null;
        this.context   =  context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View ItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.document_cardview,parent,false);
        return new MyViewHolder(ItemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Document document = documentList.get(position);
        holder.Name.setText(document.getName());
        holder.speciality.setText(document.getSpeciality());
        holder.rating.setText(document.getRating());
        if (Double.parseDouble(document.getRating())>4.5)
        {
            holder.rating.setTextColor(holder.context.getResources().getColor(R.color.green));
        }
        else if (Double.parseDouble(document.getRating())>4)
        {
            holder.rating.setTextColor(holder.context.getResources().getColor(R.color.yellow));

        }
        holder.Name.setTextColor(holder.context.getResources().getColor(R.color.black));
        holder.speciality.setTextColor(holder.context.getResources().getColor(R.color.colorAccent));
        holder.image.setImageResource(document.getImage());
        holder.Name.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, DetailsActivity.class);
// Pass data object in the bundle and populate details activity.
                intent.putExtra("Name",document.getName() );
                intent.putExtra("Image",document.getImage());
                intent.putExtra("desc",document.getDescription());
                intent.putExtra("Rating",document.getRating());
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(context, holder.image, "profile");
                context.startActivity(intent, options.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return  documentList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        TextView speciality;
        TextView rating;
        View ivProfile;
        ImageView image;
        Context context;

        MyViewHolder(View view) {
            super(view);
            Name = (TextView) view.findViewById(R.id.heading);
            speciality = (TextView) view.findViewById(R.id.speciality);
            rating = (TextView) view.findViewById(R.id.rating);
            context = view.getContext();
            ivProfile = view;
            image = (ImageView) view.findViewById(R.id.image);
        }
    }

}
