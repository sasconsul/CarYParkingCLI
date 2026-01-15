### Project Guidelines

#### Build and Configuration
- **JDK Version**: Java 17
- **Framework**: Spring Boot 3.0.4
- **CLI Framework**: Spring Shell 3.0.0
- **Database**: H2 (In-memory)
- **Build Tool**: Gradle
- **Main Application Class**: `net.sasconsul.caryparking.cli.CarYParkingCliApplication`

To build the project, use:
```bash
./gradlew build
```

To run the application:
```bash
./gradlew bootRun
```

#### Testing Information
The project uses JUnit 5 and Spring Boot Test.

##### Running Tests
To run all tests:
```bash
./gradlew test
```

To run a specific test:
```bash
./gradlew test --tests <FullClassName>
```

##### Adding New Tests
- Place tests in `src/test/java/net/sasconsul/caryparking/cli/` (or appropriate sub-packages).
- Use `@SpringBootTest` to load the full application context.
- For testing Shell commands, you can inject the command components directly.

##### Sample Test Case
```java
package net.sasconsul.caryparking.cli;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SampleTest {

    @Autowired
    private MyCommands myCommands;

    @Test
    void testCommandInjection() {
        assertNotNull(myCommands, "MyCommands should be injected");
    }
}
```

#### Development and Debugging
- **Code Style**: Follow standard Java and Spring conventions.
- **Spring Shell**: Commands are defined in classes annotated with `@ShellComponent` using `@ShellMethod`.
- **Database Console**: The H2 console is enabled at `/h2-console` (when the app is running).
- **Logging**: Logs are configured via `src/main/resources/application.properties` and output to `spring-shell.log`.
- **Configuration**:
  - `spring.datasource.url=jdbc:h2:mem:testdb`
  - `spring.jpa.database-platform=org.hibernate.dialect.H2Dialect`
