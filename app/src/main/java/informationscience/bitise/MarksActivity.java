package informationscience.bitise;

import android.app.ActionBar;
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


        public class MarksActivity extends AppCompatActivity {

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


                setContentView(R.layout.activity_marks);

                String semTitle = getIntent().getStringExtra(SemSelAssignment.EXTRA_ITEM_TITLE);



                spinner=(ProgressBar)findViewById(R.id.MarksBar3);
                webView = (WebView) findViewById(R.id.marks_web);
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webView.setWebViewClient(new myWebclient());
                webSettings.setBuiltInZoomControls(true);
                webSettings.setSupportZoom(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.setUseWideViewPort(true);

                String sem3 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1vVUodurI5G9sSK8yXPs2vnY8aNS17qMSA2uVnsi0SPg/pubhtml'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
                String sem4 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1r-EZ3Ds2T4ernsw-fPwHYvDMrFvhXpa__LqFYHC4kP8/pubhtml'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
                String sem5 = "<html><iframe src='https://docs.google.com/spreadsheets/d/19rj0otjSDQ92PLoPPv7V5eTJ-RXM3N8-AsYZ6IFF4kA/pubhtml'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
                String sem6 = "<html><iframe src='https://docs.google.com/spreadsheets/d/13D0SCMJkWZ2P_H0vqKiYud0l0kWaR4NRPbvoOO8Bl2E/pubhtml'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
                String sem7 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1sx3QzzzbutpW1CEHGp645VVjVXbSZ_devx8Rxq2Bxyk/pubhtml'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";
                String sem8 = "<html><iframe src='https://docs.google.com/spreadsheets/d/1ZGI82azFxxDK0GNVmiyiML10YuhDbp7AfDCPpOSHQPc/pubhtml'&embedded='true' width='100%' height='100%' frameborder='0'></iframe></html>";


                if (semTitle.equalsIgnoreCase(SemSelMarks.semester_3))
                {
                    webView.loadData(sem3,"text/html", "UTF-8");
                }

                else if (semTitle.equalsIgnoreCase(SemSelMarks.semester_4))
                {
                    webView.loadData(sem4,"text/html", "UTF-8");
                }

                else if (semTitle.equalsIgnoreCase(SemSelMarks.semester_5))
                {
                    webView.loadData(sem5,"text/html", "UTF-8");
                }

                else if (semTitle.equalsIgnoreCase(SemSelMarks.semester_6))
                {
                    webView.loadData(sem6,"text/html", "UTF-8");
                }

                else if (semTitle.equalsIgnoreCase(SemSelMarks.semester_7))
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
