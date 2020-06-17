// Top-level build file where you can add configuration options common to all sub-projects/modules.
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        jcenter()
        maven {
            setUrl("https://oss.sonatype.org/content/repositories/snapshots/")
        }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}")
        classpath("androidx.benchmark:benchmark-gradle-plugin:${Versions.BENCHMARK}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            setUrl("https://oss.sonatype.org/content/repositories/snapshots/")
        }

        flatDir {
            dirs = setOf(file("libs"))
        }
    }
}
