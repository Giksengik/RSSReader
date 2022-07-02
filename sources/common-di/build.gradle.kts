plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    kotlin(GradlePluginId.KAPT)
}

dependencies {
    api(Libs.DAGGER)
    implementation(project(":sources:core:core"))
}
