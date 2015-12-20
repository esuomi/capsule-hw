package io.induct.capsule;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.TreeSet;

/**
 * @since 20.12.2015
 */
public class HelloWorld {

    private final static Logger log = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        log.info("Hello! These are the args you provided to the app: " + Arrays.toString(args));

        log.info("Here's all known system properties:");
        Properties p = System.getProperties();
        for (Object key : new TreeSet<>(p.keySet())) {
            log.info("{} => {}", key, p.get(key));
        }

        log.info("Press any key to exit");
        try {
            System.in.read();
        } catch (IOException e) {
            log.error("...looks like I somehow broke myself!?");
            e.printStackTrace();
        }
        log.info("Bye!");
    }

}
