
dependencies {
    testCompile(project(":api-client"))
    testCompile(project(":web-client"))

    testCompile("org.assertj:assertj-core")
    testCompile("org.junit.jupiter:junit-jupiter-engine")
    testCompile("name.falgout.jeffrey.testing.junit5:guice-extension")

    testCompile("ru.yandex.qatools.htmlelements:htmlelements-matchers")
    testCompile("com.google.guava:guava")

}
