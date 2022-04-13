package designPatterns.creationalPattern.factory.implementation.client;

import designPatterns.creationalPattern.factory.implementation.factory.AnimalFactory;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class LoadProperties {
    public static String propertiesFileLoation =
            "/D:/ideaProjects/oneStopSolution/src/main/java/designPatterns/creationalPattern/factory/implementation/app.properties";

    public static AnimalFactory getFactoryFromPropertiesFile(String factoryKey) {

        try (FileReader reader = new FileReader(propertiesFileLoation)) {
            Properties p = new Properties();
            p.load(reader);

            Class<AnimalFactory> clazz = (Class<AnimalFactory>) Class.forName(p.getProperty(factoryKey));
            Constructor<AnimalFactory> constructor = clazz.getConstructor();

            return constructor.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Factory with provided name could not be instantiated..!!");
        }

    }
}
