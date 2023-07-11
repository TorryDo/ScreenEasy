# ScreenEasy - ScreenEz

Note: Work In Progress / Experiment Project

I. Setup:
<details> <summary> Ensure your app’s minimum SDK version is 21+ and `mavenCentral()` included</summary>
</br>
1. Ensure your app’s minimum SDK version is 21+. This is declared in the module-level `build.gradle` file 

```gradle
android {
    defaultConfig {
        ...
        minSdk 21
    }
```

2. Ensure the `mavenCentral()` repository is declared in the project-level `build.gradle` or `setting.gradle` file:

    <details><summary>build.gradle (project-level)</summary>

    ```gradle
        allprojects {
            repositories {
                mavenCentral()
                ...
            }
            ...
        }
    ```

    </details>


    <details><summary>Alternative (In case "allprojects" not found). go to settings.gradle</summary>

    ```gradle
    pluginManagement {
        repositories {
            ...
            mavenCentral()
        }
    }
    dependencyResolutionManagement {
        ...
        repositories {
            ...
            mavenCentral()
        }
    }
    ```

    </details>

</details>

<br>


Declare the dependencies in the module-level `build.gradle` file 🍀 <img src="https://img.shields.io/maven-central/v/io.github.torrydo/screen-easy" valign="middle">

```gradle
    dependencies {
        implementation "io.github.torrydo:screen-easy:<LATEST_VERSION>"
    }
```
<br>


I. Reality:

- windowManager.defaultDisplay
- display.width , display.height
- display.getRealMetrics(...)
