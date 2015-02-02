package com;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String encodeStr = "%CC%E1%BD%BB";
		String decodeStr = URLDecoder.decode(encodeStr,"GBK");
		System.out.println(decodeStr);
		String rawStr = "Ã·Ωª";
		System.out.println(URLEncoder.encode(rawStr, "GBK"));
	}

}
