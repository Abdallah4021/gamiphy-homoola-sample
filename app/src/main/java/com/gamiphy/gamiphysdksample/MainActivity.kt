package com.gamiphy.gamiphysdksample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gamiphy.library.GamiBot
import com.gamiphy.library.OnAuthTrigger
import com.gamiphy.library.OnRedeemTrigger
import com.gamiphy.library.OnTaskTrigger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.bot)
        val updateProfileBtn = findViewById<Button>(R.id.updateProfileBtn)
        val adjustNumberOfShipmentsBtn = findViewById<Button>(R.id.adjustNumberOfShipments)
        val givePontsPerTransationBtn = findViewById<Button>(R.id.givePontsPerTransationBtn)
        val pointsPerTruckQualityBtn = findViewById<Button>(R.id.pointsPerTruckQuality)
        val acceptOfferBtn = findViewById<Button>(R.id.acceptOfferButton)
        val gamiBot = GamiBot.getInstance()

        GamiBot.getInstance().registerGamiphyOnAuthTrigger(object : OnAuthTrigger {
            override fun onAuthTrigger(isSignUp: Boolean) {
                if (!isSignUp) {
                    startActivity(Intent(applicationContext, LoginActivity::class.java))
                }
            }
        }
        )

        gamiBot.registerGamiphyOnTaskTrigger(object : OnTaskTrigger {
            override fun onTaskTrigger(actionName: String) {
                if(actionName.equals("acceptOfferAction")){
                    GamiBot.getInstance().markTaskDone("acceptOfferEvent");
                    Toast.makeText(this@MainActivity,"acceptOfferEvent Task is done",Toast.LENGTH_LONG).show();
                }
                Log.d(MainActivity::class.java.simpleName, "here is action name $actionName")
            }
        })

        gamiBot.registerGamiphyOnRedeemTrigger(object : OnRedeemTrigger {
            override fun onRedeemTrigger(rewardId: String) {
                Log.d(MainActivity::class.java.simpleName, "here is reward Id  $rewardId")
                GamiBot.getInstance().markRedeemDone(rewardId)
            }
        })

//        button.setOnClickListener {
//            GamiBot.getInstance().markTaskDoneSdk("acceptOfferEvent")
//        }

        updateProfileBtn.setOnClickListener {
            GamiBot.getInstance().markTaskDoneSdk("updateProfileEvent")
        }


        adjustNumberOfShipmentsBtn.setOnClickListener {
            GamiBot.getInstance().markTaskDoneSdk("adjustNumberOfShipmentsEvent")
        }

        givePontsPerTransationBtn.setOnClickListener {
            GamiBot.getInstance().markTaskDoneSdk("givePointsPerTransactionsEvent")
        }

        pointsPerTruckQualityBtn.setOnClickListener {
            GamiBot.getInstance().markTaskDoneSdk("pointsPerTruckQualityEvent")
        }

        acceptOfferBtn.setOnClickListener {
            GamiBot.getInstance().markTaskDoneSdk("acceptOfferEvent", 1)
        }
    }
}
