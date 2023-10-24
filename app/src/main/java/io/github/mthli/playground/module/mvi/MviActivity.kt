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

package io.github.mthli.playground.module.mvi

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import io.github.mthli.playground.R
import io.github.mthli.playground.databinding.ActivityMviBinding
import org.orbitmvi.orbit.viewmodel.observe

class MviActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMviBinding
    private val viewModel by viewModels<CalculatorViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.observe(this, state = ::render, sideEffect = ::handleSideEffect)
        binding.add.setOnClickListener { viewModel.add(1) }
    }

    private fun render(state: CalculatorState) {
        binding.total.text = getString(R.string.text_total, state.total)
    }

    private fun handleSideEffect(sideEffect: CalculatorSideEffect) {
        when (sideEffect) {
            is CalculatorSideEffect.Toast -> {
                Toast.makeText(this, sideEffect.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
