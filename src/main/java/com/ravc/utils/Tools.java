/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravc.utils;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Shell32;
import com.sun.jna.platform.win32.ShlObj;
import com.sun.jna.platform.win32.WinDef;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Rodrigo
 */
public class Tools {

    public static String getDesktop() {
        char[] pszPath = new char[WinDef.MAX_PATH];
        Shell32.INSTANCE.SHGetFolderPath(null,
                ShlObj.CSIDL_DESKTOPDIRECTORY, null, ShlObj.SHGFP_TYPE_CURRENT,
                pszPath);

        return Native.toString(pszPath);
    }

    public static String getProgramFiles() {
        char[] pszPath = new char[WinDef.MAX_PATH];
        Shell32.INSTANCE.SHGetFolderPath(null,
                ShlObj.CSIDL_PROGRAM_FILES, null, ShlObj.SHGFP_TYPE_CURRENT,
                pszPath);
        File folderApp = new File(Native.toString(pszPath) + File.separator + "ManifestaNfe");
        File folderSchema = new File(Native.toString(pszPath) + File.separator + "ManifestaNfe" 
                + File.separator + "schemas");
        if (!folderApp.exists()) {
            folderApp.mkdirs();
        }
        if (!folderSchema.exists()) {
            folderSchema.mkdirs();
        }
        return Native.toString(pszPath) + File.separator + "ManifestaNfe";
    }

    public static void protocolo(String proc, String nameProc) {

        try {
            File path = new File(Tools.getProgramFiles() + File.separator
                    + "protocolos");
            if (!path.exists()) {
                path.mkdirs();
            }
            Files.write(Paths.get(path.getPath() + File.separator + nameProc + ".xml"), 
                    proc.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String formatarCNPJ(String valor) {
        if (valor.length() == 14) {
            if (valor.length() == 3) {
                valor = valor.substring(0, 2) + "." + valor.substring(2, 3);
            } else if (valor.length() >= 4 && valor.length() <= 5) {
                valor = valor.substring(0, 2) + "." + valor.substring(2, valor.length());
            } else if (valor.length() >= 6 && valor.length() <= 8) {
                valor = valor.substring(0, 2) + "." + valor.substring(2, 5) + "." + valor.substring(5, valor.length());
            } else if (valor.length() >= 9 && valor.length() <= 12) {
                valor = valor.substring(0, 2) + "." + valor.substring(2, 5) + "." + valor.substring(5, 8) + "/" + valor.substring(8, valor.length());
            } else if (valor.length() >= 12 && valor.length() <= 14) {
                valor = valor.substring(0, 2) + "." + valor.substring(2, 5) + "." + valor.substring(5, 8) + "/" + valor.substring(8, 12) + "-" + valor.substring(12, valor.length());
            }
        }
        return valor;
    }

}
