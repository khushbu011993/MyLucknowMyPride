package com.example.think.mylucknowmypride ;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
/**
 * Created by THINK on 1/4/2016.
 */
public class ImageAdaptermonuments extends BaseAdapter{
    private Context mcontext;
    public Integer[] mpics= {R.drawable.baraimambara1, R.drawable.chotaimmambara,R.drawable.satkhanda,
            R.drawable.shahibawli,R.drawable.rumidarwaza,R.drawable.chatar,R.drawable.chotaimmambara,
            R.drawable.tomb,R.drawable.tomb2,R.drawable.jamamasjid,R.drawable.residency,R.drawable.shahnazaf
    };

    public ImageAdaptermonuments(Context c){
        mcontext = c;
    }

    @Override
    public int getCount() {
        return mpics.length;
    }

    @Override
    public Object getItem(int position) {
        return mpics[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mcontext);
        imageView.setImageResource(mpics[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
    }

}
