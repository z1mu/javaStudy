package com.zimu.chapter13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author : zimu
 * @Date: 2018/6/30 09:49
 * @description :   商品的录入与显示
 */
public class Example13_5 {
    public static void main(String args[]){
        WindowGoods win = new WindowGoods();
        win.setTitle("商品的录入与显示");
    }
}

class Goods implements java.io.Serializable{    //当前类实现java.io.Serializable
    String name, mount, price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMount() {
        return mount;
    }

    public void setMount(String mount) {
        this.mount = mount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

class InputArea extends JPanel implements ActionListener{
    File f = null;  //存放链表的文件
    Box baseBox, boxV1, boxV2;
    JTextField name, mount, price;  //为Goods提供的视图
    JButton button; //控制器
    LinkedList<Goods> goodslist;       //存放Goods对象的链表
    InputArea(File f){
        this.f =f;
        goodslist = new LinkedList<Goods>();
        name = new JTextField(12);
        mount = new JTextField(12);
        price = new JTextField(12);
        button = new JButton("录入");
        button.addActionListener(this);
        boxV1 = Box.createVerticalBox();
        boxV1.add(new JLabel("输入名称"));
        boxV1.add(Box.createHorizontalStrut(8));
        boxV1.add(new JLabel("输入库存"));
        boxV1.add(Box.createHorizontalStrut(8));
        boxV1.add(new JLabel("输入单价"));
        boxV1.add(Box.createHorizontalStrut(8));
        boxV1.add(new JLabel("单击录入"));
        boxV2 = Box.createVerticalBox();
        boxV2.add(name);
        boxV2.add(Box.createHorizontalStrut(8));
        boxV2.add(mount);
        boxV2.add(Box.createHorizontalStrut(8));
        boxV2.add(price);
        boxV2.add(Box.createHorizontalStrut(8));
        boxV2.add(button);
        baseBox = Box.createHorizontalBox();
        baseBox.add(boxV1);
        baseBox.add(Box.createHorizontalStrut(10));
        baseBox.add(boxV2);
        add(baseBox);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(f.exists()){
            try {
                FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oi = new ObjectInputStream(fi);
                goodslist = (LinkedList<Goods>)oi.readObject();
                fi.close();
                oi.close();
                Goods goods = new Goods();
                goods.setName(name.getText());
                goods.setMount(name.getText());
                goods.setPrice(name.getText());
                goodslist.add(goods);
                FileOutputStream fo = new FileOutputStream(f);
                ObjectOutputStream out = new ObjectOutputStream(fo);
                out.writeObject(goodslist);
                out.close();

            }catch (Exception ee){

            }
        }
        else{
            try {
                f.createNewFile();
                Goods goods = new Goods();
                goods.setName(name.getText());
                goods.setMount(name.getText());
                goods.setPrice(name.getText());
                goodslist.add(goods);
                FileOutputStream fo = new FileOutputStream(f);
                ObjectOutputStream out = new ObjectOutputStream(fo);
                out.writeObject(goodslist);
                out.close();
            }catch (Exception ee){

            }
        }
    }
}

class WindowGoods extends JFrame implements ActionListener{
    File file = null;
    JMenuBar bar;
    JMenu fileMenu;
    JMenuItem 录入, 显示;
    JTextArea show;
    InputArea inputMessage;
    JPanel pCenter;
    JTable table;
    Object tableOne[][], column[] = {"名称", "库存", "单价"};
    CardLayout card;
    WindowGoods(){
        file = new File("库存.txt");
        录入 = new JMenuItem("录入");
        显示 = new JMenuItem("显示");
        bar =  new JMenuBar();
        fileMenu = new JMenu("菜单选项");
        fileMenu.add(录入);
        fileMenu.add(显示);
        bar.add(fileMenu);
        setJMenuBar(bar);
        录入.addActionListener(this);
        显示.addActionListener(this);
        inputMessage = new InputArea(file);
        card = new CardLayout();
        pCenter = new JPanel();
        pCenter.setLayout(card);
        pCenter.add("录入", inputMessage);
        add(pCenter, BorderLayout.CENTER);
        setVisible(true);
        setBounds(100, 50, 420, 380);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==录入){
            card.show(pCenter, "录入");
        }
        else if (e.getSource()==显示){
            try {
                FileInputStream fi = new FileInputStream(file);
                ObjectInputStream oi = new ObjectInputStream(fi);
                LinkedList<Goods> goodsList = (LinkedList<Goods>) oi.readObject();
                fi.close();
                oi.close();
                int length = goodsList.size();
                tableOne = new Object[length][3];
                table = new JTable(tableOne, column);
                pCenter.removeAll();
                pCenter.add("录入", inputMessage);
                pCenter.add("显示", new JScrollPane(table));
                pCenter.validate();
                Iterator<Goods> iter =  goodsList.iterator();
                int i = 0;
                while (iter.hasNext()){
                    Goods goods = iter.next();
                    tableOne[i][0] = goods.getName();
                    tableOne[i][1] = goods.getMount();
                    tableOne[i][2] = goods.getPrice();
                    i++;
                }
                table.repaint();

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}

