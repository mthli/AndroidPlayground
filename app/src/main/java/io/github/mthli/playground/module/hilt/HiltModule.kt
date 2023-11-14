/*
 * Copyright 2023 Matthew Lee
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.mthli.playground.module.hilt

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Qualifier

@Qualifier
annotation class DateFormat0

@Qualifier
annotation class DateFormat1

@Module
@InstallIn(ActivityComponent::class)
abstract class HiltModule {

    // https://github.com/google/dagger/issues/1691#issuecomment-919514915
    // error: A @Module may not contain both non-static and abstract binding methods.
    companion object {
        @Provides
        @DateFormat0
        fun provideDateFormat0(): DateFormat {
            return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault())
        }

        @Provides
        @DateFormat1
        fun provideDateFormat1(): DateFormat {
            return SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z", Locale.getDefault())
        }
    }

    @Binds
    abstract fun hilt(impl: HiltImpl): IHilt
}
