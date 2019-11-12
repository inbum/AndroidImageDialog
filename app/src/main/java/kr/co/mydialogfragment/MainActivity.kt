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
                "https://dummyimage.com/600x400/ffea00/070924",
                "https://dummyimage.com/300x400/ffea00/070924",
                "https://dummyimage.com/1200x400/ffea00/070924",
                "https://dummyimage.com/200x1400/ffea00/070924"
            ))
            imageDialogFragment.show(fm, "ImageDialogFragment")
        }
    }
}
