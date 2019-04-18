package app.demo.com.webapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.net.ConnectException;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.index);
        //WebView webView = findViewById(R.id.webView);
        //webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("https://www.naver.com/");
        final Context _this = Index.this;
        LinearLayout frame = new LinearLayout(_this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        frame.setLayoutParams(params);
        WebView webView = new WebView(_this);
        webView.setLayoutParams(params);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient());
        webView.addJavascriptInterface(new Object(){
            @android.webkit.JavascriptInterface
            public void showToast(String msg){
                Toast.makeText(_this,msg, Toast.LENGTH_LONG).show();
            }

        },"hybrid");
        webView.loadUrl("file:///android_asset/www/index.html");
        frame.addView(webView);
        setContentView(frame);


    }


}
