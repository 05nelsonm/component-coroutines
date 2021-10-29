# component-coroutines

A full list of `kotlin-components` projects can be found [HERE](https://kotlin-components.matthewnelson.io)

### Get Started

```kotlin
// build.gradle.kts

dependencies {
    implementation("io.matthewnelson.kotlin-components:coroutines:1.0.0")
}
```

```groovy
// build.gradle

dependencies {
    implementation "io.matthewnelson.kotlin-components:coroutines:1.0.0"
}
```

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
$ git clone --recursive https://github.com/05nelsonm/component-request.git
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
