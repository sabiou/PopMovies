package xyz.godi.popularmovies.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import de.psdev.licensesdialog.LicensesDialog;
import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;
import xyz.godi.popularmovies.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void showLicenceDialog(View view) {
        final Notices notices = new Notices();
        // Picasso
        notices.addNotice(
                new Notice("Square - Picasso", "http://square.github.io/picasso/",
                        "Copyright 2013 Square, Inc.", new ApacheSoftwareLicense20()));
        // Square
        notices.addNotice(
                new Notice("Square - Retrofit", "http://square.github.io/retrofit/",
                        "Copyright 2013 Square, Inc.", new ApacheSoftwareLicense20()));
        // ButterKnife
        notices.addNotice(
                new Notice("ButterKnife", "https://github.com/JakeWharton/butterknife/",
                        "Copyright 2013 Jake Wharton", new ApacheSoftwareLicense20()));

        new LicensesDialog.Builder(AboutActivity.this)
                .setNotices(notices)
                .setIncludeOwnLicense(true)
                .build()
                .show();
    }
}
