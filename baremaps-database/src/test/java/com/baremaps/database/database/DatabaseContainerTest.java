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

package com.baremaps.database.database;

import com.baremaps.postgres.PostgresUtils;
import com.baremaps.testing.PostgresContainerTest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.jupiter.api.BeforeEach;

public abstract class DatabaseContainerTest extends PostgresContainerTest {

  @BeforeEach
  public void initializeDatabase() throws SQLException, IOException {
    DataSource dataSource = dataSource();
    try (Connection connection = dataSource.getConnection()) {
      PostgresUtils.executeResource(connection, "osm_create_extensions.sql");
      PostgresUtils.executeResource(connection, "osm_drop_tables.sql");
      PostgresUtils.executeResource(connection, "osm_create_tables.sql");
    }
  }
}
