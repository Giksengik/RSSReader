plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
}

dependencies {
    api(Libs.MATERIAL)
    api(Libs.CORE_KTX)
    api(Libs.APPCOMPAT)
}
