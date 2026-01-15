package net.sasconsul.caryparking.cli;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MyCommands {
    private static final Logger LOG = LoggerFactory
            .getLogger(MyCommands.class);

    @ShellMethod(key = "hello-world", value="basic hello world command")
    public String helloWorld(
            @ShellOption(defaultValue = "spring") String arg
    ) {
        return "Hello world " + arg;
    }

    /**
     * Parses variable arguments from the command line
     */
    @ShellMethod(key = "args", value="parsing vargs on the command line.")
    public String argList(
            @ShellOption(defaultValue = "nothing") String... args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
            stringBuilder.append(String.format("args[%d]: %s %n", i, args[i]));
        }
        return stringBuilder.toString();
    }

    /**
     * Adds car to DB; returns SQL insert statements
     */
    @ShellMethod(key = "insert", value="add a car to the DB")
    public String insert(
            @ShellOption(defaultValue = "nothing added") String... args) {
        StringBuilder stringBuilder = new StringBuilder();
        LOG.info("args.length: {}",args.length);
        LOG.info("args.length: {}",args.length);

        for (int i = 0; i < args.length; ++i) {
            stringBuilder.append(String.format("insert into cars args[%d]: %s %n", i, args[i]));
        }
        return stringBuilder.toString();
    }

    @ShellMethod(key = "sql ", value="sql command")
    public String sqlCmd(
            @ShellOption(defaultValue = "no command") String... args) {
        StringBuilder stringBuilder = new StringBuilder();
        LOG.info("args.length: {}", args.length);

        String result =null;


        return result;
    }
}
