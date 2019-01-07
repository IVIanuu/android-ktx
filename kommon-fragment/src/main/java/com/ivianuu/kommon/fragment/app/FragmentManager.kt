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

package com.ivianuu.kommon.fragment.app

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

inline fun <reified T : Fragment> FragmentManager.fragmentById(id: Int): T =
    findFragmentById(id) as T

inline fun <reified T : Fragment> FragmentManager.fragmentByIdOrNull(id: Int): T? = try {
    fragmentById<T>(id)
} catch (e: Exception) {
    null
}

inline fun <reified T : Fragment> FragmentManager.fragmentByTag(tag: String): T =
    findFragmentByTag(tag) as T

inline fun <reified T : Fragment> FragmentManager.fragmentByIdOrNull(tag: String): T? = try {
    fragmentByTag<T>(tag)
} catch (e: Exception) {
    null
}

fun FragmentManager.doOnFragmentPreAttached(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment, context: Context) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentPreAttached = block)

fun FragmentManager.doOnFragmentAttached(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment, context: Context) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentAttached = block)

fun FragmentManager.doOnFragmentPreCreated(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentPreCreated = block)

fun FragmentManager.doOnFragmentCreated(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentCreated = block)

fun FragmentManager.doOnFragmentActivityCreated(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentActivityCreated = block)

fun FragmentManager.doOnFragmentViewCreated(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment, view: View, savedInstanceState: Bundle?) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentViewCreated = block)

fun FragmentManager.doOnFragmentStarted(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentStarted = block)

fun FragmentManager.doOnFragmentResumed(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentResumed = block)

fun FragmentManager.doOnFragmentPaused(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentPaused = block)

fun FragmentManager.doOnFragmentStopped(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentStopped = block)

fun FragmentManager.doOnFragmentSaveInstanceState(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment, outState: Bundle) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentSaveInstanceState = block)

fun FragmentManager.doOnFragmentViewDestroyed(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentViewDestroyed = block)

fun FragmentManager.doOnFragmentDestroyed(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentDestroyed = block)

fun FragmentManager.doOnFragmentDetached(
    recursive: Boolean,
    block: (fm: FragmentManager, f: Fragment) -> Unit
): FragmentManager.FragmentLifecycleCallbacks =
    registerFragmentLifecycleCallbacks(recursive, onFragmentDetached = block)

fun FragmentManager.registerFragmentLifecycleCallbacks(
    recursive: Boolean,
    onFragmentPreAttached: ((fm: FragmentManager, f: Fragment, context: Context) -> Unit)? = null,
    onFragmentAttached: ((fm: FragmentManager, f: Fragment, context: Context) -> Unit)? = null,
    onFragmentPreCreated: ((fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) -> Unit)? = null,
    onFragmentCreated: ((fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) -> Unit)? = null,
    onFragmentActivityCreated: ((fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) -> Unit)? = null,
    onFragmentViewCreated: ((fm: FragmentManager, f: Fragment, view: View, savedInstanceState: Bundle?) -> Unit)? = null,
    onFragmentStarted: ((fm: FragmentManager, f: Fragment) -> Unit)? = null,
    onFragmentResumed: ((fm: FragmentManager, f: Fragment) -> Unit)? = null,
    onFragmentPaused: ((fm: FragmentManager, f: Fragment) -> Unit)? = null,
    onFragmentStopped: ((fm: FragmentManager, f: Fragment) -> Unit)? = null,
    onFragmentSaveInstanceState: ((fm: FragmentManager, f: Fragment, outState: Bundle) -> Unit)? = null,
    onFragmentViewDestroyed: ((fm: FragmentManager, f: Fragment) -> Unit)? = null,
    onFragmentDestroyed: ((fm: FragmentManager, f: Fragment) -> Unit)? = null,
    onFragmentDetached: ((fm: FragmentManager, f: Fragment) -> Unit)? = null
): FragmentManager.FragmentLifecycleCallbacks {
    val callbacks = object : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentPreAttached(fm: FragmentManager, f: Fragment, context: Context) {
            onFragmentPreAttached?.invoke(fm, f, context)
        }

        override fun onFragmentAttached(fm: FragmentManager, f: Fragment, context: Context) {
            onFragmentAttached?.invoke(fm, f, context)
        }

        override fun onFragmentPreCreated(
            fm: FragmentManager,
            f: Fragment,
            savedInstanceState: Bundle?
        ) {
            onFragmentPreCreated?.invoke(fm, f, savedInstanceState)
        }

        override fun onFragmentCreated(
            fm: FragmentManager,
            f: Fragment,
            savedInstanceState: Bundle?
        ) {
            onFragmentCreated?.invoke(fm, f, savedInstanceState)
        }

        override fun onFragmentActivityCreated(
            fm: FragmentManager,
            f: Fragment,
            savedInstanceState: Bundle?
        ) {
            onFragmentActivityCreated?.invoke(fm, f, savedInstanceState)
        }

        override fun onFragmentViewCreated(
            fm: FragmentManager,
            f: Fragment,
            v: View,
            savedInstanceState: Bundle?
        ) {
            onFragmentViewCreated?.invoke(fm, f, v, savedInstanceState)
        }

        override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
            onFragmentStarted?.invoke(fm, f)
        }

        override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
            onFragmentResumed?.invoke(fm, f)
        }

        override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
            onFragmentPaused?.invoke(fm, f)
        }

        override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {
            onFragmentStopped?.invoke(fm, f)
        }

        override fun onFragmentSaveInstanceState(
            fm: FragmentManager,
            f: Fragment,
            outState: Bundle
        ) {
            onFragmentSaveInstanceState?.invoke(fm, f, outState)
        }

        override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
            onFragmentViewDestroyed?.invoke(fm, f)
        }

        override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
            onFragmentDestroyed?.invoke(fm, f)
        }

        override fun onFragmentDetached(fm: FragmentManager, f: Fragment) {
            onFragmentDetached?.invoke(fm, f)
        }
    }
    registerFragmentLifecycleCallbacks(callbacks, recursive)
    return callbacks
}