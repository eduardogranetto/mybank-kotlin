import com.google.protobuf.gradle.*
import org.gradle.api.JavaVersion.VERSION_17
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	id ("com.google.protobuf") version "0.8.19"
}

group = "io.mybank"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = VERSION_17

repositories {
	mavenCentral()
}

val openApiUiVersion = "1.6.9"
val grpcVersion      = "1.45.0"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.flywaydb:flyway-core")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.postgresql:postgresql")
	implementation("org.springdoc:springdoc-openapi-ui:${openApiUiVersion}")

	implementation("io.grpc:grpc-netty:${grpcVersion}")
	implementation("io.grpc:grpc-protobuf:${grpcVersion}")
	implementation("io.grpc:grpc-stub:${grpcVersion}")
	implementation("io.micrometer:micrometer-registry-prometheus")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.getByName<Jar>("jar") {
	enabled = false
}

protobuf {
	generatedFilesBaseDir = "$buildDir/generated/sources/proto"
	protoc {
		artifact = "com.google.protobuf:protoc:3.21.2"
	}

	plugins {
		id("grpc") {
			artifact = "io.grpc:protoc-gen-grpc-java:1.48.0"
		}
	}
	generateProtoTasks {
		all().forEach {
			it.plugins {
				id("grpc"){
					outputSubDir = "grpc"
				}
			}
		}
	}
}

sourceSets{
	main{
		proto{
			srcDir("$buildDir/generated/sources/proto/main/grpc")
		}
	}
}
