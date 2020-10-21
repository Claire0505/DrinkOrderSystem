package com.example.drinkordersystem

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //建立onActivityResult接收返回資料
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //判斷Intent不為空，並檢查是否夾帶資料
        data?.extras?.let {
            //驗證發出對象，確認 Main2Activity 執行的狀態
            if (requestCode == 1 && resultCode == Activity.RESULT_OK){
                //讀取Bundle資料
                tv_meal.text = String.format("飲料: ${it.getString("drink")}\n\n" +
                        "甜度: ${it.getString("sugar")}\n\n" +
                        "冰塊: ${it.getString("ice")}")
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        choiceMenu()
    }

    private fun choiceMenu() {
        //透過Intent切換至Main2Activity並傳遞 requestCode 來記錄發出者
        btn_choice.setOnClickListener {
            startActivityForResult(Intent(this, Main2Activity::class.java), 1)
        }
    }
}