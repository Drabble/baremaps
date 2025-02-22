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

package com.baremaps.workflow.tasks;

import static org.junit.jupiter.api.Assertions.*;

import com.baremaps.collection.utils.FileUtils;
import com.baremaps.testing.TestFiles;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnzipFileTest {

  @Test
  @Tag("integration")
  void run() throws IOException {
    var zip = TestFiles.resolve("monaco-shapefile.zip");
    var directory = Files.createTempDirectory("tmp_");
    var task = new UnzipFile(zip.toString(), directory.toString());
    task.run();
    FileUtils.deleteRecursively(directory);
  }
}
