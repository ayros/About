package com.ayros.about

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.ayros.about.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val user: User = User("Alex")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //findViewById<Button>(R.id.button).setOnClickListener {
        //    addNickname(it)
        //}
        binding.user = user
        binding.button.setOnClickListener {
            addNickname(it)
        }
    }


    private fun addNickname(view: View) {

        binding.apply {
            user?.nickname = editTextTextPersonName.text.toString()
            invalidateAll()
            editTextTextPersonName.visibility = View.GONE
            button.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}