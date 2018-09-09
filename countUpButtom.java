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
	
	/** カウント  */
	int count = 0;
	/** カウントアップ  */
	private JButton countButton;
	/** カウントリセット  */
	private JButton resetButton;
	/** カウント表示  */
	private JLabel label;
	
	public static void main(String ars[]) {
		countUpButtom cub = new countUpButtom();
		cub.execute();
	}
	
	public void execute(){
		//ウィンドウの設定
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(400,300);
		jFrame.setLocationRelativeTo(null);
		
		//ボタンの設定
		countButton = new JButton("カウントアップ");
		resetButton = new JButton("リセット");
		//サイズを指定
		countButton.setPreferredSize(new Dimension(150,30));
		resetButton.setPreferredSize(new Dimension(150,30));
		//ボタン用のパネルに水平配置
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new FlowLayout());
	    buttonPanel.add(countButton);
	    buttonPanel.add(resetButton);
		
	    // カウントボタンを押した時の処理を設定
		countButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				count++;
				label.setText(count + "回" );
			}
		});
	    // リセットボタンを押した時の処理を設定
		resetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				count = 0;
				label.setText(count + "回" );
			}
		});
		
		//ラベルの設定
	    label = new JLabel(count + "回");
		//ラベル用のパネルに配置
	    JPanel labelPanel = new JPanel();
	    labelPanel.add(label);
		
		//ボタン・ラベルを配置したコンポーネントを配置するコンテナを生成・BorderLayoutで配置
		Container Container = jFrame.getContentPane();
		Container.add(buttonPanel, BorderLayout.NORTH);
		Container.add(labelPanel, BorderLayout.CENTER);
		
		//可視化
		jFrame.setVisible(true);
	}
}
