package net.androidbootcamp.homemortgageinterestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView monthlyPayment = (TextView)findViewById(R.id.txtPaymentMonthly);
        ImageView image = (ImageView)findViewById(R.id.imgYears);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        float intLoan = sharedPref.getFloat("key1",0);
        int intYears = sharedPref.getInt("key2",0);
        int intPrincipal = sharedPref.getInt("key3", 0);
        float totalInterest;

        totalInterest =  (intLoan * intYears * 12) - intPrincipal;
        DecimalFormat currency = new DecimalFormat("###,###.##");
        monthlyPayment.setText("Total Interest Paid " + currency.format(totalInterest));
        if(intYears == 10){
            image.setImageResource(R.drawable.ten);
        }else if (intYears == 20){
            image.setImageResource(R.drawable.twenty);
        }else if (intYears == 30){
            image.setImageResource(R.drawable.thirty);
        }else{
            monthlyPayment.setText("Enter 10, 20, or 30 years");
        }
    }
}
