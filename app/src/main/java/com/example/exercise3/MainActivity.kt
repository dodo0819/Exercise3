package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        Toast.makeText(this@MainActivity,getString(R.string.insurance_premium)+ " " + spinnerAge.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerAge.onItemSelectedListener = this

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener(){
            calculateInsurance(it)
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener(){
            resetAll(it)
        }
    }

    private fun calculateInsurance(view:View){
        val insurance = findViewById<TextView>(R.id.textViewPremium)
        var premium = 0
        val age = spinnerAge.selectedItemPosition
        var gender = radioGroupGender.checkedRadioButtonId

        if(age == 0){
            premium += 60
        } else if (age == 1){
            premium += 70
        } else if (age == 2){
            premium += 90
        } else if (age == 3){
            premium += 120
        } else if(age == 4) {
            premium += 150
        } else
            premium += 150

        if(gender == R.id.radioButtonMale){
            if (age == 0){
                premium += 0
            } else if (age == 1){
                premium += 50
            } else if (age == 2){
                premium += 100
            } else if(age == 3){
                premium +=150
            } else if(age == 4) {
                premium += 200
            } else
                premium += 200
        }

        if(checkBoxSmoker.isChecked){
            if(age == 0){
                premium += 0
            } else if(age == 1){
                premium += 100
            } else if(age == 2){
                premium += 150
            } else if(age == 3){
                premium += 200
            } else if(age == 4){
                premium += 250
            } else
                premium += 300
        }
        insurance.text = getString(R.string.insurance_premium) + premium.toString()
    }

    private fun resetAll(view: View){
        val insurance = findViewById<TextView>(R.id.textViewPremium)

        spinnerAge.setSelection(0)
        radioGroupGender.clearCheck()
        checkBoxSmoker.isChecked = false
        insurance.setText(R.string.insurance_premium)
    }
}
