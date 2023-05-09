package com.example.bcsd05

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback


class SubFragment : Fragment() {

    private lateinit var callback: OnBackPressedCallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_sub,container,false)

//        객체생성
        val randomNum: TextView= view.findViewById(R.id.CntView)

//        넘어온 숫자를 변수에 담기
        val number:String?=this.arguments?.getString("number")

        val ran= (0..number!!.toInt())
        val random=ran.random()

//        randomnum텍스트 뷰에 값 넣기
        randomNum.text=random.toString()

        return view
    }
//

    override fun onAttach(context:Context){
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                //Fragment삭제
                // parentFragmentManager.beginTransaction().remove(this@SubFragment).commit()
                parentFragmentManager.popBackStack()
                val fragment = parentFragmentManager.findFragmentByTag(TAG)
                if (fragment != null) {
                    parentFragmentManager.beginTransaction()
                        .remove(fragment)
                        .commit()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }
}