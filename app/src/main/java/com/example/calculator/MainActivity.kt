package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import javax.xml.xpath.XPathExpression

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvone.setOnClickListener{(append(string = "1", clear = true))}
        tvtwo.setOnClickListener{(append(string = "2", clear = true))}
        tvthree.setOnClickListener{(append(string = "3", clear = true))}
        tvfour.setOnClickListener{(append(string = "4", clear = true))}
        tvfive.setOnClickListener{(append(string = "5", clear = true))}
        tvsix.setOnClickListener{(append(string = "6", clear = true))}
        seven.setOnClickListener{(append(string = "7", clear = true))}
        tveight.setOnClickListener{(append(string = "8", clear = true))}
        tvnine.setOnClickListener{(append(string = "9", clear = true))}
        tvdot.setOnClickListener{(append(string = ".", clear = true))}
        tvzero.setOnClickListener{(append(string = "0", clear = true))}


        plus.setOnClickListener{(append(string = "+", clear = true))}
        tvmul.setOnClickListener{(append(string = "*", clear = true))}
        minus.setOnClickListener{(append(string = "-", clear = true))}
        tvdivide.setOnClickListener{(append(string = "/", clear = true))}
        tvopen.setOnClickListener{(append(string = "(", clear = true))}
        tvclose.setOnClickListener{(append(string = ")", clear = true))}
        tvCE.setOnClickListener{
            tvresult.text = ""
            tvExpression.text = ""
        }
        tvback.setOnClickListener{
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text =string.substring(0,string.length-1)
            }
            tvresult.text = ""
        }
        equals.setOnClickListener{
            try{
            val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longresult = result.toLong()
                if(result == longresult.toDouble())
                    tvresult.text = longresult.toString()
                else
                    tvresult.text = result.toString()
            } catch (e:Exception) {
                Log.d("Exception","message : " + e.message)
            }
        }


    }
    fun append(string:String, clear : Boolean){
        if (tvresult.text.isNotEmpty()){
         tvExpression.text = ""
        }
        if (clear) {
            tvresult.text = ""
            tvExpression.append(string)
        }else{
            tvExpression.append(tvresult.text)
            tvExpression.append(string)
            tvresult.text =" "
        }

    }
}
