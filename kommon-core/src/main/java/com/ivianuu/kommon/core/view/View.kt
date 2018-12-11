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

package com.ivianuu.kommon.core.view

import android.view.View
import android.view.ViewParent

fun <T : ViewParent> View.parent() = parent as T

fun <T> View.tag(key: Int) = getTag() as T

fun View.onClick(onClick: (View) -> Unit) {
    setOnClickListener(onClick)
}

fun View.onLongClick(onLongClick: (View) -> Boolean) {
    setOnLongClickListener(onLongClick)
}

fun View.doOnAttachedToWindow(block: (v: View) -> Unit) =
    addOnAttachStateChangeListener(onViewAttachedToWindow = block)

fun View.doOnDetachedFromWindow(block: (v: View) -> Unit) =
    addOnAttachStateChangeListener(onViewDetachedFromWindow = block)

fun View.addOnAttachStateChangeListener(
    onViewAttachedToWindow: ((v: View) -> Unit)? = null,
    onViewDetachedFromWindow: ((v: View) -> Unit)? = null
): View.OnAttachStateChangeListener {
    val listener = object : View.OnAttachStateChangeListener {
        override fun onViewAttachedToWindow(v: View) {
            onViewAttachedToWindow?.invoke(v)
        }

        override fun onViewDetachedFromWindow(v: View) {
            onViewDetachedFromWindow?.invoke(v)
        }
    }

    addOnAttachStateChangeListener(listener)

    return listener
}