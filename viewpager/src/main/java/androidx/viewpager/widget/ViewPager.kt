/*
 * Copyright 2018 Manuel Wrage
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

package androidx.viewpager.widget

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.view.color
import androidx.internal.NO_GETTER
import androidx.internal.noGetter
import androidx.internal.setEdgeGlowColor

private val edgeGlows = arrayOf("mEdgeGlowLeft", "mEdgeGlowTop", "mEdgeGlowRight", "mEdgeGlowBottom")

var ViewPager.edgeGlowEffectColor: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(value) { setEdgeGlowColor(value, edgeGlows) }

var ViewPager.edgeGlowEffectColorResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(value) { edgeGlowEffectColor = color(value) }

fun ViewPager.doOnPageScrolled(block: (position: Int, positionOffset: Float, positionOffsetPixels: Int) -> Unit) =
    addOnPageChangeListener(onPageScrolled = block)

fun ViewPager.doOnPageSelected(block: (position: Int) -> Unit) =
    addOnPageChangeListener(onPageSelected = block)

fun ViewPager.doOnPageScrollStateChanged(block: (state: Int) -> Unit) =
    addOnPageChangeListener(onPageScrollStateChanged = block)

fun ViewPager.addOnPageChangeListener(
    onPageScrolled: ((position: Int, positionOffset: Float, positionOffsetPixels: Int) -> Unit)? = null,
    onPageSelected: ((position: Int) -> Unit)? = null,
    onPageScrollStateChanged: ((state: Int) -> Unit)? = null
): ViewPager.OnPageChangeListener {
    val listener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            onPageScrolled?.invoke(position, positionOffset, positionOffsetPixels)
        }

        override fun onPageSelected(position: Int) {
            onPageSelected?.invoke(position)
        }

        override fun onPageScrollStateChanged(state: Int) {
            onPageScrollStateChanged?.invoke(state)
        }
    }
    addOnPageChangeListener(listener)
    return listener
}