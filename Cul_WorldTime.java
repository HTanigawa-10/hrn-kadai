package jisa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cul_WorldTime{
	public static String cont;  //�t���O
	
	public static void main(String args[]) {
		int N = 0;      //�v�Z����s�s�̑���
		String p_i = null; //�s�s��(���[�U��)
		int s_i = 0;    //����
		
		do{
//�v�Z����s�s�̐������
		System.out.println(message.MSG1);
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

			try {
			//���͑҂�
				String n = null;
				n = br1.readLine();
				
				//int�^�ɕϊ�
				//���͒l�����l�ȊO�̏ꍇ�ANumberFormatException
				N = Integer.parseInt(n);
				
				//���͒l�̔��茋�ʕ\��
				inputNumberCheck(N);
				
			}catch (NumberFormatException e){
				System.out.println(message.E_MSG1);
			}catch(IOException e) {
				System.out.println(message.E_MSG2);
				e.printStackTrace();
			}
		}while(cont.equals("n"));

//�s�s���Ǝ���(�i��)�̏������
		for(int i=0;i < N;i++) {
			
			String IN_p_i = null;
			System.out.println((i+1) + message.MSG3);
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				//���͑҂�
				IN_p_i = br2.readLine();
				
			}catch (NumberFormatException e){
				System.out.println("���̓G���[:");
			}catch(IOException e){
				System.out.println("���̓G���[:");
				e.printStackTrace();
			}
			
		}
	}

	/*public int cul_time_diff() {
		
	//	return int 1
	}
	
	
	
}


	*/

//���͒l�̔�����s��
//�����́A���͒l�������ȊO�A�܂��͔͈͊O�̐��l�̏ꍇ��NG
public static void inputNumberCheck(int N_Input){
	//���͒l��1�ȏ�A100�ȉ��̐����l�ł��邱�Ƃ��m�F
	if(1 <= N_Input && N_Input <= 100){
		System.out.println(message.MSG2);
		Cul_WorldTime.cont = "y";
	}else{
		Cul_WorldTime.cont = "n";
		System.out.println(message.E_MSG1);
	}
}


public class message{
	public static final String MSG1 = "�\������s�s�̐�����͂��Ă��������B";	
	public static final String MSG2 = "����OK";
	public static final String MSG3 = "�ڂ̓s�s���Ǝ����̏�����͂��Ă��������B�s�s��(���p�p��������20���ȓ�) ����(1h�`24h)";	
	public static final String E_MSG1 = "���͓��e���s���ł��B1�`100�܂ł̐�������͂��Ă��������B";
	public static final String E_MSG2 = "���͓��e���s���ł��B�ēx���͂��Ă��������B";
}
}



