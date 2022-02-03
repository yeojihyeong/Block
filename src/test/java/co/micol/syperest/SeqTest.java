package co.micol.syperest;

public class SeqTest {

	public static long seq = 40;

	public static void main(String[] args) {

		//seq++;
		//String strSeq = "0000000" + seq;

		// 16자리
		long t = System.nanoTime();
		// 13자리
		long t1 = System.currentTimeMillis();

		;
		
		String result = String.valueOf(t).substring(7);
		//System.out.println(t1);
		
		System.out.println(result);
		//System.out.println(strSeq);
	}

}