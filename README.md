# ScreenEasy 💎 ScreenEz
🔥 An Android library that provides quick access to screen attributes like: `screenSize`, `cutout`, `status/navbar`, `safeArea`, ... without worrying about headache, deprecated stuffs. 

&nbsp;

<div align="center">

| what we want | reality |
| :-: | :-: |
| <img src="https://github.com/TorryDo/assets/blob/main/screen_easy/demo/what_we_want.png" width="300"> | <img src="https://github.com/TorryDo/assets/blob/main/screen_easy/demo/reality.png" width="500"> |

[<img src="https://img.shields.io/badge/platform-Android-yellow.svg" valign="middle">](https://www.android.com) 
[<img src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat" valign="middle">](https://android-arsenal.com/api?level=21) 
[<img src="https://img.shields.io/maven-central/v/io.github.torrydo/screen-easy" valign="middle">]() 
[<img src="https://img.shields.io/badge/License-Apache_2.0-blue.svg" valign="middle">](https://www.apache.org/licenses/LICENSE-2.0)


</div>

<br>

## Table of Contents 📝
> 1. [Install](#install)
> 2. [Usage](#usage)
> 3. [Contribution guide](#contribution_guide)
> 4. [WIP Note](#note) 🚧
> 5. [License](#license)

&nbsp;

## I. Install  <a name="install"/>
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


## II. Usage <a name="usage"/>
1, Firstly, init `ScreenEz.with(context)` anywhere in your project

> Optional: call `ScreenEz.refresh()` when configuration change (orientation/rotation change...)

> If you are developing a library that use `ScreenEasy` internally, please create an instance of `ScreenEasy()` instead. You can find the reason [here](https://github.com/TorryDo/ScreenEasy/issues/1)

<details><summary>Sample</summary>

```java
// consider using this approach instead if you are developing a library/submodule
val screenEasy = ScreenEasy()
screenEasy.with(context)
```

</details>



2, That's it, no more step needed, enjoy! 💖

<br>

<details><summary><b>Java</b></summary>

| API | Return | Description |
| :- | :- | :- |
| `with(context)` | None | Call this function one time before any other function to setup properly. Calling multiple times is okay, but unnecessary |
| `refresh()` | None | Refresh attributes, call when configuration change, rotation, ... |
| `getNavBarPadding()` | ScreenPadding | Represent screen padding of system bar for navigation |
| `getStatusBarPadding()` | ScreenPadding | Represent screen padding of status bar. |
| `getCutoutPadding()` | ScreenPadding | Represent screen padding of cutout for the notch, or smth similar |
| `getFullWidth()` | Int | Width of the screen in pixel |
| `getFullHeight()` | Int | Height of the screen in pixel |
| `getFullSize()` | Size | Size of the screen in pixel |
| `isButtonsNavigation()` | Boolean | True if buttons navigation is being used |
| `isGestureNavigation()` | Boolean | True if gesture navigation is being used |
| `getSafeArea()` | ScreenArea | The area of the screen that is not obscured by the navigation bar, status bar, or other system UI elements. |
| `getSafeScreenPadding()` | ScreenPadding | Returns the safe screen padding |
| `getSafePaddingLeft()` | Int | Padding for LEFT edge to avoid overlap with system UI |
| `getSafePaddingRight()` | Int | Padding for RIGHT edge to avoid overlap with system UI |
| `getSafePaddingTop()` | Int | Padding for TOP edge to avoid overlap with system UI |
| `getSafePaddingBottom()` | Int | Padding for BOTTOM edge to avoid overlap with system UI |
| `getSafeWidth()` | Int | The width of the screen after subtracting the system bar on the left and right sides |
| `getSafeHeight()` | Int | The height of the screen after subtracting the system bar on the top and bottom sides |
| `getSafeSize()` | Size | The Size(width, height) of the screen after subtracting the system bar on all sides |
| `getStatusBarHeight()` | Int |  status bar height (pixel unit) |
| `getNavBarHeight()` | Int | navigation bar height (both gesture and buttons in pixel unit) |
| `isPortrait()` | Boolean | True if screen is in portrait mode |
| `getScreenRotation()` | ScreenRotation | the rotation of the screen. (portrait, landscape, reversed...) |

</details>


<details open><summary><b>Kotlin</b></summary>

| API | Return | Description |
| :- | :- | :- |
| `with(context)` | None | Call this function one time before any other function to setup properly. Calling multiple times is okay, but unnecessary |
| `refresh()` | None | Refresh attributes, call when configuration change, rotation, ... |
| `navBarPadding` | ScreenPadding | Represent screen padding of system bar for navigation |
| `statusBarPadding` | ScreenPadding | Represent screen padding of status bar. |
| `cutoutPadding` | ScreenPadding | Represent screen padding of cutout for the notch, or smth similar |
| `fullWidth` | Int | Width of the screen in pixel |
| `fullHeight` | Int | Height of the screen in pixel |
| `fullSize` | Size | Size of the screen in pixel |
| `safeArea` | ScreenArea | The area of the screen that is not obscured by the navigation bar, status bar, or other system UI elements. |
| `safeScreenPadding` | ScreenPadding | Returns the safe screen padding |
| `safePaddingLeft` | Int | Padding for `LEFT` edge to avoid overlap with system UI |
| `safePaddingRight` | Int | Padding for `RIGHT` edge to avoid overlap with system UI |
| `safePaddingTop` | Int | Padding for `TOP` edge to avoid overlap with system UI |
| `safePaddingBottom` | Int | Padding for `BOTTOM` edge to avoid overlap with system UI |
| `safeWidth` | Int | The width of the screen after subtracting the system bar on the left and right sides |
| `safeHeight` | Int | The height of the screen after subtracting the system bar on the top and bottom sides |
| `safeSize` | Size | The `Size` of the screen after subtracting the system bar on all sides |
| `statusBarHeight` | Int |  status bar height (pixel unit) |
| `navBarHeight` | Int | navigation bar height (both gesture and buttons in pixel unit) |
| `screenRotation` | ScreenRotation | the rotation of the screen. (portrait, landscape, reversed...) |
| `isPortrait()` | Boolean | `true` if screen is in portrait mode, `false` otherwise |
| `isButtonsNavigation()` | Boolean | `true` if buttons navigation is being used |
| `isGestureNavigation()` | Boolean | `true` if gesture navigation is being used |

</details>







<br>

## III, Contribution Guide 👏  <a name="contribution_guide">

Contributions are welcome! 🙌

- If you come across a bug or have an idea for a new feature, please let us know by creating an [Issue](https://github.com/TorryDo/ScreenEasy/issues) 🐞🐛💡
- If you've already fixed a bug or implemented a feature, feel free to submit a [Pull request](https://github.com/TorryDo/ScreenEasy/pulls) 🚀
- Having questions, ideas, or feedback? Don't worry, I gotchu. Simply open a [Discussion](https://github.com/TorryDo/ScreenEasy/discussions) 🔊
- Find this project useful? Don't forget to show some love by giving a star ⭐

Thank you! 💖

<br>

## IV, Work in Progress 🚧 <a name="note">
This library is still under heavy development. There is still a lot of code cleanup to do, so expect breaking API changes over time.

Please refer to the following page to check out the change-log: [Releases](https://github.com/TorryDo/ScreenEasy/releases)

Everything's gonna be ok! 🍀

<br>

## V, License <a name="license"/>

```

    Copyright 2023 TorryDo

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

```

