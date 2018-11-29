@file:Suppress("ClassName", "unused")

object Build {
    const val applicationId = "com.ivianuu.kommon.sample"
    const val buildToolsVersion = "28.0.3"

    const val compileSdk = 28
    const val minSdk = 14
    const val targetSdk = 28
    const val versionCode = 1
    const val versionName = "0.0.1"
}

object Versions {
    const val androidGradlePlugin = "3.2.1"
    const val androidx = "1.0.0"
    const val androidxAppCompat = "1.0.2"
    const val androidxCore = "1.0.1"
    const val androidxArch = "2.0.0-rc01"
    const val archWork = "1.0.0-alpha08"
    const val constraintLayout = "1.1.3"
    const val kotlin = "1.3.10"
    const val materialComponents = "1.0.0"
    const val mavenGradle = "2.1"
}

object Deps {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"

    const val androidXAnnotation = "androidx.annotation:annotation:${Versions.androidx}"
    const val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
    const val androidxCore = "androidx.core:core:${Versions.androidxCore}"
    const val androidxCoreKtx = "androidx.core:core-ktx:${Versions.androidx}"
    const val androidxFragment = "androidx.fragment:fragment:${Versions.androidx}"
    const val androidxRecyclerView = "androidx.recyclerview:recyclerview:${Versions.androidx}"
    const val androidxViewPager = "androidx.viewpager:viewpager:${Versions.androidx}"

    const val archLifecycleExtensions =
        "androidx.lifecycle:lifecycle-extensions:${Versions.androidxArch}"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val materialComponents =
        "com.google.android.material:material:${Versions.materialComponents}"

    const val mavenGradlePlugin = "com.github.dcendents:android-maven-gradle-plugin:${Versions.mavenGradle}"
}