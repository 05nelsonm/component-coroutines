# component-coroutines
[![badge-license]][url-license]
[![badge-latest-release]][url-latest-release]

[![badge-kotlin]][url-kotlin]
[![badge-coroutines]][url-coroutines]

![badge-platform-android]
![badge-platform-jvm]
![badge-platform-js]
![badge-platform-js-node]
![badge-platform-linux]
![badge-platform-macos]
![badge-platform-ios]
![badge-platform-tvos]
![badge-platform-watchos]
![badge-platform-windows]
![badge-support-apple-silicon]
![badge-support-js-ir]

Referencing Coroutine `Dispatchers` within a class makes testing difficult which is why passing the `CoroutineDispatcher` via 
constructor arguments is a wise decision. `component-coroutines`' `CoroutineDispatchers` interface serves as a wedge that points to 
whatever dispatcher you set it up with.

A full list of `kotlin-components` projects can be found [HERE](https://kotlin-components.matthewnelson.io)

### Get Started

<!-- TAG_VERSION -->

```kotlin
// build.gradle.kts

dependencies {
    implementation("io.matthewnelson.kotlin-components:coroutines:1.1.4")
}
```

<!-- TAG_VERSION -->

```groovy
// build.gradle

dependencies {
    implementation "io.matthewnelson.kotlin-components:coroutines:1.1.4"
}
```

### Kotlin Version Compatibility

**Note:** as of `1.1.0`, the experimental memory model for KotlinNative is enabled.

<!-- TAG_VERSION -->

| coroutines | kotlin | kotlinx-coroutines |
|:----------:|:------:|:------------------:|
|   1.1.4    | 1.7.20 |       1.6.4        |
|   1.1.3    | 1.6.21 |       1.6.3        |
|   1.1.2    | 1.6.21 |       1.6.1        |
|   1.1.1    | 1.6.21 |       1.6.1        |
|   1.1.0    | 1.6.10 |       1.6.0        |
|   1.0.0    | 1.5.31 |       1.5.2        |

### `CoroutineDispatchers` Example (Using Android ViewModel + Hilt)
```kotlin
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun provideCoroutineDispatchers(): CoroutineDispatchers =
        object : CoroutineDispatchers {
            override val default: CoroutineDispatcher
                get() = Dispatchers.Default
            override val io: CoroutineDispatcher
                get() = Dispatchers.IO
            override val main: CoroutineDispatcher
                get() = Dispatchers.Main
            override val mainImmediate: CoroutineDispatcher
                get() = Dispatchers.Main.immediate
            override val unconfined: CoroutineDispatcher
                get() = Dispatchers.Unconfined
        }

}

@HiltViewModel
class MyViewModel @Inject constructor(
    dispatchers: CoroutineDispatchers
): ViewModel(), CoroutineDispatchers by dispatchers {

    init {
        viewModelScope.launch(io) {
            // do work
        }
    }

}
```

### Git

This project utilizes git submodules. You will need to initialize them when
cloning the repository via:

```bash
$ git clone --recursive https://github.com/05nelsonm/component-coroutines.git
```

If you've already cloned the repository, run:
```bash
$ git checkout master
$ git pull
$ git submodule update --init
```

In order to keep submodules updated when pulling the latest code, run:
```bash
$ git pull --recurse-submodules
```

<!-- TAG_VERSION -->
[badge-latest-release]: https://img.shields.io/badge/latest--release-1.1.4-blue.svg?style=flat
[badge-license]: https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat

<!-- TAG_DEPENDENCIES -->
[badge-kotlin]: https://img.shields.io/badge/kotlin-1.7.20-blue.svg?logo=kotlin
[badge-coroutines]: https://img.shields.io/badge/coroutines-1.6.4-blue.svg?logo=kotlin

<!-- TAG_PLATFORMS -->
[badge-platform-android]: http://img.shields.io/badge/-android-6EDB8D.svg?style=flat
[badge-platform-jvm]: http://img.shields.io/badge/-jvm-DB413D.svg?style=flat
[badge-platform-js]: http://img.shields.io/badge/-js-F8DB5D.svg?style=flat
[badge-platform-js-node]: https://img.shields.io/badge/-nodejs-68a063.svg?style=flat
[badge-platform-linux]: http://img.shields.io/badge/-linux-2D3F6C.svg?style=flat
[badge-platform-macos]: http://img.shields.io/badge/-macos-111111.svg?style=flat
[badge-platform-ios]: http://img.shields.io/badge/-ios-CDCDCD.svg?style=flat
[badge-platform-tvos]: http://img.shields.io/badge/-tvos-808080.svg?style=flat
[badge-platform-watchos]: http://img.shields.io/badge/-watchos-C0C0C0.svg?style=flat
[badge-platform-wasm]: https://img.shields.io/badge/-wasm-624FE8.svg?style=flat
[badge-platform-windows]: http://img.shields.io/badge/-windows-4D76CD.svg?style=flat
[badge-support-android-native]: http://img.shields.io/badge/support-[AndroidNative]-6EDB8D.svg?style=flat
[badge-support-apple-silicon]: http://img.shields.io/badge/support-[AppleSilicon]-43BBFF.svg?style=flat
[badge-support-js-ir]: https://img.shields.io/badge/support-[js--IR]-AAC4E0.svg?style=flat

[url-latest-release]: https://github.com/05nelsonm/component-coroutines/releases/latest
[url-license]: https://www.apache.org/licenses/LICENSE-2.0.txt
[url-kotlin]: https://kotlinlang.org
[url-coroutines]: https://github.com/Kotlin/kotlinx.coroutines
