package android.example.cookwithme

import android.os.Bundle

class DetailActivity : BaseActivity() {

    var id:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var intent = intent.getIntExtra("id", 0)


    }
}