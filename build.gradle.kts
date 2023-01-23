repositories {
    mavenCentral()
}

plugins {
    `java-library`
    idea
    scala
}

dependencies {
    implementation("org.scala-lang:scala-library:2.12.17")
    implementation("org.apache.spark:spark-core_2.12:3.0.3")
    implementation("org.apache.spark:spark-sql_2.12:3.0.3")

    testImplementation("org.scalatest:scalatest_2.12:3.0.2")
    testImplementation("junit:junit:4.13")
}

configurations {
    implementation {
        resolutionStrategy.failOnVersionConflict()
    }
}

sourceSets {
    main {
        java.srcDir("src/main/scala")
        resources.srcDirs("src/main/resources")
    }
    test{
        java.srcDirs("src/test/scala")
        resources.srcDirs("src/test/resources")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks {
    test {
        testLogging.showExceptions = true
    }
}