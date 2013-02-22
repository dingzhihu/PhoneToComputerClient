package com.dingzhihu.phonetocomputer;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * Created with IntelliJ IDEA.
 * User: dingzhihu
 * Date: 13-2-22
 * Time: 下午4:34
 */
public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        getFragmentManager().beginTransaction()
                .replace(R.id.content, new SettingsFragment())
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
