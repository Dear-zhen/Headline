/*******************************************************************************
 * PROPRIETARY/CONFIDENTIAL
 * Copyright (c) 2004-2009 WisageTech 
 *
 * All rights reserved. This medium contains confidential and proprietary
 * source code and other information which is the exclusive property of
 * WisageTech.  None of these materials may be used,
 * disclosed, transcribed, stored in a retrieval system, translated into
 * any other language or other computer language, or transmitted in any form
 * or by any means (electronic, mechanical, photocopied, recorded or
 * otherwise) without the prior written permission of WisageTech.
 *******************************************************************************
 *
 * $Header: /iManage/Betty/mobile/MobileClient/Android/MobileClient/src/com/gearteks/imanage/util/DisplayUtil.java,v 1.1.2.3 2014/12/18 02:17:27 thomsontang Exp $
 * $Id: DisplayUtil.java,v 1.1.2.3 2014/12/18 02:17:27 thomsontang Exp $
 * $Author: thomsontang $
 * $Date: 2014/12/18 02:17:27 $
 * $Revision: 1.1.2.3 $
 *
 *******************************************************************************
 */
package com.dearzou.headline.util;

import android.content.Context;
import android.graphics.Paint;
import android.view.WindowManager;
import android.widget.TextView;


public class DisplayUtil {
   /**
    * 将px值转换为dip或dp值，保证尺寸大小不变
    * 
    * @param pxValue
    * @param scale
    *           （DisplayMetrics类中属性density）
    * @return
    */
   public static int px2dip(Context context, float pxValue) {
      final float scale = context.getResources().getDisplayMetrics().density;
      return (int) (pxValue / scale + 0.5f);
   }

   /**
    * 将dip或dp值转换为px值，保证尺寸大小不变
    * 
    * @param dipValue
    * @param scale
    *           （DisplayMetrics类中属性density）
    * @return
    */
   public static int dip2px(Context context, float dipValue) {
      final float scale = context.getResources().getDisplayMetrics().density;
      return (int) (dipValue * scale + 0.5f);
   }

   /**
    * 将px值转换为sp值，保证文字大小不变
    * 
    * @param pxValue
    * @param fontScale
    *           （DisplayMetrics类中属性scaledDensity）
    * @return
    */
   public static int px2sp(Context context, float pxValue) {
      final float scale = context.getResources().getDisplayMetrics().density;
      return (int) (pxValue / scale + 0.5f);
   }

   /**
    * 将sp值转换为px值，保证文字大小不变
    * 
    * @param spValue
    * @param fontScale
    *           （DisplayMetrics类中属性scaledDensity）
    * @return
    */
   public static int sp2px(Context context, float dipValue) {
      final float scale = context.getResources().getDisplayMetrics().density;
      return (int) (dipValue * scale + 0.5f);
   }

   /**
    * 判断TextView的文字长度
    * 
    * @param tv
    * @return
    */
   public static float measureTextLength(TextView tv) {
      Paint paint = new Paint();
      paint.setTextSize(tv.getTextSize());
      return paint.measureText(tv.getText() + "");
   }
   
   /**
    * 判断文字所需的长度
    * @param textSize
    * @param text
    * @return
    */
   public static float measureTextLength(float textSize, String text) {
      Paint paint = new Paint();
      paint.setTextSize(textSize);
      return paint.measureText(text);
   }

   /**
    * 判断TextView的文字内容是否超过最大行数（即出现。。。的情况）
    * @param tv
    * @param maxLines
    * @return
    */
   public static boolean isOverFlowed(TextView tv, int maxLines) {
      return (((int) measureTextLength((TextView) tv) + 0.5f) + ((TextView) tv).getPaddingLeft() + ((TextView) tv)
         .getPaddingRight()) / ((TextView) tv).getWidth() > maxLines;
   }
   
   public static boolean isOverFlowed(float textSize, String text, int width, int maxLines) {
      if (width == 0) {
         return false;
      }
      return ((int) measureTextLength(textSize, text) / width) > maxLines;
   }
   
   /**
    * 获取屏幕宽度
    * @param context
    * @return
    */
   public static int getWindowWidth(Context context) {
      return getWindowManager(context).getDefaultDisplay().getWidth(); 
   }
   
   /**
    * 获取屏幕高度
    * @param context
    * @return
    */
   public static int getWindowHeight(Context context) {
      return getWindowManager(context).getDefaultDisplay().getHeight(); 
   }
   
   
   /**
    * 获取WindowManager
    * @param context
    * @return
    */
   public static WindowManager getWindowManager(Context context) {
      return (WindowManager) context.getSystemService(Context.WINDOW_SERVICE); 
   }
   
}
