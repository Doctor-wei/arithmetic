package compute3;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Printable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Exercise_GUI {
	 public static void main(String[] agrs)
	    {
	        JFrame frame = new JFrame("��ϰ��");    //����Frame����
	        JPanel nav = new JPanel(new FlowLayout(FlowLayout.LEADING,20,15)); //��������ʽ���֣����20
	        JPanel content = new JPanel(new GridLayout(5,10,0,0)); //������,���񲼾֣�ÿ��10��
	        JPanel left_foot = new JPanel(new FlowLayout(FlowLayout.LEADING,40,15)); 
	        JPanel right_foot = new JPanel(new GridLayout(1,4,50,0)); 
	        JButton add_btn = new JButton("�ӷ���ʽ");
	        JButton sub_btn = new JButton("������ʽ");
	        JButton mix_btn = new JButton("�����ʽ");
	        JButton save_btn = new JButton("������");
	        
	        JButton ans_btn = new JButton("��ô�");
            add_btn.setBounds(50, 0, 50, 20);
	        nav.add(add_btn);
	        nav.add(sub_btn);
	        nav.add(mix_btn);
	        nav.add(save_btn);
	        
	      
	        
	        left_foot.add(ans_btn);
	        left_foot.add(right_foot);
	        right_foot.add(new JLabel("��ȷ����:"));
	        right_foot.add(new JLabel("��������:"));
	        right_foot.add(new JLabel("��ȷ��:"));
	        right_foot.add(new JLabel("�ܵ÷�:"));
	        
	        frame.setLayout(new BorderLayout());    //ΪFrame�������ò���ΪBorderLayout
	        
	        frame.add(nav,BorderLayout.NORTH);
	        frame.add(content,BorderLayout.CENTER);
	        frame.add(left_foot,BorderLayout.SOUTH);
	
	        frame.setBounds(20,230,1000,300);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
            add_btn.addActionListener(new ActionListener() {
				
				@Override
			public void actionPerformed(ActionEvent e) {
				content.removeAll(); 
				content.repaint();
				
				ArrayList<String[]> lstFile = new ArrayList<String[]>();
				
                for(int i=0;i<20;i++) {
                	JLabel label = new JLabel(lstFile.get(i)[1]);
				    content.add(label);
                }
                content.revalidate();
				}
			});
	        
	        
	    }

}


