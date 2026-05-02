package com.example.caloru

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.example.caloru.ui.theme.CaloruTheme
import com.example.caloru.view.CaloruScreen


class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            LocalDatabase::class.java,
            "caloru.db"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaloruTheme {
                CaloruScreen()
            }
        }
    }
}
