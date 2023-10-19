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

package io.github.mthli.playground.module.nested

import android.annotation.SuppressLint
import android.view.View
import com.zhihu.android.sugaradapter.Layout
import com.zhihu.android.sugaradapter.SugarHolder
import io.github.mthli.playground.R

@SuppressLint("NonConstantResourceId")
@Layout(R.layout.layout_nested)
class NestedHolder(view: View) : SugarHolder<Int>(view) {
    override fun onBindData(data: Int) {
        rootView.setBackgroundResource(if (data % 2 == 0) R.color.indigo else R.color.cyan)
    }
}
