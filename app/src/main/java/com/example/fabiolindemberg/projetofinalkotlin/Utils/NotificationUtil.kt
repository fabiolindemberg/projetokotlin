package com.example.fabiolindemberg.projetofinalkotlin.Utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.support.v4.app.NotificationCompat
import com.example.fabiolindemberg.projetofinalkotlin.R

object NotificationUtil {

    val MEU_CANAL = "Meu Canal"

    private fun setChannel(service: NotificationManager){
        /*
       Quando usa o channel, o channelId deve ser o mesmo utilizado no Notification/NotificationCompat Builder
        */

        if(Build.VERSION.SDK_INT > 26) {
            val channel = NotificationChannel(MEU_CANAL, "name", NotificationManager.IMPORTANCE_HIGH)
            service.createNotificationChannel(channel)
        }
    }

    fun showBigPictureNotification(context: Context, id: Int, title: String, text: String, intent: Intent, picture: Bitmap) {

        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val nofificationBuilder = NotificationCompat.Builder(context, MEU_CANAL)
            .setContentText(text)
            .setContentTitle(title)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setSmallIcon(R.drawable.notification_icon_background)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(picture))

        val service = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        setChannel(service)

        service.notify(98, nofificationBuilder.build())
    }

    fun show(context: Context, id: Int, title: String, text: String, bigText: String, intent: Intent) {

        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val nofificationBuilder = NotificationCompat.Builder(context, MEU_CANAL)
            .setContentText(text)
            .setContentTitle(title)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setSmallIcon(R.drawable.notification_icon_background)
            .setStyle(NotificationCompat.BigTextStyle().bigText(bigText).setBigContentTitle(bigText))


        val service = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        setChannel(service)

        service.notify(98, nofificationBuilder.build())

    }
}