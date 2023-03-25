package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] titles = {"桌子", "苹果","蛋糕","线衣","猕猴桃","围巾",
                            "桌子2", "苹果2","蛋糕2","线衣2","猕猴桃2","围巾2"};
    private String[] prices = {"1800元", "10元/kg", "300元", "350元", "15元/kg", "200元",
                            "1800元", "10元/kg", "300元", "350元", "15元/kg", "200元"};
    private int[] icons = {R.drawable.table, R.drawable.apple,R.drawable.cake,
                        R.drawable.wireclothes,R.drawable.kiwifruit,R.drawable.scarf,
                        R.drawable.table, R.drawable.apple,R.drawable.cake,
                        R.drawable.wireclothes,R.drawable.kiwifruit,R.drawable.scarf};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.lv);
        MyBaseAdapter myAdapter = new MyBaseAdapter();
        mListView.setAdapter(myAdapter);


    }
    class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return titles.length;
        }
        @Override
        public Object getItem(int position) {
            return titles[position];
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
/*            View view = View.inflate(MainActivity.this, R.layout.list_item, null);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView price = (TextView) view.findViewById(R.id.price);
            ImageView iv = (ImageView) view.findViewById(R.id.iv);
            title.setText(titles[position]);
            price.setText(prices[position]);
            iv.setBackgroundResource(icons[position]);
            return view;*/
            ViewHolder viewHolder = null;
            if (convertView == null){
                convertView = View.inflate(MainActivity.this, R.layout.list_item, null);
                viewHolder = new ViewHolder();
                viewHolder.title = (TextView) convertView.findViewById(R.id.title);
                viewHolder.price = (TextView) convertView.findViewById(R.id.price);
                viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.title.setText(titles[position]);
            viewHolder.price.setText(prices[position]);
            viewHolder.iv.setBackgroundResource(icons[position]);
            return convertView;
        }
    }
    static class ViewHolder{
        TextView title;
        TextView price;
        ImageView iv;
    }

}
