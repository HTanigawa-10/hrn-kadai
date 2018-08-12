package kadai_06;

import java.util.Scanner;

public class travel_schedule {
	/**�A�x�̓���**/
	private int M = 0;
	/**���s�̓���**/
	private int N = 0;
	/**�A�x�̓��t**/
	private int[] consecutiveHolidays;
	/**�A�x�̍~���m��**/
	private int[] rainfallProbability;
	
	public static travel_schedule ts = null;
	
	Scanner sc = null;
	
	public static void main(String ars[]) {
		
		System.out.println("�A�x�̓����Ɨ��s�̓�������͂��Ă��������B(���p�X�y�[�X��؂�)");

		try {
			ts = new travel_schedule();
			//[0]�A�x����M��[1]���s����N���擾����B
			String s[] = ts.getSchedule(); 
			ts.M = Integer.parseInt(s[0]);
			ts.N = Integer.parseInt(s[1]);
		
			//���̓`�F�b�N
			ts.checkInputNum(ts.M,ts.N);
		
			System.out.println("�A�x�̓��t�Ɗe���̍~���m��(%)�𔼊p�X�y�[�X��؂�œ��͂��Ă��������B");
		
			//�A�x�̓��t�ƁA�e���ɂ��̍~���m�����擾�B	
			ts.setRainfallProbability(ts.M ,ts.N);
		} catch (Exception e){
			System.out.println("���͒l�̓ǂݎ��Ɏ��s���܂����B");
			e.printStackTrace();
		} finally {
			//�C���X�^���X�̃N���[�Y����
			if (ts.sc != null) {ts.sc.close();};
		}
			
		//���̓`�F�b�N
		ts.checkRainfallProbability(ts.consecutiveHolidays, ts.rainfallProbability);
		
		//���s���Ԓ��ɍ~���m�����ł��Ⴍ�Ȃ���Ԃ��v�Z�A�o�͂���B
		String result = ts.getTravelDays(ts.M, ts.N, ts.consecutiveHolidays, ts.rainfallProbability);
		System.out.println("�~���m�����ł��Ⴍ�Ȃ����");
		System.out.println(result);
	}
	
	/*
	 * �A�x�����Ɨ��s�����̓��͏��������܂��B
	 * @return s �A�x�����Ɨ��s�������i�[����z��
	 */
	public String[] getSchedule() throws Exception {
		/**���͒l���ꎞ�I�Ɋi�[**/
		String[] s = null;
		
		ts.sc = new Scanner(System.in);
		String N = ts.sc.nextLine();
		s = N.split(" ");
						
		return s;
	}
	
	/*
	 * �A�x�����Ɨ��s�����̓��͒l�`�F�b�N�B�G���[�̏ꍇ�͏����I���B
	 * @param M �A�x�̓���
	 * @param N�@���s�̓���
	 */
	public void checkInputNum(int M ,int N) { 
		
		//1<=N<=M<=30�ł��邱�ƁB
		if (1 <= N && N <= 30 && 1 <= M && M <= 30 ) {
			if (!(N <= M)) {
				System.out.println("���s�̓����͘A�x�̓�����菬�����l���w�肵�Ă��������B�B");
				System.exit(1);
			}
		} else {
			System.out.println("�A�x�̓����Ɨ��s�̓�����30�ȉ��̐��l���w�肵�Ă��������B");
			System.exit(1);
		}
	}
	
	/*
	 * �A�x�̓��t�ƍ~���m���̓��͏������s���܂��B
	 * @param M �A�x�̓���
	 * @param N�@���s�̓���
	 */
	public void setRainfallProbability (int M ,int N ) {
		/**���͒l���ꎞ�I�Ɋi�[**/
		String[] s = null;
		ts.consecutiveHolidays = new int[M];
		ts.rainfallProbability = new int[M];
			
		//���p�X�y�[�X��؂�ŘA�x�̓��t�ƍ~���m�����A���ꂼ��̔z��Ɏ擾
		for (int i = 0 ; i < M ; i++) {
			String str = ts.sc.nextLine();
			s = str.split(" ");
			
			consecutiveHolidays[i] = Integer.parseInt(s[0]);
			rainfallProbability[i] = Integer.parseInt(s[1]);
		}
	}
	
	/*
	 * �A�x�̓��t�ƍ~���m���̓��͒l�`�F�b�N�B�G���[�̏ꍇ�͏����I���B
	 * @param ch �A�x�̓��t
	 * @param rp�@�~���m��
	 */
	public void checkRainfallProbability(int[] ch , int[] rp) {
		boolean errorFlag = true;
		
		for (int i :ch) {
			if(!(1 <= i && i <= 30)) errorFlag = false;
		}
		
		if (errorFlag == false) {
			System.out.println("�A�x�̓��t���s���ł��B1�ȏ�30�ȉ��̒l����͂��Ă��������B");
			System.exit(1);
		}
		
		for (int i :rp) {
			if (!(0 <= i && i <= 100)) errorFlag = false;
		}
		
		if (errorFlag == false) {
			System.out.println("�~���m���̒l���s���ł��B1�ȏ�100�ȉ��̒l����͂��Ă��������B");
			System.exit(1);
		}
	}
	
	/*
	 * ���s���Ԓ��ɍ~���m�����ł��Ⴍ�Ȃ���Ԃ��v�Z�A�o�͂���B
	 * 
	 * @param M �A�x�̓���
	 * @param N�@���s�̓���
	 * @param ch �A�x�̓��t
	 * @param rp�@�~���m��
	 * @return startDate + " " + endDate �~���m�����ł��Ⴍ�Ȃ�A���s�̊J�n�E�I����
	 */
	String getTravelDays(int M ,int N ,int[] ch, int[] rp) {
		//o����M-1�܂ł̕��ς��Ƃ�
		//1����M�܂ł̕��ς��Ƃ�
		//��r����B
		//�Ⴂ�ق����c���B
		//2����M+1�܂ł̕��ς��Ƃ�
		//��r����B
		//�Ⴂ�ق����c���B
		//3����M+2�܂ł̕��ς��Ƃ�
		
		int bestRainfallProbability = 0;
		
		//�A�x�������痷�s�����ꍇ�̍~���m���̕��ς��擾����B
		bestRainfallProbability = getAverage(0,N-1,rp);
		int startDate = ch[0];
		int endDate = ch[N-1];
		
		//�A�x2���ڈȍ~�̍~���m���̕��ςƔ�r���Ă����B
		for (int i = 1 ; i < (M-N) ; i++) {
			int ave = getAverage(i,i+N-1,rp);
		
			if (ave < bestRainfallProbability) {
				startDate = ch[i];
				endDate = ch[i+N-1];
			}
		}
		return startDate + " " + endDate;
	}
	
	/*
	 * int�^�z��̗v�f�ԍ�a����b�܂ł̕��ς��v�Z����B
	 * @param a �����n�߂̗v�f�ԍ�
	 * @param b �����I���̗v�f�ԍ�
	 * @param list[] �~���m���̃��X�g
 	 * @return total/(b-a+1) int�^�z��̗v�f�ԍ�a����b�܂ł̕���
	 */
	int getAverage(int a , int b ,int[] list) {
		int total = 0; 
		
		for (int i = a ; i <= b ; i++) {
			total += list[i];
		}
				
		return total/(b-a+1);
	}
	
}