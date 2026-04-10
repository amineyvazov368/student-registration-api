package org.example.studentregistrationapi.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class QrService {

    public String generateQrCode(String content) {

        try {

            Files.createDirectories(Paths.get("qrcodes"));
            String fileName= UUID.randomUUID() + "png";

            BitMatrix bitMatrix = new MultiFormatWriter()
                    .encode(content, BarcodeFormat.QR_CODE, 300,300);
            MatrixToImageWriter.writeToPath(
                    bitMatrix,"PNG", Paths.get("qrcodes/"+fileName)
            );
            return "/qrcodes/" + fileName;
        }
        catch (Exception e) {
            throw new RuntimeException("Error generating QR Code", e);
        }
    }


}
