plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK)
    defaultConfig {
        applicationId = "xyz.godi.popularmovies"
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
        versionName = Versions.VERSION_NAME

        buildConfigField("String", "API_KEY", properties["api_key"] as String)

        vectorDrawables.useSupportLibrary = true

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
            }
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }


    // Required for AR because it includes a library built with Java 8
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    // To avoid the compile error: "Cannot inline bytecode built with JVM target 1.8
    // into bytecode that is being built with JVM target 1.6"
    kotlinOptions {
        val options = this
        options.jvmTarget = "1.8"
    }
}


dependencies {
    api(platform(project(":depconstraints")))
    kapt(platform(project(":depconstraints")))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    // Kotlin ktx
    implementation(Libs.CORE_KTX)
    // Kotlin
    implementation(Libs.KOTLIN_STDLIB)

    // UI
    implementation(Libs.ACTIVITY_KTX)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.FRAGMENT_KTX)
    implementation(Libs.CARDVIEW)
    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.MATERIAL)
    implementation(Libs.VECTOR_DRAWABLES)
    implementation(Libs.RECYCLER_VIEW)
    implementation(Libs.SWIPE_REFRESH)

    // Android JetPack
    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
    implementation(Libs.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Libs.LIFECYCLE_VIEW_MODEL_KTX)
    kapt(Libs.LIFECYCLE_COMPILER)
    implementation(Libs.ROOM_RUNTIME)
    implementation(Libs.ROOM_KTX)
    implementation(Libs.NAVIGATION_UI_KTX)
    kapt(Libs.ROOM_COMPILER)
    testImplementation(Libs.ARCH_TESTING)

    // Dagger Hilt
    implementation(Libs.HILT_ANDROID)
    implementation(Libs.HILT_VIEWMODEL)
    androidTestImplementation(Libs.HILT_TESTING)
    kapt(Libs.HILT_COMPILER)
    kapt(Libs.ANDROIDX_HILT_COMPILER)
    kaptAndroidTest(Libs.HILT_COMPILER)
    kaptAndroidTest(Libs.ANDROIDX_HILT_COMPILER)

    // Retrofit
    implementation(Libs.RETROFIT)
    implementation(Libs.RETROFIT_GSON)

    // Local unit tests
    testImplementation(Libs.JUNIT)
    testImplementation(Libs.HAMCREST)

    // unit tests livedata
    testImplementation(Libs.ARCH_TESTING)

    // Sandwich
    implementation(Libs.SANDWICH)

    // Google Gson
    implementation(Libs.GSON)

    // Glide
    implementation(Libs.GLIDE)
    kapt(Libs.GLIDE_COMPILER)

    // color palette
    implementation("androidx.palette:palette:1.0.0")
    // Licences dialog
    implementation("de.psdev.licensesdialog:licensesdialog:2.1.0")

    // adapter
    implementation(Libs.BASE_RECYCLER_ADAPTER)

    // transformation
    implementation(Libs.TRANSFORMATION_LAYOUT)

    // whatif
    implementation(Libs.WHATIF)

    androidTestImplementation("androidx.test.uiautomator:uiautomator:2.2.0")
    androidTestImplementation("com.google.truth:truth:1.0")
}