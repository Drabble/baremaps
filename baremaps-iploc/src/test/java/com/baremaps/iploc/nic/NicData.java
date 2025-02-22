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

package com.baremaps.iploc.nic;

import com.baremaps.testing.TestFiles;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

public class NicData {

  private static final String SAMPLE = "sample.txt";

  public static List<NicObject> sample(String resource) throws IOException {
    try (InputStream input = Files.newInputStream(TestFiles.resolve(resource))) {
      return NicParser.parse(input).toList();
    }
  }
}
