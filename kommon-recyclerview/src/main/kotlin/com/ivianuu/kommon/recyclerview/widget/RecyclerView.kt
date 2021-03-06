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

package com.ivianuu.kommon.recyclerview.widget

import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.doOnScrollStateChanged(block: ((recyclerView: RecyclerView, newState: Int) -> Unit)?): RecyclerView.OnScrollListener =
    addOnScrollListener(onScrollStateChanged = block)

fun RecyclerView.doOnScrolled(block: ((recyclerView: RecyclerView, dx: Int, dy: Int) -> Unit)?): RecyclerView.OnScrollListener =
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

fun RecyclerView.doOnItemInterceptTouchEvent(block: (rv: RecyclerView, e: MotionEvent) -> Boolean): RecyclerView.OnItemTouchListener =
    addOnItemTouchListener(onInterceptTouchEvent = block)

fun RecyclerView.doOnItemTouchEvent(block: (rv: RecyclerView, e: MotionEvent) -> Unit): RecyclerView.OnItemTouchListener =
    addOnItemTouchListener(onTouchEvent = block)

fun RecyclerView.doOnItemRequestDisallowInterceptTouchEvent(block: (disallowIntercept: Boolean) -> Unit): RecyclerView.OnItemTouchListener =
    addOnItemTouchListener(onRequestDisallowInterceptTouchEvent = block)

fun RecyclerView.addOnItemTouchListener(
    onInterceptTouchEvent: ((rv: RecyclerView, e: MotionEvent) -> Boolean)? = null,
    onTouchEvent: ((rv: RecyclerView, e: MotionEvent) -> Unit)? = null,
    onRequestDisallowInterceptTouchEvent: ((disallowIntercept: Boolean) -> Unit)? = null
): RecyclerView.OnItemTouchListener {
    val listener = object : RecyclerView.OnItemTouchListener {
        override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean =
            onInterceptTouchEvent?.invoke(rv, e) ?: false

        override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
            onTouchEvent?.invoke(rv, e)
        }

        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
            onRequestDisallowInterceptTouchEvent?.invoke(disallowIntercept)
        }
    }
    addOnItemTouchListener(listener)
    return listener
}

fun RecyclerView.doOnChildViewAttachedToWindow(block: (view: View) -> Unit): RecyclerView.OnChildAttachStateChangeListener =
    addOnChildAttachStateChangeListener(onChildViewAttachedToWindow = block)

fun RecyclerView.doOnChildViewDetachedFromWindow(block: (view: View) -> Unit): RecyclerView.OnChildAttachStateChangeListener =
    addOnChildAttachStateChangeListener(onChildViewDetachedFromWindow = block)

fun RecyclerView.addOnChildAttachStateChangeListener(
    onChildViewAttachedToWindow: ((view: View) -> Unit)? = null,
    onChildViewDetachedFromWindow: ((view: View) -> Unit)? = null
): RecyclerView.OnChildAttachStateChangeListener {
    val listener = object : RecyclerView.OnChildAttachStateChangeListener {
        override fun onChildViewAttachedToWindow(view: View) {
            onChildViewAttachedToWindow?.invoke(view)
        }

        override fun onChildViewDetachedFromWindow(view: View) {
            onChildViewDetachedFromWindow?.invoke(view)
        }
    }
    addOnChildAttachStateChangeListener(listener)
    return listener
}

fun RecyclerView.Adapter<*>.doOnChanged(block: () -> Unit): RecyclerView.AdapterDataObserver =
    registerAdapterDataObserver(onChanged = block)

fun RecyclerView.Adapter<*>.doOnItemRangeChanged(block: (positionStart: Int, itemCount: Int, payload: Any?) -> Unit): RecyclerView.AdapterDataObserver =
    registerAdapterDataObserver(onItemRangeChanged = block)

fun RecyclerView.Adapter<*>.doOnItemRangeInserted(block: (positionStart: Int, itemCount: Int) -> Unit): RecyclerView.AdapterDataObserver =
    registerAdapterDataObserver(onItemRangeInserted = block)

fun RecyclerView.Adapter<*>.doOnItemRangeRemoved(block: (positionStart: Int, itemCount: Int) -> Unit): RecyclerView.AdapterDataObserver =
    registerAdapterDataObserver(onItemRangeRemoved = block)

fun RecyclerView.Adapter<*>.doOnItemRangeMoved(block: (fromPosition: Int, toPosition: Int, itemCount: Int) -> Unit): RecyclerView.AdapterDataObserver =
    registerAdapterDataObserver(onItemRangeMoved = block)

fun RecyclerView.Adapter<*>.registerAdapterDataObserver(
    onChanged: (() -> Unit?)? = null,
    onItemRangeChanged: ((positionStart: Int, itemCount: Int, payload: Any?) -> Unit)? = null,
    onItemRangeInserted: ((positionStart: Int, itemCount: Int) -> Unit)? = null,
    onItemRangeRemoved: ((positionStart: Int, itemCount: Int) -> Unit)? = null,
    onItemRangeMoved: ((fromPosition: Int, toPosition: Int, itemCount: Int) -> Unit)? = null
): RecyclerView.AdapterDataObserver {
    val observer = object : RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            onChanged?.invoke()
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
            onItemRangeChanged?.invoke(positionStart, itemCount, payload)
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            onItemRangeInserted?.invoke(positionStart, itemCount)
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            onItemRangeRemoved?.invoke(positionStart, itemCount)
        }

        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
            onItemRangeMoved?.invoke(fromPosition, toPosition, itemCount)
        }
    }
    registerAdapterDataObserver(observer)
    return observer
}