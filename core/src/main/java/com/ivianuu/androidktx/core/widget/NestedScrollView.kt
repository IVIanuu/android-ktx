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

package com.ivianuu.androidktx.core.widget

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.widget.NestedScrollView
import com.ivianuu.androidktx.core.view.color
import com.ivianuu.androidktx.internal.NO_GETTER
import com.ivianuu.androidktx.internal.noGetter
import com.ivianuu.androidktx.internal.setEdgeGlowColor

private val edgeGlows = arrayOf("mEdgeGlowLeft", "mEdgeGlowTop", "mEdgeGlowRight", "mEdgeGlowBottom")

var NestedScrollView.edgeGlowEffectColor: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(value) { setEdgeGlowColor(value, edgeGlows) }

var NestedScrollView.edgeGlowEffectColorResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(value) { edgeGlowEffectColor = color(value) }