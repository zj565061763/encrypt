plugins {
   id("com.android.library")
   id("org.jetbrains.kotlin.android")
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

   kotlinOptions {
      freeCompilerArgs += "-module-name=$libGroupId.$libArtifactId"
   }

   publishing {
      singleVariant("release") {
         withSourcesJar()
      }
   }
}

kotlin {
   jvmToolchain(8)
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
