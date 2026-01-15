package net.sasconsul.caryparking.cli;

import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class DatabaseBackupComponent {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseBackupComponent.class);

    private final DataSource dataSource;

    @Autowired
    public DatabaseBackupComponent(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PreDestroy
    public void backupDatabase() {
        LOG.info("Shutting down: Writing out the database to backup.sql");
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            String scriptCommand = new StringBuilder("SCRIPT ").append("TO 'backup.sql'").toString();
            statement.execute(scriptCommand);
            LOG.info("Database successfully written to backup.sql");
        } catch (Exception e) {
            LOG.error("Failed to write out the database", e);
        }
    }
}
