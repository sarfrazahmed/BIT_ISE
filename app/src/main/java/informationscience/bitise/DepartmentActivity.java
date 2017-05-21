package informationscience.bitise;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DepartmentActivity extends AppCompatActivity {

    private WebView webView;

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

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_department);



        webView = (WebView) findViewById(R.id.webview_dept);


        webView.loadUrl("file:///android_asset/ISE.html");
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setSaveFormData(true);

            webView.getSettings().setBuiltInZoomControls(true);

            webView.setWebViewClient(new MyWebViewClient());
    }
			
			private class MyWebViewClient extends WebViewClient
{ 
    @Override 
    //show the web page in webview but not in web browser
    public boolean shouldOverrideUrlLoading(WebView view, String url) { 
        view.loadUrl (url); 
        return true;
    }
}




}
