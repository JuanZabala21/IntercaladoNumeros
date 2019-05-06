package Intercalate;
//Juan Zabala 
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Intercalado extends JFrame{
    JTextField T1,T2,T3; 
    JButton B1,B2;
    JLabel L1,L2,L3; 
    JPanel P1,P2,P3,P4,P5;  
    Container C; 
    public Intercalado() {
      super("Intercalado de Digitos");
      this.setSize(300,170);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      this.setResizable(false);
      C = getContentPane();   
      //Declaracion 
      B1 = new JButton("Intercalar");
      B2 = new JButton("Borrar"); 
      L1 = new JLabel("Valor de A:");
      L2 = new JLabel("Valor de B:");
      L3 = new JLabel("Intercalado:");
      T1 = new JTextField("",5);
      T2 = new JTextField("",5);
      T3 = new JTextField("",10); 
      T3.setEditable(false);
      P1 = new JPanel(new FlowLayout());
      P2 = new JPanel(new FlowLayout());
      P3 = new JPanel(new FlowLayout());
      P4 = new JPanel(new FlowLayout()); 
      P5 = new JPanel(new GridLayout(4,2,0,0));
      
      //Ubicar en los paneles
      //1
      P1.add(L1); P1.add(T1);
      //2
      P2.add(L2); P2.add(T2);
      //3
      P3.add(L3); P3.add(T3);
      //4
      P4.add(B1); P4.add(B2);
      //5
      P5.add(P1); P5.add(P2); P5.add(P4);  P5.add(P3);
      //Container al panel 5
      C.add(P5);
      
        //Intercalar
        B1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent ae) {
        String t1 = T1.getText();
        String t2 = T2.getText(); 
        String tf = ""; 
      
        if(t1.length() >= t2.length()) {
            for (int i = 0; i < t2.length(); i++) {
                tf += t1.charAt(i);
                tf += t2.charAt(i);
             }
            if(t1.length()!= t2.length()){
                for (int i = t2.length(); i < t1.length(); i++) {
                    tf += t1.charAt(i);
                }
            }
        } else {
            for (int i = 0; i < t1.length(); i++) {
                tf += t2.charAt(i);
                tf += t1.charAt(i); 
          
            }
            for (int i = t1.length(); i < t2.length(); i++) {
                tf += t2.charAt(i);
           }
        }
      T3.setText(tf);
        }
      });
        //Borrar
        B2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent ae) {
                T1.setText("");
                T2.setText("");
                T3.setText("");
                T1.requestFocus();
          }
       });
        //Focos
        T1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent ae) {
                 T2.requestFocus();
          }
       });
                T2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent ae) {
                 B1.doClick();//Enter para que se ejecute la intercalado
          }
       });
      //No se puedan escribir letras en los JTextField y me garantiza que sean solamente numeros enteros, tampoco aceptan signos.
      T1.addKeyListener(new KeyAdapter()
{
        public void keyTyped(KeyEvent KE)
   {
      char caracter = KE.getKeyChar();
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b'))
      {
         KE.consume(); 
      }
   }
});
      T2.addKeyListener(new KeyAdapter()
{
   public void keyTyped(KeyEvent KE)
   {
      char caracter = KE.getKeyChar();
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b'))
      {
         KE.consume();  
      }
   }
 });
 }
}
