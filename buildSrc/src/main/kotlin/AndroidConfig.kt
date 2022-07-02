/**
 * @author e.a.vlasov
 */
object AndroidConfig {
    const val MIN_SDK_VERSION = 21
    const val COMPILE_SDK_VERSION = 31
    const val TARGET_SDK_VERSION = 31
}

interface BuildType {

    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }
}
