package modanov.test.project2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val APP_PREFERENCES = "mysettings"
    private val APP_PREFERENCES_STRING = "inputed_text"
    lateinit var pref: SharedPreferences
    private var str=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        btnSave.setOnClickListener {
            saveText()
        }
        btnShow.setOnClickListener {
            showSavedText()
        }
    }


    private fun saveText() {
        var strTemp = editText.text.toString()
        val editor = pref.edit()
        editor.putString(APP_PREFERENCES_STRING,strTemp)
        editor.apply()
    }

    private fun showSavedText() {
        if (pref.contains(APP_PREFERENCES_STRING)){
            str = pref.getString(APP_PREFERENCES_STRING,"").toString()
            editText.setText(str)
        }
    }
}

