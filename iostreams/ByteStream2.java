package iostreams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ByteStream2 {

	public static void main(String[] args) {
		 String filePath = "C:/Users/Isign/OneDrive/Documents/input.txt"; 

	        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)) {
	            int character;
	            while ((character = reader.read()) != -1) {
	                char ch = (char) character;
	                String binaryUTF8 = toBinaryString(ch, StandardCharsets.UTF_8);
	                String binaryUTF16 = toBinaryString(ch, StandardCharsets.UTF_16);
	                int asciiValue = (int) ch;
	                System.out.printf("Character: %c, UTF-8 Binary: %s, UTF-16 Binary: %s, ASCII Value: %d%n", ch, binaryUTF8, binaryUTF16, asciiValue);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static String toBinaryString(char ch, Charset charset) {
	        byte[] bytes = String.valueOf(ch).getBytes(charset);
	        StringBuilder binary = new StringBuilder();
	        for (byte b : bytes) {
	            binary.append(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
	        }
	        return binary.toString();
	    }
}