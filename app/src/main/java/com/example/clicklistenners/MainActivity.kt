package com.example.clicklistenners

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private lateinit var restartButton: Button
    private lateinit var textView: TextView

    private var isYesClicked = true
    private var isNoClicked = true
    private val questions: List<String> = mutableListOf(
        "Вам понятен этот урок?",
        "Мне жаль. Посмотрим урок еще раз?",
        "Я рад, что все понятно. Продолжим?",
        "Ура!",
        "Тогда увидимся!"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        buttonClick()
    }

    private fun initViews() {
        yesButton = findViewById(R.id.yesButton)
        noButton = findViewById(R.id.noButton)
        textView = findViewById(R.id.textView)
        restartButton = findViewById(R.id.restartButton)
        textView.text = questions[0]
    }

    private fun buttonClick() {
        restartButton.setOnClickListener {
            textView.text = questions[0]
            isYesClicked = true
            isNoClicked = true
        }
        yesButton.setOnClickListener {
            if (isYesClicked) {
                textView.text = questions[2]
                isYesClicked = false
            } else {
                textView.text = questions[3]
                isYesClicked = true
            }
        }
        noButton.setOnClickListener {
            if (isNoClicked) {
                textView.text = questions[1]
                isNoClicked = false
            } else {
                textView.text = questions[4]
                isNoClicked = true
            }
        }
    }
}