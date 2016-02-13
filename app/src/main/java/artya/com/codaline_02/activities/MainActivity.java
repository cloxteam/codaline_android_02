package artya.com.codaline_02.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import artya.com.codaline_02.R;

/**
 * Created by artya on 13.02.16.
 */
public class MainActivity extends FragmentActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }

    //Counting symbols
    public void onClickCalculate(View view){
        EditText fieldForInput = (EditText) findViewById(R.id.field_for_input);
        TextView txtCountOfSymbols = (TextView) findViewById(R.id.txt_count_of_symbols);

        //next line is not optimal and I know it :)
        txtCountOfSymbols.setText("Total count of symbols: " + String.valueOf(fieldForInput.getText().toString().length()));
    }

    //processing BACK key
    private static long back_pressed;

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
            super.onBackPressed();
        else
            Toast.makeText(getBaseContext(), "Press once again to exit!",
                    Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }
}
