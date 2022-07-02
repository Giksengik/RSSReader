package gikse.rssreader.common.android.resource.di

import android.app.ActivityManager
import android.app.AlarmManager
import android.app.DownloadManager
import android.app.NotificationManager
import android.content.ClipboardManager
import android.content.Context
import android.hardware.SensorManager
import android.location.LocationManager
import android.media.AudioManager
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Vibrator
import android.telephony.TelephonyManager
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.core.app.NotificationManagerCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import gikse.rssreader.common.android.resource.*
import gikse.rssreader.common.android.resource.provider.ResourceProvider
import gikse.rssreader.common.android.resource.provider.ResourceProviderImpl
import gikse.rssreader.common.di.ComponentHolder
import gikse.rssreader.common.di.DIComponent

/**
 * @author e.a.vlasov
 */
interface SystemComponent : DIComponent {
    fun activityManager(): ActivityManager
    fun alarmManager(): AlarmManager
    fun audioManager(): AudioManager
    fun clipboardManager(): ClipboardManager
    fun connectivityManager(): ConnectivityManager
    fun downloadManager(): DownloadManager
    fun inputMethodManager(): InputMethodManager
    fun localBroadcastManager(): LocalBroadcastManager
    fun locationManager(): LocationManager
    fun notificationManager(): NotificationManager
    fun notificationManagerCompat(): NotificationManagerCompat
    fun sensorManager(): SensorManager
    fun telephonyManager(): TelephonyManager
    fun vibrator(): Vibrator
    fun windowManager(): WindowManager
    fun wifiManager(): WifiManager
    fun resourceProvider(): ResourceProvider
}

object SystemComponentHolder : ComponentHolder<SystemComponent>() {
    override fun build(): SystemComponent = SystemComponentImpl()
}

internal class SystemComponentImpl(
    module: SystemModule = SystemModule.Impl(SystemComponentDependencies.Impl),
) : SystemComponent by module

internal interface SystemModule : SystemComponent {

    class Impl(deps: SystemComponentDependencies) : SystemModule,
        SystemComponentDependencies by deps {
        override fun activityManager(): ActivityManager = context.activityManager
        override fun alarmManager(): AlarmManager = context.alarmManager
        override fun audioManager(): AudioManager = context.audioManager
        override fun clipboardManager(): ClipboardManager = context.clipboardManager
        override fun connectivityManager(): ConnectivityManager = context.connectivityManager
        override fun downloadManager(): DownloadManager = context.downloadManager
        override fun inputMethodManager(): InputMethodManager = context.inputMethodManager
        override fun localBroadcastManager(): LocalBroadcastManager = context.localBroadcastManager
        override fun locationManager(): LocationManager = context.locationManager
        override fun notificationManager(): NotificationManager = context.notificationManager
        override fun notificationManagerCompat(): NotificationManagerCompat =
            context.notificationManagerCompat

        override fun sensorManager(): SensorManager = context.sensorManager
        override fun telephonyManager(): TelephonyManager = context.telephonyManager
        override fun vibrator(): Vibrator = context.vibrator
        override fun windowManager(): WindowManager = context.windowManager
        override fun wifiManager(): WifiManager = context.wifiManager
        override fun resourceProvider(): ResourceProvider = ResourceProviderImpl(context)
    }
}

interface SystemComponentDependencies {
    val context: Context

    object Impl : SystemComponentDependencies {
        override val context: Context
            get() = ContextComponentHolder.get().context()

    }
}
