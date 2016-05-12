package com.encumberedmonkeys.plunger.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * @author muoz & thenanox
 * @version 1.0
 * Localisation
 */
public class LocalisationService {
    private static LocalisationService instance = null;
    private final HashMap<String, ResourceBundle> supportedLanguages = new HashMap<>();

    private ResourceBundle configured;

    public static LocalisationService getInstance() {
        if (instance == null) {
            synchronized (LocalisationService.class) {
                if (instance == null) {
                    instance = new LocalisationService();
                }
            }
        }
        return instance;
    }

    private LocalisationService() {
        ResourceBundle english = ResourceBundle.getBundle("game.text", new Locale("en"), new UTF8Control());
        supportedLanguages.put("en", english);
        ResourceBundle spanish = ResourceBundle.getBundle("game.text", new Locale("es"), new UTF8Control());
        supportedLanguages.put("es", spanish);
        configured = spanish;
    }

    public void setLanguage(String language){
        configured = supportedLanguages.get(language);
    }

    public String getCurrentLanguage(){
        return configured.getLocale().toString();
    }

    public String getString(String key) {
        String result;
        try {
            result = configured.getString(key);
        } catch (MissingResourceException e) {
            result = "String not found";
        }
        return result;
    }

    public HashMap<String, ResourceBundle> getSupportedLanguages() {
        return supportedLanguages;
    }

    public class UTF8Control extends ResourceBundle.Control {
        public ResourceBundle newBundle
                (String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
                throws IllegalAccessException, InstantiationException, IOException
        {
            // The below is a copy of the default implementation.
            String bundleName = toBundleName(baseName, locale);
            String resourceName = toResourceName(bundleName, "properties");
            ResourceBundle bundle = null;
            InputStream stream = null;
            if (reload) {
                URL url = loader.getResource(resourceName);
                if (url != null) {
                    URLConnection connection = url.openConnection();
                    if (connection != null) {
                        connection.setUseCaches(false);
                        stream = connection.getInputStream();
                    }
                }
            } else {
                stream = loader.getResourceAsStream(resourceName);
            }
            if (stream != null) {
                try {
                    // Only this line is changed to make it to read properties files as UTF-8.
                    bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
                } finally {
                    stream.close();
                }
            }
            return bundle;
        }
    }
}
