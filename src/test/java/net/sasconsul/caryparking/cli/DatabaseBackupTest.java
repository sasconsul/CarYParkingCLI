package net.sasconsul.caryparking.cli;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DatabaseBackupTest {

    @Autowired
    private DatabaseBackupComponent databaseBackupComponent;

    @Autowired
    private DataSource dataSource;

    @Test
    void testBackupDatabase() throws Exception {
        // 1. Ensure there is something in the database
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS backup_test (id INT PRIMARY KEY);");
            statement.execute("INSERT INTO backup_test VALUES (1);");
        }

        // 2. Trigger backup
        databaseBackupComponent.backupDatabase();

        // 3. Verify backup.sql exists
        File backupFile = new File("backup.sql");
        assertTrue(backupFile.exists(), "backup.sql should exist after backup");

        // 4. Cleanup
        if (backupFile.exists()) {
            backupFile.delete();
        }
    }
}
