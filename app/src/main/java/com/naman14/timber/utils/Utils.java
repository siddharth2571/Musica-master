package com.naman14.timber.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.naman14.timber.R;

/**
 * Created by siddharth on 10/4/2015.
 */
public class Utils {

    public static boolean isConnectingToInternet(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conMgr != null) {
            NetworkInfo[] info = conMgr.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }

    public static void InterstitialAdLodingandShow(Context ctx) {
        final InterstitialAd interstitialAd = new InterstitialAd(ctx);
        interstitialAd.setAdUnitId(ctx.getString(R.string.Interstial_admob));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                interstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.

            }
        });
    }


    public static InterstitialAd newInterstitialAd(Context ctx) {
        InterstitialAd interstitialAd = new InterstitialAd(ctx);
        interstitialAd.setAdUnitId(ctx.getString(R.string.Interstial_admob));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.

            }
        });
        return interstitialAd;
    }

    public static InterstitialAd adverd;

    public static void Adloaded(final Context ctx) {
        try {
           adverd = new InterstitialAd(ctx);
            adverd.setAdUnitId(ctx.getString(R.string.Interstial_admob));
            adverd.loadAd(new AdRequest.Builder().build());
            adverd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    adverd.show();
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {

                }

                @Override
                public void onAdClosed() {
                    // Proceed to the next level.
//                    requestNewInterstitial();
//                    adverd.setAdUnitId(ctx.getString(R.string.Interstial_admob));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void requestNewInterstitial() {

        AdRequest adRequest = new AdRequest.Builder().build();
        adverd.loadAd(adRequest);

    }


}
