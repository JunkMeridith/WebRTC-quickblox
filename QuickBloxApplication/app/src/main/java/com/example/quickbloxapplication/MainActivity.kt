package com.example.quickbloxapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quickblox.auth.session.QBSettings
import com.quickblox.core.exception.QBResponseException
import com.quickblox.users.model.QBUser
import com.quickblox.core.QBEntityCallback
import com.quickblox.chat.QBChatService
import com.quickblox.auth.session.QBSession
import com.quickblox.auth.QBAuth
import com.quickblox.chat.QBSignaling
import com.quickblox.chat.QBWebRTCSignaling
import com.quickblox.chat.listeners.QBVideoChatSignalingManagerListener
import com.quickblox.videochat.webrtc.QBRTCClient
import com.quickblox.videochat.webrtc.QBRTCConfig


class MainActivity : AppCompatActivity() {

    private val appContext: Context = this
    private val APP_ID = "76454"
    private val AUTH_KEY = "9kUvdzZcpWW-4Rv"
    private val AUTH_SECRET = "AtBsr9K8nTL7LDB"
    private val ACCOUNT_KEY = "jYuLkkdB24iEgboR5eGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        QBSettings.getInstance().init(applicationContext, APP_ID, AUTH_KEY, AUTH_SECRET)
        QBSettings.getInstance().accountKey = ACCOUNT_KEY

        loginUser()
        setupCAllListener()


        val loginIntent = Intent(appContext, EnterRoomActivityTest::class.java)
        startActivity(loginIntent)




    }

    private fun loginUser() {
        val login = "TabbyTheTablet"
        val password = "TABBYTHETABLET1!"

        val user = QBUser(login, password)
        QBAuth.createSession(user)

    }

    private fun setupCAllListener() {
        val rtcClient = QBRTCClient.getInstance(applicationContext)
//        private var chatService: QBChatService? = null
//        // Add signalling manager
//        chatService.getVideoChatWebRTCSignalingManager()
//            .addSignalingManagerListener(QBVideoChatSignalingManagerListener { qbSignaling, createdLocally ->
//                if (!createdLocally) {
//                    rtcClient.addSignaling(qbSignaling as QBWebRTCSignaling)
//                }
//            })
//
//        // Configure
//        QBRTCConfig.setDebugEnabled(true)
//     //   SettingsUtil.configRTCTimers(this@CallService)
//
//        // Add service as callback to RTCClient
//        rtcClient.addSessionCallbacksListener(WebRtcSessionManager.getInstance(this))
//        rtcClient.prepareToProcessCalls()
    }

}
