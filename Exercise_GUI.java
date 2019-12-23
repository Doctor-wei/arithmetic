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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Exercise_GUI {
	 public static void main(String[] agrs)
	    {	
		    
		    JTextField flag = new JTextField();
		    
	        JFrame frame = new JFrame("��ϰ��");    //����Frame����
	        JPanel nav = new JPanel(new FlowLayout(FlowLayout.LEADING,20,15)); //��������ʽ���֣����20
	        JPanel content = new JPanel(new GridLayout(5,10,0,0)); //������,���񲼾֣�ÿ��10��
	        JPanel left_foot = new JPanel(new FlowLayout(FlowLayout.LEADING,40,15)); 
	        JPanel right_foot = new JPanel(new GridLayout(1,4,50,0)); 
	        JComboBox cmbadd=new JComboBox();    //����JComboBox
	        JComboBox cmbsub=new JComboBox();    //����JComboBox
	        JComboBox cmbmix=new JComboBox();    //����JComboBox
	        
	        cmbadd.addItem("--��ѡ����ϰ�ļӷ�ϰ��--");    //�������б������һ��
	        cmbadd.addItem("��һ��");
	        cmbadd.addItem("�ڶ���");
	        cmbadd.addItem("������");
	        
	        cmbsub.addItem("--��ѡ����ϰ�ļ���ϰ��--");    //�������б������һ��
	        cmbsub.addItem("��һ��");
	        cmbsub.addItem("�ڶ���");
	        cmbsub.addItem("������");
	        
	        cmbmix.addItem("--��ѡ����ϰ�ļ���ϰ��--");    //�������б������һ��
	        cmbmix.addItem("��һ��");
	        cmbmix.addItem("�ڶ���");
	        cmbmix.addItem("������");
	        
	        
	        JButton add_btn = new JButton("�ӷ���ʽ");
	        JButton sub_btn = new JButton("������ʽ");
	        JButton mix_btn = new JButton("�����ʽ");
	        JButton save_btn = new JButton("������");
	        
	        JButton ans_btn = new JButton("��ô�");
            add_btn.setBounds(50, 0, 50, 20);
            nav.add(cmbadd);
            nav.add(cmbsub);
            nav.add(cmbmix);
            //nav.add(add_btn);
//	        nav.add(sub_btn);
//	        nav.add(mix_btn);
	        nav.add(save_btn);
	        

           
            JTextField[] filed = new JTextField[50]; 
            JLabel[] labels = new JLabel[50]; 
	        left_foot.add(ans_btn);
	        left_foot.add(right_foot);
	        right_foot.add(new JLabel("��ȷ����:"));
	        JLabel Tnum=new JLabel();
	        right_foot.add(Tnum);
	        right_foot.add(new JLabel("��������:"));
	        JLabel Fnum=new JLabel();
	        right_foot.add(Fnum);
	        right_foot.add(new JLabel("��ȷ��:"));
	        JLabel Tp=new JLabel();
	        right_foot.add(Tp);
	        right_foot.add(new JLabel("�ܵ÷�:"));
	        JLabel Score=new JLabel();
	        right_foot.add(Score);
	        frame.setLayout(new BorderLayout());    //ΪFrame�������ò���ΪBorderLayout
	        
	        frame.add(nav,BorderLayout.NORTH);
	        frame.add(content,BorderLayout.CENTER);
	        frame.add(left_foot,BorderLayout.SOUTH);
	
	        frame.setBounds(20,230,1500,300);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
            cmbadd.addActionListener(new ActionListener() {
				
				@Override
			public void actionPerformed(ActionEvent e) {
				flag.setText("Add");
				content.removeAll(); 
				content.repaint();
				//��ʼ��
				Tnum.setText("");
				Fnum.setText("");
				Tp.setText("");
				Score.setText("");
				
				AddFile add = new AddFile();
				ArrayList<String[]> lstFile = new ArrayList<String[]>();
				int number;
				if(cmbadd.getSelectedItem().toString()=="��һ��")
				number=1;
				else if(cmbadd.getSelectedItem().toString()=="�ڶ���")
				number=2;
				else if (cmbadd.getSelectedItem().toString()=="������")
					number=3;
				else 
					number=0;
				lstFile=add.Read("Practice", "Add", number);//����ϰ�ļ�
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
	        
		cmbsub.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				flag.setText("Sub");
				content.removeAll();
				content.repaint();
				//��ʼ��
				Tnum.setText("");
				Fnum.setText("");
				Tp.setText("");
				Score.setText("");
				
				SubFile sub = new SubFile();
				ArrayList<String[]> lstFile = new ArrayList<String[]>();
				int number=0;
				if(cmbadd.getSelectedItem().toString()=="��һ��")
				number=1;
				else if(cmbadd.getSelectedItem().toString()=="�ڶ���")
				number=2;
					else if (cmbadd.getSelectedItem().toString()=="������")
					number=3;
					else
						number=0;
				lstFile = sub.Read("Practice", "Sub", number);// ����ϰ�ļ�
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
	    
		cmbmix.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				flag.setText("Mix");
				content.removeAll();
				content.repaint();
				
				//��ʼ��
				Tnum.setText("");
				Fnum.setText("");
				Tp.setText("");
				Score.setText("");
				
				MixFile mix = new MixFile();
				ArrayList<String[]> lstFile = new ArrayList<String[]>();
				int number=0;
				if(cmbadd.getSelectedItem().toString()=="��һ��")
				number=1;
				else if(cmbadd.getSelectedItem().toString()=="�ڶ���")
				number=2;
				else if (cmbadd.getSelectedItem().toString()=="������")
				number=3;
				else
					number=0;
				lstFile = mix.Read("Practice", "Mix", number);// ����ϰ�ļ�
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
				int number=0;//��¼�Եĸ���
				AddFile add = new AddFile();
				ArrayList<String[]> Answer = new ArrayList<String[]>();
				String[] input = new String[50];
				Answer = add.Read("Exercise", flag.getText(), 1);// ����ϰ�ļ�
				
				for (int i = 0; i < Answer.size(); i++) {
					input[i]=filed[i].getText();
					labels[i].setText(Answer.get(i)[2]);
					if(Answer.get(i)[2].equals(input[i])) {
						filed[i].setBackground(Color.GREEN);
						number++;
					}else
						filed[i].setBackground(Color.RED);
				}
				Tnum.setText(String.valueOf(number)+"��");
				Fnum.setText(String.valueOf((50-number))+"��");
				Tp.setText(String.valueOf((number/50.0)*100)+"%");
				Score.setText(String.valueOf(number)+"��");
			}
		});
		
//		save_btn.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				for (int i = 0; i < 50; i++) {
//					filed[i].setText();
//				}
//				content.revalidate();
//			}
//		});
//	    
	    }

}


