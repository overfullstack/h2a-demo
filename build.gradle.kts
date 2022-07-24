import com.diffplug.spotless.extra.wtp.EclipseWtpFormatterStep.XML

plugins {
  java
  id("com.adarshr.test-logger") version "3.2.0"
  id("com.diffplug.spotless") version "6.8.0"
}

group = "ga.overfullstack"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

spotless {
  kotlin {
    target("src/main/java/**/*.kt", "src/test/java/**/*.kt")
    targetExclude("$buildDir/generated/**/*.*")
    ktlint()
      .setUseExperimental(true)
      .editorConfigOverride(mapOf("indent_size" to "2", "continuation_indent_size" to "2"))
  }
  kotlinGradle {
    target("*.gradle.kts")
    ktlint()
      .setUseExperimental(true)
      .editorConfigOverride(mapOf("indent_size" to "2", "continuation_indent_size" to "2"))
  }
  java {
    toggleOffOn()
    target("src/main/java/**/*.java", "src/test/java/**/*.java")
    targetExclude("$buildDir/generated/**/*.*")
    importOrder()
    removeUnusedImports()
    googleJavaFormat()
    trimTrailingWhitespace()
    indentWithSpaces(2)
    endWithNewline()
  }
  format("xml") {
    targetExclude("pom.xml")
    target("*.xml")
    eclipseWtp(XML)
  }
  format("documentation") {
    target("*.md", "*.adoc")
    trimTrailingWhitespace()
    indentWithSpaces(2)
    endWithNewline()
  }
}

dependencies {
  val immutablesVersion = "2.9.0"
  annotationProcessor("org.immutables:value:$immutablesVersion")
  compileOnly("org.immutables:builder:$immutablesVersion")
  compileOnly("org.immutables:value-annotations:$immutablesVersion")
  implementation("io.vavr:vavr:0.10.4")
  implementation("org.slf4j:slf4j-api:1.7.36")
  implementation("org.springframework:spring-beans:+")
  implementation("org.springframework:spring-context:+")

  runtimeOnly("org.apache.logging.log4j:log4j-slf4j18-impl:2.17.1")
  testImplementation("org.mockito:mockito-core:+")
  testImplementation(platform("org.junit:junit-bom:+"))
  testImplementation("org.junit.jupiter:junit-jupiter-api")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

java.sourceCompatibility = JavaVersion.VERSION_17

tasks {
  test {
    useJUnitPlatform()
    ignoreFailures = true
  }
  testlogger {
    theme = com.adarshr.gradle.testlogger.theme.ThemeType.MOCHA_PARALLEL
  }
}
