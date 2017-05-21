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


public class AttendanceActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_attendance);

        String semTitle = getIntent().getStringExtra(SemSelAttn.EXTRA_ITEM_TITLE);


        spinner=(ProgressBar)findViewById(R.id.progressBar3);
        webView = (WebView) findViewById(R.id.attendance_web);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new myWebclient());
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);


        String sem3 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1bSKCyk3nhpmVesOr1lH-7-bMpDwD7zKyQU0je4sy5T8/pubhtml?gid=880650812&single=true'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
        String sem4 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1JXYacWN3sRlf2yOTDaQp9f8JlABhZvbAEoDEzT7NUVQ/pubhtml?gid=718390919&single=true'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
        String sem5 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1bSKCyk3nhpmVesOr1lH-7-bMpDwD7zKyQU0je4sy5T8/pubhtml?gid=488542902&single=true'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
        String sem6 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1JXYacWN3sRlf2yOTDaQp9f8JlABhZvbAEoDEzT7NUVQ/pubhtml?gid=1529284797&single=true\n'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
        String sem7 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1bSKCyk3nhpmVesOr1lH-7-bMpDwD7zKyQU0je4sy5T8/pubhtml?gid=1861920494&single=true'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
        String sem8 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1JXYacWN3sRlf2yOTDaQp9f8JlABhZvbAEoDEzT7NUVQ/pubhtml?gid=581223720&single=true'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";


        if (semTitle.equalsIgnoreCase(SemSelAttn.semester_3))
        {
            webView.loadData(sem3,"text/html", "UTF-8");
        }

        else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_4))
        {
            webView.loadData(sem4,"text/html", "UTF-8");
        }

        else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_5))
        {
            webView.loadData(sem5,"text/html", "UTF-8");
        }

        else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_6))
        {
            webView.loadData(sem6,"text/html", "UTF-8");
        }

        else if (semTitle.equalsIgnoreCase(SemSelAttn.semester_7))
        {
            webView.loadData(sem7,"text/html", "UTF-8");
        }

        else
        {
            webView.loadData(sem8,"text/html", "UTF-8");
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
            webView.loadUrl( "javascript:window.location.reload(true)");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}

