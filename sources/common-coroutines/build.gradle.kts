plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    kotlin(GradlePluginId.KAPT)
}

dependencies {
    api(CoreDependency.COROUTINES_ANDROID)
    api(CoreDependency.COROUTINES_CORE)
}
