package com.iot.psychologicaltest;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListViewMain extends AppCompatActivity {
//L


    private ListAdapter adapter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        adapter = new ListAdapter();
        listView = (ListView) findViewById(R.id.listView);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
                intent.putExtra("data", listCustom.get(position));
                startActivity(intent);
            }
        });

        listView.setAdapter(adapter);

    }

            // 보통 ListView는 통신을 통해 가져온 데이터를 보여줍니다.
            // arrResId, titles, contents를 서버에서 가져온 데이터라고 생각하시면 됩니다.
            private void setData() {
                TypedArray arrResId = getResources().obtainTypedArray(R.array.resId);
                String[] titles = getResources().getStringArray(R.array.title);


                for (int i = 0; i < arrResId.length(); i++) {
                    ListItem dto = new ListItem();
                    dto.setResId(arrResId.getResourceId(i, 0));
                    dto.setTitle(titles[i]);


                    adapter.addItem(dto);
                }
            }


        }
