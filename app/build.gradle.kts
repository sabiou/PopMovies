plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK)
    defaultConfig {
        applicationId = "xyz.godi.popularmovies"
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
        versionName = Versions.versionName

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
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        dataBinding = true
    }


    // Required for AR because it includes a library built with Java 8
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    // To avoid the compile error: "Cannot inline bytecode built with JVM target 1.8
    // into bytecode that is being built with JVM target 1.6"
    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }
}


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.APPCOMPAT)
    implementation(Libs.MATERIAL)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.CARDVIEW)
    implementation(Libs.VECTOR_DRAWABLES)
    // Kotlin ktx
    implementation(Libs.CORE_KTX)

    // Android JetPack
    implementation ("androidx.fragment:fragment-ktx:1.2.5")
    implementation ("androidx.lifecycle:lifecycle-runtime:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation ("androidx.room:room-runtime:2.2.5")
    implementation ("androidx.room:room-ktx:2.2.5")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.2.2")
    implementation ("androidx.navigation:navigation-ui-ktx:2.2.2")
    kapt ("androidx.room:room-compiler:2.2.5")
    testImplementation ("androidx.room:room-testing:2.2.5")

    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation ("junit:junit:4.13")

    // retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    // Gson
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    // Picasso
    implementation ("com.squareup.picasso:picasso:2.71828")
    // color palette
    implementation ("androidx.palette:palette:1.0.0")
    // Licences dialog
    implementation("de.psdev.licensesdialog:licensesdialog:2.1.0")

    // dagger
    implementation ("com.google.dagger:dagger:2.28")
    implementation ("com.google.dagger:hilt-android:2.28-alpha")
    implementation ("com.google.dagger:hilt-android-testing:2.28-alpha")
    implementation ("androidx.hilt:hilt-common:1.0.0-alpha01")
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01")
    kapt ("com.google.dagger:dagger-compiler:2.28")
    kapt ("com.google.dagger:hilt-android-compiler:2.28-alpha")
    kapt ("androidx.hilt:hilt-compiler:1.0.0-alpha01")
    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.28-alpha")
    kaptAndroidTest ("com.google.dagger:hilt-android-compiler:2.28-alpha")

    // adapter
    implementation ("com.github.skydoves:baserecyclerviewadapter:0.1.3")

    // transformation
    implementation ("com.github.skydoves:transformationlayout:1.0.4")

    // whatif
    implementation ("com.github.skydoves:whatif:1.0.4")

    // sandwich
    implementation ("com.github.skydoves:sandwich:1.0.1")

    // Glide
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    kapt ("com.github.bumptech.glide:compiler:4.11.0")

    // test
    androidTestImplementation ("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation ("androidx.test.espresso:espresso-contrib:3.2.0")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.2.0")
    androidTestImplementation ("androidx.test.espresso:espresso-intents:3.2.0")
    androidTestImplementation ("androidx.test.ext:junit:1.1.1")
    androidTestImplementation ("androidx.test.uiautomator:uiautomator:2.2.0")
    androidTestImplementation ("androidx.work:work-testing:2.3.4")
    androidTestImplementation ("com.google.truth:truth:1.0")
    testImplementation ("junit:junit:4.13")
}