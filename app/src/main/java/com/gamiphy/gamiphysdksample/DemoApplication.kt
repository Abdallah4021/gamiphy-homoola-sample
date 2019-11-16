package com.gamiphy.gamiphysdksample

import android.app.Application
import com.gamiphy.library.GamiBot

class DemoApplication() : Application() {

    override fun onCreate() {
        super.onCreate()
        GamiBot.getInstance().init("5dc9335e5d2ed200121fc720").setDebug(true)
    }

}