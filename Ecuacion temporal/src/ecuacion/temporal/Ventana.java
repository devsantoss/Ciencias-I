/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecuacion.temporal;

import java.awt.Container;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class Ventana extends JFrame {

    JLabel etqNum = new JLabel("Digite la cantidad de numeros a generar random");
    JTextField txtNum = new JTextField();
    JLabel etqShowArr = new JLabel();
    JLabel etqShowArrOrd = new JLabel();
    JButton btnShow = new JButton("MOSTRAR");
    JButton btnVol = new JButton("VOLVER");

    public Ventana() {
        Container c = getContentPane();
        c.setLayout(null);
        this.setTitle("CASO PROMEDIO");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        c.add(etqNum);
        c.add(etqShowArr);
        c.add(etqShowArrOrd);
        c.add(txtNum);
        c.add(btnShow);
        c.add(btnVol);

        etqNum.setBounds(50, 50, 250, 35);
        etqShowArr.setBounds(50, 90, 250, 35);
        etqShowArrOrd.setBounds(50, 150, 450, 35);
        txtNum.setBounds(350, 50, 90, 35);
        btnShow.setBounds(150, 200, 150, 35);
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        btnVol.setBounds(310, 200, 150, 35);
        btnVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolActionPerformed(evt);
            }
        });

        setVisible(true);
        setSize(500, 300);

    }

    public void btnShowActionPerformed(java.awt.event.ActionEvent evt) {
        //caso promedio
        String s = txtNum.getText();
        int num = Integer.valueOf(s);
        int random, c = 1;

        int ArrNum[] = new int[num];

        for (int i = 0; i < num; i++) {

            random = (int) (Math.random() * 200 + 1);
            ArrNum[i] = random;

        }
        etqShowArr.setText(Arrays.toString(ArrNum));
        for (int i = 0; i < num - 1; i++) {
            c = c + 5;
            for (int j = i + 1; j < num; j++) {
                c = c + 5;
                if (ArrNum[i] > ArrNum[j]) {
                    int t = ArrNum[i];
                    ArrNum[i] = ArrNum[j];
                    ArrNum[j] = t;
                    c = c + 7;
                }    
            }
            c = c + 1;
        }
        c = c + 2;
        float ec = ( (17*(num*num)) + ((7*num) - 12) )/4;
        etqShowArrOrd.setText(Arrays.toString(ArrNum) + " OE: " + c + " Ecuacion: "+ ec);

    }
    public void btnVolActionPerformed(java.awt.event.ActionEvent evt) {
        Menu m = new Menu();
        setVisible(false);
    }

}
