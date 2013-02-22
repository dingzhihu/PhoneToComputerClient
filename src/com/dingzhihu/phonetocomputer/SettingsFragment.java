package com.dingzhihu.phonetocomputer;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created with IntelliJ IDEA.
 * User: dingzhihu
 * Date: 13-2-22
 * Time: 下午4:33
 */
public class SettingsFragment  extends PreferenceFragment{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

    }
}
