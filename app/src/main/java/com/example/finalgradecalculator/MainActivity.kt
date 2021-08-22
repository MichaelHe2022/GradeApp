package com.example.finalgradecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.currGrade)
        val num2 = findViewById<EditText>(R.id.whatPercentage)
        val num3 = findViewById<EditText>(R.id.desiredGrade)
        val b1 = findViewById<Button>(R.id.button)

        b1.setOnClickListener() {
            val current = num1.text.toString().toDouble()
            val desired = num3.text.toString().toDouble()
            val percentage = num2.text.toString().toDouble()
            val result = calculate(current, desired, percentage)
            resultText.text = selector(result, desired)
        }
    }


    /*
      @param current : current grade
      @param desired : desired grade
      @param percentage : what % of total grade is the final
     */
    fun calculate(current: Double, desired: Double, percentage: Double) : Double {
        val difference = desired - current;
        val pointWorth = 100.0 / percentage;
        val needed = current + (difference * pointWorth)

        return needed
    }

    fun selector(result : Double, desired : Double) : String {
        if(result < 30.0) {
            return "You need a " + result + "% on the final to get a " + desired + "% overall. You don't need to study, go play video games"
        }
        else if(result >= 30.0 && result < 50.0 ) {
            return "You need a " + result + "% on the final to get a " + desired + "% overall. You can focus on other classes"
        }
        else if( result > 100) {
            return "You need a " + result + "% on the final to get a " + desired + "% overall. It's impossible, aim for a lower grade"
        }
        else if(result >= 50.0 && result < 70.0) {
            return "You need a " + result + "% on the final to get a " + desired + "% overall. You'll be fine even if you only study a little bit"
        }
        else {
            return "You need a " + result + "% on the final to get a " + desired + "% overall. Good Luck!"
        }
    }




}