package cn.innk.android_res;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by ronny on 17-5-23.
 */

public class Login extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnclose = (Button) findViewById(R.id.btn3);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Button btn2 = (Button) findViewById(R.id.btn2);
//                btn2.setText("登陆成功");
                finish();
//                TIPS: finish() 为点击事件响应的关闭方法
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private Button btnclose;
}
