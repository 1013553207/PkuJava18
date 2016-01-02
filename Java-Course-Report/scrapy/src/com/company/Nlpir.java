package com.company;

import java.io.UnsupportedEncodingException;
import com.sun.jna.Library;
import com.sun.jna.Native;

public class Nlpir {

	public static boolean init_flag = false;

	public static boolean init() throws Exception {
		String argu = "";
		String system_charset = "UTF-8";
		int charset_type = 1;
		if (!CLibrary.Instance.NLPIR_Init(argu.getBytes(system_charset),
				charset_type, "0".getBytes(system_charset))) {
			System.out.println("初始下失败");
			return false;
		}
		return true;
	}
	public static void destroy(){
		if(init_flag)
			CLibrary.Instance.NLPIR_Exit();
	}


	public interface CLibrary extends Library {

		CLibrary Instance = (CLibrary) Native.loadLibrary(
				"NLPIR.dll", CLibrary.class);

		public boolean NLPIR_Init(byte[] sDataPath, int encoding,
		                          byte[] sLicenceCode);
		public String NLPIR_ParagraphProcess(String sSrc, int bPOSTagged);
		public String NLPIR_GetKeyWords(String sLine,int nMaxKeyLimit,boolean bWeightOut);
		public void NLPIR_Exit();
	}

	public static String transString(String aidString, String ori_encoding,
	                                 String new_encoding) {
		try {
			return new String(aidString.getBytes(ori_encoding), new_encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String handle(String sInput) throws Exception {
		if(!init_flag)
			init_flag = init();

		String nativeByte = "";
		try {
			nativeByte = CLibrary.Instance.NLPIR_GetKeyWords(sInput, 100, false);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return  nativeByte;
	}
}

