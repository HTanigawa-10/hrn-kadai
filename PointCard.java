package kadai_09;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PointCard {
	/** ���V�[�g�̖��� */
	private int N = 0;
	/** key:���t ,value:�w�����z */
	private HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	/** ���v�w�����z */
	private int m = 0;
	/** ���v�|�C���g */
	private int s = 0;
	
	/**
	 * �W�����͂ň������󂯎��Ama���Ɋi�[���܂��B
	 * @param receipts �����̃��V�[�g���
	 */
	public void inputArgs(String[] receipts){
		Scanner sc = null;
		boolean errFlag = false;
		try {
			System.out.println("----------���͊J�n----------");
			//�W������
			sc = new Scanner(System.in);
			//���V�[�g�����̎擾
			N = Integer.parseInt(sc.nextLine());
			//���V�[�g����0�ȉ��̏ꍇ�͏����I��
			if(N <= 0) {
				System.out.println("���V�[�g�̐����s���ł��B");
				System.exit(0);
			}
			//key:���t ,value:�w�����z���擾�A�͈̓`�F�b�N���s��
			for (int i = 0; i < N; i++) {
	            String s = sc.nextLine();
	            String[] array = s.split(" ");
	            
				//���͒l�`�F�b�N
				checkArgs(N ,Integer.parseInt(array[0]), Integer.parseInt(array[1]));
	            
	            //key:���t ,value:�w�����z�Ƃ��Ď擾����B���łɓ��t�L�[�����݂����ꍇ�́A�w�����z�����Z����B
	            if(map.containsKey(Integer.valueOf(array[0]))) {
	            	map.put(Integer.valueOf(array[0]), Integer.valueOf(map.get(array[0]) + array[1]));
	            } else {
		            map.put(Integer.valueOf(array[0]), Integer.valueOf(array[1]));
	            }
			}
			System.out.println("----------���͏I��----------");
		} catch(Exception e) {
			//���̑���O
			e.printStackTrace();
			System.out.println("�����̌`�����s���ł��B");
			errFlag = true;
		} finally {
			if(sc != null) {sc.close();};
			if(errFlag) {System.exit(0);}
		}
	}
	
	/**
	 * ���͒l�͈̔̓`�F�b�N���s���܂��B�G���[�������͏������I�����܂��B
	 * 
	 */
	public void checkArgs(int N,int day ,int price) {
		String errMsg = null; 
		
		//���V�[�g�̐��@1�`100
		if (!(1 <= N && N <= 100)) {
			errMsg = "���V�[�g�̐����s���ł��B";
		}
		//���V�[�g�̔��s���t 1�`31
		if (!(1 <= day && day <= 31)) {
			errMsg = "���V�[�g�̔��s���t���s���ł��B"; 
		}
		//���̓��t�̃��V�[�g�̍w�����z�@1�`10000
		if (!(1 <= price && price <= 10000)) {
			errMsg = "�w�����z���s���ł��B"; 
		}
		//�G���[���b�Z�[�W�̕\��
		if (errMsg != null) {
			System.out.println(errMsg);
			System.exit(0);
		}
	}
	
	/** ���C���������s���܂��B*/
	public void execute() {
		for (Map.Entry<Integer, Integer> map : map.entrySet()) {
			/** �|�C���g�W���@*/
			double dayPint = 0.01;
			double three_dayPint = 0.03;
			double five_dayPint = 0.05; 

			String day_s = map.getKey().toString();
			int price = map.getValue().intValue();
			
			//5�̕t������3�̕t�����͂��ꂼ��̃|�C���g�W����ݒ�
			if (day_s.contains("5")) {
				dayPint = five_dayPint;
			} else if (day_s.contains("3")) {
				dayPint = three_dayPint;
			}
			//�w�����z�ƃ|�C���g�����Z
			m += price;
			s += price * dayPint ;
		}
	}
	/** ���ʂ��o�͂��܂��B*/
	public void println() {
		System.out.println("----------�o�͊J�n----------");
		System.out.println(m + "�~");
		System.out.println(s + "�|�C���g");
		System.out.println("----------�o�͏I��----------");
	}
	
	/**
	 * ���C���������s���܂��B
	 * @param args
	 */
	public static void main (String[] args) {
		PointCard pointcard = new PointCard();
		
		//�W�����͂��s���B���͒l��map�ɑ�����Ă����B
		pointcard.inputArgs(args);
		
		//���v���z�ƃ|�C���g�̌v�Z���s�����C������
		pointcard.execute();
		
		//���ʂ�\������o�͏���
		pointcard.println();
	}
}
