pluginManagement {
    val flutterSdkPath: String = run {
        val properties = java.util.Properties()
        file("local.properties").inputStream().use { properties.load(it) }
        val flutterSdkPath = properties.getProperty("flutter.sdk")
        require(flutterSdkPath != null) { "flutter.sdk not set in local.properties" }
        flutterSdkPath
    }
    settings.extra["flutterSdkPath"] = flutterSdkPath

    includeBuild("${settings.extra["flutterSdkPath"]}/packages/flutter_tools/gradle")

    plugins {
        id("dev.flutter.flutter-gradle-plugin") version "1.0.0" apply false
    }
}

include(":app")

apply(from = "${settings.extra["flutterSdkPath"]}/packages/flutter_tools/gradle/app_plugin_loader.gradle")
