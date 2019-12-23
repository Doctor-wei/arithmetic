package compute3;
import java.awt.BorderLayout;
import java.awt.Color;
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
		    
		    JTextField flag = new JTextField();
		    
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
	        

           
            JTextField[] filed = new JTextField[50]; 
            JLabel[] labels = new JLabel[50]; 
	        left_foot.add(ans_btn);
	        left_foot.add(right_foot);
	        right_foot.add(new JLabel("正确数量:"));
	        JLabel Tnum=new JLabel();
	        right_foot.add(Tnum);
	        right_foot.add(new JLabel("错误数量:"));
	        JLabel Fnum=new JLabel();
	        right_foot.add(Fnum);
	        right_foot.add(new JLabel("正确率:"));
	        JLabel Tp=new JLabel();
	        right_foot.add(Tp);
	        right_foot.add(new JLabel("总得分:"));
	        JLabel Score=new JLabel();
	        right_foot.add(Score);
	        frame.setLayout(new BorderLayout());    //为Frame窗口设置布局为BorderLayout
	        
	        frame.add(nav,BorderLayout.NORTH);
	        frame.add(content,BorderLayout.CENTER);
	        frame.add(left_foot,BorderLayout.SOUTH);
	
	        frame.setBounds(20,230,1500,300);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
            add_btn.addActionListener(new ActionListener() {
				
				@Override
			public void actionPerformed(ActionEvent e) {
				flag.setText("Add");
				content.removeAll(); 
				content.repaint();
				AddFile add = new AddFile();
				ArrayList<String[]> lstFile = new ArrayList<String[]>();
				lstFile=add.Read("Practice", "Add", 1);//读练习文件
                for(int i=0;i<lstFile.size();i++) {
                	JLabel label = new JLabel(lstFile.get(i)[1]);
				    content.add(label);
				    filed[i] = new JTextField();
				    content.add(filed[i]);
				    
				    labels[i]= new JLabel();
				    labels[i].setText("");
				    content.add(labels[i]);
                }
                content.revalidate();
				}
			});
	        
		sub_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				flag.setText("Sub");
				content.removeAll();
				content.repaint();
				SubFile sub = new SubFile();
				ArrayList<String[]> lstFile = new ArrayList<String[]>();
				lstFile = sub.Read("Practice", "Sub", 1);// 读练习文件
				for (int i = 0; i < lstFile.size(); i++) {
					JLabel label = new JLabel(lstFile.get(i)[1]);
					content.add(label);
					 filed[i] = new JTextField();
					    content.add(filed[i]);
					    
					    labels[i]= new JLabel();
					    labels[i].setText("");
					    content.add(labels[i]);
				}
				content.revalidate();
			}
		});
	    
		mix_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				flag.setText("Mix");
				content.removeAll();
				content.repaint();
				MixFile mix = new MixFile();
				ArrayList<String[]> lstFile = new ArrayList<String[]>();
				lstFile = mix.Read("Practice", "Mix", 1);// 读练习文件
				for (int i = 0; i < lstFile.size(); i++) {
					JLabel label = new JLabel(lstFile.get(i)[1]);
					content.add(label);
					filed[i] = new JTextField();
					content.add(filed[i]);
					  
				    labels[i]= new JLabel();
				    labels[i].setText("");
				    content.add(labels[i]);
					
				}
				content.revalidate();
			}
		});
		
		ans_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int number=0;//记录对的个数
				AddFile add = new AddFile();
				ArrayList<String[]> Answer = new ArrayList<String[]>();
				String[] input = new String[50];
				Answer = add.Read("Exercise", flag.getText(), 1);// 读练习文件
				
				for (int i = 0; i < Answer.size(); i++) {
					input[i]=filed[i].getText();
					labels[i].setText(Answer.get(i)[2]);
					if(Answer.get(i)[2].equals(input[i])) {
						filed[i].setBackground(Color.GREEN);
						number++;
					}else
						filed[i].setBackground(Color.RED);
				}
				Tnum.setText(String.valueOf(number)+"个");
				Fnum.setText(String.valueOf((50-number))+"个");
				Tp.setText(String.valueOf((number/50.0)*100)+"%");
				Score.setText(String.valueOf(number)+"分");
			}
		});
		
		
	    }

}


