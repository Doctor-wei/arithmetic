//此GUI为完成，为初代版本
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
	        JFrame frame = new JFrame("练习题");    //创建Frame窗口
	        JPanel nav = new JPanel(new FlowLayout(FlowLayout.LEADING,20,15)); //导航栏流式布局，间隔20
	        JPanel content = new JPanel(new GridLayout(5,10,0,0)); //内容区,网格布局，每行10道
	        JPanel left_foot = new JPanel(new FlowLayout(FlowLayout.LEADING,40,15)); 
	        JPanel right_foot = new JPanel(new GridLayout(1,4,50,0)); 
	        JButton add_btn = new JButton("加法算式");
	        JButton sub_btn = new JButton("减法算式");
	        JButton mix_btn = new JButton("混合算式");
	        JButton save_btn = new JButton("保存结果");
	        
	        JButton ans_btn = new JButton("获得答案");
            add_btn.setBounds(50, 0, 50, 20);
	        nav.add(add_btn);
	        nav.add(sub_btn);
	        nav.add(mix_btn);
	        nav.add(save_btn);
	        
	      
	        
	        left_foot.add(ans_btn);
	        left_foot.add(right_foot);
	        right_foot.add(new JLabel("正确数量:"));
	        right_foot.add(new JLabel("错误数量:"));
	        right_foot.add(new JLabel("正确率:"));
	        right_foot.add(new JLabel("总得分:"));
	        
	        frame.setLayout(new BorderLayout());    //为Frame窗口设置布局为BorderLayout
	        
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


