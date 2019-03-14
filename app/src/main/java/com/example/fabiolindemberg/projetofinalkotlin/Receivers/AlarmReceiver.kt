package com.example.fabiolindemberg.projetofinalkotlin.Receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.fabiolindemberg.projetofinalkotlin.Services.NotificationService

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        context.startService(Intent(context, NotificationService::class.java))
    }
}
