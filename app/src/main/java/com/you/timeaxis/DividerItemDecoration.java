package com.you.timeaxis;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by youxuan on 2017/6/13 0013.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {


    //画左边字的画笔
    private Paint mPaint;

    //画左边日期字的画笔(时间+日期)

    private Paint mPaint1;
    private Paint mPaint2;

    // 左 上偏移的长度
    private int item_leftInterval;
    private int item_topInterval;

    //轴点半径
    private int circle_radius;

    //图标
    private Bitmap mIcon;


    public DividerItemDecoration(Context context) {
        //轴点颜色
        mPaint = new Paint();
        mPaint.setColor(Color.RED);

        //左边时间文本画笔(蓝色)
        mPaint1 = new Paint();
        mPaint1.setColor(Color.BLUE);
        mPaint1.setTextSize(30);

        mPaint2 = new Paint();
        mPaint2.setColor(Color.BLUE);

        item_topInterval = 50;
        item_leftInterval = 200;

        circle_radius = 10;

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(item_leftInterval,item_topInterval,0,0);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        //获取RecyclerView的child view的个数

        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {

            View child = parent.getChildAt(i);

            //绘制轴点
            float centerx = child.getLeft() - item_leftInterval / 3;
            float centery = child.getTop() - item_topInterval + (item_topInterval + child.getHeight()) / 2;

            // 绘制轴点圆
            c.drawCircle(centerx, centery, circle_radius, mPaint);


            /**
             * 绘制上半轴线
             */
            // 上端点坐标(x,y)
            float upLine_up_x = centerx;
            float upLine_up_y = child.getTop() - item_topInterval;

            // 下端点坐标(x,y)
            float upLine_bottom_x = centerx;
            float upLine_bottom_y = centery - circle_radius;

            //绘制上半部轴线
            c.drawLine(upLine_up_x, upLine_up_y, upLine_bottom_x, upLine_bottom_y, mPaint);

            /**
             * 绘制下半轴线
             */
            // 上端点坐标(x,y)
            float bottomLine_up_x = centerx;
            float bottom_up_y = centery + circle_radius;

            // 下端点坐标(x,y)
            float bottomLine_bottom_x = centerx;
            float bottomLine_bottom_y = child.getBottom();

            //绘制下半部轴线
            c.drawLine(bottomLine_up_x, bottom_up_y, bottomLine_bottom_x, bottomLine_bottom_y, mPaint);

            /**
             * 绘制左边时间文本
             */
            // 获取每个Item的位置
            int index = parent.getChildAdapterPosition(child);
            // 设置文本起始坐标
            float Text_x = child.getLeft() - item_leftInterval * 5 / 6;
            float Text_y = upLine_bottom_y;


            // 根据Item位置设置时间文本
            switch (index) {
                case (0):
                    // 设置日期绘制位置
                    c.drawText("13:40", Text_x, Text_y, mPaint1);
                    c.drawText("2017.4.03", Text_x + 5, Text_y + 20, mPaint2);
                    break;
                case (1):
                    // 设置日期绘制位置
                    c.drawText("17:33", Text_x, Text_y, mPaint1);
                    c.drawText("2017.4.03", Text_x + 5, Text_y + 20, mPaint2);
                    break;
                case (2):
                    // 设置日期绘制位置
                    c.drawText("20:13", Text_x, Text_y, mPaint1);
                    c.drawText("2017.4.03", Text_x + 5, Text_y + 20, mPaint2);
                    break;
                case (3):
                    // 设置日期绘制位置
                    c.drawText("11:40", Text_x, Text_y, mPaint1);
                    c.drawText("2017.4.04", Text_x + 5, Text_y + 20, mPaint2);
                    break;
                case (4):
                    // 设置日期绘制位置
                    c.drawText("13:20", Text_x, Text_y, mPaint1);
                    c.drawText("2017.4.04", Text_x + 5, Text_y + 20, mPaint2);
                    break;
                case (5):
                    // 设置日期绘制位置
                    c.drawText("22:40", Text_x, Text_y, mPaint1);
                    c.drawText("2017.4.04", Text_x + 5, Text_y + 20, mPaint2);
                    break;
                default:c.drawText("已签收", Text_x, Text_y, mPaint1);
            }
        }
    }
}
