rootProject.name = ("RSS Reader")

include(":app")

include(
    "sources:core:core",
    "sources:core:presentation",
)

include(
    "sources:common-ui",
    "sources:common-recycler",
    "sources:common-coroutines",
    "sources:common-di",
    "sources:common-android-resource",
    "sources:feature-main",
    "sources:feature-main-ui",
)

include(
    "sources:feature-search",
)

//includeRecursive(File("sources"))

fun includeRecursive(dir: File) {
    if (isModule(dir)) {
        val moduleName = ":${dir.name}"
        include(moduleName)
        project(moduleName).projectDir = dir
    } else {
        // Тут чет не так, вылетает StackOverflow
        if (dir.isDirectory) {
            dir.listFiles()
                .filter { it.isDirectory }
                .forEach { includeRecursive(it) }
        }
    }
}

fun isModule(dir: File): Boolean {
    return File(dir, "build.gradle.kts").isFile
}
