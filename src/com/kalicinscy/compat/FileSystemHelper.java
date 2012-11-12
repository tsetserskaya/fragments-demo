/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalicinscy.compat;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.File;

/**
 *
 * @author wojtek
 */
public class FileSystemHelper {
    public static File getExternalCacheDir(Context ctx){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            return FroyoHelper.getExternalCacheDir(ctx);
        } else {
            return EclairHelper.getExternalCacheDir(ctx);
        }
    }
    
    
    private static class EclairHelper {
        public static File getExternalCacheDir(Context ctx){
            return new File(Environment.getExternalStorageDirectory(), ".pl.przepisy");
        }
    }
    
    private static class FroyoHelper {
        public static File getExternalCacheDir(Context ctx){
            return ctx.getExternalCacheDir();
        }
    }
}
