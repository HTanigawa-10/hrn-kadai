import java.util.*;
import java.util.Map.Entry;

public class Bookpurchase {

	    public static void main(String args[] ) throws Exception {
	    
	        int N = 0;//�Ј���
	        int M = 0;//�{�̍���
	        String o_j = null; //�w�������@�Ј���
	        Integer p_j = 0; //�w�����z   0�`N�Ԃ�[�w�������@�Ј���]�ƕR�Â�
	        Map<String, Integer> map = new HashMap<>(); 
	    	Scanner sc = new Scanner(System.in);
	        
	        System.out .println("�Ј�������͂��Ă��������B");
	  
	  //�Ј������擾����B      
	        try {
	        	N = sc.nextInt();
	        	//���͒l�`�F�b�N(���p���l)
	        	checkNumRange(N);
	        }catch(InputMismatchException e) {
	        	sc.close();
	        	throw new IllegalArgumentException(MSG.EMSG1);
	        }
	        
	        System.out .println("�Ј����𔼊p�X�y�[�X��؂�œ��͂��Ă��������B");
	        
	        String[] s_N = new String[N];
	        
	  //�Ј����𔼊p�X�y�[�X��؂�Ŏ擾����B 
	        sc = new Scanner(System.in);
	        String s = sc.nextLine();
	        s_N = s.split(" ");
	        
	        for(String n : s_N ) {
	        	int count = 0;
	        //�������`�F�b�N
	        	checkName(n);
	        //�d���`�F�b�N
	        	for(String same_name : s_N ) {
	        		if(same_name.equals(n))count++;
	        			if(count == 2) {
	        				sc.close();
	        				throw new IllegalArgumentException(MSG.EMSG4);
	        			}
	        	}
	        }
	        
	  //hashmap�ɃL�[�F�Ј����A�l�F0�Ƃ��Đݒ�A
	        for(String a: s_N) {
	        	map.put(a, 0);  
	        }
	        
	        System.out .println("�����̐�����͂��Ă��������B");
	        
      //�Ј��������w�������{�̍���M���擾����B      
	        try {
	            sc = new Scanner(System.in);
	        	M = sc.nextInt();
	        	checkNumRange(M);
	        }catch(InputMismatchException e) {
	        	//���͒l�����p���l�ȊO�̏ꍇ
	        	sc.close();
	        	throw new IllegalArgumentException(MSG.EMSG1);
	        }
	        System.out .println("�Ј����ƍw�����z�𔼊p�X�y�[�X��؂�œ��͂��Ă��������B");
	   //�Ј��������w�������{�̍w�����zp_j�𔼊p�X�y�[�X��؂�Ŏ擾����B�@�@�Ј���  �w�����z
	        
	        String[] s_M = new String[M];
	        for (int i = 0; i < M; i++) {
	        	sc = new Scanner(System.in);
	            String s4 = sc.nextLine(); 
	            sc.close();
	            
	            s_M = s4.split(" ",-1);
	            o_j = s_M[0];
	            //�������`�F�b�N
	            checkName(o_j);
	            
	            //���͒l�`�F�b�N(���p���l,�͈�)
	            try {
	            	p_j = Integer.valueOf(s_M[1]);
	            	checkNumRange2(p_j);
	            }catch(NumberFormatException e) {
	            	throw new IllegalArgumentException("�w�����z��" + MSG.EMSG1);
	            }
	            
	            
	            //�Ј�����key�ƈ�v����ꍇ�́A�w�����z��val�ɉ��Z
	            for(String key: map.keySet()) {
	            	if(o_j.equals(key)){
	            		 Integer val = map.get(key);
	            		 map.put(key, val+p_j);
	            	}
	            }
	        }
	        
	    //�w�����z���������ɎЈ������o��
	        
	        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());	        
	        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
	            //compare���g�p���Ēl���r����
	            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
	            {
	                //�~��
	                return obj2.getValue().compareTo(obj1.getValue());
	            }
	        });
	        
	        System.out.println("���Ѝw���҈ꗗ(�~��)");
	        // 7. ���[�v�ŗv�f���ɒl���擾����
	        for(Entry<String, Integer> entry : list_entries) {
	            System.out.println(entry.getKey() + " : " + entry.getValue());
	        }
	    }
	    
	    /* �Ј����A�{�̐����̓`�F�b�N
	     * �p�����[�^�����p�������ŏ��l�ȏ�A�ő�l�ȉ��ł���΂��̒l��ԋp����B
	    */
	    public static int checkNumRange(int n) {
			// �ŏ��l�ȏ�A�ŏ��l�ȉ��̔���
			if (1 <= n && n <= 100) {
				// ����OK�Ȃ炻�̒l��ԋp����
				return n;
			}
			// ����NG�Ȃ�G���[
			throw new IllegalArgumentException(MSG.EMSG2);
		}
	    
	    /* �w�����z���̓`�F�b�N
	     * �p�����[�^�����p�������ŏ��l�ȏ�A�ő�l�ȉ��ł���΂��̒l��ԋp����B
	    */
	    public static int checkNumRange2(int n) {
			// �ŏ��l�ȏ�A�ŏ��l�ȉ��̔���
			if (1 <= n && n <= 10000) {
				// ����OK�Ȃ炻�̒l��ԋp����
				return n;
			}
			// ����NG�Ȃ�G���[
			throw new IllegalArgumentException(MSG.EMSG3);
		}
	    
	    /* �Ј������̓`�F�b�N
	     * ���������ŏ��l�ȏ�A�ő�l�ȉ��ł���΂��̒l��ԋp����B
	    */
	    public static void checkName(String name) {
			// �ŏ��l�ȏ�A�ŏ��l�ȉ��̔���
			if (1 <= name.length() && name.length() <= 20) {
				return;
			}
			// ����NG�Ȃ�G���[
			throw new IllegalArgumentException(MSG.EMSG4);
		}
	       
public class MSG{
	public static final String EMSG1 = "���p�����œ��͂��Ă��������B";
	public static final String EMSG2 = "1�ȏ�100�ȉ��̐��l����͂��ĉ������B";
	public static final String EMSG3 = "1�ȏ�10000�ȉ��̐��l����͂��ĉ������B";
	public static final String EMSG4 = "�Ј����͂�20���ȓ��œ��͂��ĉ������B"; 
	public static final String EMSG5 = "�Ј������d�����Ă��܂��B"; 
}
}

	    

