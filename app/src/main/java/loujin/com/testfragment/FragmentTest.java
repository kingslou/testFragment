package loujin.com.testfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import fragments.FragmentOne;

/**
 * http://www.yrom.net/blog/2013/03/10/fragment-switch-not-restart/
 * http://developer.android.com/intl/zh-cn/guide/components/fragments.html
 * Created by jin on 2016.03.20.
 */
public class FragmentTest extends AppCompatActivity {

    private FrameLayout frameLayout;
    private TextView textContact;
    private TextView textCompany;
    private TextView textDept;

    private Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_test);
        frameLayout = (FrameLayout) findViewById(R.id.content);
        textContact = (TextView) findViewById(R.id.textContact);
        textCompany = (TextView) findViewById(R.id.textCompany);
        textDept = (TextView) findViewById(R.id.textDept);
        if (frameLayout == null) {
            if (savedInstanceState != null) {
                return;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.content, new FragmentOne()).commit();
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

    public void switchContent(Fragment from, Fragment to) {
        if (mContent != to) {
            mContent = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) {    // 先判断是否被add过
                transaction.hide(from).add(R.id.content, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }
}
