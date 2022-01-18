package com.example.agecalculator

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener{ view->
            printAge(view)

        }
    }

    private fun printAge(view: View)
    {
        var myCalender = Calendar.getInstance()
        var year = myCalender.get(Calendar.YEAR)
        var month = myCalender.get(Calendar.MONTH)
        var day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this
            , DatePickerDialog.OnDateSetListener{
                view, year, month, day ->

                val selectedDate = "$day/${month + 1}/$year"
                textView2.text = selectedDate

                var dob = Calendar.getInstance()
                dob.set(year, month, day)

                var age = myCalender.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
                if(myCalender.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
                {
                    age--
                }

                textView4.text = "You are $age year old"
                                                }
            , year
            , month
            , day).show()
    }
}