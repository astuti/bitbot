package info.bit.bot;

import org.pircbotx.PircBotX;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import javax.security.auth.login.Configuration;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by astuti on 30/3/15.
 */
public class IrcBitBot {
    public static Logger logger = LoggerFactory.getLogger(IrcBitBot.class);
    public static Map<String, Object> conf= null;
    public static Map<String, Object> strings=  null;

    static Yaml yaml= new Yaml();

    public static String owner= "ownername";

    public static void main(String[] args)
    {
        setUpDefaultConfigs();
/*
        if(!GraphicsEnvironment.isHeadless())
        {
            new GuiApp();
        }*/

        new IrcBitBot();
    }

    public File serverConfig= new File("config/server.yml");
   /* static File stringsFile =new File("config/strings.yml");*/

    public static void setUpDefaultConfigs() {
        try {
            File f1 = new File("database");
            File f2 = new File("config");
            f1.mkdir();
            f2.mkdir();
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (!serverConfig.exists()) {
            logger.info("First Time Config Setup , Please edit the config after it got written ");
            try {
                serverConfig.createNewFile();
                Scanner scanner = new Scanner(IrcBitBot.class.getResourceAsStream("./defaultServerConfig.yml"));
                FileWriter fileWriter = new FileWriter(serverConfig);
                while (scanner.hasNextLine()) {
                    fileWriter.write(scanner.nextLine() + '\n');

                }

                fileWriter.close();
                scanner.close();
                logger.info("finished writing default config.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

   /* Configuration<PircBotX> server =  new Configuration.Builder()
            .setEncoding(StandardCharsets.UTF_8)
            .setName((String) conf.get("nick"))
            .setAutoNickChange(true)*/
}
