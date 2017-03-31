package com.imageprocess;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

    //原图、底片、复古、灰度、黑白、浮雕
    private ImageView mOriginalImage,mNegativeImage,mRetroImage,mGreyImage,mBlackWhiteImage,mReliefImage,mGreyWhiteImage,mBlurImage;

    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOriginalImage = (ImageView)findViewById(R.id.image_process_original);
        mNegativeImage = (ImageView)findViewById(R.id.image_process_negative);
        mRetroImage = (ImageView)findViewById(R.id.image_process_retro);
        mGreyImage = (ImageView)findViewById(R.id.image_process_grey);
        mBlackWhiteImage = (ImageView)findViewById(R.id.image_process_black_white);
        mReliefImage = (ImageView)findViewById(R.id.image_process_relief);
        mGreyWhiteImage = (ImageView)findViewById(R.id.image_process_grey_white);
        mBlurImage = (ImageView)findViewById(R.id.image_process_blur);

        mBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.beautiful_girl);

        //原图
        mOriginalImage.setImageBitmap(mBitmap);
        //底片
        mNegativeImage.setImageBitmap(ImageProcessUtil.getImagFromNegative(mBitmap));
        //复古
        mRetroImage.setImageBitmap(ImageProcessUtil.getImagFromRetro(mBitmap));
        //灰度
        mGreyImage.setImageBitmap(ImageProcessUtil.getImagFromGrey(mBitmap));
        //黑白
        mBlackWhiteImage.setImageBitmap(ImageProcessUtil.getImagFromBlackWhite(mBitmap));
        //浮雕
        mReliefImage.setImageBitmap(ImageProcessUtil.getImagFromRelief(mBitmap));
        //灰白
        mGreyWhiteImage.setImageBitmap(ImageProcessUtil.getImageToGreyWhite(mBitmap));
        //高斯模糊
        mBlurImage.setImageBitmap(ImageProcessUtil.getImageToBlur(mBitmap));
    }
}
