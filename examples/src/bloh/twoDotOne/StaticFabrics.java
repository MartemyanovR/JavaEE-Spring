package bloh.twoDotOne;


import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Date;

public class StaticFabrics {

	public static void main(String[] args) throws IOException {
		Instant instant = Instant.now();
		Date date = Date.from(instant);
		System.out.println(date.toString());
		
		BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
		System.out.println(prime);
		
		
		FileStore fileStore = Files.getFileStore(Paths.get("c:\\eclipse-workspace\\Test1\\.classpath"));
		System.out.println(fileStore.type());
	}

}
