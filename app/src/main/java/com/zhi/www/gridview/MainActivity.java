package com.zhi.www.gridview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private GridView mGv;
    private MyAdapter mAdapter;
    private int[] images = new int[]{
            R.mipmap.icon_01,R.mipmap.icon_02, R.mipmap.icon_03,R.mipmap.icon_02,R.mipmap.icon_01,
            R.mipmap.icon_02,R.mipmap.icon_03,R.mipmap.icon_02,
    };
    private String[] titles = new String[]{
            "01号", "02号","03号","04号","05号","06号","07号","08号"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGv = (GridView) findViewById(R.id.gv);
        mAdapter = new MyAdapter(MainActivity.this);
        mGv.setAdapter(mAdapter);
    }

    class MyAdapter extends BaseAdapter{
        Context context;

        public MyAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(null == convertView){
                convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
                holder = new ViewHolder();
                holder.mIvImage = (ImageView) convertView.findViewById(R.id.iv_image);
                holder.mTvTitle = (TextView) convertView.findViewById(R.id.tv_title);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.mIvImage.setImageResource(images[position]);
            holder.mTvTitle.setText(titles[position]);
            return convertView;
        }
    }
    static class ViewHolder {
        ImageView mIvImage;
        TextView mTvTitle;
    }
}