package xyz.godi.popularmovies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import xyz.godi.popularmovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).also { binding = it}.root )
    }
}