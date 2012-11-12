package com.kalicinscy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.util.LinkedList;

public class Streams {

    static LinkedList<SoftReference<byte[]>> bufferPool = new LinkedList<SoftReference<byte[]>>();
    static byte[] mainBuffer = new byte[4 * 1024];

    private static synchronized byte[] getBuffer() {
        byte[] buf;
        if (mainBuffer != null) {
            buf = mainBuffer;
            mainBuffer = null;
            return buf;
        }
        while (bufferPool.size() > 0) {
            buf = bufferPool.remove().get();
            if (buf != null) {
                return buf;
            }
        }
        return new byte[4 * 1024];
    }

    private static synchronized void releaseBuffer(byte[] buf) {
        if (mainBuffer == null) {
            mainBuffer = buf;
        } else {
            bufferPool.add(new SoftReference<byte[]>(buf));
        }
    }

    public static void copy(InputStream is, OutputStream os) throws IOException {
        byte[] bytes = getBuffer();
        int read = -1;
        while ((read = is.read(bytes)) != -1) {
            os.write(bytes, 0, read);
        }
        os.flush();
        releaseBuffer(bytes);
    }
}