import com.github.gradle.node.npm.task.NpmTask
import java.util.regex.Pattern.compile

plugins {
	java
	war
	id("org.springframework.boot") version "3.0.6"
	id("io.spring.dependency-management") version "1.1.0"
	// querydsl 관련 명령어
	// id("com.ewerk.gradle.plugins.querydsl") version "1.0.10" -> QueryDSL 플러그인 사용하지 않도록. 3.X.X 버전 위에선 gradlew로 빌드할때 문제가 있는거 같음.
	id("com.github.node-gradle.node") version "3.5.1"
}

node {
	val frontendNodeVersion = "16.15.0"
	val frontendNpmVersion = "8.5.5"
	val nodeDir = file("${project.projectDir}/../frontend")
	val npmDir = file("${project.projectDir}/../frontend/node_modules")
	val projectDir = file("${project.projectDir}/../frontend")
	val isDownload = System.getenv("REQUIRE_NODE_INSTALL") != null && System.getenv("REQUIRE_NODE_INSTALL") == "TRUE"

	println("### projectPath : ${project.projectDir}")
	println("### buildDir : ${project.buildDir}")
	println("### isDownload : $isDownload")

	version.set(frontendNodeVersion)
	npmVersion.set(frontendNpmVersion)
	download.set(isDownload)
	workDir.set(nodeDir)
	npmWorkDir.set(npmDir)
	nodeProjectDir.set(projectDir)
}

group = "com.kjs"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
//	implementation("org.springframework.boot:spring-boot-starter-jersey")
	//implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.security:spring-security-oauth2-client:6.0.2")
	implementation ("org.springframework.boot:spring-boot-starter-validation")
	//DB
	implementation("org.postgresql:postgresql:42.5.3")
	implementation("org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4.1:1.16")
	//JWT
	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
	implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")
	//QueryDSL
	implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")

	implementation("org.projectlombok:lombok:1.18.22")

	implementation("org.mapstruct:mapstruct:1.5.3.Final")
	implementation("org.jetbrains:annotations:24.0.0")


	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	annotationProcessor("com.querydsl:querydsl-apt:${dependencyManagement.importedProperties["querydsl.version"]}:jakarta")
	annotationProcessor("jakarta.annotation:jakarta.annotation-api")
	annotationProcessor("jakarta.persistence:jakarta.persistence-api")

	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

val nodeInstall = tasks.register<NpmTask>("nodeInstall") {
	args.set(listOf("install"))
}

val frontendTask = tasks.register<NpmTask>("frontendTask") {
	dependsOn(nodeInstall)
	args.set(listOf("run", "generate"))
}

val copyTask = tasks.register<Copy>("copy") {
	dependsOn(frontendTask)
	val frontendDir = "${project.projectDir}/../frontend/dist"
	val buildDir = "${project.buildDir}/resources/main/static/admin"
	from(file(frontendDir))
	into(file(buildDir))
	println("### copy done!! from : $frontendDir to $buildDir")
}

val cleanFrontTask = tasks.register("cleanFront", Delete::class) {
	delete("${project.projectDir}/../frontend/dist")
}

val generated = "src/main/generated"

tasks.withType<JavaCompile>().configureEach {
	options.compilerArgs.addAll(listOf(
			"--enable-preview",
			"-Amapstruct.unmappedTargetPolicy=IGNORE")) // ignore unmapped target global setting
	options.generatedSourceOutputDirectory.set(file(generated))
}


java.sourceSets["main"].java {
	srcDir(generated)
}

tasks.withType<Test>().configureEach {
	jvmArgs("--enable-preview")
}

tasks.withType<JavaExec>().configureEach {
	jvmArgs("--enable-preview")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
