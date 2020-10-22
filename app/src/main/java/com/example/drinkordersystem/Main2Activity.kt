package com.example.drinkordersystem

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //餐點送出
        mealSend()

    }

    private fun mealSend() {
        btn_send.setOnClickListener {
            if ( ed_drink.length() < 1) {
                Toast.makeText(this, "請輸入飲料名稱", Toast.LENGTH_SHORT).show()
            } else {
                //宣告Bundle
                val bundle = Bundle()
                //取得EditText字串內容，把飲料名稱資訊甜度與冰塊資訊放入Bundle
                bundle.putString("drink", ed_drink.text.toString())

                bundle.putString("sugar", sugarRadioGroup.findViewById<RadioButton>
                (sugarRadioGroup.checkedRadioButtonId).text.toString())

                bundle.putString("ice", iceRadioGroup.findViewById<RadioButton>
                (iceRadioGroup.checkedRadioButtonId).text.toString())
                
                //透過 setResult 將資料傳回
                //用Activity.RESULT_OK 標記執行狀態並記錄Intent
                setResult(Activity.RESULT_OK, Intent().putExtras(bundle))
                finish()
            }
        }
    }
}