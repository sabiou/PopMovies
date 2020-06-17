plugins {
    id("java-platform")
    id("maven-publish")
}

val appcompat = "1.1.0"
val activity = "1.0.0"
val baseRecycler = "0.1.3"
val cardview = "1.0.0"
val archTesting = "2.0.0"
val benchmark = "1.0.0"
val browser = "1.0.0"
val constraintLayout = "1.1.3"
val core = "1.2.0"
val coroutines = "1.3.4"
val coroutinesTest = "1.3.4"
val espresso = "3.1.1"
val fragment = "1.2.4"
val glide = "4.9.0"
val gson = "2.8.6"
val hamcrest = "1.3"
val hilt = Versions.HILT
val hiltJetPack = "1.0.0-alpha01"
val junit = "4.13"
val junitExt = "1.1.1"
val lifecycle = "2.2.0"
val material = "1.1.0"
val okhttp = "3.10.0"
val okio = "1.14.0"
val recyclerView = "1.1.0"
val retrofit = "2.9.0"
val room = "2.2.5"
val rules = "1.1.1"
val runner = "1.2.0"
val sandwich = "1.0.1"
val swiperefresh = "1.0.0"
val timber = "4.7.1"
val transformationLayout = "1.0.4"
val whatif = "1.0.4"

dependencies {
    constraints {
        api("${Libs.ACTIVITY_KTX}:$activity")
        api("${Libs.ANDROIDX_HILT_COMPILER}:$hiltJetPack")
        api("${Libs.APPCOMPAT}:$appcompat")
        api("${Libs.BASE_RECYCLER_ADAPTER}:$baseRecycler")
        api("${Libs.CARDVIEW}:$cardview")
        api("${Libs.ARCH_TESTING}:$archTesting")
        api("${Libs.CONSTRAINT_LAYOUT}:$constraintLayout")
        api("${Libs.CORE_KTX}:$core")
        api("${Libs.COROUTINES}:$coroutines")
        api("${Libs.COROUTINES_TEST}:$coroutines")
        api("${Libs.ESPRESSO_CORE}:$espresso")
        api("${Libs.ESPRESSO_CONTRIB}:$espresso")
        api("${Libs.FRAGMENT_KTX}:$fragment")
        api("${Libs.GLIDE}:$glide")
        api("${Libs.GLIDE_COMPILER}:$glide")
        api("${Libs.GSON}:$gson")
        api("${Libs.HAMCREST}:$hamcrest")
        api("${Libs.HILT_ANDROID}:$hilt")
        api("${Libs.HILT_COMPILER}:$hilt")
        api("${Libs.HILT_TESTING}:$hilt")
        api("${Libs.HILT_VIEWMODEL}:$hiltJetPack")
        api("${Libs.JUNIT}:$junit")
        api("${Libs.EXT_JUNIT}:$junitExt")
        api("${Libs.KOTLIN_STDLIB}:${Versions.KOTLIN}")
        api("${Libs.LIFECYCLE_COMPILER}:$lifecycle")
        api("${Libs.LIFECYCLE_LIVE_DATA_KTX}:$lifecycle")
        api("${Libs.LIFECYCLE_VIEW_MODEL_KTX}:$lifecycle")
        api("${Libs.MATERIAL}:$material")
        api("${Libs.NAVIGATION_FRAGMENT_KTX}:${Versions.NAVIGATION}")
        api("${Libs.NAVIGATION_UI_KTX}:${Versions.NAVIGATION}")
        api("${Libs.ROOM_KTX}:$room")
        api("${Libs.ROOM_RUNTIME}:$room")
        api("${Libs.ROOM_COMPILER}:$room")
        api("${Libs.OKHTTP}:$okhttp")
        api("${Libs.OKHTTP_LOGGING_INTERCEPTOR}:$okhttp")
        api("${Libs.RECYCLER_VIEW}:$recyclerView")
        api("${Libs.RETROFIT}:$retrofit")
        api("${Libs.RETROFIT_GSON}:$retrofit")
        api("${Libs.RULES}:$rules")
        api("${Libs.SANDWICH}:$sandwich")
        api("${Libs.SWIPE_REFRESH}:$swiperefresh")
        api("${Libs.RUNNER}:$runner")
        api("${Libs.TIMBER}:$timber")
        api("${Libs.TRANSFORMATION_LAYOUT}:$transformationLayout")
        api("${Libs.WHATIF}:$whatif")
    }
}

publishing {
    publications {
        create<MavenPublication>("myPlatform") {
            from(components["javaPlatform"])
        }
    }
}