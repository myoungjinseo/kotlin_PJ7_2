package com.cookandroid.project7_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var baselayout: LinearLayout

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "배경색 바꾸기(컨텍스트 메뉴)"
        baselayout = findViewById<LinearLayout>(R.id.baselayout)
        button1 = findViewById<Button>(R.id.button1)
        registerForContextMenu(button1)
        button2 = findViewById<Button>(R.id.button2)
        registerForContextMenu(button2)
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View,
                                     menuInfo: ContextMenu.ContextMenuInfo?) {

        super.onCreateContextMenu(menu, v, menuInfo)

        if (v === button1) {
            menu.setHeaderTitle("배경색 변경")
            menu.add(0, 1, 0, "배경색 (빨강)")
            menu.add(0, 2, 0, "배경색 (초록)")
            menu.add(0, 3, 0, "배경색 (파랑)")

        }
        if (v === button2) {
            menu.add(0, 4, 0, "버튼 45도 회전")
            menu.add(0, 5, 0, "버튼 2배 확대")
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            1 -> {
                baselayout.setBackgroundColor(Color.RED)
                return true
            }
            2 -> {
                baselayout.setBackgroundColor(Color.GREEN)
                return true
            }
            3 -> {
                baselayout.setBackgroundColor(Color.BLUE)
                return true
            }
            4 -> {
                button2.rotation = 45f
                return true
            }
            5 -> {
                button2.scaleX = 2f
                return true
            }
        }
        return false
    }

}
