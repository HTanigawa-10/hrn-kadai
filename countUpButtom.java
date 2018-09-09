package kadai_08;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class countUpButtom extends Frame {
	
	/** �J�E���g  */
	int count = 0;
	/** �J�E���g�A�b�v  */
	private JButton countButton;
	/** �J�E���g���Z�b�g  */
	private JButton resetButton;
	/** �J�E���g�\��  */
	private JLabel label;
	
	public static void main(String ars[]) {
		countUpButtom cub = new countUpButtom();
		cub.execute();
	}
	
	public void execute(){
		//�E�B���h�E�̐ݒ�
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(400,300);
		jFrame.setLocationRelativeTo(null);
		
		//�{�^���̐ݒ�
		countButton = new JButton("�J�E���g�A�b�v");
		resetButton = new JButton("���Z�b�g");
		//�T�C�Y���w��
		countButton.setPreferredSize(new Dimension(150,30));
		resetButton.setPreferredSize(new Dimension(150,30));
		//�{�^���p�̃p�l���ɐ����z�u
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new FlowLayout());
	    buttonPanel.add(countButton);
	    buttonPanel.add(resetButton);
		
	    // �J�E���g�{�^�������������̏�����ݒ�
		countButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				count++;
				label.setText(count + "��" );
			}
		});
	    // ���Z�b�g�{�^�������������̏�����ݒ�
		resetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				count = 0;
				label.setText(count + "��" );
			}
		});
		
		//���x���̐ݒ�
	    label = new JLabel(count + "��");
		//���x���p�̃p�l���ɔz�u
	    JPanel labelPanel = new JPanel();
	    labelPanel.add(label);
		
		//�{�^���E���x����z�u�����R���|�[�l���g��z�u����R���e�i�𐶐��EBorderLayout�Ŕz�u
		Container Container = jFrame.getContentPane();
		Container.add(buttonPanel, BorderLayout.NORTH);
		Container.add(labelPanel, BorderLayout.CENTER);
		
		//����
		jFrame.setVisible(true);
	}
}
