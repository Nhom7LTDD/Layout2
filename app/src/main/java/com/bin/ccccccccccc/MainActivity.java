package com.bin.ccccccccccc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    ListView listAlbum;
    int[] hinhdaidien={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5};
    int[] hinhdongho={R.drawable.time,R.drawable.time,R.drawable.time,R.drawable.time,R.drawable.time};
    int[] hinhstock={R.drawable.chair,R.drawable.book,R.drawable.tv,R.drawable.ao,R.drawable.chair};
    String[] tensp={"Used Living Furniture","Smashing Book #4","Macbook Air 13''","Awsome Blue Blaze","Cool Living Couch"};
    String[] time={"2h","5h","5h","2d","2d"};
    String[] cost={"$350","$25","$1500","$725","$350"};
    List<Album> danhSachAlbum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAlbum=(ListView) findViewById(R.id.listAlbum);

        danhSachAlbum=new ArrayList<>();
        for (int i=0;i<hinhdaidien.length;i++){
            Album album=new Album();
            album.setAnhdaidien(hinhdaidien[i]);
            album.setAnhdongho(hinhdongho[i]);
            album.setAnhstock(hinhstock[i]);
            album.setTensp(tensp[i]);
            album.setTime(time[i]);
            album.setCost(cost[i]);
        danhSachAlbum.add(album);
        }
        CustomAdapter  adapterAlbum= new CustomAdapter(this,R.layout.listview_layout,danhSachAlbum);
        adapterAlbum.notifyDataSetChanged();
        listAlbum.setAdapter(adapterAlbum);

    }
    public class CustomAdapter extends ArrayAdapter<Album> {
        Context context ;
        int resource;
        List<Album> listAlbum;
        public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Album> objects) {
            super(context, resource, objects);

            this.context=context;
            this.resource=resource;
            this.listAlbum= objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowItem= inflater.inflate(resource,parent,false);
            ImageView anhdaidien=(ImageView) rowItem.findViewById(R.id.anhsp);
            ImageView anhdongho=(ImageView)rowItem.findViewById(R.id.imagetime);
            ImageView anhstock=(ImageView)rowItem.findViewById(R.id.imagestock);
            TextView  tensp=(TextView)rowItem.findViewById(R.id.tensp);
            TextView  time=(TextView)rowItem.findViewById(R.id.time);
            TextView  cost=(TextView)rowItem.findViewById(R.id.cost);

            anhdaidien.setImageResource(listAlbum.get(position).getAnhdaidien());
            anhdongho.setImageResource(listAlbum.get(position).getAnhdongho());
            anhstock.setImageResource(listAlbum.get(position).getAnhstock());
            tensp.setText(listAlbum.get(position).getTensp());
            time.setText(listAlbum.get(position).getTime());
            cost.setText(listAlbum.get(position).getCost());
            return  rowItem;
        }
    }
}