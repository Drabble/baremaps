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

package com.baremaps.osm.function;

import com.baremaps.osm.model.DataBlock;
import com.baremaps.osm.model.Entity;
import com.baremaps.osm.model.HeaderBlock;
import java.util.function.Consumer;

/** Represents an operation on the entities of blocks of different types. */
public class BlockEntityConsumer implements BlockConsumer {

  private final Consumer<Entity> consumer;

  /**
   * Constructs a block consumer that applies the specified consumer to the block entities.
   *
   * @param consumer the entity consumer
   */
  public BlockEntityConsumer(Consumer<Entity> consumer) {
    this.consumer = consumer;
  }

  /** {@inheritDoc} */
  @Override
  public void match(HeaderBlock headerBlock) throws Exception {
    consumer.accept(headerBlock.getHeader());
    consumer.accept(headerBlock.getBound());
  }

  /** {@inheritDoc} */
  @Override
  public void match(DataBlock dataBlock) throws Exception {
    dataBlock.getDenseNodes().forEach(consumer);
    dataBlock.getNodes().forEach(consumer);
    dataBlock.getWays().forEach(consumer);
    dataBlock.getRelations().forEach(consumer);
  }
}
