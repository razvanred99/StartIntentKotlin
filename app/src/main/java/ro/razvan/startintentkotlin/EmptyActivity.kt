package ro.razvan.startintentkotlin

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem

class EmptyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {

        val dialog = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert)
        else AlertDialog.Builder(this)

        dialog.setMessage(getString(R.string.are_you_sure))
                .setIcon(android.R.drawable.stat_sys_warning)
                .setPositiveButton(android.R.string.yes) { dialogInterface, _ ->
                    run {
                        super@EmptyActivity.onBackPressed()
                        dialogInterface.dismiss()
                    }
                }
                .setNegativeButton(android.R.string.no) { dialogInterface, _ -> dialogInterface.dismiss() }.setCancelable(false)
                .show()
    }
}
