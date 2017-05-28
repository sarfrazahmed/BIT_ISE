package informationscience.bitise;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class FeedbackSelectorActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM_TITLE = "extra.item.title";
    public static final String student = "sf";
    public static final String customer = "cf";
    public static final String course = "ce";
    public static final String employer = "es";
    public static final String alumni = "af";
    public static final String events = "ef";



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




        setContentView(R.layout.activity_feedback_selector);

        Button student = (Button) findViewById(R.id.sf);
        Button customer = (Button) findViewById(R.id.cf);
        Button course = (Button) findViewById(R.id.ce);
        Button employer = (Button) findViewById(R.id.es);
        Button alumni = (Button) findViewById(R.id.af);
        Button events = (Button) findViewById(R.id.ef);


        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(FeedbackSelectorActivity.student);
            }
        });
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(FeedbackSelectorActivity.customer);
            }
        });

        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(FeedbackSelectorActivity.course);
            }
        });

        employer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(FeedbackSelectorActivity.employer);
            }
        });

        alumni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(FeedbackSelectorActivity.alumni);
            }
        });

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(FeedbackSelectorActivity.events);
            }
        });

    }



    private void loadDetailActivity(String choice) {
        Intent intent = new Intent(FeedbackSelectorActivity.this, FeedbackActivity.class);
        intent.putExtra(FeedbackSelectorActivity.EXTRA_ITEM_TITLE, choice);
        startActivity(intent);

    }
}
