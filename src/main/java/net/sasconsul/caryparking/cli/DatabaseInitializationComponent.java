package net.sasconsul.caryparking.cli;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class DatabaseInitializationComponent {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseInitializationComponent.class);

    private final DataSource dataSource;

    @Autowired
    public DatabaseInitializationComponent(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void initDatabase() {
        File buildSql = new File("build.sql");
        if (buildSql.exists()) {
            LOG.info("Found build.sql, executing initialization...");
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                String sql = Files.readString(buildSql.toPath());
                statement.execute(sql);
                LOG.info("Database successfully initialized from build.sql");
            } catch (Exception e) {
                LOG.error("Failed to initialize database from build.sql", e);
            }
        } else {
            LOG.info("build.sql not found, skipping database initialization");
        }
    }
}
