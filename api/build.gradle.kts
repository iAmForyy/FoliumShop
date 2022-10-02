plugins{
    java
}

repositories{
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies{
    compileOnly("org.spigotmc:spigot-api:1.19.2-R0.1-SNAPSHOT")
}