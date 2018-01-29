package com.ns.ctrl;

import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import com.ns.Splash.R;
import com.unity3d.player.UnityPlayer;

public class SplashMgr
{
    private  static SplashMgr instance = null;
    public  static  SplashMgr GetInstance()
    {
        if(instance == null)
        {
            instance = new SplashMgr();
        }
        return  instance;
    }

    private  SplashMgr(){}

    private UnityPlayer mUnityPlayer;
    private ImageView bgImg;

    public void SetSplash(UnityPlayer unityPlayer)
    {
        mUnityPlayer = unityPlayer;
        bgImg = new ImageView(unityPlayer.currentActivity);
        bgImg.setBackgroundResource(R.drawable.loadingsplash);
        bgImg.setScaleType(ImageView.ScaleType.FIT_XY);
        unityPlayer.addView(bgImg);
    }

    public void HideSplash(UnityPlayer unityPlayer)
    {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                if(bgImg != null)
                {
                    mUnityPlayer.removeView(bgImg);
                    bgImg = null;
                }
            }
        });
    }
}
