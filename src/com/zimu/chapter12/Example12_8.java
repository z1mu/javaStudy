package com.zimu.chapter12;

import com.sun.org.apache.xml.internal.security.Init;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @author : zimu
 * @Date: 2018/7/9 14:48
 * @description :   文件对话框
 */
public class Example12_8 {
    public static void main(String args[]){
        WindowReader win = new WindowReader();
        win.setTitle("使用文件对话框读/写文件");
    }
}

class WindowReader extends JFrame implements ActionListener{

    JFileChooser fileDialog;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem itemSave, itemOpen;
    JTextArea textArea;
    BufferedReader in;
    FileReader fileReader;
    BufferedWriter out;
    FileWriter fileWriter;
    WindowReader(){
        init();
        setSize(300, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        textArea = new JTextArea(10,10 );
        textArea.setFont(new Font("楷体_gb2312", Font.PLAIN, 28));
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        menuBar = new JMenuBar();
        menu = new JMenu("文件");
        itemSave = new JMenuItem("保存文件");
        itemOpen = new JMenuItem("打开文件");
        itemSave.addActionListener(this);
        itemOpen.addActionListener(this);
        menu.add(itemOpen);
        menu.add(itemSave);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        fileDialog = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Java源文件", ".java");
        fileDialog.setFileFilter(filter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemSave){
            int state = fileDialog.showSaveDialog(this);
            if (state==JFileChooser.APPROVE_OPTION){
                try {
                    File dir = fileDialog.getCurrentDirectory();
                    String name = fileDialog.getSelectedFile().getName();
                    File file = new File(dir, name);
                    fileWriter = new FileWriter(file);
                    out = new BufferedWriter(fileWriter);
                    out.write(textArea.getText());
                    out.close();
                    fileWriter.close();
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        }else if (e.getSource() == itemOpen){
           int state = fileDialog.showOpenDialog(this);
           if (state == JFileChooser.APPROVE_OPTION){
               textArea.setText(null);
               try {
                   File dir = fileDialog.getCurrentDirectory();
                   String name = fileDialog.getSelectedFile().getName();
                   File file = new File(dir, name);
                   fileReader = new FileReader(file);
                   in = new BufferedReader(fileReader);
                   String s = null;
                   while ((s = in.readLine())!=null){
                       textArea.append(s+"\n");
                   }
                   in.close();
                   fileReader.close();
               }catch (Exception e1){
                   e1.printStackTrace();
               }
           }
        }
    }
}
