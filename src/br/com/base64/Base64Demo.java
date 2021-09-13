package br.com.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class Base64Demo {
	
	public static void main(String[] args) {
		
		try {
			
			//Encode String
			String base64Encoded = Base64.getEncoder().encodeToString("This is a String encoded".getBytes("utf-8"));
			System.out.println(base64Encoded);
			
			//Decode String
			byte[] base64Decoded = Base64.getDecoder().decode(base64Encoded);
			System.out.println(new String(base64Decoded, "utf-8"));
			
			
			
			//Encode URL
			String base64UrlEncoded = Base64.getUrlEncoder().encodeToString("main.jsf?id=1".getBytes("utf-8"));
			System.out.println("URL Encoded=" + base64UrlEncoded);
			
			//Decode URL
			byte[] base64UrlDecoded = Base64.getUrlDecoder().decode(base64UrlEncoded);
			System.out.println(new String(base64UrlDecoded, "utf-8"));		
			
			
			//MIME
			StringBuffer s = new StringBuffer();
			
			for (int i = 0; i < 10; i++) {
				s.append(UUID.randomUUID().toString());
			}
			
			byte[] mimeBytes = s.toString().getBytes("utf8");
			
			
			//Encode MIME
			String base64MimeEncoded = Base64.getMimeEncoder().encodeToString(mimeBytes);
			System.out.println(base64MimeEncoded);
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
