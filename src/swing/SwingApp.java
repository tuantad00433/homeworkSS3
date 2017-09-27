/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import com.sun.javafx.css.StyleManager;
import console.entity.Student;
import console.model.StudentModel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ProgressBar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ADMIN-PC
 */
public class SwingApp extends JFrame {

    private JLabel lblId, lblName, lblEmail, lblPhone, lblClass, lblRollNum, lblDob, lblTotalMsg, lblNameMsg, lblMailMsg, lblNotice;
    private JButton button, submitBtn, button2;
    private JTextField txtId, txtPhone;
    private JSpinner txtDob;
    private JTextField txtName, txtEmail, txtClass, txtRollNum;
    private JPanel pane1, pane2, pane;
    JProgressBar pBar;
    JFrame fr;
    int barValue = 0;
    JDialog box;

    public SwingApp() {
        //chinh Frame
        fr = new JFrame();

        this.fr.setSize(900, 900);
        this.fr.setLocationRelativeTo(null);
        this.fr.setTitle("==================Đang Chờ Đồng Hồ Khởi Động...==================");
        pane1 = new JPanel(new GridBagLayout());
        pane2 = new JPanel(null);
        pane = new JPanel(new CardLayout());
        //khoi tao cac component
        lblId = new JLabel("ID:");
        lblName = new JLabel("Name:");
        lblEmail = new JLabel("Email:");
        lblPhone = new JLabel("Phone:");
        lblDob = new JLabel("Date of Birth:");
        lblClass = new JLabel("Class:");
        lblRollNum = new JLabel("RollNum:");
        button = new JButton("NHẬP DỮ LIỆU");
        button2 = new JButton("QUAY LẠI");
        submitBtn = new JButton("XEM DANH SÁCH");
        lblTotalMsg = new JLabel();
        lblMailMsg = new JLabel();
        lblNameMsg = new JLabel();
        lblNotice = new JLabel("TÍNH NĂNG ĐANG ĐƯỢC XÂY DỰNG-VUI LÒNG CHỌN QUAY LẠI");
        txtClass = new JTextField();
        txtRollNum = new JTextField();
        txtId = new JTextField();
        txtPhone = new JTextField();
        txtName = new JTextField();
        txtEmail = new JTextField();

        SpinnerDateModel spinModel = new SpinnerDateModel();
        txtDob = new JSpinner(spinModel);
        txtDob.setEditor(new JSpinner.DateEditor(txtDob, "dd/MM/yyyy"));
//Thêm vào pane2
        lblNotice.setFont(new Font(null, Font.ITALIC, 15));
        lblNotice.setBounds(100, 200, 500, 100);
        pane2.add(lblNotice);
        button2.setBounds(300, 300, 100, 50);
        pane2.add(button2);
        this.button2.addActionListener(new switchToPane1());

        //Them component vao pane1
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 150;
        c.ipady = 40;
        c.fill = GridBagConstraints.HORIZONTAL;
        lblId.setVerticalAlignment(SwingConstants.CENTER);
        lblId.setHorizontalAlignment(SwingConstants.LEFT);
        c.insets = new Insets(0, 20, 0, 0);
        lblId.setMaximumSize(new Dimension(50, 40));
        this.pane1.add(this.lblId, c);

        c.gridx = 1;
        c.gridy = 1;
//        c.fill = GridBagConstraints.HORIZONTAL;
        txtId.setMaximumSize(new Dimension(100, 20));
        this.pane1.add(this.txtId, c);
        
        c.gridx = 0;
        c.gridy = 2;
        lblName.setVerticalAlignment(SwingConstants.CENTER);
        lblName.setHorizontalAlignment(SwingConstants.LEFT);

        this.pane1.add(this.lblName, c);

        c.gridx = 1;
        c.gridy = 2;

        this.pane1.add(this.txtName, c);
        c.gridx = 2;
        c.gridy = 2;
//        c.insets = new Insets(0, 20, 0, 0);
lblNameMsg.setMaximumSize(new Dimension(80, 20));
        this.pane1.add(this.lblNameMsg, c);
//c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 3;
        lblEmail.setVerticalAlignment(SwingConstants.CENTER);
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        this.pane1.add(this.lblEmail, c);

        c.gridx = 1;
        c.gridy = 3;
        this.pane1.add(this.txtEmail, c);

        c.gridx = 2;
        c.gridy = 3;
lblMailMsg.setMaximumSize(new Dimension(80, 20));
        this.pane1.add(this.lblMailMsg, c);

        c.gridx = 0;
        c.gridy = 4;
        lblPhone.setVerticalAlignment(SwingConstants.CENTER);
        lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
        this.pane1.add(this.lblPhone, c);

        c.gridx = 1;
        c.gridy = 4;
        this.pane1.add(this.txtPhone, c);

        c.gridx = 0;
        c.gridy = 5;
        lblClass.setVerticalAlignment(SwingConstants.CENTER);
        lblClass.setHorizontalAlignment(SwingConstants.LEFT);
        this.pane1.add(this.lblClass, c);

        c.gridx = 1;
        c.gridy = 5;
        this.pane1.add(this.txtClass, c);

        c.gridx = 0;
        c.gridy = 6;
        lblRollNum.setVerticalAlignment(SwingConstants.CENTER);
        lblRollNum.setHorizontalAlignment(SwingConstants.LEFT);
        this.pane1.add(this.lblRollNum, c);

        c.gridx = 1;
        c.gridy = 6;
        this.pane1.add(this.txtRollNum, c);

        c.gridx = 0;
        c.gridy = 7;
        lblDob.setVerticalAlignment(SwingConstants.CENTER);
        lblDob.setHorizontalAlignment(SwingConstants.LEFT);
        this.pane1.add(this.lblDob, c);

        c.gridy = 7;
        c.gridx = 1;
        this.pane1.add(this.txtDob, c);
        this.button.addActionListener(new LoginHandle());
        this.button.addActionListener(new JLog());
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;

        this.pane1.add(this.button, c);
        this.submitBtn.addActionListener(new switchToPane2());
        c.gridx = 0;
        c.gridy = 9;
        c.gridwidth = 2;
        this.pane1.add(this.submitBtn, c);
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        lblTotalMsg.setVerticalAlignment(SwingConstants.CENTER);
        lblTotalMsg.setHorizontalAlignment(SwingConstants.CENTER);
        c.insets = new Insets(0, 0, 10, 0);
        this.pane1.add(this.lblTotalMsg, c);

        this.pane.add(pane1, "pane1");
        this.pane.add(pane2, "pane2");
        this.fr.add(pane);

        //Tạo và thêm đồng hồ
        Timer timer = new Timer(1000, new Clock());
        timer.start();

        //Xu ly khi tat
        this.fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ProgressBar
        pBar = new JProgressBar(JProgressBar.HORIZONTAL, 50, 100);
    }

    private void resetMsg() {
        lblNameMsg.setText("");
        lblMailMsg.setText("");
        lblTotalMsg.setText("");
    }

    private void showMsg(HashMap<String, String> errors) {
        lblTotalMsg.setForeground(Color.red);
        lblTotalMsg.setText("Vui lòng sửa các lỗi bên dưới: ");
        if (errors.containsKey("txtName")) {
            lblNameMsg.setForeground(Color.red);
            lblNameMsg.setText(errors.get("txtName"));

        } else {
            lblNameMsg.setForeground(Color.GREEN);
            lblNameMsg.setText("\u2713" + "Tên chính xác");
        }
        if (errors.containsKey("txtMail")) {
            lblMailMsg.setForeground(Color.red);
            lblMailMsg.setText(errors.get("txtMail"));
        } else {
            lblMailMsg.setForeground(Color.green);
            lblMailMsg.setText("\u2713" + "Email đúng định dạng");
        }
    }

    class LoginHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = txtName.getText();
            String mail = txtEmail.getText();

            HashMap<String, String> errors = new FormHandle().validateLogin(name, mail);
            if (errors.size() == 0) {
                resetMsg();
                Student student = new Student();
                StudentModel studentModel = new StudentModel();
                student.setName(name);
                student.setEmail(mail);
                try {
                    studentModel.insert(student);
                    JOptionPane.showMessageDialog(pane, "Thông tin đã được lưu vào database");
                } catch (Exception exc) {
                    System.out.println(exc);
                }
            } else {
                showMsg(errors);
            }

        }
    }

    class ResetHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            txtName.setText("");
            txtEmail.setText("");
        }

    }

    class JLog implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            box = new JDialog(fr);
            box.setLocationRelativeTo(null);
            box.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            box.setSize(400, 150);
            box.setLocation(450, 300);

            box.setLayout(new FlowLayout(FlowLayout.CENTER));
            box.add(pBar);
            box.setVisible(true);

            Timer t = new Timer(500, new startBar());
            t.start();

        }

    }

//Xu Ly Dong Ho: 
    class Clock implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            fr.setTitle("Thời gian: " + dateFormat.format(date));

        }

    }
//Xu ly ProgressBar

    class startBar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            barValue += 20;
            pBar.setValue(barValue);
            pBar.setStringPainted(true);
            if (barValue == 100) {
                barValue = 0;
                box.setVisible(false);

            }
        }

    }

    //Nut chuyen doi Pane trong CardLayout
    class switchToPane2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) pane.getLayout();
            cl.show(pane, "pane2");
        }

    }

    class switchToPane1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) pane.getLayout();
            cl.show(pane, "pane1");
        }

    }
}
