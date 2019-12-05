package com.youxu.business.utils.uuid;


import java.util.Random;
import java.util.UUID;

public class UUIDUtils {

	public static String randomUUID10() {
		return RandomUtils.randomString(10);
	}
	
	public static String randomUUID20() {
		return RandomUtils.randomString(20);
	}
	
	public static String randomUUID(int length) {
		return RandomUtils.randomString(length);
	}
	
	public static String getUUIDPath(String uuid){
		StringBuilder builder=new StringBuilder();
		builder.append("/");
		builder.append((uuid.substring(0, 3).hashCode())%100+"").append("/");
		builder.append((uuid.substring(7,10).hashCode())%100+"").append("/");
		builder.append((uuid.substring(11,14).hashCode())%100+"").append("/");
		return builder.toString();
	}
	
	public static String getAttTable(){
		Random rand = new Random();
		int nextInt = rand.nextInt(10)+1;
		StringBuilder builder=new StringBuilder();
		builder.append("ATT_FILE_").append(String.format("%02d", nextInt));
		return builder.toString();
	}

	public static Long randomUUIDInt10() {
		String str = new String();
		Long long1=null;
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int i1 = random.nextInt(10);
			str = str+i1;
		}
		Long aLong = Long.valueOf(str);

		return aLong;
	}

	public static Long randomUUIDInt8() {
		String str = new String();
		Long long1=null;
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			int i1 = random.nextInt(8);
			str = str+i1;
		}
		Long aLong = Long.valueOf(str);

		return aLong;
	}
	public static String randomUUIDInt13() {
		String str = new String();
		Random random = new Random();
		for (int i = 0; i < 13; i++) {
			int i1 = random.nextInt(13);
			str = str+i1;
		}
		return str;
	}

	public static String randomUUIDInt(Integer number, Integer size) {
		String str = new String();
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			int i1 = random.nextInt(size);
			str = str+i1;
		}
		return str;
	}
    // --------------------------------------------------------生成uuid-------------------------------------------------
	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
			"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };


	public static String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 4; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();

	}
	
}
