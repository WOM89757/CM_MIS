//Source file: C:\\Users\\ï\\Desktop\\����\\������Ϣϵͳ\\MIS\\CMMIS\\src\\keyListener\\InputKeyListener.java

package keyListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputKeyListener extends KeyAdapter 
{
   
   /**
   �����������̳м����¼�
   @param e
   @roseuid 5D0B97CE00E1
    */
   public void keyTyped(KeyEvent e) 
   {
		String key="-0123456789"+(char)8;// ����ͨ�����̿�������İ���
		if(key.indexOf(e.getKeyChar())<0){// ��ǰ���µİ���û��key�б���
			e.consume();// ���ٵ�ǰû��key�б���İ���
		}    
   }
}
