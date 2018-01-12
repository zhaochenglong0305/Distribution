package distribution.xiaomei.lit.com.distribution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fyjr.baselibrary.base.BaseActivity;

import distribution.xiaomei.lit.com.distribution.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this,R.layout.activity_main);
    }

    @Override
    public void initView() {
        super.initView();
    }
}
