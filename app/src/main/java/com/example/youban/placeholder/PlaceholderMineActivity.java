package com.example.youban.placeholder;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.youban.R;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderMineActivity {
    public static final List<PlaceholderMin> ACTS = new ArrayList<>();

    private static final int COUNT = 10;

    static {
        for (int i = 1; i <= COUNT; i++) {
            addPer(createPlaceholderMineActivity(i));
        }
    }

    private static void addPer(PlaceholderMin min) {
        ACTS.add(min);
    }

    private static PlaceholderMineActivity.PlaceholderMin createPlaceholderMineActivity(int position) {
        Bitmap bitmap = BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.tem3);
        return new PlaceholderMineActivity.PlaceholderMin(String.valueOf(position),bitmap,"name","2021.01.01","活动内容活动内容",bitmap,bitmap,bitmap,"北京长阳去","0");
    }

    public static class PlaceholderMin {
        public final String id;
        public final Bitmap phead;
        public final String name;
        public final String time;
        public final String content;
        public final Bitmap aimage1;
        public final Bitmap aimage2;
        public final Bitmap aimage3;
        public final String location;
        public final String goodnumber;
        public PlaceholderMin(String id, Bitmap phead, String name, String time, String content, Bitmap aimage1, Bitmap aimage2, Bitmap aimage3, String location, String goodnumber) {
            this.id = id;
            this.phead = phead;
            this.name = name;
            this.time = time;
            this.content = content;
            this.aimage1 = aimage1;
            this.aimage2 = aimage2;
            this.aimage3 = aimage3;
            this.location = location;
            this.goodnumber = goodnumber;
        }
    }
}
