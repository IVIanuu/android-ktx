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

package com.ivianuu.kommon.core.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(layoutResId: Int, attachToRoot: Boolean = false): View {
    return inflate<View>(layoutResId, attachToRoot)
}

@JvmName("inflateTyped")
fun <T : View> ViewGroup.inflate(layoutResId: Int, attachToRoot: Boolean = false): T {
    return LayoutInflater.from(context).inflate(layoutResId, this, attachToRoot) as T
}

fun ViewGroup.doOnChildViewAdded(block: (parent: View, child: View) -> Unit): ViewGroup.OnHierarchyChangeListener =
    setOnHierarchyChangeListener(onChildViewAdded = block)

fun ViewGroup.doOnChildViewRemoved(block: (parent: View, child: View) -> Unit): ViewGroup.OnHierarchyChangeListener =
    setOnHierarchyChangeListener(onChildViewRemoved = block)

fun ViewGroup.setOnHierarchyChangeListener(
    onChildViewAdded: ((parent: View, child: View) -> Unit)? = null,
    onChildViewRemoved: ((parent: View, child: View) -> Unit)? = null
): ViewGroup.OnHierarchyChangeListener {
    val listener = object : ViewGroup.OnHierarchyChangeListener {
        override fun onChildViewAdded(parent: View, child: View) {
            onChildViewAdded?.invoke(parent, child)
        }

        override fun onChildViewRemoved(parent: View, child: View) {
            onChildViewRemoved?.invoke(parent, child)
        }
    }
    setOnHierarchyChangeListener(listener)
    return listener
}