package com.example.youban.placeholder;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.youban.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderPerson {

    public static final List<PlaceholderPer> PERS = new ArrayList<PlaceholderPer>();

    private static final int COUNT = 10;

    static {
        for (int i = 1; i <= COUNT; i++) {
            addPer(createPlaceholderPer(i));
        }
    }

    private static void addPer(PlaceholderPer per) {
        PERS.add(per);
    }

    private static PlaceholderPer createPlaceholderPer(int position) {
        Bitmap bitmap = BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.tem3);
        return new PlaceholderPer(String.valueOf(position),bitmap, "name"+position,"2020.10.11","yourfather"+position);
    }



    public static class PlaceholderPer {
        public final String id;
        public final Bitmap bitmap;
        public final String name;
        public final String information;
        public final String time;


        public PlaceholderPer(String id,Bitmap bitmap,String name,String time,String information) {
            this.id = id;
            this.bitmap = bitmap;
            this.name = name;
            this.time = time;
            this.information = information;
        }
    }
}