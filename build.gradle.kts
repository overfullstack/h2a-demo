plugins {
  java
  id("com.adarshr.test-logger") version "3.1.0"
}

group = "ga.overfullstack"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

val immutablesVersion = "2.9.0"
dependencies {
  annotationProcessor("org.immutables:value:$immutablesVersion")
  compileOnly("org.immutables:builder:$immutablesVersion")
  compileOnly("org.immutables:value-annotations:$immutablesVersion")
  implementation("io.vavr:vavr:+")
  implementation("org.slf4j:slf4j-api:+")
  implementation("org.springframework:spring-beans:+")
  implementation("org.springframework:spring-context:+")

  runtimeOnly("org.apache.logging.log4j:log4j-slf4j18-impl:+")
  testImplementation("org.mockito:mockito-core:+")
  testImplementation(platform("org.junit:junit-bom:+"))
  testImplementation("org.junit.jupiter:junit-jupiter-api")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

java.sourceCompatibility = JavaVersion.VERSION_17

tasks.test {
  useJUnitPlatform()
  ignoreFailures = true
}

testlogger {
  setTheme("mocha")
  showExceptions = true
  showStackTraces = false
  showFullStackTraces = false
  showCauses = false
  slowThreshold = 2000
  showSummary = true
  showSimpleNames = true
  showPassed = true
  showSkipped = true
  showFailed = true
  showStandardStreams = false
  showPassedStandardStreams = false
  showSkippedStandardStreams = false
  showFailedStandardStreams = false
}
