```
TorangNetwork/gradle % git submodule add https://github.com/sarang628/TorangToml.git
Cloning into '/Users/sarangyang/AndroidStudioProjects/TorangNetwork/gradle/TorangToml'...
remote: Enumerating objects: 278, done.
remote: Counting objects: 100% (116/116), done.
remote: Compressing objects: 100% (43/43), done.
remote: Total 278 (delta 40), reused 111 (delta 36), pack-reused 162 (from 1)
Receiving objects: 100% (278/278), 30.75 KiB | 2.56 MiB/s, done.
Resolving deltas: 100% (93/93), done.
```

settings
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    versionCatalogs {
        create("libs") {
            from(files("gradle/TorangToml/libs.versions.toml"))
        }
    }
}
```