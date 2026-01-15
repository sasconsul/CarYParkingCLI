package net.sasconsul.caryparking.cli;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DatabaseInitializationTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyCommands myCommands;

    @Test
    void testDatabaseInitializationAndEmptyDb() throws Exception {
        // 1. Prepare build.sql
        File buildSql = new File("build.sql");
        String sqlContent = "CREATE TABLE IF NOT EXISTS test_table (id INT PRIMARY KEY, name VARCHAR(255));" +
                "INSERT INTO test_table (id, name) VALUES (1, 'test_initialization');";
        Files.writeString(buildSql.toPath(), sqlContent);

        try {
            // 2. Manually trigger initialization if necessary (or just verify it if the component ran)
            // Since @SpringBootTest loads the context, DatabaseInitializationComponent should have run.
            // But it might have run before we created build.sql.
            // Let's call it manually for the test to be sure.
            DatabaseInitializationComponent initializer = context.getBean(DatabaseInitializationComponent.class);
            initializer.initDatabase();

            // 3. Verify table exists and has data
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT name FROM test_table WHERE id = 1");
                assertTrue(resultSet.next());
                assertEquals("test_initialization", resultSet.getString("name"));
            }

            // 4. Test empty-db command
            String result = myCommands.emptyDb();
            assertEquals("Database emptied successfully", result);

            // 5. Verify database is empty
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                // In H2, DROP ALL OBJECTS removes all tables.
                // We check if the table still exists.
                assertThrows(Exception.class, () -> statement.executeQuery("SELECT * FROM test_table"));
            }

        } finally {
            // Cleanup build.sql
            if (buildSql.exists()) {
                buildSql.delete();
            }
        }
    }
}
