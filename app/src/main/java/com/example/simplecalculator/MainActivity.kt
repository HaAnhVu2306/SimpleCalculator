package com.example.simplecalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.simplecalculator.ui.theme.SimpleCalculatorTheme

class MainActivity : ComponentActivity() {
    private var operator: Operator = Operator.NONE
    private var isOperatorClicked: Boolean = false
    private var operand1: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun Clear(view: View){
        val textoutput: TextView = findViewById(R.id.TV)
        textoutput.text= ""
        operand1 = 0
    }
    fun CE(view: View){
        val textoutput: TextView = findViewById(R.id.TV)
        textoutput.text= ""
    }
    fun BS(view: View){
        val textoutput: TextView = findViewById(R.id.TV)
        val length = textoutput.length()
        if(length>1)
            textoutput.text = textoutput.text.subSequence(0,length-1)
        else
            textoutput.text ="0"
    }
    fun numberAction(view: View){
        if(view is Button)
        {
            val textoutput: TextView = findViewById(R.id.TV)
            if(isOperatorClicked){
                val textoutput: TextView = findViewById(R.id.TV)
                operand1 = textoutput.text.toString().toInt()
                textoutput.text= ""
                isOperatorClicked =false
            }
            textoutput.append(view.text)
        }
    }
    fun operatorButtonClickplus(view: View){
        operator = Operator.ADD
        isOperatorClicked = true
    }
    fun operatorButtonClickminus(view: View){
        operator = Operator.SUB
        isOperatorClicked = true
    }
    fun operatorButtonClickmul(view: View){
        operator = Operator.MUL
        isOperatorClicked = true
    }
    fun operatorButtonClickdiv(view: View){
        operator = Operator.DIV
        isOperatorClicked = true
    }
    fun equalsAction(view: View){
        val textoutput: TextView = findViewById(R.id.TV)
        val operand2 = textoutput.text.toString().toInt()
        val result: Int
        when(operator){
            Operator.ADD -> result = operand1 + operand2
            Operator.SUB -> result = operand1 - operand2
            Operator.MUL -> result = operand1 * operand2
            Operator.DIV -> result = operand1 / operand2
            else -> result = 0
        }
        textoutput.text= result.toString()
        isOperatorClicked = true
    }
}

enum class Operator {ADD, SUB, MUL, DIV, NONE}

