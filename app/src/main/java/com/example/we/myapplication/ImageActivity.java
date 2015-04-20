package com.example.we.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by ByunghooLim on 15. 4. 20..
 */
public class ImageActivity extends Activity {
    private PhotoView mBarcode;
    private String mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);

        mBarcode = (PhotoView) findViewById(R.id.imageView);

        mPath = getIntent().getExtras().getString("PATH");
    }

    @Override
    public void onResume() {
        super.onResume();
        loadImage();
    }

    private void loadImage() {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bm = BitmapFactory.decodeFile(mPath, options);

            mBarcode.setImageBitmap(bm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
