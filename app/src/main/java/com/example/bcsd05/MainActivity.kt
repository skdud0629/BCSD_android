package com.example.bcsd05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var DIALOGbutton : Button = findViewById(R.id.DialogButton)
        var COUNTbutton : Button = findViewById(R.id.CntButton)

        val outputtext : TextView= findViewById<TextView>(R.id.CntView)
        var num=0;

        var RANDOMbutton : Button = findViewById(R.id.RandomButton)

        DIALOGbutton.setOnClickListener{
            Toast.makeText(this@MainActivity,"Toast message",Toast.LENGTH_SHORT).show()
        }

        COUNTbutton.setOnClickListener{
            num++
            outputtext.setText(num.toString())

        }
        RANDOMbutton.setOnClickListener{

            val bundle: Bundle=Bundle()//데이터를 담을 객체 생성
            val number: String=outputtext.text.toString()
            bundle.putString("number",number)//데이터 담기
            val subFragment:SubFragment=SubFragment()//프래그먼트 선언
            subFragment.arguments=bundle //프래그먼트에 데이터 넘기기

            val manager:FragmentManager=supportFragmentManager
            val transaction:FragmentTransaction= manager.beginTransaction()

            transaction.add(R.id.frameLayout, subFragment)
            transaction.addToBackStack(null)
            transaction.commit()

            // transaction.replace(R.id.frameLayout,subFragment).commit()//프래그먼트 화면에 보여주기

        }

    }

}