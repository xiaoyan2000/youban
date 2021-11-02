package com.example.youban.placeholder;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.youban.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();

    private static final int COUNT = 10;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPlaceholderItem(i));
        }
    }

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PlaceholderItem createPlaceholderItem(int position) {
        Bitmap bitmap = BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.tem3);
        return new PlaceholderItem(String.valueOf(position),bitmap, "Item " ,"2020.10.11","China","20" );
    }


    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {
        public final String id;
        public final Bitmap bitmap;
        public final String name;
        public final String time;
        public final String address;
        public final String num_people;

        public PlaceholderItem(String id,Bitmap bitmap,String name,String time,String address,String num_people) {
            this.id = id;
            this.bitmap = bitmap;
            this.name = name;
            this.time = time;
            this.address = address;
            this.num_people = num_people;
        }
    }
}