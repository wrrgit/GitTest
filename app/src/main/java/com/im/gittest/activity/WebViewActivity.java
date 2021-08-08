package com.im.gittest.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.im.gittest.R;

public class WebViewActivity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebView = findViewById(R.id.web_view);
        mWebView.getSettings();
        //得到webview设置
        WebSettings webSettings = mWebView.getSettings();
        //允许使用javascript
        webSettings.setJavaScriptEnabled(true);
        //设置字符编码
        webSettings.setDefaultTextEncodingName("UTF-8");
        //支持缩放
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        //将WebAppInterface与javascript绑定
        //mWebView.addJavascriptInterface(new PaymentJavaScriptInterface(),"Android");
        //android assets目录下html文件路径url为 file:///android_asset/profile.html
        String url = "file:///android_asset/" + "百度一下，你就知道.html";
        mWebView.loadUrl(url);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onResume() {
        super.onResume();
        if ((getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
            mWebView.getSettings().setForceDark(WebSettings.FORCE_DARK_ON);
        } else {
            mWebView.getSettings().setForceDark(WebSettings.FORCE_DARK_OFF);
        }
    }
}