package kadai_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HospitalRoomNumber {

	public static void main(String[] args) {
		
		HospitalRoomNumber hrn = new HospitalRoomNumber();
		
		/** �����Ȑ���*/
		int n = 0;
		/** �����ԍ����X�g*/
		List<Integer> roomNumber = new ArrayList<Integer>();
		/** ��]���镔���ԍ����X�g*/
		List<Integer> hopeRoomNumber = new ArrayList<Integer>();
		
 		//�����Ȕԍ�n�A�a���̑���m�A�����ԍ�r_i�̓��́B
		//�����ԍ��̃��X�groomNumber���쐬�BNG�̏ꍇ�͏����I��
		if(!hrn.getList(roomNumber)) {
			System.out.println("�������I�����܂��B");
			System.exit(0);
		};
		
		//�����Ȑ���n���擾
		n = roomNumber.get(0);
		
		//�����ԍ��ȊO�̗v�f���폜�@�ˁ@�����Ȑ���,�a���̑���
		roomNumber.remove(0);
		roomNumber.remove(0);
		
		//�����Ȕԍ�n���܂܂Ȃ������ԍ����o��
		hrn.getHopeNumber(n, roomNumber, hopeRoomNumber);
	}
	
	/*�����ԍ���m���ǂݍ���ŁAList������B
	*@param AbstractSequentialList<Integer> roomNumber �󂢂Ă镔���ԍ��̃��X�g
	*@return true ����������I��
	*@return false ���̓`�F�b�NNG
	*@return false�@��O����
	*/
	public Boolean getList(List<Integer> roomNumber){
		
		InputStreamReader isr = null;
		BufferedReader sr = null;
		try {
			String line = null;
			isr = new InputStreamReader(System.in);
			sr = new BufferedReader(isr);
			
			System.out.println("�����Ȑ�������͂��ĉ������B");
			int count = 0; 
			
			//���[�vnull�܂ł͂��������Ȃ��H
			while(((line = sr.readLine()) != null)) {
				int input = 0;
	
				//�󕶎��̏ꍇ��NG
				if(line == "") {
					System.out.println(ErrorMsg.EMSG1);
					return false;
				}
				
				//���͒l��int�^�ɕϊ�
				input = Integer.parseInt(line);
				
				//���͒l��list�ɒǉ�
				roomNumber.add(input); 
				count++;
				
				//���̓`�F�b�N NG�̏ꍇ�͏����I��
				if(!inputNumberCheck(count, Integer.parseInt(line))) {
					return false;
				}
				
				//�w�肵�������̐�(roomNumber���X�g��2�ڂ̗v�f)�ɒB�����ꍇ�̓��[�v�I��
				if (count > 2) {
					if(count > (roomNumber.get(1)+1)) {
						break;
					}
				}
				
				//���b�Z�[�W
				if(count == 1) {
					System.out.println("�a���̑�������͂��ĉ������B");
				} else if(count == 2) {
					System.out.println("�����ԍ���" + roomNumber.get(1) + "���͂��ĉ������B");
				}
			}
			return true;
		}catch(IOException e){	
			//�ǂݍ��݃G���[
			System.out.println(ErrorMsg.EMSG3);
			return false;
		}catch(NumberFormatException e){	
			//���͒l�����l�ł͖����ꍇ
			System.out.println(ErrorMsg.EMSG4);
			return false;
		}catch(Exception e){	
			e.printStackTrace();
			return false; 
		}finally {
			//�C���X�^���X�̃N���[�Y����
			try {
				if (sr != null) {
					sr.close();
				}
				if (isr != null) {
					isr.close();
				}
			} catch(Exception e) {}
		}
	}
	
	/*���͒l�̃`�F�b�N������B
	*@param int i ���͏��łǂ̒l������
	*@param int in�@���͒l
	*@return true�@���͒l���������ꍇ 
	*@return false ���͒l���s���ȏꍇ
	*/
	Boolean inputNumberCheck(int count,int in){
		if(count == 1) {
			if(!(0 <= in && in <= 9)) {
				System.out.println(ErrorMsg.EMSG5);
				return false;
			}
		} else if(count == 2) {
			if(!(1 <= in && in <= 100)) {
				System.out.println(ErrorMsg.EMSG6);
				return false;
			}
		} else {
			if(!(0 <= in && in <= 1000)) {
				System.out.println(ErrorMsg.EMSG7);
				return false;
			}
		}
		return true;
	}
	
	/*�����Ȕԍ����܂܂�Ȃ������ԍ��𔻕ʂ��A�o��
	*@param int i ���͏��łǂ̒l������
	*@param int in�@���͒l
	*@return true�@���͒l���������ꍇ 
	*@return false ���͒l���s���ȏꍇ
	*/
	void getHopeNumber(int n, List<Integer> roomNumber,List<Integer> hopeRoomNumber) {
		/**�����Ȑ��l String�^*/
		final String sn = String.valueOf(n);

		//�����Ȑ������܂܂Ȃ��ꍇ�́AHopeRoomNumber�ɉ�����
		roomNumber.stream()
		.filter(a -> !a.toString().contains(sn))
		.forEach(a -> hopeRoomNumber.add(a));
		
		//��]���镔���ԍ����o��
		//��]���镔���ԍ���1���Ȃ����"none" ���o��
		if(hopeRoomNumber.size() == 0) {
			System.out.println("�����Ȕԍ�" + n + "���܂܂Ȃ������ԍ��͂���܂���ł����B");
			System.out.println("none");
		} else {
			System.out.println("�����Ȕԍ�" + n + "���܂܂Ȃ������ԍ��͈ȉ��̒ʂ�ł��B");
			for(int i : hopeRoomNumber) {
				System.out.println(i);
			}
		}
	}
}
	
	

