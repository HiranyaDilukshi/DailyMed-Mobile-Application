package com.united.dailymed;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class changeActivities extends AppCompatActivity {

    Dialog myDialog;
    Button btngotopopup;
    Button btnChangeTips;
    Button btnDailyActivities;
    RadioGroup rgNewActivities;
    Button btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupactivities);

    }

        /********************************************* POP UP TO CHANGE Activities ********************************************************/
    public void changeActivities(View view) {

        btnDailyActivities = findViewById(R.id.btnActivities);
        btnReset = findViewById(R.id.btnSetGender);
        rgNewActivities = findViewById(R.id.GenderGroup);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivities(rgNewActivities);//calling update method to change the time
                Toast.makeText(getApplicationContext(), "Update Success", Toast.LENGTH_SHORT).show();

            }
        });


    }//end of on click

    /********************************************* UPDATE METHOD TO CHANGE Activities ********************************************************/
    public void changeActivities(RadioGroup rgNewActivities) {
        WaterDBHandler waterdbhandler = new WaterDBHandler(this);
        //System.out.println("Look here 2");
        // System.out.println(rgNewTime);
        RadioButton radioButton = findViewById(rgNewActivities.getCheckedRadioButtonId());
        //System.out.println("look here 3:"+radioButton.getText().toString());

        //calling the update method in db helper
        long val = waterdbhandler.updateActivities((radioButton.getText().toString()));

        if (val > 0) {
            Intent i = new Intent(changeActivities.this, Waterdashboard.class);
            startActivity(i);

        } else {
            Toast.makeText(this, "Update Failed", Toast.LENGTH_SHORT).show();

        }
    }//end of method

}






//    /* THE UPDATE GOAL METHOD **/
//    @SuppressLint("ShowToast")
//    public void updateTotal(View view) {
//        //getting the ids of required components
//        edtTotal = findViewById(R.id.editTextTotal);
//        btnResetTotal = findViewById(R.id.btnUpdateTotal);
//        //instance of db
//        WaterDBHandler waterdbhandler = new WaterDBHandler(this);
//        //converting to String
//        Double total = Double.parseDouble(edtTotal.getText().toString());
//        //validation
//        if (!total.isNaN()) {
//
//            Double tot = Double.parseDouble(edtTotal.getText().toString());
//            long val = waterdbhandler.updateTotal(tot);
//
//            if (val > 0) {
//                Intent i = new Intent(changeTotal.this, Waterdashboard.class);
//                Toast.makeText(getApplicationContext(), "Updated!!", Toast.LENGTH_SHORT).show();
//                startActivity(i);
//                //myDialog.dismiss();
//            } else {
//                Intent i = new Intent(changeTotal.this, Changewatersettings.class);
//                Toast.makeText(this, "Failed to update!!", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(changeTotal.this, "Please enter Total!", Toast.LENGTH_SHORT);
//        }
//
//
//        /* UPDATING AMOUNT WHEN A NEW AMOUNT IS ADDED */
//        Double drankAlready = waterdbhandler.getDrank();
//        // Double totDrank = (Double.parseDouble(txtCoffee.getText().toString())*0.8)+drankAlready;
//
//        //Double amt = Double.parseDouble(txtCoffee.getText().toString());
//
//        Double totDrank = calcDrank(drankAlready);
//
//        Double remainingAlready = waterdbhandler.getRemainingAmt();
//        Double totRemaining = calRemaining(total,drankAlready);
//        // Double totRemaining = remainingAlready - (Double.parseDouble(txtCoffee.getText().toString())*0.8);
//
//
//        int val = waterdbhandler.updateInfo(totDrank, totRemaining);
//
//        if (val > 0) {
//
//            Intent i = new Intent(changeTotal.this, Waterdashboard.class);
//            startActivity(i);
//
//        } else {
//            Toast.makeText(this, "Could Not update! ", Toast.LENGTH_SHORT).show();
//        }
//    }//end of method
//
//    /* CALCULATING THE DRANK AMOUNT */
//    public Double calcDrank(Double drankAlready) {
//        return (drankAlready);
//    }
//
//    /* CALCULATING THE REMAINING AMOUNT **/
//    public Double calRemaining(Double amt,Double drankAlready) {
//        return ((amt-(drankAlready)));
//    }
//
//}