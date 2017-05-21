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

public class AssignmentActivity extends AppCompatActivity {

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

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_assignment);

        String semTitle = getIntent().getStringExtra(SemSelAssignment.EXTRA_ITEM_TITLE);

        spinner=(ProgressBar)findViewById(R.id.progressBarAssgn);
        webView = (WebView) findViewById(R.id.assignment_web);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new myWebclient());
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        String sem3 = "https://drive.google.com/drive/folders/0BwGbXf5-HYCHamllSFRvMGt0T1k?usp=sharing";
        String sem4 = "https://drive.google.com/drive/folders/0BwGbXf5-HYCHVmotMjZtSWowams?usp=sharing";
        String sem5 = "https://drive.google.com/drive/folders/0BwGbXf5-HYCHcUNoVDQ0VmxLQzQ?usp=sharing";
        String sem6 = "https://drive.google.com/drive/folders/0BwGbXf5-HYCHZkZnRDIzWU5rMkk?usp=sharing";
        String sem7 = "https://drive.google.com/drive/folders/0BwGbXf5-HYCHMjJ0YnRCT0dKdWs?usp=sharing";
        String sem8 = "https://drive.google.com/drive/folders/0BwGbXf5-HYCHSFNaM0M0TUw5Vzg?usp=sharing";

        if (semTitle.equalsIgnoreCase(SemSelAssignment.semester_3))
        {
            webView.loadUrl(sem3);
        }

        else if (semTitle.equalsIgnoreCase(SemSelAssignment.semester_4))
        {
            webView.loadUrl(sem4);
        }

        else if (semTitle.equalsIgnoreCase(SemSelAssignment.semester_5))
        {
            webView.loadUrl(sem5);
        }

        else if (semTitle.equalsIgnoreCase(SemSelAssignment.semester_6))
        {
            webView.loadUrl(sem6);
        }

        else if (semTitle.equalsIgnoreCase(SemSelAssignment.semester_7))
        {
            webView.loadUrl(sem7);
        }

        else
        {
            webView.loadUrl(sem8);
        }


    }

    public class myWebclient extends WebViewClient{
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}

