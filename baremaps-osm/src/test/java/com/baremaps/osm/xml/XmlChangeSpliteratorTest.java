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

package com.baremaps.osm.xml;

import static com.baremaps.testing.TestFiles.DATA_OSC_XML;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.baremaps.osm.model.Change;
import com.baremaps.stream.AccumulatingConsumer;
import com.baremaps.stream.HoldingConsumer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Spliterator;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class XmlChangeSpliteratorTest {

  @Test
  void tryAdvance() throws IOException {
    try (InputStream input = Files.newInputStream(DATA_OSC_XML)) {
      Spliterator<Change> spliterator = new XmlChangeSpliterator(input);
      spliterator.forEachRemaining(fileBlock -> assertNotNull(fileBlock));
      assertFalse(spliterator.tryAdvance(new HoldingConsumer<>()));
    }
  }

  @Test
  void forEachRemaining() throws IOException {
    try (InputStream input = Files.newInputStream(DATA_OSC_XML)) {
      Spliterator<Change> spliterator = new XmlChangeSpliterator(input);
      AccumulatingConsumer<Change> accumulator = new AccumulatingConsumer<>();
      spliterator.forEachRemaining(accumulator);
      assertEquals(accumulator.values().size(), 7);
      assertEquals(
        accumulator.values().stream()
          .flatMap(change -> change.getEntities().stream())
          .collect(Collectors.toList())
          .size(),
        51);
    }
  }
}
