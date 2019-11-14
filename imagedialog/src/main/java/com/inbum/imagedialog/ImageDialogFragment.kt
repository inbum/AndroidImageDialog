package com.inbum.imagedialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_image_dialog.*
import java.util.ArrayList

class ImageDialogFragment : DialogFragment() {

    private lateinit var imgList: ArrayList<String>

    companion object {
        private const val EXTRA_IMG_URLS = "extra_img_urls"

        fun newInstance(imgUrlList : java.util.ArrayList<String>) : ImageDialogFragment {
            val args = Bundle()
            args.putStringArrayList(EXTRA_IMG_URLS, imgUrlList)
            val dialog = ImageDialogFragment()
            dialog.arguments = args
            return dialog
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args = arguments
        imgList = args?.getStringArrayList(EXTRA_IMG_URLS) as ArrayList<String>

        // 스타일 적용
        setStyle(STYLE_NORMAL, R.style.CustomFullDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_dialog, container, false)
    }

    override fun onResume() {

        val params = dialog?.window?.attributes
        params?.width = ViewGroup.LayoutParams.MATCH_PARENT
        params?.height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog?.window?.attributes = params
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imgbtn_close.setOnClickListener {
            dismiss()
        }

        val adapter = ImageViewPagerAdapter(imgList)
        viewpager?.adapter = adapter
        text_position.text = String.format("%d / %d", 1, imgList.size)
        viewpager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPageSelected(position: Int) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                text_position.text = String.format("%d / %d", position + 1, imgList.size);
            }
        })
    }
}