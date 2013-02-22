package com.dingzhihu.phonetocomputer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final int SELECT_IMG = 1;
    private static final String KEY_PREF_HOST = "pref_host";

    private String mImgPath;
    private EditText mText;
    private Button mImg;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mText = (EditText) findViewById(R.id.text);
        mImg = (Button) findViewById(R.id.img);
        mImg.setOnClickListener(this);

        findViewById(R.id.go).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        if (id == R.id.img) {
            selectImg();

        } else if (id == R.id.go) {
            upload();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMG && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            mImgPath = parseImgPath(uri);
            mImg.setText(mImgPath);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void selectImg() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, SELECT_IMG);

    }

    private void upload() {

        if (TextUtils.isEmpty(mText.getText()) && TextUtils.isEmpty(mImgPath)) {
            return;
        }



        if (!TextUtils.isEmpty(mText.getText())) {

        }

        if (!TextUtils.isEmpty(mImgPath)) {

        }

    }

    private String getHost() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        return pref.getString(KEY_PREF_HOST, getString(R.string.default_host));
    }

    private String parseImgPath(Uri uri) {
        String[] projection = {MediaStore.MediaColumns.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int index = cursor
                .getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();

        return cursor.getString(index);
    }


}
