plugins {
    id("groovy")
    id("application")
    id("com.ryandens.javaagent-application") version "0.4.2"
    id("com.ryandens.javaagent-test") version "0.4.2"
}

group = "spp.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://pkg.sourceplus.plus/sourceplusplus/probe-jvm")
}

dependencies {
    implementation("org.codehaus.groovy:groovy:3.0.13")
    implementation("io.micronaut:micronaut-management:3.6.4")

    //attaches Source++ probe to the application
    javaagent("plus.sourceplus.probe:probe-jvm:0.7.10-SNAPSHOT")

    //used for the tail logs command
    implementation("org.apache.skywalking:apm-toolkit-logback-1.x:8.15.0")
    implementation("org.slf4j:slf4j-api:2.0.2")
    implementation("ch.qos.logback:logback-classic:1.4.1")

    //used for endpoint indicators
    implementation("io.micronaut:micronaut-http-server-netty:3.6.4")
    implementation("io.micronaut:micronaut-inject-groovy:3.6.4")

    //used for test indicators
    testJavaagent("plus.sourceplus.probe:probe-jvm:0.7.10-SNAPSHOT")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

application {
    mainClass.set("spp.demo.Main")
    applicationName = "demo-groovy"
}
