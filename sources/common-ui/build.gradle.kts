plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    kotlin(GradlePluginId.KAPT)
}

dependencies {
    api(Libs.VIEW_BINDING_DELEGATE)
    implementation(project(":sources:core:core"))
}
