package ro.razvan.startintentkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.content_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        tilName.editText!!.setText(intent.getStringExtra(getString(R.string.extra_name)))
        tilSurname.editText!!.setText(intent.getStringExtra(getString(R.string.extra_surname)))

        fab.setOnClickListener {
            tilName!!.error = null
            tilSurname!!.error = null
            val txtName = tilName!!.editText!!.text.toString().trim()
            if (txtName.isNotEmpty()) {
                val txtSurname = tilSurname!!.editText!!.text.toString().trim()
                if (txtSurname.isNotEmpty()) {
                    val response = Intent()
                    response.putExtra(getString(R.string.extra_surname), txtSurname)
                    response.putExtra(getString(R.string.extra_name), txtName)
                    setResult(Activity.RESULT_OK, response)
                    finish()
                } else
                    tilSurname!!.error = getString(R.string.fill_this_field)
            } else
                tilName!!.error = getString(R.string.fill_this_field)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }
}
