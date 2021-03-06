/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
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

package io.appium.espressoserver.lib.handlers.exceptions

import fi.iki.elonen.NanoHTTPD

class InvalidElementStateException : AppiumException {
    constructor() : super(
            "An element command could not be completed because the element is in an invalid state (error.g. attempting to click a disabled element)")

    constructor(reason: String) : super(reason) {}

    constructor(reason: String, cause: Throwable) : super(reason, cause) {}

    constructor(action: String, elementId: String, cause: Throwable) : super(
            String.format("Could not perform %s action on the element %s", action, elementId),
            cause) {
    }

    override fun error(): String {
        return "invalid element state"
    }

    override fun status(): NanoHTTPD.Response.Status {
        return NanoHTTPD.Response.Status.BAD_REQUEST
    }
}
