plugins{
    id("com.github.johnrengelman.shadow") version("7.1.2")
    java
}

repositories{
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies{
    implementation(project(":api"))
    compileOnly("org.spigotmc:spigot-api:1.19.2-R0.1-SNAPSHOT")
}