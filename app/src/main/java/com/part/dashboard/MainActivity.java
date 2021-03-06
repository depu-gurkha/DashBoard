package com.part.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Toolbar myToolbar;
    ImageView ivLanding;
    CardView cardIv;
    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String,List<String>> listItem;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myToolbar=findViewById(R.id.customToolbarr);
        ivLanding=findViewById(R.id.ivLanding);
        expandableListView=findViewById(R.id.expandableList);
        listGroup=new ArrayList<>();
        listItem=new HashMap<>();
        mainAdapter=new MainAdapter(this,listGroup,listItem);
        expandableListView.setAdapter(mainAdapter);
        initListData();
        cardIv=findViewById(R.id.cardIv);
        cardIv.setBackgroundColor(Color.TRANSPARENT);
        Glide.with(this).load("https://rkmhikai.online/public/assets/img/student.jpg").into(ivLanding);
        setSupportActionBar(myToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);


    }

    private void initListData() {
        listGroup.add(getString(R.string.group1));
        listGroup.add(getString(R.string.group2));
        listGroup.add(getString(R.string.group3));
        listGroup.add(getString(R.string.group4));
        String[] array;
        List<String> list1=new ArrayList<>();
        array=getResources().getStringArray(R.array.group1);
        for(String item : array){
            list1.add(item);
        }
        List<String> list2=new ArrayList<>();
        array=getResources().getStringArray(R.array.group2);
        for(String item : array){
            list1.add(item);
        }
        List<String> list3=new ArrayList<>();
        array=getResources().getStringArray(R.array.group3);
        for(String item : array){
            list1.add(item);
        }

        List<String> list4=new ArrayList<>();
        array=getResources().getStringArray(R.array.group4);
        for(String item : array){
            list1.add(item);
        }
        listItem.put(listGroup.get(0),list1);
        listItem.put(listGroup.get(1),list2);
        listItem.put(listGroup.get(2),list3);
        listItem.put(listGroup.get(3),list4);
        mainAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Item 3 Selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


