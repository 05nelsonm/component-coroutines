/*
 *  Copyright 2021 Matthew Nelson
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * */
package io.matthewnelson.component.coroutines

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Serves as a wedge between [kotlinx.coroutines.Dispatchers] and your coroutines such
 * that you are able to inject [CoroutineDispatchers] and use, while altering the
 * retrieved [CoroutineDispatcher] for things like testing. Helps with multiplatform
 * projects as you can write all the code in `commonMain` while providing
 * [CoroutineDispatchers] configured for the specific platform.
 * */
interface CoroutineDispatchers {
    val default: CoroutineDispatcher
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val mainImmediate: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}
