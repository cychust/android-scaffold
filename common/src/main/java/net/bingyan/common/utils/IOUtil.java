package net.bingyan.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

/**
 * Author   dashmrl
 * Date     28/01/2018
 * Time     20:51
 * Email    xinliugm@gmail.com
 */

public class IOUtil {
    public static boolean stream2file(InputStream is, File file) {
        BufferedInputStream bis = null;
        OutputStream os = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            os = new FileOutputStream(file);
            bos = new BufferedOutputStream(os);
            byte[] buffer = new byte[512];
            int len = 0;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            close(bos, os, bis, is);
        }
        return true;
    }

    public static String stream2str(InputStream is) {
        BufferedInputStream bis = null;
        Reader r = null;
        BufferedReader br = null;
        bis = new BufferedInputStream(is);
        r = new InputStreamReader(bis);
        br = new BufferedReader(r);
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[512];
        int len = 0;
        try {
            while ((len = br.read(buffer)) != -1) {
                sb.append(buffer, 0, len);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(br, r, bis, is);
        }
        return "";
    }

    public static String file2str(File file) {
        Reader r = null;
        BufferedReader br = null;
        try {
            r = new FileReader(file);
            br = new BufferedReader(r);
            StringBuilder sb = new StringBuilder();
            char[] buffer = new char[512];
            int len = 0;
            while ((len = br.read(buffer)) != -1) {
                sb.append(buffer, 0, len);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(br, r);
        }
        return "";
    }

    public static boolean str2file(String str, File file,boolean append) {
        FileWriter w = null;
        BufferedWriter bw = null;
        try {
            w = new FileWriter(file,append);
            bw = new BufferedWriter(w);
            bw.write(str, 0, str.length());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            close(bw, w);
        }
        return true;
    }

    public static void close(Closeable... closeables) {
        if (closeables == null) {
            return;
        }
        for (int i = 0; i < closeables.length; i++) {
            Closeable closeable = closeables[i];
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
