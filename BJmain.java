package blackJack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJmain {

	public static void main (String args[]) {
		String message = null; //�o�̓��b�Z�[�W
		String sInput = null; //String�R�}���h���C������
	   	String result = null; //���v���胁�b�Z�[�W
	   	String cont = "y"; //3��ڈȍ~�̑��s����p
		ArrayList<Integer> InputNumArray = new ArrayList<Integer>(); //���͒l�̔z��B���͂����񐔂Ɨv�f�ԍ�����v
		int iInput = 0; //int�R�}���h���C������
		int count = 1;  //���͉񐔃J�E���g
		int total = 0;  //���͒l���v
		
		
		System.out.println("BlackJack���J�n���܂��B");
		
		//3��ڈȍ~���s���邩�ǂ�������
		while(cont.equals("y")){
		
			//1��ڂ�2��ڂ̓��͂��s�����[�v
			for(int i=1; i < 3;){
			
				System.out.println( count + "�ڂ̐�����͂��Ă��������B");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
				try {
					//���͑҂�
					sInput = br1.readLine();
		
					//int�^�ɕϊ�
					//���͒l�����l�ȊO�̏ꍇ�ANumberFormatException
					iInput = Integer.parseInt(sInput)  ;
		
					//���͒l�̔��茋�ʕ\��
					message = inputNumberCheck(iInput);
					System.out.println(message);
		
					if(message == "���͒lOK!") {
						//������(i-1,iInput)����(iInput)�ɏC���B��128�`131���C��
						InputNumArray.add(iInput);
						i = ++count;
					}
			
				}catch (NumberFormatException e){
					message = "���͂����l���s���ł��B1�ȏ�13�ȉ��̐����l����͂��Ă��������B";
					System.out.println(message);
				}catch(IOException e){
					System.out.println("���̓G���[:");
					e.printStackTrace();
				}
			}
		
			//���v���v�Z
			total = inputNumberCul(InputNumArray);
			//"BlackJack!!!","Pig!!","Hit","STAND!!"�̂����ꂩ�𔻒�(result)
			result = inputNumberMes(total);
			
			//result��"BlackJack!!!"�܂���"Pig!!"�̏ꍇ�́A���b�Z�[�W��\�����ăQ�[���I���B
   	 		if(result == "BlackJack!!!" || result == "Pig!!") {
   	 			System.out.println("���v:" + total + result);
   	 			cont = "n";
   	 		}else{
   	 			
   	 			System.out.println("���v:" + total);
   	 			//"HOLD"�̏ꍇ�́A3��ڈȍ~�̂̓��͂��s�����ǂ������肳����@y/n
   	 			//�s���ȕ�������͂����ꍇ�͍ē��́i���b�Z�[�W�Ȃ��j
   	 			do  {
   	 				System.out.println("����ɐ���ǉ����܂����H y/n");
   	 				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
   	 	    
   	 				try {
   	 					//���͑҂�
   	 					cont = br2.readLine();
   	 					if(cont.equals("n")) {
   	 						System.out.println("���v:" + total + "STAND!!!");
   	 					}else {
   	 					System.out.println("Hit!!!");
   	 					}
   	 					}catch(IOException e){
   	 						System.out.println("���̓G���[:");
   	 						e.printStackTrace();
   	 					}
   	 			//3��ڈȍ~�̑��s����p��cont��"y","n"�̂�����ł��Ȃ��ꍇ�͍ē���
   	 			}while(!(cont.equals("y") || cont.equals("n")));	
   	 		}
		}
   	 	System.out.println("BlackJack���I�����܂��B");
	}	
	
	
	
	
	
	//���͒l�̔�����s��
	//�����́A���͒l�������ȊO�A�܂��͔͈͊O�̐��l�̏ꍇ��NG

	public static String inputNumberCheck(int iInput) {
		
		String message = null;
	    
			//���͒l��1�ȏ�A13�ȉ��̐����l�ł��邱�Ƃ��m�F
			if(iInput < 1 ) {
				message = "���͒l�����������܂��B1�ȏ�13�ȉ��̐����l����͂��Ă��������B";
			}
		    else if(13 < iInput){
		    	message = "���͒l���傫�����܂��B1�ȏ�13�ȉ��̐����l����͂��Ă��������B";
		    }
		    else {
		        message = "���͒lOK!";
			}
			return message;
		}

	
	
     //i��ڂ̐��l�̏o�͂ƁA���v���v�Z����B
     public static int inputNumberCul(ArrayList<Integer> InputNumArray) {
    	 int total = 0;
    	 String message = null;

     //�C���ς�
    		 for (int i = 0 ; i < (InputNumArray.size()) ; i++) {  			 
    			 message = (1 + i) + "��ځF" + InputNumArray.get(i);
    			 System.out.println(message);
    			 total = total + InputNumArray.get(i);			 
    		 }
    	 return total;
     }
     
    	 
    	 
     //���͒l�̍��v������s���B���ꂼ��̌��ʃ��b�Z�[�W��Ԃ��B
     public static String inputNumberMes(int total) {
    	 
    	 String result = null; 
     
    	 if(total == 21) {
       		 result = ("BlackJack!!!");
    	 }else if (21 < total) {
    		 result = ("Pig!!");
    	 }else {
    		 result = ("HOLD");
    	 }
    	 
         return result;
     }
}

	
	
	
	
	
	





















