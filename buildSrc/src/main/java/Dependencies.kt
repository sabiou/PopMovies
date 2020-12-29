/**
 * Created by Farouk on 26/12/2020.
 */
@Suppress("unused")
object Sdk {
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 30
    const val COMPILE_SDK_VERSION = 30
}

@Suppress("unused")
object Version {
    const val ANDROIDX_TEST_EXT = "1.1.2"
    const val ANDROIDX_TEST = "1.3.0"
    const val ANDROID_LIFECYCLE = "2.2.0"
    const val ANDROID_ARCH = "2.1.0"
    const val APPCOMPAT = "1.2.0"
    const val BASE_RECYCLER_ADAPTER = "0.1.3"
    const val COIL = "1.1.0"
    const val CONSTRAINT_LAYOUT = "2.0.4"
    const val CORE_KTX = "1.3.2"
    const val COROUTINES = "1.4.2"
    const val ESPRESSO_CORE = "3.3.0"
    const val FRAGMENT = "1.2.5"
    const val GSON = "2.8.6"
    const val HILT = "2.28.3-alpha"
    const val HILT_ANDROID = "1.0.0-alpha02"
    const val INSETTER = "0.3.1"
    const val JUNIT = "4.13.1"
    const val KOTLINX_SERIALIZATION = "1.0.1"
    const val KLUENT = "1.64"
    const val KTLINT = "0.39.0"
    const val LIVE_DATA_TESTING = "1.1.2"
    const val MATERIAL_COMPONENTS = "1.2.1"
    const val NAVIGATION_COMPONENT = "2.3.2"
    const val OKHTTP = "4.9.0"
    const val RECYCLERVIEW = "1.1.0"
    const val RETROFIT = "2.9.0"
    const val ROOM = "2.2.6"
    const val RETROFIT_KOTLINX_SERIALIZATION = "0.8.0"
    const val ROBOLECTRIC = "4.4"
    const val SANDWICH = "1.0.7"
    const val SWIPE_REFRESH = "1.1.0"
    const val RETROFIT_GSON = "2.9.0"
    const val TRANSFORMATION_LAYOUT = "1.0.6"
    const val VECTOR_DRAWABLES = "1.1.0"
    const val WHATIF = "1.0.9"
    const val WORK = "2.4.0"
    const val GRADLE_VERSIONS_UPDATE = "0.36.0"
}

@Suppress("unused")
object BuildPluginsVersion {
    const val AGP = "4.1.1"
    const val DETEKT = "1.14.2"
    const val KOTLIN = "1.4.21"
    const val KTLINT = "9.4.1"
    const val VERSIONS_PLUGIN = "0.36.0"
}

@Suppress("unused")
object LibArchitecture {
    const val FRAGMENT = "androidx.fragment:fragment-ktx:${Version.FRAGMENT}"
    const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.ANDROID_LIFECYCLE}"
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Version.NAVIGATION_COMPONENT}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Version.NAVIGATION_COMPONENT}"
    const val NAVIGATION_FEATURES_MODULES = "androidx.navigation:navigation-dynamic-features-fragment:${Version.NAVIGATION_COMPONENT}"
    const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.ANDROID_LIFECYCLE}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Version.ROOM}"
    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Version.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Version.ROOM}"
    const val WORK_KTX = "androidx.work:work-runtime-ktx:${Version.WORK}"
}

@Suppress("unused")
object LibCoroutines {
    const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.COROUTINES}"
    const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.COROUTINES}"
}

@Suppress("unused")
object LibDI {
    // Hilt
    const val HILT_COMPILER = "androidx.hilt:hilt-compiler:${Version.HILT_ANDROID}"
    const val HILT_DAGGER_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Version.HILT}"
    const val HILT_VIEW_MODEL = "androidx.hilt:hilt-lifecycle-viewmodel:${Version.HILT_ANDROID}"
    const val HILT_DAGGER = "com.google.dagger:hilt-android:${Version.HILT}"
    const val HILT_DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Version.HILT}"
    const val DAGGER = "com.google.dagger:dagger:${Version.HILT}"
}

@Suppress("unused")
object LibHttp {
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Version.OKHTTP}"
    const val OKHTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:${Version.OKHTTP}"
    const val GSON = "com.google.code.gson:gson:${Version.GSON}"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Version.RETROFIT_GSON}"
}

@Suppress("unused")
object LibSerialization {
    const val KOTLINX =
            "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Version.KOTLINX_SERIALIZATION}"
    const val RETROFIT_KOTLINX =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Version.RETROFIT_KOTLINX_SERIALIZATION}"
}

@Suppress("unused")
object LibSupport {
    // Support library
    const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:${Version.APPCOMPAT}"
    const val ANDROIDX_CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT}"
    const val ANDROIDX_CORE_KTX = "androidx.core:core-ktx:${Version.CORE_KTX}"
    const val SWIPE_REFRESH = "androidx.swiperefreshlayout:swiperefreshlayout:${Version.SWIPE_REFRESH}"
    const val VECTOR_DRAWABLES = "androidx.vectordrawable:vectordrawable:${Version.VECTOR_DRAWABLES}"
}

@Suppress("unused")
object LibTesting {
    const val ANDROID_CORE_TESTING = "androidx.arch.core:core-testing:${Version.ANDROID_ARCH}"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.COROUTINES}"
    const val JUNIT = "junit:junit:${Version.JUNIT}"
    const val KLUENT = "org.amshove.kluent:kluent-android:${Version.KLUENT}"
    const val LIVE_DATA_TESTING = "com.jraska.livedata:testing-ktx:${Version.LIVE_DATA_TESTING}"
    const val ROBOLECTRIC = "org.robolectric:robolectric:${Version.ROBOLECTRIC}"
}

@Suppress("unused")
object LibUI {
    const val MATERIAL_COMPONENTS = "com.google.android.material:material:${Version.MATERIAL_COMPONENTS}"
    const val COIL = "io.coil-kt:coil:${Version.COIL}"
    const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Version.RECYCLERVIEW}"
    const val INSETTERS = "dev.chrisbanes:insetter-ktx:${Version.INSETTER}"
}

@Suppress("unused")
object LibAndroidTesting {
    const val ANDROIDX_TEST_RULES = "androidx.test:rules:${Version.ANDROIDX_TEST}"
    const val ANDROIDX_TEST_RUNNER = "androidx.test:runner:${Version.ANDROIDX_TEST}"
    const val ANDROIDX_TEST_EXT_JUNIT = "androidx.test.ext:junit:${Version.ANDROIDX_TEST_EXT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Version.ESPRESSO_CORE}"
}

@Suppress("unused")
object Plugins {
    const val ANDROID_GRADLE_PLUGIN = "com.android.tools.build:gradle:${BuildPluginsVersion.AGP}"
    const val GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-stdlib:${BuildPluginsVersion.KOTLIN}"
    const val NAVIGATION_SAFE_ARGS = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.NAVIGATION_COMPONENT}"
    const val HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${Version.HILT}"
    const val GRADLE_VERSIONS = "com.github.ben-manes:gradle-versions-plugin:${Version.GRADLE_VERSIONS_UPDATE}"
}

@Suppress("unused")
object LibOthers {
    const val SANDWICH = "com.github.skydoves:sandwich:${Version.SANDWICH}"
    const val WHATIF = "com.github.skydoves:whatif:${Version.WHATIF}"
    const val TRANSFORMATION_LAYOUT = "com.github.skydoves:transformationlayout:${Version.TRANSFORMATION_LAYOUT}"
    const val BASE_RECYCLER_ADAPTER = "com.github.skydoves:baserecyclerviewadapter:${Version.BASE_RECYCLER_ADAPTER}"
}