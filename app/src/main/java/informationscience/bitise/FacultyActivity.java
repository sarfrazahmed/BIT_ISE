package informationscience.bitise;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class FacultyActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.buttoncolordark));
            window.setNavigationBarColor(getResources().getColor(R.color.buttoncolordark));
        }


        setContentView(R.layout.activity_faculty);

        spinner = (ProgressBar) findViewById(R.id.progressBar2);
        webView = (WebView) findViewById(R.id.fac_webview);
        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new myWebclient());
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);


        webView.loadUrl("file:///android_asset/FacultyDocx.htm");

    }
        public class myWebclient extends WebViewClient {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                spinner.setVisibility(View.GONE);
            }

            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
        }


        @Override
        public boolean onKeyDown ( int keyCode, KeyEvent event){
            if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
                this.webView.goBack();
                webView.loadUrl("javascript:window.location.reload(true)");
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }

}
