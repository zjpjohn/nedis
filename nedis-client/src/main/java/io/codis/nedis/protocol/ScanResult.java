/**
 * Copyright (c) 2015 CodisLabs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
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
package io.codis.nedis.protocol;

import static io.codis.nedis.util.NedisUtils.toBytes;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangduo
 * @see http://redis.io/commands/scan
 */
public class ScanResult<T> {

    private static final byte[] FINISHED_CURSOR = toBytes("0");

    private final byte[] cursor;

    private final List<T> values;

    public ScanResult(byte[] cursor, List<T> values) {
        this.cursor = cursor;
        this.values = values;
    }

    public byte[] cursor() {
        return cursor;
    }

    public List<T> values() {
        return values;
    }

    public boolean more() {
        return !Arrays.equals(cursor, FINISHED_CURSOR);
    }
}
