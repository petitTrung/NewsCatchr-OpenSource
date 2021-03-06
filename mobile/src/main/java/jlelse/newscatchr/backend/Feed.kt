/*
 * NewsCatchr  Copyright (C) 2016  Jan-Lukas Else
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package jlelse.newscatchr.backend

import android.support.annotation.Keep
import com.afollestad.bridge.annotations.Body
import com.afollestad.bridge.annotations.ContentType

@Keep
@ContentType("application/json")
class Feed {

    constructor()

    @Body
    var title: String? = null
    @Body(name = "id")
    var feedIdA: String? = null
    @Body
    var feedId: String? = null
    @Body
    var website: String? = null
    @Body
    var topics: Array<String>? = null

    var saved: Boolean = false

    fun url(): String? {
        return if (feedId != null) {
            if (feedId?.startsWith("feed") ?: false) feedId?.substring(5) else feedId
        } else if (feedIdA != null) {
            if (feedIdA?.startsWith("feed") ?: false) feedIdA?.substring(5) else feedIdA
        } else null
    }

}
