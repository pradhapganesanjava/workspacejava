package com.pg.endecrypt;

import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Example {

	public static void main(String[] args) {

		String encryptStr = "CgkJPHRleHRhcmVhIGlkPSJ0cmFuc2FjdGlvbl9zdW1tYXJ5X2h0bWwiIG5hbWU9ImVtYWlsX3RleHQiIGNsYXNzPSJoaWRlIj4JCTwvdGV4dGFyZWE CgkJPGlucHV0IHR5cGU9ImhpZGRlbiIgaWQ9InRyYW5zYWN0aW9uX3N1bW1hcnlfZW1haWxfc3ViamVjdCIgbmFtZT0iZW1haWxfc3ViamVjdCIgdmFsdWU9IkVtYWlsIHlvdXIgVHJhbnNhY3Rpb24gU3VtbWFyeSI CgkJPGgyPgoJCQlFbWFpbCB5b3VyIFRyYW5zYWN0aW9uIFN1bW1hcnkKCQk8L2gyPgoKCQk8cD4KCQkJPHN0cm9uZz5QbGVhc2UgZW50ZXIgeW91ciBlbWFpbCBiZWxvdzwvc3Ryb25nPgoJCTwvcD4KCQk8dGFibGUgY2xhc3M9ImZvcm1fZmllbGRzIj4KCQkJPHRib2R5Pjx0cj4KCQkJCTx0aD5FbWFpbDwvdGg CgkJCQk8dGQ PGlucHV0IHR5cGU9InRleHQiIG5hbWU9ImVtYWlsIj48L3RkPgoJCQk8L3RyPgoJCQk8IS0tIENSMzE0OTQgIC0tPgoJCQkKCQk8L3Rib2R5PjwvdGFibGU CgkJPHAgY2xhc3M9ImRpc2NsYWltZXIiPgoJCQlZb3VyIGluZm9ybWF0aW9uIHdpbGwgYmUga2VwdCBjb25maWRlbnRpYWwKCQk8L3A Cgk=";

		String secretStr = "This is my secret word";
		
		try {
			
			Encoder encoder = Base64.getEncoder();
			byte[] encoderByteStrArr = encoder.encode(secretStr.getBytes());
			String encodedStr = encoderByteStrArr.toString();
			System.out.println("encodedStr "+ encodedStr);
			
			// Get bytes from string
			Decoder decod = Base64.getDecoder();
			byte[] byteArray = decod.decode(encodedStr);

			// Print the decoded array
			System.out.println(Arrays.toString(byteArray));
			// Print the decoded string
			String decodedString = new String(byteArray);
			System.out.println(encryptStr + " = " + decodedString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
