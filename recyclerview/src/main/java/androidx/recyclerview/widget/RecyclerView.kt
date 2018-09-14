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

package androidx.recyclerview.widget

import android.widget.EdgeEffect
import androidx.core.view.backgroundColor
import androidx.internal.NO_GETTER
import androidx.internal.field
import androidx.internal.noGetter
import androidx.internal.setEdgeGlowColor

private val edgeGlows = arrayOf("mLeftGlow", "mTopGlow", "mRightGlow", "mBottomGlow")

var RecyclerView.edgeGlowEffectColor: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) { setEdgeGlowColor(value, edgeGlows) }

var RecyclerView.edgeGlowEffectColorResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) { edgeGlowEffectColor = value }

inline fun <reified T : RecyclerView.Adapter<*>> RecyclerView.adapter() =
    adapter as T

inline fun <reified T : RecyclerView.Adapter<*>> RecyclerView.adapterOrNull() = try {
    adapter as T
} catch (e: Exception) {
    null
}

inline fun <reified T : RecyclerView.LayoutManager> RecyclerView.layoutManager() =
    layoutManager as T

inline fun <reified T : RecyclerView.LayoutManager> RecyclerView.layoutManagerOrNull() = try {
    layoutManager<T>()
} catch (e: Exception) {
    null
}

fun RecyclerView.doOnScrollStateChanged(block: ((recyclerView: RecyclerView, newState: Int) -> Unit)?) =
    addOnScrollListener(onScrollStateChanged = block)

fun RecyclerView.doOnScrolled(block: ((recyclerView: RecyclerView, dx: Int, dy: Int) -> Unit)?) =
    addOnScrollListener(onScrolled = block)

fun RecyclerView.addOnScrollListener(
    onScrollStateChanged: ((recyclerView: RecyclerView, newState: Int) -> Unit)? = null,
    onScrolled: ((recyclerView: RecyclerView, dx: Int, dy: Int) -> Unit)? = null
): RecyclerView.OnScrollListener {
    val listener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            onScrollStateChanged?.invoke(recyclerView, newState)
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            onScrolled?.invoke(recyclerView, dx, dy)
        }
    }
    addOnScrollListener(listener)
    return listener
}