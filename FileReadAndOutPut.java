package kadai_12;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class FileReadAndOutPut {
	
	public static void main(String args[]) throws Exception{
		/** �o�͏����p��Map �������\�[�g�𗘗p���� */
		Map<String, OutputInfo> outputMap = new TreeMap<>();
		/** ���v���z */
		long amounts = 0;
		/** �����Ώۂ̊g���q(.xml)*/
		String XML = ".xml";
		/** �t�@�C���@*/
		File file = null;
		/** �t�@�C���ꗗ*/
		File files[] = null;
		/** XML�t�@�C���p�X���X�g*/
		ArrayList<String> xmlFileList = null;
		
		//�w�肵���f�B���N�g���z���̃t�@�C���ꗗ���擾���܂��B
		file = new File(args[0]);
		files = file.listFiles();
		
		//�w��̃f�B���N�g���z���Ƀt�@�C�������݂��Ȃ��ꍇ�͏������I�����܂��B
		if ( files == null ) {
			System.out.println("�w��̃p�X�̓f�B���N�g���ł͂���܂���B");
            System.exit(1);
		} else if ( files.length == 0 ) {
			System.out.println("�w��̃f�B���N�g���z���Ƀt�@�C�������݂��܂���B");
            System.exit(1);
		}
		
		xmlFileList = new ArrayList<String>();
		
		//�Ώۂ̃f�B���N�g���z�����ׂĂ�.xml�t�@�C���̃t���p�X���擾���܂��B
		for ( int i = 0 ; i < files.length ; i++ ) { 
			String fileName = files[i].getName();
			
			if ( !files[i].isDirectory() ) {
                if ( fileName.endsWith(XML) )
                	xmlFileList.add( file + "/" + fileName );
			}
		}
		
		//XML�t�@�C�������݂��Ȃ��ꍇ�͏������I�����܂��B
		if ( xmlFileList.size() == 0 ) {
			System.out.println("XML�t�@�C�������݂��܂���ł����B");
            System.exit(1);
		}

		//XML�t�@�C���̃t�@�C���������[�v���܂��B
		for ( int i = 0 ; i < xmlFileList.size() ; i++ ) {
			ReceiptInfo recieptInfo = null;
			
			//XML���I�u�W�F�N�g�ɕϊ����܂��B
			try {
				recieptInfo = ReadFile.readXmlWithPath(xmlFileList.get(i), ReceiptInfo.class);
			} catch (Exception e) {
				System.out.println("XML�t�@�C���̓��e������������܂���B�w��̌`���ƈ�v���Ă��邱�Ƃ��m�F���Ă��������B");
				System.out.println("�Ώۃt�@�C���@�u" + xmlFileList.get(i) + "�v");
	            e.printStackTrace();
	            System.exit(1);
			}
			
			//�ϊ������I�u�W�F�N�g��������擾���܂��B
			for (ItemInfo itemInfo : recieptInfo.getItems()) {
				String id = itemInfo.getId();
				if (!outputMap.containsKey(id)) {
				    outputMap.put(id, new OutputInfo(itemInfo.getName()));
				} else {
				    outputMap.get(id).increaseItemCounts();
				}
				amounts += itemInfo.getPrice();
			}
		}

		//���ʂ��o�͂��܂��B
		for (String key : outputMap.keySet()) {
			System.out.println("���i���F" + outputMap.get(key).getItemName() + "�@�w�����F" + outputMap.get(key).getItemCounts());
		}
		System.out.println("���v���z�F" + amounts + "�~");
	  }
}