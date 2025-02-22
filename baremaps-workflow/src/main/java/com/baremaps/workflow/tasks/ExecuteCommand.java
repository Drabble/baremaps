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

import com.baremaps.workflow.Task;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record ExecuteCommand(String command) implements Task {

  private static final Logger logger = LoggerFactory.getLogger(ExecuteCommand.class);

  @Override
  public void run() {
    try {
      new ProcessBuilder().command("/bin/sh", "-c", command).start().waitFor();
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (InterruptedException e) {
      logger.error("Failed to execute process", e);
      Thread.currentThread().interrupt();
    }
  }
}
