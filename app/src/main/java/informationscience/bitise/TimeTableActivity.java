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


public class TimeTableActivity extends AppCompatActivity {

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


        setContentView(R.layout.activity_time_table);

        String semTitle = getIntent().getStringExtra(SemSelAssignment.EXTRA_ITEM_TITLE);



        spinner=(ProgressBar)findViewById(R.id.progressBarTT);
        webView = (WebView) findViewById(R.id.timetable_web);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new myWebclient());
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        String sem3 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1CeFG1ZhHvpKNSx5dqbMHl6qXl4miaE0wTKfi5kflRC4/pubhtml?gid=769704244&single=true'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
        String sem4 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1ek8VWvyYz3ODRSCMe_IxOw0Zwzb9R5UkPhk1utpZvRE/pubhtml?gid=892204099&single=true'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
        String sem5 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1CeFG1ZhHvpKNSx5dqbMHl6qXl4miaE0wTKfi5kflRC4/pubhtml?gid=1221603951&single=true'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
        String sem6 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1ek8VWvyYz3ODRSCMe_IxOw0Zwzb9R5UkPhk1utpZvRE/pubhtml?gid=1539666479&single=true'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
        String sem7 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1CeFG1ZhHvpKNSx5dqbMHl6qXl4miaE0wTKfi5kflRC4/pubhtml?gid=968777206&single=true'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
        String sem8 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1ek8VWvyYz3ODRSCMe_IxOw0Zwzb9R5UkPhk1utpZvRE/pubhtml?gid=1105887063&single=true'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";


        if (semTitle.equalsIgnoreCase(SemSelTT.semester_3))
        {
            webView.loadData(sem3,"text/html", "UTF-8");
        }

        else if (semTitle.equalsIgnoreCase(SemSelTT.semester_4))
        {
            webView.loadData(sem4,"text/html", "UTF-8");
        }

        else if (semTitle.equalsIgnoreCase(SemSelTT.semester_5))
        {
            webView.loadData(sem5,"text/html", "UTF-8");
        }

        else if (semTitle.equalsIgnoreCase(SemSelTT.semester_6))
        {
            webView.loadData(sem6,"text/html", "UTF-8");
        }

        else if (semTitle.equalsIgnoreCase(SemSelTT.semester_7))
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


