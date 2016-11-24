package com.example.a5alumno.datastorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG_MAIN_ACTIVITY = "In-MainActivity";
    private static final String MY_SHARED_PREFERENCES = "MySharedPrefsKey";
    private static final String outputFilename = "internalStorageFile.txt";
    //private static final String outputFilename = "internalStorageFile2.txt";

    private TextView mHello_TxtView;
    private EditText mUpdate_EdtTxt;
    private SharedPreferences mSharedPrefs;
    private int mCurViewMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mHello_TxtView = (TextView) this.findViewById(R.id.textViewHello);
        this.mUpdate_EdtTxt = (EditText) this.findViewById(R.id.edtTextUpdate);
        final Button ok_Btn = (Button) this.findViewById(R.id.btnOk);
        final Button internalStorage_Btn = (Button) this.findViewById(R.id.btnInternalStorage);
        final Button externalStorage_Btn = (Button) this.findViewById(R.id.btnExternalStorage);
        final Button getFiles_Btn = (Button) this.findViewById(R.id.btnGetFiles);
        final Button createDB_Btn = (Button) this.findViewById(R.id.btnDataBase);

        ok_Btn.setOnClickListener(this);
        internalStorage_Btn.setOnClickListener(this);
        externalStorage_Btn.setOnClickListener(this);
        getFiles_Btn.setOnClickListener(this);
        createDB_Btn.setOnClickListener(this);

        //Comprobamos si hay datos en las Shared Preferences y los cargamos en caso que los haya
        SharedPreferences mSettings = this.getSharedPreferences(MainActivity.MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        String mString = mSettings.getString("myStringKey", "");
        if (!mString.isEmpty()) {
            Log.i(MainActivity.TAG_MAIN_ACTIVITY, "SharedPreferences available: " + mString);
            this.mHello_TxtView.setText(mString);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = mSharedPrefs.edit();
        editor.putInt("view_mode", mCurViewMode);
        editor.apply();
    }

    @Override
    public void onClick(View view) {

    }
}
