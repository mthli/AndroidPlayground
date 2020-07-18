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

package io.github.mthli.playground.module.touch

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import io.github.mthli.playground.extension.getActionName

class TouchView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    companion object {
        private const val TAG = "View"
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        Log.i(TAG, "dispatchTouchEvent, action: ${event.getActionName()}")
        return super.dispatchTouchEvent(event)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        Log.i(TAG, "onTouchEvent, action: ${event.getActionName()}")
        // return super.onTouchEvent(event)
        return true
    }
}
