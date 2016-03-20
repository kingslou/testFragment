package loujin.com.testfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import fragments.FragmentOne;

/**
 * Created by jin on 2016.03.20.
 */
public class FragmentTest extends AppCompatActivity {

    private FrameLayout frameLayout;
    private TextView textContact;
    private TextView textCompany;
    private TextView textDept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_test);
        frameLayout = (FrameLayout) findViewById(R.id.content);
        textContact = (TextView)findViewById(R.id.textContact);
        textCompany = (TextView)findViewById(R.id.textCompany);
        textDept = (TextView)findViewById(R.id.textDept);
        if (frameLayout == null) {
            if (savedInstanceState != null) {
                return;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.content,new FragmentOne()).commit();
        }

        textContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textDept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
