package informationscience.bitise;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class SemSelMarks extends AppCompatActivity {


    public static final String EXTRA_ITEM_TITLE = "extra.item.title";
    public static final String semester_3 = "third";
    public static final String semester_4 = "fourth";
    public static final String semester_5 = "fifth";
    public static final String semester_6 = "sixth";
    public static final String semester_7 = "seventh";
    public static final String semester_8 = "eighth";

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




        setContentView(R.layout.activity_sem_sel_marks);

        Button sem3 = (Button) findViewById(R.id.sem3marks);
        Button sem4 = (Button) findViewById(R.id.sem4marks);
        Button sem5 = (Button) findViewById(R.id.sem5marks);
        Button sem6 = (Button) findViewById(R.id.sem6marks);
        Button sem7 = (Button) findViewById(R.id.sem7marks);
        Button sem8 = (Button) findViewById(R.id.sem8marks);

        sem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(SemSelMarks.semester_3);
            }
        });

        sem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(SemSelMarks.semester_4);
            }
        });

        sem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(SemSelMarks.semester_5);
            }
        });

        sem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(SemSelMarks.semester_6);
            }
        });

        sem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(SemSelMarks.semester_7);
            }
        });

        sem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDetailActivity(SemSelMarks.semester_8);
            }
        });

    }


    private void loadDetailActivity(String semTitle) {
        Intent intent = new Intent(SemSelMarks.this, MarksActivity.class);
        intent.putExtra(SemSelMarks.EXTRA_ITEM_TITLE, semTitle);
        startActivity(intent);

    }
}
