package net.androidbootcamp.homemortgageinterestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.DoubleBuffer;

public class MainActivity extends AppCompatActivity {

    float intLoan;
    int intYears;
    int intPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText loan = (EditText)findViewById(R.id.txtMonthlyPayment);
        final EditText years = (EditText)findViewById(R.id.txtYears);
        final EditText principal = (EditText)findViewById(R.id.txtPrincipal);
        Button compute = (Button)findViewById(R.id.btnCompute);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intLoan = Float.parseFloat(loan.getText().toString());
                intYears = Integer.parseInt(years.getText().toString());
                intPrincipal = Integer.parseInt(principal.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("key1", intLoan);
                editor.putInt("key2", intYears);
                editor.putInt("key3", intPrincipal);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Payment.class));

            }
        });
    }
}
