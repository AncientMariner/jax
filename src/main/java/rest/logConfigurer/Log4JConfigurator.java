package rest.logConfigurer;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log4JConfigurator {
    private static final Logger logger = Logger.getLogger(Log4JConfigurator.class);
    public static void main(String args[]) {
        BasicConfigurator.configure(); //enough for configuring log4j
        Logger.getRootLogger().setLevel(Level.WARN); //changing log level

        logger.error("Critical message, almost fatal");
        logger.warn("Warnings, which may lead to system impact");
        logger.info("Information");
        logger.debug("Debugging information ");
    }
}