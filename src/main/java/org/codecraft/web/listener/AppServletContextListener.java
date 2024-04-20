package org.codecraft.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;

public class AppServletContextListener implements ServletContextListener {

  private static final String URL = "jdbc:postgresql://localhost:5432/codecraft-web";
  private static final String USER = "codecraft";
  private static final String PASSWORD = "9h2A66KSVscyh6";

  @Override
  public void contextInitialized(ServletContextEvent sce) {

    migrateCore();
    migrateBase();
  }

  private MigrateResult migrateCore() {
    Flyway flywayCore =
        Flyway.configure()
            .dataSource(URL, USER, PASSWORD)
            .table("flyway_codecraft_core_schema_history")
            .baselineVersion("1.0.0.0001")
            .locations("org/codecraft/apps/core/db/migration", "core/db/migration")
            .schemas("public")
            .sqlMigrationPrefix("Core_V")
            .baselineOnMigrate(true)
            .load();

    return migrate(flywayCore);
  }

  private MigrateResult migrateBase() {
    Flyway flywayBase =
        Flyway.configure()
            .dataSource(URL, USER, PASSWORD)
            .table("flyway_codecraft_base_schema_history")
            .baselineVersion("1.0.0.0001")
            .locations("org/codecraft/apps/base/db/migration", "base/db/migration")
            .schemas("public")
            .sqlMigrationPrefix("Base_V")
            .baselineOnMigrate(true)
            .load();
    return migrate(flywayBase);
  }

  private MigrateResult migrate(Flyway flyway) {
    return flyway.migrate();
  }
}
