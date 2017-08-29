package com.example.andyshi.mypractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.Fragment;

/**
 * Created by AndyShi on 2017/8/24.
 */

public class IndexFragment extends Fragment{
    private TextView txtUser;
    String[] func = {"冷氣控制","智慧插座"};
    int[] icons = {R.drawable.aircon,R.drawable.plug};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtUser = (TextView)getView().findViewById(R.id.textView);
        txtUser.setSingleLine();
        txtUser.setText("WHAT THE HELL IS HAPPENING RIGHT NOW!?");
        txtUser.setSelected(true);
        GridView gridView = (GridView)getView().findViewById(R.id.grid);
        IconAdapter iconAdapter = new IconAdapter();
        gridView.setAdapter(iconAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch ((int) l){
                    case R.drawable.aircon:
                        intent = new Intent(getActivity(),AirconActivity.class);
                        startActivity(intent);
                        break;
                    case R.drawable.plug:
                        intent = new Intent(getActivity(),PlugconActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }

    class IconAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return func.length;
        }

        @Override
        public Object getItem(int i) {
            return func[i];
        }

        @Override
        public long getItemId(int i) {
            return icons[i];
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View row = view;
            if(row==null){
                row = getActivity().getLayoutInflater().inflate(R.layout.item_row,null);
                ImageView imageView = (ImageView)row.findViewById(R.id.itemImage);
                TextView textView = (TextView)row.findViewById(R.id.item_text);
                imageView.setImageResource(icons[i]);
                textView.setText(func[i]);
            }
            return row;
        }
    }
}
