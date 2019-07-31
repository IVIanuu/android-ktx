/*
 * Copyright 2019 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.kommon.core.widget

import android.widget.SeekBar

fun SeekBar.doOnProgressChanged(block: (seekBar: SeekBar, progress: Int, fromUser: Boolean) -> Unit): SeekBar.OnSeekBarChangeListener =
    setOnSeekBarChangeListener(onProgressChanged = block)

fun SeekBar.doOnStartTrackingTouch(block: (seekBar: SeekBar) -> Unit): SeekBar.OnSeekBarChangeListener =
    setOnSeekBarChangeListener(onStartTrackingTouch = block)

fun SeekBar.doOnStopTrackingTouch(block: (seekBar: SeekBar) -> Unit): SeekBar.OnSeekBarChangeListener =
    setOnSeekBarChangeListener(onStopTrackingTouch = block)

fun SeekBar.setOnSeekBarChangeListener(
    onProgressChanged: ((seekBar: SeekBar, progress: Int, fromUser: Boolean) -> Unit)? = null,
    onStartTrackingTouch: ((seekBar: SeekBar) -> Unit)? = null,
    onStopTrackingTouch: ((seekBar: SeekBar) -> Unit)? = null
): SeekBar.OnSeekBarChangeListener {
    val listener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            onProgressChanged?.invoke(seekBar, progress, fromUser)
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {
            onStartTrackingTouch?.invoke(seekBar)
        }

        override fun onStopTrackingTouch(seekBar: SeekBar) {
            onStopTrackingTouch?.invoke(seekBar)
        }
    }
    setOnSeekBarChangeListener(listener)
    return listener
}