package com.jackhidle.connectionutil;

import android.content.Context;
import android.util.Log;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

public class AdUtils {
    public static InterstitialAd interstitial;
    public static boolean checked = false;
    public static boolean isInternetConnection = false;

    public static void loadInterstitial(Context context) {
        Log.d("FBAudience", "Start to load Interstitial Ads");
        interstitial = new InterstitialAd(context, context.getString(R.string.facebook_interstitial_start_id));
        // Set listeners for the Interstitial Ad
        interstitial.setAdListener(new InterstitialAdListener() {

            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("FBAudience", "Interstitial Ads load error: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("FBAudience", "Interstitial Ads load successful");
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
            }
        });
        AdSettings.addTestDevice("e7b47d119b5ee13341325ad8ec48f628");
        interstitial.loadAd();
    }

    public static void showInterstitial(Context context) {
        if (interstitial != null && interstitial.isAdLoaded()) {
            interstitial.show();
            loadInterstitial(context);
        }
    }
}
