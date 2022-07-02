/**
 * @author e.a.vlasov
 */
object Libs {

    // DI
    const val DAGGER = "com.google.dagger:dagger:${LibVersions.DAGGER}"
    const val DAGGER_COMPILE = "com.google.dagger:${LibVersions.DAGGER_COMPILE}"

    // ANDROID
    const val CORE_KTX = "androidx.core:core-ktx:${LibVersions.CORE_KTX}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${LibVersions.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${LibVersions.MATERIAL}"

    // TEST
    const val TEST_JUNIT = "junit:junit:${LibVersions.TEST_JUNIT}"
    const val ANDROID_JUNIT = "androidx.test.ext:junit:${LibVersions.ANDROID_JUNIT}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${LibVersions.ESPRESSO}"

    // THIRD PARTY LIBS
    const val GLIDE = "com.github.bumptech.glide:glide:${LibVersions.GLIDE}"
    const val VIEW_BINDING_DELEGATE =
        "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${LibVersions.VIEW_BINDING_DELEGATE}"

}
