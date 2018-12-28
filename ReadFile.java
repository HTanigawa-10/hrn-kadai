package kadai_12;

import java.io.File;

import javax.xml.bind.JAXB;

class ReadFile {

	/******************************************************
	 * XMLファイルを読み込み、指定されたクラスのオブジェクトに変換する
	 * @param path ファイルのフルパス
	 * @param clazz 変換対象のクラス(ルート)
	 * @return 変換後のオブジェクト
	 ******************************************************/
	public static <T> T readXmlWithPath(String filePath,Class<T> clazz) {
		T info = (T) JAXB.unmarshal(new File(filePath), clazz);
		return info;
	}
	
}
