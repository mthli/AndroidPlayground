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

package io.github.mthli.playground.module.flow

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import io.github.mthli.playground.R
import io.github.mthli.playground.databinding.ActivityFlowBinding
import kotlinx.coroutines.launch

class FlowActivity : AppCompatActivity() {

    private val viewModel by viewModels<FlowViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.add.setOnClickListener { viewModel.add(1) }

        // lifecycleScope launch in Dispatchers.Main
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.addState().collect {
                    binding.total.text = getString(R.string.text_total, it)
                }
            }
        }
    }
}
