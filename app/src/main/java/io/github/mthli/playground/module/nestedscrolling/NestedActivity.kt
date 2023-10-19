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

package io.github.mthli.playground.module.nestedscrolling

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhihu.android.sugaradapter.SugarAdapter
import io.github.mthli.playground.R
import io.github.mthli.playground.databinding.ActivityNestedBinding

class NestedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityNestedBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_nested)

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = SugarAdapter.Builder
            .with(mutableListOf<Int>().apply { for (i in 0 until 100) add(i) })
            .add(NestedHolder::class.java).build()
    }
}
