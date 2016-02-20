package artya.com.codaline_02.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import artya.com.codaline_02.R;

/**
 * Created by artya on 13.02.16.
 */
public class MainActivity extends FragmentActivity{

    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    SharedPreferences.Editor editor;
    String n;
    EditText fieldForInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);


    }

    //Counting symbols
    public void onClickCalculate(View view){
        fieldForInput = (EditText) findViewById(R.id.field_for_input);
        TextView txtCountOfSymbols = (TextView) findViewById(R.id.txt_count_of_symbols);

        //next line is not optimal and I know it :)
        txtCountOfSymbols.setText(String.valueOf(fieldForInput.getText().toString().length()));

    }

    //processing BACK key
    private static long back_pressed;

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
            super.onBackPressed();
        else
            Toast.makeText(getBaseContext(), R.string.exit_toast,
                    Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        n = fieldForInput.getText().toString();
        editor = sharedpreferences.edit();
        editor.putString(Name, n).apply();
        editor.commit();
        Toast.makeText(MainActivity.this,"Text saved",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }


    // не виходить отримати збережений рядок
    @Override
    protected void onStart() {
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        // не  виходить прив’язати fieldForInput = sharedpreferences.getString(MyPREFERENCES, n);
        //не знайю, що ротиби тут
        sharedpreferences.getString(MyPREFERENCES, n);


        //fieldForInput.setText(String.valueOf(sharedpreferences)); - вилітає exeption

        super.onStart();
    }
}
