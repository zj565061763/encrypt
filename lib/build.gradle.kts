plugins {
   alias(libs.plugins.android.library)
   alias(libs.plugins.kotlin.android)
   `maven-publish`
}

val libGroupId = "com.sd.lib.android"
val libArtifactId = "encrypt"
val libVersionName = "1.0.0-alpha01"

android {
   namespace = "com.sd.lib.encrypt"
   compileSdk = libs.versions.androidCompileSdk.get().toInt()
   defaultConfig {
      minSdk = 21
   }

   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
   }

   kotlinOptions {
      jvmTarget = "1.8"
      freeCompilerArgs += "-module-name=$libGroupId.$libArtifactId"
   }

   publishing {
      singleVariant("release") {
         withSourcesJar()
      }
   }
}

dependencies {
}

publishing {
   publications {
      create<MavenPublication>("release") {
         groupId = libGroupId
         artifactId = libArtifactId
         version = libVersionName
         afterEvaluate {
            from(components["release"])
         }
      }
   }
}
