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

package io.github.mthli.playground

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.mthli.playground.databinding.ActivityMainBinding
import io.github.mthli.playground.module.nestedscrolling.NestedActivity
import io.github.mthli.playground.module.touch.TouchActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.touch.setOnClickListener { startActivity(Intent(this, TouchActivity::class.java)) }
        binding.nestedScrolling.setOnClickListener { startActivity(Intent(this, NestedActivity::class.java)) }
    }
}
