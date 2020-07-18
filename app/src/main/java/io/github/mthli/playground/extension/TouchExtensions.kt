/*
 * Copyright 2020 Matthew Lee
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

package io.github.mthli.playground.extension

import android.view.MotionEvent

fun MotionEvent.getActionName() = when (action) {
    MotionEvent.ACTION_DOWN -> "ACTION_DOWN"
    MotionEvent.ACTION_MOVE -> "ACTION_MOVE"
    MotionEvent.ACTION_UP -> "ACTION_UP"
    MotionEvent.ACTION_CANCEL -> "ACTION_CANCEL"
    else -> "IGNORE"
}
