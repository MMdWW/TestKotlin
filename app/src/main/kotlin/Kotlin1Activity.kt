package com.example.zxy.testmvvm.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.util.Util
import com.example.zxy.testmvvm.R
import com.example.zxy.testmvvm.model.MusicBean
import com.example.zxy.testmvvm.model.UserBean
import kotlinx.android.synthetic.main.activity_kotlin1.*
import java.util.*

class Kotlin1Activity : AppCompatActivity() {
    val url:String = "http://7xrnko.com1.z0.glb.clouddn.com/qiniu_andfix_2.png"
    val setTea: Set<String> = setOf("E", "F", "B", "C", "A", "D", "F", "B")

    val list=ArrayList<UserBean>()
    val list1=ArrayList<UserBean1>()
    val mlist=ArrayList<String>()
    val db: DBManager1?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin1)
        tv.text = "Hello MyKotlin"

        Glide.with(this).load(R.mipmap.ic_launcher).into(iv)

        btn.setOnClickListener { Toast.makeText(this, "aaa"+ list[1], Toast.LENGTH_SHORT).show() }
        checkbox.setOnCheckedChangeListener { buttonView, isChecked ->  Toast.makeText(this, "aaa"+ isChecked, Toast.LENGTH_SHORT).show()}
        url.toLowerCase();
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode==82){
            test()
        }
        return super.onKeyDown(keyCode, event)
    }

    fun test() {
        val u=UserBean()
        u.name.set("aaaa")
        u.sex.set("bbb")

        var i = 0;
        while(i < 5) {
            list.add(u)
            i++
        }

        for (user in list){
            LogUtils.d("user="+user.toString())
        }


    }

    fun test1(name: String) {}

    fun test2(): Boolean {
        return true
    }

    fun test3(): String? {
        return null
    }

    fun foo(param: Int) {

        val result = if (param == 1) {
            "one"
        } else if (param == 2) {
            "two"
        } else {
            "three"
        }
    }

    val music: List<MusicBean> get() {
        return music
    }
    val user: List<UserBean> get() {
        return user
    }


}
