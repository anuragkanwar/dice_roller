package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Anurag Kanwar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        findViewById<Button>(R.id.done_button).setOnClickListener{
//            addNickName(it)
//        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }


    private fun addNickName(callOnButton: View) {
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)
//
//        nickNameTextView.text = editText.text
//        editText.visibility = View.GONE
//        callOnButton.visibility = View.GONE
//        nickNameTextView.visibility = View.VISIBLE
        myName?.nickName = nickname_edit.text.toString()
        binding.invalidateAll()
        binding.nicknameText.text = binding.nicknameEdit.text
        binding.nicknameEdit.visibility = View.GONE
        binding.doneButton.visibility = View.GONE
        binding.nicknameText.visibility = View.GONE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(callOnButton.windowToken, 0)
    }
}
