/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravc.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 *
 * @author Rodrigo
 */
public class Properties {

    public String result = "";
    InputStream inputStream;
    Parameters params = new Parameters();
    FileBasedConfigurationBuilder<FileBasedConfiguration> builder
            = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                    .configure(params.fileBased()
                            .setFile(new File(Tools.getProgramFiles()
                                    + File.separator + "manifestaNfe.properties")));

    public void defaultConfig() {
        builder.setAutoSave(true);

        File config = new File(Tools.getProgramFiles()
                + File.separator + "manifestaNfe.properties");

        if (!config.exists()) {
            try (FileOutputStream fileOut = new FileOutputStream(config)) {
                Configuration configDefaults = builder.getConfiguration();
                configDefaults.setProperty("manifestaNfe.cnpjcpf", "");
                configDefaults.setProperty("manifestaNfe.operacao", "0");
                configDefaults.setProperty("manifestaNfe.tipoCertificado", "A1");
                configDefaults.setProperty("manifestaNfe.tipoCertificadoA3", "0");
                configDefaults.setProperty("manifestaNfe.estadoEmitente", "0");
                configDefaults.setProperty("manifestaNfe.senhaCertificado", "");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException | ConfigurationException ex) {
                ex.printStackTrace();
            }
        }

    }

    public Configuration prop() {
        defaultConfig();
        try {
            return (Configuration) builder.getConfiguration();
        } catch (ConfigurationException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String setProp(String prop, String propValue) {
        defaultConfig();
        try {
            Configuration config = builder.getConfiguration();
            config.setProperty(prop, propValue);
        } catch (ConfigurationException cex) {
            cex.getStackTrace();
        }

        return null;
    }

}
