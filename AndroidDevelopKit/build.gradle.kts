plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    `maven-publish`
}

android {
    namespace = "com.eathemeat.androiddevelopkit"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "io.github.peter12757"
            artifactId = "AndroidDevelopKit"
            version = "1.0.0"
            afterEvaluate {
                from(components["release"])
            }
            pom {
                name = "androidWidget"
                version = "1.0.0"
                artifactId = "AndroidDevelopKit"
                groupId  ="io.github.peter12757"
                packaging  ="aar"
                description  ="AndroidDevelopKit"
                url = "https://github.com/peter12757/AndroidDevelopKit"
                scm {
                    url = "https://github.com/peter12757/AndroidDevelopKit/tree/main"
                    connection = "scm:git@github.com:peter12757/AndroidDevelopKit.git"
                    developerConnection = "scm:git@github.com:peter12757/AndroidDevelopKit.git"
                }
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url ="http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        id = "PeterXi"
                        name = "PeterXi"
                        email = "peter12757@126.com"
                    }
                }
            }
        }

    }



    repositories {

    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(project(":StateMachine"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}