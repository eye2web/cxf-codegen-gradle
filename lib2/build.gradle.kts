import io.mateo.cxf.codegen.wsdl2java.Wsdl2Java

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.4/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    id("io.mateo.cxf-codegen") version "2.2.0"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

cxfCodegen {
    cxfVersion.set("3.6.2")
}

dependencies {

    api(libs.bundles.cxfCodegen)
    cxfCodegen(libs.bundles.cxfCodegen)

    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api("org.apache.commons:commons-math3:3.6.1")

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:32.1.1-jre")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

val generatedFilesDir = "$projectDir/build/generated"

tasks.register("test1", Wsdl2Java::class) {
    //notCompatibleWithConfigurationCache("incompatible plugin")
    toolOptions {
        autoNameResolution.set(true)
        outputDir.set(File(generatedFilesDir))
        wsdl.set("$projectDir/src/main/resources/wsdl/calculator.wsdl")
        //  bindingFiles.add("$projectDir/src/main/resources/wsdl/calculator.xml")
    }
}

tasks.register("test2", Wsdl2Java::class) {
    //notCompatibleWithConfigurationCache("incompatible plugin")
    toolOptions {
        autoNameResolution.set(true)
        outputDir.set(File(generatedFilesDir))
        wsdl.set("$projectDir/src/main/resources/wsdl/calculator.wsdl")
        //  bindingFiles.add("$projectDir/src/main/resources/wsdl/calculator.xml")
    }
}

sourceSets {
    getByName("main") {
        java.srcDir(generatedFilesDir)
    }
}