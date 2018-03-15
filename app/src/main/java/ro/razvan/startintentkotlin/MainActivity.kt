package ro.razvan.startintentkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun firstWay(view: View) {
        val intent = Intent(this, EmptyActivity::class.java)
        startActivity(intent)
    }

    fun secondWay(view: View) {
        val intent = Intent("AZIONE_SPECIFICATA")
        startActivity(intent)
    }

    fun editDetails(view: View) {
        val intent = Intent(this, EditActivity::class.java)
        intent.putExtra(getString(R.string.extra_name), txvName!!.text)
        intent.putExtra(getString(R.string.extra_surname), txvSurname!!.text)

        startActivityForResult(intent, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && data != null) {

            when (requestCode) {
                0 -> {
                    txvName!!.text = data.getStringExtra(getString(R.string.extra_name))
                    txvSurname!!.text = data.getStringExtra(getString(R.string.extra_surname))
                    Toast.makeText(this, getString(R.string.done), Toast.LENGTH_SHORT).show()
                }
            }

        } else {
            Toast.makeText(this, getString(R.string.operation_canceled), Toast.LENGTH_SHORT).show()
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
