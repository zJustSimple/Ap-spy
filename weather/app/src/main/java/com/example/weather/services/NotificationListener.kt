package com.example.weather.services
import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.example.weather.utils.Consts.TYPE_MESSENGER
import com.example.weather.utils.Consts.TYPE_WHATSAPP
import com.example.weather.utils.Consts.TYPE_INSTAGRAM
import javax.inject.Inject
import come.example.weather
//Handler that reads notifications received by an android applicaton.
class NotificationListener: NotificationListenerService(){

    @Inject lateinit var interactor:InteractorNotificationService
    //Inject to MainActivity
    override fun onCreate(){
    super.onCreate()

    }
    //TODO: Implement object to bind
    override fun onListenerConnected(){
        super.onListenerConnected()
    }
    override fun onListenerDisconnected(){
        super.onListenerDisconnected()
    }
    override fun onNotificationPosted(sbn: StatusBarNotification){
        super.onNotificationPosted(sbn)
            val typeNotification = matchTypeNotification(sbn.packageName)
            if(sbn.tag != null && typeNotification!=0){
                val bundle = sbn.notification.extras
                val text = bundle.getString(Notification.EXTRA_TEXT)
                val title = bundle.getString(Notification.EXTRA_TITLE)
                val icon = sbn.notification.smallIcon
                val nameImage = sbn.postTime




        }
    }
    private fun matchTypeNotification(packageName:String): Int = when(packageName){
        FACEBOOK_MESSENGER_PACK_NAME -> TYPE_MESSENGER
        WHATSAPP_PACK_NAME -> TYPE_WHATSAPP
        INSTAGRAM_PACK_NAME -> TYPE_INSTAGRAM
        else -> 0
    }
}
