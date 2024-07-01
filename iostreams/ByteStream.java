package iostreams;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream {

	public static void main(String[] args) {
		try(FileInputStream fis=new FileInputStream("C:/Users/Isign/OneDrive/Documents/input.txt")){
			int data;
			while((data=fis.read())!=-1)
			{
				 char character = (char) data;
	                int asciiValue = data;
	                System.out.printf("Character: %c, ASCII: %d%n", character, asciiValue);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
