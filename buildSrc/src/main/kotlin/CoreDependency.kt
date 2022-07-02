/**
 * @author e.a.vlasov
 */
object CoreVersions {
    const val KOTLIN = "1.5.21"

    //COROUTINES
    const val COROUTINES = "1.5.1"
}

object CoreDependency {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${CoreVersions.KOTLIN}"

    //COROUTINES
    const val COROUTINES_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${CoreVersions.COROUTINES}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CoreVersions.COROUTINES}"
}
