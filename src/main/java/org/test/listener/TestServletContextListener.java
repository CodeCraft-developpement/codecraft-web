package org.test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.flywaydb.core.Flyway;

public class TestServletContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    String url = "jdbc:postgresql://localhost:5432/codecraft-web";
    String user = "codecraft";
    String password = "9h2A66KSVscyh6";

    Flyway flywayCore =
        Flyway.configure()
            .dataSource(url, user, password)
            .table("flyway_codecraft_core_schema_history")
            .baselineVersion("1.0.0.0001")
            .locations("classpath:db/migration")
            .schemas("public")
            .sqlMigrationPrefix("Core_V")
            .baselineOnMigrate(true)
            .load();

    Flyway flywayBase =
        Flyway.configure()
            .dataSource(url, user, password)
            .table("flyway_codecraft_base_schema_history")
            .baselineVersion("1.0.0.0001")
            .locations("org/codecraft/apps/base/db/migration", "base/db/migration")
            .schemas("public")
            .sqlMigrationPrefix("Base_V")
            .baselineOnMigrate(true)
            .load();

    flywayCore.migrate();
    flywayBase.migrate();
  }
}
