package informationscience.bitise;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class FeedbackActivity extends AppCompatActivity {

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

        setContentView(R.layout.activity_feedback);

        String choice = getIntent().getStringExtra(FeedbackSelectorActivity.EXTRA_ITEM_TITLE);


        webView = (WebView) findViewById(R.id.web_feedback);
        spinner=(ProgressBar)findViewById(R.id.progressBarFeedback);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSaveFormData(true);
        webView.setWebViewClient(new myWebclient());

        String sflink = "https://docs.google.com/forms/d/e/1FAIpQLSfIrKPPql665tMp3ZYbEK5VgNSfhGvAvg__UeUUfC0RIrrbfg/viewform?usp=sf_link";
        String cflink = "https://docs.google.com/forms/d/e/1FAIpQLSdO97AQvMZuJ2uV1LevIsnA-8LlwvlvIYH7EnZx9jacoHQE8A/viewform?usp=sf_link";
        String celink = "https://docs.google.com/forms/d/e/1FAIpQLSfjNCTuBd2JUdIIQosbm_N3KlbgXyMsapyW0LqjgCnz01eJDg/viewform?usp=sf_link";
        String eslink = "https://docs.google.com/forms/d/e/1FAIpQLSd_pywS0cVEOs9-avieUib4wligQAa7ZHdhH1a64rg6m4qd7A/viewform?usp=sf_link";
        String aflink = "https://docs.google.com/forms/d/e/1FAIpQLSes0zhlpOiicMdkgg70vEAQPLxPh8suHl--7s4S4RzQ40IGMA/viewform?usp=sf_link";
        String eflink = "https://docs.google.com/forms/d/e/1FAIpQLSd4bfqiDuZJWlZ9jFj7Aze3yr_1STLRPIwawoLTbH9NVwetag/viewform?usp=sf_link";

        if (choice.equalsIgnoreCase(FeedbackSelectorActivity.student))
        {
            webView.loadUrl(sflink);
        }

        else if (choice.equalsIgnoreCase(FeedbackSelectorActivity.customer))
        {
            webView.loadUrl(cflink);
        }

        else if (choice.equalsIgnoreCase(FeedbackSelectorActivity.course))
        {
            webView.loadUrl(celink);
        }

        else if (choice.equalsIgnoreCase(FeedbackSelectorActivity.employer))
        {
            webView.loadUrl(eslink);
        }

        else if (choice.equalsIgnoreCase(FeedbackSelectorActivity.alumni))
        {
            webView.loadUrl(aflink);
        }

        else
        {
            webView.loadUrl(eflink);
        }

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
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl (url);
            return true;
        }




    }
}
