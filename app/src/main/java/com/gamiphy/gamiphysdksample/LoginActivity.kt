package com.gamiphy.gamiphysdksample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gamiphy.library.GamiBot
import com.gamiphy.library.models.User
import com.gamiphy.library.utils.GamiphyData
import com.gamiphy.library.utils.HashUtil

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        GamiBot.getInstance().login(
            User(
                "ahmad.alstatey@gamiphy.co", "Ahmad Alstaty",
                HashUtil.createHmacKey(
                    "ahmad.alstatey@gamiphy.co|Ahmad Alstaty",
                    "e71f524cee7995766626bd40350d883d14ded66dc095a3b89fb71b89faa751ce"
                )
            )
        )
        GamiBot.getInstance().open(this)
        finish()
    }
}
