plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    kotlin(GradlePluginId.KAPT)
}

android {
    defaultConfig {
        applicationId = "gikse.rssreader"
    }
}

dependencies {
    implementation(project(":sources:common-android-resource"))
    implementation(project(":sources:core:core"))
    implementation(project(":sources:common-di"))
    implementation(project(":sources:common-ui"))
    implementation(project(":sources:common-coroutines"))
}
