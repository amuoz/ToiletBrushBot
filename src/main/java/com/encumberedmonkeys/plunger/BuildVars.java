package com.encumberedmonkeys.plunger;

/**
 * @author muoz & thenanox
 * @version 1.0
 * Custom build vars
 */
public class BuildVars {
    public static final Boolean debug = true;
    public static final Boolean useWebHook = false;
    public static final int PORT = 8443;
    public static final String EXTERNALWEBHOOKURL = "your-external-url:" + PORT;
    public static final String INTERNALWEBHOOKURL = "your-internal-url:" + PORT;
    public static final String pathToCertificatePublicKey = "path/to/my/certkey.pem";
    public static final String certificatePublicKeyFileName = "certkey.pem";

    public static final String DirectionsApiKey = "<your-api-key>";

    public static final String TRANSIFEXUSER = "<transifex-user>";
    public static final String TRANSIFEXPASSWORD = "<transifex-password>";

    public static final String pathToLogs = "./";
}
