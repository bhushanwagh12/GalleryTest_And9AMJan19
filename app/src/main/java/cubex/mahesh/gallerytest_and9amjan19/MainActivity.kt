package cubex.mahesh.gallerytest_and9amjan19

import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.indiview.view.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var path = "/storage/sdcard0/GBWhatsApp/Media/GBWhatsApp Images/Sent/"
        var file = File(path)
        if(!file.exists()){
            path = "/storage/emulated/0/GBWhatsApp/Media/GBWhatsApp Images/Sent/"
            file = File(path)
        }
        var files = file.listFiles()


        gallery1.adapter = object : BaseAdapter() {
            override fun getCount(): Int = files.size

            override fun getItem(p0: Int): Any = 0

            override fun getItemId(p0: Int): Long = 0

            override fun getView(pos: Int, p1: View?, p2: ViewGroup?): View {

                var inflater = LayoutInflater.from(
                                                                                    this@MainActivity)
                var v = inflater.inflate(R.layout.indiview, null)

                var file = files[pos]
                var bmp  = BitmapFactory.decodeFile(file.path)
                var tBmp = ThumbnailUtils.extractThumbnail(bmp,
                                                    300,300)
                v.iview.setImageBitmap(tBmp)
                v.name. text = file.name
                return  v
            }
        }



    }



}
