/* 
 * Sourcerer: an infrastructure for large-scale source code analysis.
 * Copyright (C) by contributors. See CONTRIBUTORS.txt for full list.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package edu.uci.ics.sourcerer.tools.java.metrics.db;

import edu.uci.ics.sourcerer.util.io.arguments.Command;
import edu.uci.ics.sourcerer.utils.db.DatabaseConnectionFactory;

/**
 * @author Joel Ossher (jossher@uci.edu)
 */
public class Main {
  public static final Command COMPUTE_DB_METRICS = new Command("compute-db-metrics", "Computes metrics using the database.") {
    @Override
    protected void action() {
      MetricsCalculator.calculateMetrics();
    }
  }.setProperties(DatabaseConnectionFactory.DATABASE_URL, DatabaseConnectionFactory.DATABASE_USER, DatabaseConnectionFactory.DATABASE_PASSWORD);
  
  public static void main(String[] args) {
    Command.execute(args, Main.class);
  }
}
