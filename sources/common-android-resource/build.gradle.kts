plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    kotlin(GradlePluginId.KAPT)
}

dependencies {
    implementation(project(":sources:core:core"))
    implementation(project(":sources:common-di"))
}
