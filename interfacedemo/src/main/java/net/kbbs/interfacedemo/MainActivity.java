package net.kbbs.interfacedemo;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import net.kbbs.interfacedemo.bird.Bird;
import net.kbbs.interfacedemo.bird.BirdInfo;
import net.kbbs.interfacedemo.calculator.Calculator;
import net.kbbs.interfacedemo.calculator.MyCalculator;
import net.kbbs.interfacedemo.callback.OnInfoFetchCallback;

public class MainActivity extends AppCompatActivity implements OnInfoFetchCallback{

    private static final String TAG = "RonnyMainActivity";
    private static final int MSG_SET_TEXT_COLOR_GREEN = 0;
    private static final int MSG_SET_BACKGROUND_COLOR_YELLOW = 1;
    private static final int MSG_SET_TEXT_CONTENT = 2;

    private InfoService mInfoService;
    private MainHandler mHandler;
    private Button btnGetInfo,btnWaitChange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInfoService = new InfoService(this);
        mHandler = new MainHandler();
        btnGetInfo = (Button)findViewById(R.id.btn_getinfo);
        btnWaitChange = (Button)findViewById(R.id.btn_waitchange);


        btnGetInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "will exe fetchInfo");
                fetchInfo();
                Log.i(TAG, "pass fetchInfo");
            }
        });


        //---------bird interface
        BirdInfo bInfo = new Bird();
        bInfo.getBirdInfo();
        //---------calculator interface
        Calculator calc = new MyCalculator();
        Log.i(TAG, "calculator 3*7 is " + calc.mul(3,7));
    }


    public void fetchInfo() {
        Log.i(TAG, "将调用InfoService的getInfo方法去创建一个子线程执行耗时任务，然后执行完回调onSuccess接口");
        mInfoService.getInfo();
    }

    @Override
    public void onSuccess(String info) throws InterruptedException {
        Log.i(TAG, info);
        Log.i(TAG, "onSuccess will sendEmptyMessage to set button style !");
        mHandler.sendEmptyMessage(MSG_SET_TEXT_COLOR_GREEN);
        mHandler.sendEmptyMessage(MSG_SET_BACKGROUND_COLOR_YELLOW);
        mHandler.sendEmptyMessage(MSG_SET_TEXT_CONTENT);
        Thread.sleep(1000);
        Log.i(TAG, "onSuccess over!");
    }

    @Override
    public void onFailure() {
        Log.w(TAG,"获取信息失败!");
    }

    public class MainHandler extends Handler {
        public MainHandler() {
            Log.i(TAG, "init MainHandler");
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SET_TEXT_COLOR_GREEN:
                    Log.i(TAG, "on handleMessage case : MSG_SET_TEXT_COLOR_GREEN!");
                    btnWaitChange.setTextColor(Color.GREEN);
                    break;
                case MSG_SET_BACKGROUND_COLOR_YELLOW:
                    Log.i(TAG, "on handleMessage case : MSG_SET_BACKGROUND_COLOR_YELLOW!");
                    btnWaitChange.setBackgroundColor(Color.YELLOW);
                    break;
                case MSG_SET_TEXT_CONTENT:
                    Log.i(TAG, "on handleMessage case : MSG_SET_TEXT_CONTENT!");
                    btnWaitChange.setText("我已换装");
                    break;
            }
        }
    }
}
