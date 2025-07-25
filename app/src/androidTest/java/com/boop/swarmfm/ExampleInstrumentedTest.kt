package com.boop.swarmfm  // Make sure this matches your actual package name

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val streamUrl = "https://femboysocks.com"

        val vlcIntent = Intent(Intent.ACTION_VIEW).apply {
            setPackage("org.videolan.vlc")
            data = Uri.parse(streamUrl)
        }

        try {
            startActivity(vlcIntent)
        } catch (e: ActivityNotFoundException) {
            // VLC not installed – open Play Store
            val playStoreIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://play.google.com/store/apps/details?id=org.videolan.vlc")
                setPackage("com.android.vending")
            }
            startActivity(playStoreIntent)
        }

        finish()
    }
}
