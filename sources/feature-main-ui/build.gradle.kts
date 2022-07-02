plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    kotlin(GradlePluginId.KAPT)
}

android {
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":sources:core:core"))
    implementation(project(":sources:common-ui"))
    implementation(project(":sources:common-di"))
}
