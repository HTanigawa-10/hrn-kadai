package kadai_12;

import java.io.File;

import javax.xml.bind.JAXB;

class ReadFile {

	/******************************************************
	 * XML�t�@�C����ǂݍ��݁A�w�肳�ꂽ�N���X�̃I�u�W�F�N�g�ɕϊ�����
	 * @param path �t�@�C���̃t���p�X
	 * @param clazz �ϊ��Ώۂ̃N���X(���[�g)
	 * @return �ϊ���̃I�u�W�F�N�g
	 ******************************************************/
	public static <T> T readXmlWithPath(String filePath,Class<T> clazz) {
		T info = (T) JAXB.unmarshal(new File(filePath), clazz);
		return info;
	}
	
}
