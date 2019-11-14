package kr.co.mydialogfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inbum.imagedialog.ImageDialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener{
            val fm = supportFragmentManager
            val imageDialogFragment = ImageDialogFragment.newInstance(arrayListOf(
                "http://lorempixel.com/1800/1100/animals",
                "http://lorempixel.com/410/1900/cats",
                "http://lorempixel.com/1910/555/sports"
            ))
            imageDialogFragment
            imageDialogFragment.show(fm, "ImageDialogFragment")
        }
    }
}
