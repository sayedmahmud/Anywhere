package org.anywhere.server.encoder.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class CompressedBase64Encoder {

    public String exec(final String str) {
        try {
            ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
            Deflater deflater = new Deflater(Deflater.DEFLATED, true);
            DeflaterOutputStream outputStream = new DeflaterOutputStream(bytesOut, deflater);
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
            outputStream.finish();
            return Base64.getEncoder().encodeToString(bytesOut.toByteArray());
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
}