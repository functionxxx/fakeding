package com.tanmou.fakeding;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView midPicView = findViewById(R.id.midPic);

        //判断数据目录下是否存在a.png，若存在则显示该图片
        String midPicUrl = getExternalFilesDir(null).getAbsolutePath()+"/a.png";
        if(fileIsExists(midPicUrl)) {
            Bitmap bitmap = BitmapFactory.decodeFile(midPicUrl);
            midPicView.setImageBitmap(bitmap);
            /* TO_LIMIT_PICTURE_SIZE_FOR_HARDWARE_ACCELERATING
            int[] maxTextureSize = new int[1];
            // Get MaxTextureSize from Device
            GLES10.glGetIntegerv(GL10.GL_MAX_TEXTURE_SIZE, maxTextureSize, 0);
            if(bitmap.getWidth()<=maxTextureSize[0] && bitmap.getHeight()<=maxTextureSize[0]) {
                midPicView.setImageBitmap(bitmap);
            } else {
                Toast tips = Toast.makeText(this, null, Toast.LENGTH_SHORT);
                tips.setText("图像过大，无法显示");
                tips.show();
            } */
        }
    }
    public boolean fileIsExists(String strFile) {
        try {
            File f=new File(strFile);
            if(!f.exists()) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

