package com.imageprocess;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * 图像处理类
 */

public class ImageProcessUtil {

    /**
     * 底片效果处理  算法  r = 255 - r, g = 255 - g, b = 255 - b
     * @param mBitmap 原图
     * @return 底片效果图
     */
    public static Bitmap getImagFromNegative(Bitmap mBitmap){
        //像素
        int color;
        //RGBA 代表红、绿、蓝、透明度
        int r, g, b, a;
        //生成一个bitmap
        Bitmap negativeBitmap = Bitmap.createBitmap(mBitmap.getWidth(),mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //原图像素集合
        int oldPixel[] = new int[mBitmap.getWidth() * mBitmap.getHeight()];
        //新的像素集合
        int newPixel[] = new int[mBitmap.getWidth() * mBitmap.getHeight()];
        /**
         * 参数
         * pixels  接收位图颜色值的数组
         * offset  写入到pixels[]中的第一个像素索引值
         * stride  pixels[]中的行间距个数值(必须大于等于位图宽度)。可以为负数
         * x      从位图中读取的第一个像素的x坐标值。
         * y      从位图中读取的第一个像素的y坐标值
         * width  从每一行中读取的像素宽度
         * height 读取的行数
         */
        mBitmap.getPixels(oldPixel,0,mBitmap.getWidth(),0,0,mBitmap.getWidth(),mBitmap.getHeight());
        //循环获取图片的像素
        for(int i = 0; i < oldPixel.length; i ++){
            //每个像素
            color = oldPixel[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);
            //计算新的RGBA
            r = 255 - r;
            g = 255 - g;
            b = 255 - b;
            r = processColorValue(r);
            g = processColorValue(g);
            b = processColorValue(b);
            //生成新的像素值
            color = Color.argb(a, r, g, b);
            newPixel[i] = color;
        }
        //将新生成的像素赋值给新的图片
        negativeBitmap.setPixels(newPixel,0,mBitmap.getWidth(),0,0,mBitmap.getWidth(),mBitmap.getHeight());
        //返回处理后的图片
        return negativeBitmap;
    }

    /**
     * 复古效果处理 算法 r = (int)(0.393 * r + 0.769 * g + 0.189 * b);g = (int)(0.349 * r + 0.686 * g + 0.168 * b);b = (int)(0.272 * r + 0.534 * g + 0.131 * b);
     * @param mBitmap 原图
     * @return 复古效果图
     */
    public static Bitmap getImagFromRetro(Bitmap mBitmap){
        //像素
        int color;
        //RGBA 代表红、绿、蓝、透明度
        int r, g, b, a;
        //生成一个bitmap
        Bitmap redroBitmap = Bitmap.createBitmap(mBitmap.getWidth(),mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //原图像素集合
        int oldPixel[] = new int[mBitmap.getWidth() * mBitmap.getHeight()];
        //新的像素集合
        int newPixel[] = new int[mBitmap.getWidth() * mBitmap.getHeight()];
        //获取图片的像素
        mBitmap.getPixels(oldPixel,0,mBitmap.getWidth(),0,0,mBitmap.getWidth(),mBitmap.getHeight());
        //循环获取图片的像素
        for(int i = 0; i < oldPixel.length; i ++){
            //每个像素
            color = oldPixel[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);
            //计算新的RGBA
            r = (int)(0.393 * r + 0.769 * g + 0.189 * b);
            g = (int)(0.349 * r + 0.686 * g + 0.168 * b);
            b = (int)(0.272 * r + 0.534 * g + 0.131 * b);
            r = processColorValue(r);
            g = processColorValue(g);
            b = processColorValue(b);
            //生成新的像素值
            color = Color.argb(a, r, g, b);
            newPixel[i] = color;
        }
        //将新生成的像素赋值给新的图片
        redroBitmap.setPixels(newPixel,0,mBitmap.getWidth(),0,0,mBitmap.getWidth(),mBitmap.getHeight());
        //返回处理后的图片
        return redroBitmap;
    }

    /**
     * 灰度效果处理 算法 r = (int)(r * 0.3 + g * 0.59 + b * 0.11);g = (int)(r * 0.3 + g * 0.59 + b * 0.11);b = (int)(r * 0.3 + g * 0.59 + b * 0.11);
     * @param mBitmap 原图
     * @return 灰度效果图
     */
    public static Bitmap getImagFromGrey(Bitmap mBitmap){
        //像素
        int color;
        //RGBA 代表红、绿、蓝、透明度
        int r, g, b, a;
        //生成一个bitmap
        Bitmap redroBitmap = Bitmap.createBitmap(mBitmap.getWidth(),mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //原图像素集合
        int oldPixel[] = new int[mBitmap.getWidth() * mBitmap.getHeight()];
        //新的像素集合
        int newPixel[] = new int[mBitmap.getWidth() * mBitmap.getHeight()];
        //获取图片的像素
        mBitmap.getPixels(oldPixel,0,mBitmap.getWidth(),0,0,mBitmap.getWidth(),mBitmap.getHeight());
        //循环获取图片的像素
        for(int i = 0; i < oldPixel.length; i ++){
            //每个像素
            color = oldPixel[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);
            //计算新的RGBA
            r = (int)(r * 0.3 + g * 0.59 + b * 0.11);
            g = (int)(r * 0.3 + g * 0.59 + b * 0.11);
            b = (int)(r * 0.3 + g * 0.59 + b * 0.11);
            r = processColorValue(r);
            g = processColorValue(g);
            b = processColorValue(b);
            //生成新的像素值
            color = Color.argb(a, r, g, b);
            newPixel[i] = color;
        }
        //将新生成的像素赋值给新的图片
        redroBitmap.setPixels(newPixel,0,mBitmap.getWidth(),0,0,mBitmap.getWidth(),mBitmap.getHeight());
        //返回处理后的图片
        return redroBitmap;
    }

    /**
     * 黑白效果处理 感觉不是太准确，可能有更好的算法
     * @param mBitmap 原图
     * @return 黑白效果图
     */
    public static Bitmap getImagFromBlackWhite(Bitmap mBitmap){
        //像素
        int color;
        //RGBA 代表红、绿、蓝、透明度
        int r, g, b, a;
        //平均值
        int agv;
        //生成一个bitmap
        Bitmap blackWhiteBitmap = Bitmap.createBitmap(mBitmap.getWidth(),mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //原图像素集合
        int oldPixel[] = new int[mBitmap.getWidth() * mBitmap.getHeight()];
        //新的像素集合
        int newPixel[] = new int[mBitmap.getWidth() * mBitmap.getHeight()];
        //获取图片的像素
        mBitmap.getPixels(oldPixel,0,mBitmap.getWidth(),0,0,mBitmap.getWidth(),mBitmap.getHeight());
        //循环获取图片的像素
        for(int i = 0; i < oldPixel.length; i ++){
            //每个像素
            color = oldPixel[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);
            //计算平均值
            agv = (r + g + b)/3;
            if(agv >= 128){ //128为经验值 也可以是100
                r = g = b = 255;
            }else {
                r = g = b = 0;
            }
            r = processColorValue(r);
            g = processColorValue(g);
            b = processColorValue(b);
            //生成新的像素值
            color = Color.argb(a, r, g, b);
            newPixel[i] = color;
        }
        //将新生成的像素赋值给新的图片
        blackWhiteBitmap.setPixels(newPixel,0,mBitmap.getWidth(),0,0,mBitmap.getWidth(),mBitmap.getHeight());
        //返回处理后的图片
        return blackWhiteBitmap;
    }

    /**
     * 浮雕效果处理 算法 r = (int)(nr - r + 128);g = (int)(ng - g + 128);b = (int)(nb - b + 128);
     * @param mBitmap 原图
     * @return 浮雕效果图
     */
    public static Bitmap getImagFromRelief(Bitmap mBitmap){
        //像素
        int color;
        //下一个像素
        int nextColor;
        //RGBA 代表红、绿、蓝、透明度
        int r, g, b, a;
        //下一个RGB
        int nr, ng, nb;
        //平均值
        int agv;
        //生成一个bitmap
        Bitmap reliefBitmap = Bitmap.createBitmap(mBitmap.getWidth(),mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //原图像素集合
        int oldPixel[] = new int[mBitmap.getWidth() * mBitmap.getHeight()];
        //新的像素集合
        int newPixel[] = new int[mBitmap.getWidth() * mBitmap.getHeight()];
        //获取图片的像素
        mBitmap.getPixels(oldPixel,0,mBitmap.getWidth(),0,0,mBitmap.getWidth(),mBitmap.getHeight());
        //循环获取图片的像素
        for(int i = 1; i < oldPixel.length; i ++){
            //下一个像素
            nextColor = oldPixel[i];
            //每个像素
            color = oldPixel[i - 1];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);
            nr = Color.red(nextColor);
            ng = Color.green(nextColor);
            nb = Color.blue(nextColor);
            //计算新的RGBA
            r = (int)(nr - r + 128);
            g = (int)(ng - g + 128);
            b = (int)(nb - b + 128);
            r = processColorValue(r);
            g = processColorValue(g);
            b = processColorValue(b);
            //生成新的像素值
            color = Color.argb(a, r, g, b);
            newPixel[i] = color;
        }
        //将新生成的像素赋值给新的图片
        reliefBitmap.setPixels(newPixel,0,mBitmap.getWidth(),0,0,mBitmap.getWidth(),mBitmap.getHeight());
        //返回处理后的图片
        return reliefBitmap;
    }

    /**
     * 将彩色图转换为纯黑白二色
     * @param  bmp 原图
     * @return 返回转换好的位图
     */
    public static Bitmap getImageToGreyWhite(Bitmap bmp) {
        int width = bmp.getWidth(); // 获取位图的宽
        int height = bmp.getHeight(); // 获取位图的高
        int[] pixels = new int[width * height]; // 通过位图的大小创建像素点数组

        bmp.getPixels(pixels, 0, width, 0, 0, width, height);
        int alpha = 0xFF << 24;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int grey = pixels[width * i + j];

                //分离三原色
                int red = ((grey & 0x00FF0000) >> 16);
                int green = ((grey & 0x0000FF00) >> 8);
                int blue = (grey & 0x000000FF);

                //转化成灰度像素
                grey = (int) (red * 0.3 + green * 0.59 + blue * 0.11);
                grey = alpha | (grey << 16) | (grey << 8) | grey;
                pixels[width * i + j] = grey;
            }
        }
        //新建图片
        Bitmap newBmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        //设置图片数据
        newBmp.setPixels(pixels, 0, width, 0, 0, width, height);

        return newBmp;
    }
    /**
     * 高斯模糊
     *
     * @param bmp
     * @return
     */
    public static Bitmap getImageToBlur(Bitmap bmp) {
        // 高斯矩阵
        int[] gauss = new int[] { 1, 2, 1, 2, 4, 2, 1, 2, 1 };

        int width = bmp.getWidth();
        int height = bmp.getHeight();
        Bitmap newBmp = Bitmap.createBitmap(width, height,
                Bitmap.Config.RGB_565);

        int pixR = 0;
        int pixG = 0;
        int pixB = 0;

        int pixColor = 0;

        int newR = 0;
        int newG = 0;
        int newB = 0;

        int delta = 16; // 值越小图片会越亮，越大则越暗

        int idx = 0;
        int[] pixels = new int[width * height];
        bmp.getPixels(pixels, 0, width, 0, 0, width, height);
        for (int i = 1, length = height - 1; i < length; i++) {
            for (int k = 1, len = width - 1; k < len; k++) {
                idx = 0;
                for (int m = -1; m <= 1; m++) {
                    for (int n = -1; n <= 1; n++) {
                        pixColor = pixels[(i + m) * width + k + n];
                        pixR = Color.red(pixColor);
                        pixG = Color.green(pixColor);
                        pixB = Color.blue(pixColor);

                        newR = newR + pixR * gauss[idx];
                        newG = newG + pixG * gauss[idx];
                        newB = newB + pixB * gauss[idx];
                        idx++;
                    }
                }

                newR /= delta;
                newG /= delta;
                newB /= delta;

                newR = Math.min(255, Math.max(0, newR));
                newG = Math.min(255, Math.max(0, newG));
                newB = Math.min(255, Math.max(0, newB));

                pixels[i * width + k] = Color.argb(255, newR, newG, newB);

                newR = 0;
                newG = 0;
                newB = 0;
            }
        }

        newBmp.setPixels(pixels, 0, width, 0, 0, width, height);

        return newBmp;
    }



    public static int processColorValue(int rgba){

        if(rgba > 255){
            rgba = 255;
        }
        return rgba;
    }

}
