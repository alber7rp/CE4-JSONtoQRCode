package CE.CE2;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import static java.lang.System.out;
import java.util.Scanner;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.json.simple.JSONObject;

public class QRCodeGenerator {
    private static final String QR_CODE_IMAGE_PATH = "./QRCode.png";

    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
       
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static void main(String[] args) {
    	out.println("Alberto Gabriel Ruiz Pérez - Comercio Electrónico - MISTIC\n");
    	out.println("JSON -> QR Code Generator");
    	
    	if (args.length == 0) {
    		out.println("ERROR, introduce un objeto JSON en formato string");
    	}
    	else{
    		try {
    			generateQRCodeImage(args[0], 350, 350, QR_CODE_IMAGE_PATH);
    			out.println("QR Code Generated correctly");
    		} catch (WriterException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	
        
    }
}