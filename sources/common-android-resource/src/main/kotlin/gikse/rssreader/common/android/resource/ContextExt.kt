package gikse.rssreader.common.android.resource

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

/**
 * @author e.a.vlasov
 */
val Context.activityManager: ActivityManager get() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
val Context.alarmManager: AlarmManager get() = getSystemService(Context.ALARM_SERVICE) as AlarmManager
val Context.audioManager: AudioManager get() = getSystemService(Context.AUDIO_SERVICE) as AudioManager
val Context.clipboardManager: ClipboardManager get() = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
val Context.connectivityManager: ConnectivityManager get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
val Context.downloadManager: DownloadManager get() = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
val Context.inputMethodManager: InputMethodManager get() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
val Context.localBroadcastManager: LocalBroadcastManager
    get() = LocalBroadcastManager.getInstance(
        this
    )
val Context.locationManager: LocationManager get() = getSystemService(Context.LOCATION_SERVICE) as LocationManager
val Context.notificationManager: NotificationManager get() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
val Context.notificationManagerCompat: NotificationManagerCompat
    get() = NotificationManagerCompat.from(
        this
    )
val Context.sensorManager: SensorManager get() = getSystemService(Context.SENSOR_SERVICE) as SensorManager
val Context.telephonyManager: TelephonyManager get() = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
val Context.vibrator: Vibrator get() = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
val Context.windowManager: WindowManager get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager
val Context.wifiManager: WifiManager get() = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
