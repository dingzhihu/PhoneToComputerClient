package com.dingzhihu.phonetocomputer;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final int SELECT_IMG = 1;
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

    private String parseImgPath(Uri uri) {
        String[] projection = {MediaStore.MediaColumns.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int index = cursor
                .getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();

        return cursor.getString(index);
    }


}
