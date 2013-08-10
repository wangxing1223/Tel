package com.example.Tel;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private static final int item1 = Menu.FIRST;
    private static final int item2 = Menu.FIRST +1;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        imageView = (ImageView) findViewById(R.id.imageView);
        registerForContextMenu(imageView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,item1,0,"打电话");
        menu.add(0,item2,0,"发短信");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int i = item.getItemId();
        switch (i){
            case item1:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel: 13546352324" ));
                startActivity(intent);
                break;
            case item2:
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_SENDTO);
                intent1.setData(Uri.parse("smsto: 13546352324" ));
                intent1.putExtra("sms_body","welcome to .....");
                startActivity(intent1);
                break;
        }
        return true;

    }


}
