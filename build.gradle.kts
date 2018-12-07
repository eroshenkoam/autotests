import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import ru.vyarus.gradle.plugin.quality.QualityExtension

buildscript {
    repositories {
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("io.spring.gradle:dependency-management-plugin:1.0.6.RELEASE")
        classpath("ru.vyarus:gradle-quality-plugin:3.3.0")
    }
}

val gradleScriptDir by extra("${rootProject.projectDir}/gradle")

tasks.existing(Wrapper::class) {
    gradleVersion = "4.10.2"
    distributionType = Wrapper.DistributionType.ALL
}

configure(allprojects) {
    group = "io.eroshenkoam.samples"
    version = version
}

configure(subprojects) {

    apply(plugin = "java")
    apply(plugin = "maven")
    apply(plugin = "ru.vyarus.quality")
    apply(plugin = "io.spring.dependency-management")

    tasks.withType(JavaCompile::class) {
        sourceCompatibility = "${JavaVersion.VERSION_1_8}"
        targetCompatibility = "${JavaVersion.VERSION_1_8}"
        options.encoding = "UTF-8"
    }

    configure<DependencyManagementExtension> {
        dependencies {
            dependency("io.qameta.atlas:atlas-webdriver:1.2.0")
            dependency("ru.yandex.qatools.htmlelements:htmlelements-matchers:1.18")

            dependency("org.aeonbits.owner:owner:1.0.10")
            dependency("org.projectlombok:lombok:1.16.16")

            dependency("com.google.inject:guice:4.2.2")

            dependency("com.google.guava:guava:24.0-jre")

            dependency("com.squareup.retrofit2:retrofit:2.5.0")
            dependency("com.squareup.retrofit2:converter-jackson:2.5.0")

            dependency("org.seleniumhq.selenium:selenium-java:3.9.1")

            dependency("org.junit.jupiter:junit-jupiter-api:5.2.0")
            dependency("org.junit.jupiter:junit-jupiter-engine:5.2.0")
            dependency("org.junit.jupiter:junit-jupiter-params:5.2.0")

            dependency("org.jdbi:jdbi:2.77")

            dependency("name.falgout.jeffrey.testing.junit5:guice-extension:1.1.0")

            dependency("org.assertj:assertj-core:3.10.0")
        }
    }

    configure<QualityExtension> {
        configDir = "$gradleScriptDir/quality"
        pmdVersion = "6.9.0"
    }

    repositories {
        maven("https://dl.bintray.com/qameta/maven")

        mavenCentral()
    }

}
