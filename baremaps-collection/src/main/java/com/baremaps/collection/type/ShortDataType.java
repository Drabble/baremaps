/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.baremaps.collection.type;

import java.nio.ByteBuffer;

/** A {@link DataType} for reading and writing shorts in {@link ByteBuffer}s. */
public class ShortDataType implements SizedDataType<Short> {

  /** {@inheritDoc} */
  @Override
  public int size(Short value) {
    return 2;
  }

  /** {@inheritDoc} */
  @Override
  public void write(ByteBuffer buffer, int position, Short value) {
    buffer.putShort(position, value);
  }

  /** {@inheritDoc} */
  @Override
  public Short read(ByteBuffer buffer, int position) {
    return buffer.getShort(position);
  }
}
