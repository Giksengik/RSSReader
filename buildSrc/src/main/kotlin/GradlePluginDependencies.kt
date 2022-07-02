/**
 * @author e.a.vlasov
 */
object GradlePluginVersions {
    const val ANDROID_BUILD_TOOLS = "7.0.0"
    const val KOTLIN = CoreVersions.KOTLIN
}

object GradlePluginId {
    const val ANDROID_COMMON_CONFIG = "common-android-config"
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KAPT = "kapt"
}

object GradlePluginDependency {
    const val ANDROID_BUILD_TOOLS =
        "com.android.tools.build:gradle:${GradlePluginVersions.ANDROID_BUILD_TOOLS}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${GradlePluginVersions.KOTLIN}"
}
