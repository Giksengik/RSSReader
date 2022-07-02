buildscript {
    repositories {
        google()
        jcenter()
        maven("https://dl.bintray.com/kotlin/kotlin-eap/")
    }
    dependencies {
        classpath(GradlePluginDependency.ANDROID_BUILD_TOOLS)
        classpath(GradlePluginDependency.KOTLIN)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")

    }
}

// all projects = root project + sub projects
allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
