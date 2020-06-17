package xyz.godi.popularmovies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.psdev.licensesdialog.LicensesDialog
import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20
import de.psdev.licensesdialog.model.Notice
import de.psdev.licensesdialog.model.Notices
import xyz.godi.popularmovies.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    fun showLicenceDialog() {
        val notices = Notices()
        // Picasso
        notices.addNotice(
                Notice("Square - Picasso", "http://square.github.io/picasso/",
                        "Copyright 2013 Square, Inc.", ApacheSoftwareLicense20()))
        // Square
        notices.addNotice(
                Notice("Square - Retrofit", "http://square.github.io/retrofit/",
                        "Copyright 2013 Square, Inc.", ApacheSoftwareLicense20()))
        // ButterKnife
        notices.addNotice(
                Notice("ButterKnife", "https://github.com/JakeWharton/butterknife/",
                        "Copyright 2013 Jake Wharton", ApacheSoftwareLicense20()))
        LicensesDialog.Builder(this@AboutActivity)
                .setNotices(notices)
                .setIncludeOwnLicense(true)
                .build()
                .show()
    }
}