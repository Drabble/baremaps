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

package com.baremaps.postgres.handlers;

import java.io.DataOutputStream;
import java.io.IOException;

public class ByteValueHandler<T extends Number> extends BaseValueHandler<T> {

  @Override
  protected void internalHandle(DataOutputStream buffer, final T value) throws IOException {
    buffer.writeInt(1);
    buffer.writeByte(value.byteValue());
  }
}
