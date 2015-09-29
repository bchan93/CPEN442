//import java.math.BigInteger;
//import java.security.SecureRandom;
import java.util.Random;

public class crc2 {
	public static void main (String[] args) {
    	//CRC32 function
		String studentNumberMD5 = "DF7D31166FE74D52F562EC4474280D0C";	//DF7D31166FE74D52F562EC4474280D0C
										//584B2710871AB0B90A9595F8F735E293
		int crcX = 0; int crcY = 0;
		crcX = crcHash(studentNumberMD5);
		System.out.println("CRC32 (via direct calculation) = " + Integer.toHexString(crcX));
		
		String temp = null;
		
		for(int i = 0;i<Integer.MAX_VALUE;i++) {
			//crcY=crcHash(Integer.toString(i));
			temp = randomString(32);
			crcY=crcHash(temp);
			if (crcY == crcX){
				System.out.println("yCRC32 (via direct calculation) = " + Integer.toHexString(crcY) + "\n");		
				System.out.print("y string: " + temp + "\n");
			}
			//System.out.println("yCRC32 (via direct calculation) = " + Integer.toHexString(crcY) + "\n");		
			//System.out.print("y string: " + temp + "\n");
		}
		/*for(int i = 0;i<Integer.MAX_VALUE;i++){
			crcY=crcHash(Integer.toString(-i));
			if (crcY == crcX){
				System.out.println("yCRC32 (via direct calculation) = " + Integer.toHexString(crcY) + "\n");		
				System.out.print("y string: " +-i+ "\n");
			}
		}*/
		
		System.out.print("Done");
		
    }
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random rnd = new Random();

	static String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	/*private static SecureRandom random = new SecureRandom();
	
	public static String nextSessionID() {
		return new BigInteger(130, random).toString(32);
	}*/
	
	public static Integer crcHash(String desiredString){
		byte[] bytes = desiredString.getBytes();
		int crc  = 0xFFFFFFFF;  
        int poly = 0xEDB88320;

        for (byte b : bytes) {
            int temp = (crc ^ b) & 0xff;

            // read 8 bits one at a time
            for (int i = 0; i < 8; i++) {
                if ((temp & 1) == 1) temp = (temp >>> 1) ^ poly;
                else                 temp = (temp >>> 1);
            }
            crc = (crc >>> 8) ^ temp;
        }

        // flip bits
        crc = crc ^ 0xffffffff;
        return crc;
	}
}