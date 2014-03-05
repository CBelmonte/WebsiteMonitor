package monitor;

import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @title Server Monitor
 * @author carmine
 * @version 00.01.02
 * @server http://10.0.0.50:8080/global/lm/ to http://10.0.0.57:8080/global/lm/
 *
 * Concurrency Help -
 * http://docs.oracle.com/javase/tutorial/uiswing/components/progress.html
 * 
 * SplashScreen Help -
 * http://wiki.netbeans.org/Splash_Screen_Beginner_Tutorial
 *
 * Description - This will check server response times and E-Mail log files when
 * unacceptable responses result. Also, there may be times to automatically
 * restart the server.
 *
 * @Added - Check Box functionality
 * @Added - Separated out into multiple thread functions
 */
public class Monitor01 extends javax.swing.JFrame {
//Global variables

    String[][][][][] IP = new String[8][8][8][8][8];
    String IP0 = "";
    String IP1 = "";
    String IP2 = "";
    String IP3 = "";
    String IP4 = "";
    String IP5 = "";
    String IP6 = "";
    String IP7 = "";
    String fileName = "MonitorLogC01.txt";
    ImageIcon iconReady = new ImageIcon("ready12.png");
    ImageIcon iconNeut = new ImageIcon("neutral12.png");
    ImageIcon iconError = new ImageIcon("error12.png");
    int loopTime = 10000;
    int slp = 10000;
    int x = 0;
    int code;
    boolean go = true;
    Object o;
    boolean running = false;
    boolean running0 = false;
    boolean running1 = false;
    boolean running2 = false;
    boolean running3 = false;
    boolean running4 = false;
    boolean running5 = false;
    boolean running6 = false;
    boolean running7 = false;
    boolean running8 = false;

    public Monitor01() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(100, 100, 100));

        jTable1.setFont(new java.awt.Font("MS Gothic", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Address", "Status", "Response Time", "Code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(36);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(3).setMinWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(120);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(100, 100, 100));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(220, 220, 240));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setText("--:--:--");
        jTextField1.setToolTipText("");
        jTextField1.setFocusable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(100, 100, 100));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(220, 220, 240));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.setText("--:--:--");
        jTextField2.setToolTipText("");
        jTextField2.setFocusable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(100, 100, 100));
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(220, 220, 240));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField3.setText("--:--:--");
        jTextField3.setToolTipText("");
        jTextField3.setFocusable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(100, 100, 100));
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(220, 220, 240));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField4.setText("--:--:--");
        jTextField4.setToolTipText("");
        jTextField4.setFocusable(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(100, 100, 100));
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(220, 220, 240));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField5.setText("--:--:--");
        jTextField5.setToolTipText("");
        jTextField5.setFocusable(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(100, 100, 100));
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(220, 220, 240));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField6.setText("--:--:--");
        jTextField6.setToolTipText("");
        jTextField6.setFocusable(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(100, 100, 100));
        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(220, 220, 240));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField7.setText("--:--:--");
        jTextField7.setToolTipText("");
        jTextField7.setFocusable(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(100, 100, 100));
        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(220, 220, 240));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField8.setText("--:--:--");
        jTextField8.setToolTipText("");
        jTextField8.setFocusable(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jCheckBox1.setToolTipText("This will set a looping timer to check the servers");
        jCheckBox1.setEnabled(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setToolTipText("This will set a looping timer to check the servers");
        jCheckBox2.setEnabled(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setToolTipText("This will set a looping timer to check the servers");
        jCheckBox3.setEnabled(false);
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setToolTipText("This will set a looping timer to check the servers");
        jCheckBox4.setEnabled(false);
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setToolTipText("This will set a looping timer to check the servers");
        jCheckBox5.setEnabled(false);
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jCheckBox6.setToolTipText("This will set a looping timer to check the servers");
        jCheckBox6.setEnabled(false);
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox7.setToolTipText("This will set a looping timer to check the servers");
        jCheckBox7.setEnabled(false);
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox8.setToolTipText("This will set a looping timer to check the servers");
        jCheckBox8.setEnabled(false);
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitor/neutral12.png"))); // NOI18N
        jLabel1.setToolTipText("");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitor/neutral12.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitor/neutral12.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitor/neutral12.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitor/neutral12.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitor/neutral12.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitor/neutral12.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/monitor/neutral12.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Arial Narrow", 0, 10)); // NOI18N
        jButton1.setText("Test All");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jToggleButton1.setText("Start All");
        jToggleButton1.setEnabled(false);
        jToggleButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButton1StateChanged(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1015, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setText("realistIQ 1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Reset IP's");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setText("Exit");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem3.setText("jMenuItem3");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("View");
        jMenu3.setToolTipText("");

        jMenuItem4.setText("History Guage");
        jMenuItem4.setToolTipText("");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //Set cursor to "wait"
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        // Load Configuration # 1 into array
        IP[0][0][0][0][0] = "http://10.0.0.50:8080/global/lm/";
        IP[1][0][0][0][0] = "http://10.0.0.51:8080/global/lm/";
        IP[2][0][0][0][0] = "http://wwe.google.com";
        IP[3][0][0][0][0] = "http://10.0.0.53:8080/global/lm/";
        IP[4][0][0][0][0] = "http://10.0.0.54:8080/global/lm/";
        IP[5][0][0][0][0] = "http://10.0.0.55:8080/global/lm/";
        IP[6][0][0][0][0] = "http://10.0.0.56:8080/global/lm/";
        IP[7][0][0][0][0] = "http://10.0.0.57:8080/global/lm/";

        //Set Variables
        IP0 = IP[0][0][0][0][0];
        IP1 = IP[1][0][0][0][0];
        IP2 = IP[2][0][0][0][0];
        IP3 = IP[3][0][0][0][0];
        IP4 = IP[4][0][0][0][0];
        IP5 = IP[5][0][0][0][0];
        IP6 = IP[6][0][0][0][0];
        IP7 = IP[7][0][0][0][0];

        // Load configuration # 1 into tables
        jTable1.setValueAt(IP[0][0][0][0][0], 0, 0);
        jTable1.setValueAt(IP[1][0][0][0][0], 1, 0);
        jTable1.setValueAt(IP[2][0][0][0][0], 2, 0);
        jTable1.setValueAt(IP[3][0][0][0][0], 3, 0);
        jTable1.setValueAt(IP[4][0][0][0][0], 4, 0);
        jTable1.setValueAt(IP[5][0][0][0][0], 5, 0);
        jTable1.setValueAt(IP[6][0][0][0][0], 6, 0);
        jTable1.setValueAt(IP[7][0][0][0][0], 7, 0);

        //Start indicator lights

        jLabel1.setIcon(iconNeut);
        jLabel2.setIcon(iconNeut);
        jLabel3.setIcon(iconNeut);
        jLabel4.setIcon(iconNeut);
        jLabel5.setIcon(iconNeut);
        jLabel6.setIcon(iconNeut);
        jLabel7.setIcon(iconNeut);
        jLabel8.setIcon(iconNeut);

        //Enable Select, Test and checkboxes
        jButton1.setEnabled(rootPaneCheckingEnabled);

        jToggleButton1.setEnabled(rootPaneCheckingEnabled);
        jCheckBox1.setEnabled(rootPaneCheckingEnabled);
        jCheckBox2.setEnabled(rootPaneCheckingEnabled);
        jCheckBox3.setEnabled(rootPaneCheckingEnabled);
        jCheckBox4.setEnabled(rootPaneCheckingEnabled);
        jCheckBox5.setEnabled(rootPaneCheckingEnabled);
        jCheckBox6.setEnabled(rootPaneCheckingEnabled);
        jCheckBox7.setEnabled(rootPaneCheckingEnabled);
        jCheckBox8.setEnabled(rootPaneCheckingEnabled);

        //Return cursor to normal
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        //logfile
        //fileName = "MonitorLogC01.txt";
        
        //update jTextArea from MonitorLogC01.txt
        UpdateTextArea();

    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Check IP for connectivity

        //load current values
        reloadValues();

        //run all on a new thread
        check01();




    }//GEN-LAST:event_jButton1ActionPerformed
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        reset01();

    }//GEN-LAST:event_jMenuItem2ActionPerformed
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected() == true) {
            Thread t1 = new Thread(new Processor1());
            t1.start();
            running1 = true;
            running = running1;
            o = jTextField1;

        } else {
            shutdown(1);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed
    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (jCheckBox2.isSelected() == true) {
            Thread t2 = new Thread(new Processor2());
            t2.start();
            running2 = true;
        } else {
            shutdown(2);
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if (jCheckBox3.isSelected() == true) {
            Thread t3 = new Thread(new Processor3());
            t3.start();
            running3 = true;
        } else {
            shutdown(3);
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed
    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed
    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        if (jCheckBox4.isSelected() == true) {
            Thread t4 = new Thread(new Processor4());
            t4.start();
            running4 = true;
        } else {
            shutdown(4);
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed
    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        if (jCheckBox5.isSelected() == true) {
            Thread t5 = new Thread(new Processor5());
            t5.start();
            running5 = true;
        } else {
            shutdown(5);
        }
    }//GEN-LAST:event_jCheckBox5ActionPerformed
    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed
    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        if (jCheckBox6.isSelected() == true) {
            Thread t6 = new Thread(new Processor6());
            t6.start();
            running6 = true;
        } else {
            shutdown(6);
        }
    }//GEN-LAST:event_jCheckBox6ActionPerformed
    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed
    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        if (jCheckBox7.isSelected() == true) {
            Thread t7 = new Thread(new Processor7());
            t7.start();
            running7 = true;
        } else {
            shutdown(7);
        }
    }//GEN-LAST:event_jCheckBox7ActionPerformed
    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed
    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        if (jCheckBox8.isSelected() == true) {
            Thread t8 = new Thread(new Processor8());
            t8.start();
            running8 = true;
        } else {
            shutdown(8);
        }
    }//GEN-LAST:event_jCheckBox8ActionPerformed
    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed
    private void jToggleButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButton1StateChanged
    }//GEN-LAST:event_jToggleButton1StateChanged
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
            System.out.println("Start All");
            jToggleButton1.setText("Stop All");
            jCheckBox1.setSelected(true);
            Thread t1 = new Thread(new Processor1());
            t1.start();
            running1 = true;
            jCheckBox2.setSelected(true);
            Thread t2 = new Thread(new Processor2());
            t2.start();running1 = true;
            jCheckBox3.setSelected(true);
            Thread t3 = new Thread(new Processor3());
            t3.start();running2 = true;
            jCheckBox4.setSelected(true);
            Thread t4 = new Thread(new Processor4());
            t4.start();running3 = true;
            jCheckBox5.setSelected(true);
            Thread t5 = new Thread(new Processor5());
            t5.start();running4 = true;
            jCheckBox6.setSelected(true);
            Thread t6 = new Thread(new Processor6());
            t6.start();running5 = true;
            jCheckBox7.setSelected(true);
            Thread t7 = new Thread(new Processor7());
            t7.start();running6 = true;
            jCheckBox8.setSelected(true);
            Thread t8 = new Thread(new Processor8());
            t8.start();running7 = true;

        } else {
            System.out.println("unselected");
            jToggleButton1.setText("Select All");
            jCheckBox1.setSelected(false);
            shutdown(1);
            jCheckBox2.setSelected(false);
            shutdown(2);
            jCheckBox3.setSelected(false);
            shutdown(3);
            jCheckBox4.setSelected(false);
            shutdown(4);
            jCheckBox5.setSelected(false);
            shutdown(5);
            jCheckBox6.setSelected(false);
            shutdown(6);
            jCheckBox7.setSelected(false);
            shutdown(7);
            jCheckBox8.setSelected(false);
            shutdown(8);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed
    private void jTable1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusLost
        reloadValues();
    }//GEN-LAST:event_jTable1FocusLost
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        exit();
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    /**
     * * Methods / functions **
     */
    public void reloadValues() {
        // Test currently loaded values

        for (x = 0; x < 10; x++) {
            System.out.println(x);
        }

        //make sure the values match the table
        for (x = 0; x < 8; x++) {
            if (jTable1.getValueAt(x, 0) != null) {
                if (jTable1.getValueAt(x, 0) != IP[x][0][0][0][0]) {
                    IP[x][0][0][0][0] = jTable1.getValueAt(x, 0).toString();
                    IP0 = IP[x][0][0][0][0].toString();
                    System.out.println(IP0 + " has been updated");

                } else {
                    System.out.println(jTable1.getValueAt(x, 0) + " is unchanged");
                }
            } else {
                System.out.println(x + " is currently empty");
            }
        }
        if (IP[0][0][0][0][0] != null) {
            jCheckBox1.setEnabled(true);
        }
        if (IP[1][0][0][0][0] != null) {
            jLabel2.setIcon(iconNeut);
        }
        if (IP[2][0][0][0][0] != null) {
            jLabel3.setIcon(iconNeut);
        }
        if (IP[3][0][0][0][0] != null) {
            jLabel4.setIcon(iconNeut);
        }
        if (IP[4][0][0][0][0] != null) {
            jLabel5.setIcon(iconNeut);
        }
        if (IP[5][0][0][0][0] != null) {
            jLabel6.setIcon(iconNeut);
        }
        if (IP[6][0][0][0][0] != null) {
            jLabel7.setIcon(iconNeut);
        }
        if (IP[7][0][0][0][0] != null) {
            jLabel8.setIcon(iconNeut);
        }


    }

    //Timer Function
    class TimerThread extends Thread {

        public void run(int serv) {
            System.out.println("entering run function");
            //Timer
            long seconds = TimeUnit.MILLISECONDS.toSeconds(loopTime);
            System.out.println("System time = " + seconds);
            if (seconds > 0) {
                jTextField1.setText(String.valueOf(seconds));
            } else {
                jTextField1.setText("--:--:--");
            }
            for (long u = seconds; u < 0; u--) {
                if (jTextField1.getText() == "--:--:--") {
                    u = seconds;
                    //Stop Timer
                    if (jCheckBox1.isSelected() == false) {
                        jTextField1.setText("--:--:--");
                        System.out.println("ending thread");
                        Thread.currentThread().interrupt();
                        return;
                    }
                } else {
                    check02(serv);//check connectivity
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                jTextField1.setText(String.valueOf(u));
            }
        }
    }

    //Function to check all servers
    public void check01() {

        //Debug
        System.out.println("I have entered the check function");
        //check for connectivity
        for (x = 0; x <= 7; x++) {
            if (IP[x][0][0][0][0].toString() == null) {
            } else {
                try {
                    URL t = new URL(IP[x][0][0][0][0].toString());
                    HttpURLConnection conn = (HttpURLConnection) t.openConnection();
                    conn.setRequestMethod("GET");  //conn.setRequestMethod ("HEAD") or ("GET"); 
                    conn.connect();
                    code = conn.getResponseCode();
                    jTable1.setValueAt(code, x, 3);
                    jTable1.setValueAt("Successful", x, 1);
                    jTable1.setValueAt("Functioning", x, 2);
                    System.out.println("Success - x = " + x);

                    //here comes an unbelievably unecessary and messy if structure due to not finding the way to have a loop decide which icon to update using a variable - ugh!
                    if (x == 0) {
                        jLabel1.setIcon(iconReady);
                    } else if (x == 1) {
                        jLabel2.setIcon(iconReady);
                    } else if (x == 2) {
                        jLabel3.setIcon(iconReady);
                    } else if (x == 3) {
                        jLabel4.setIcon(iconReady);
                    } else if (x == 4) {
                        jLabel5.setIcon(iconReady);
                    } else if (x == 5) {
                        jLabel6.setIcon(iconReady);
                    } else if (x == 6) {
                        jLabel7.setIcon(iconReady);
                    } else if (x == 7) {
                        jLabel8.setIcon(iconReady);
                    } else {
                    }


                } catch (Exception e) {
                    //here comes an unbelievably unecessary and messy if structure due to not finding the way to have a loop decide which icon to update using a variable - ugh!
                    if (x == 0) {
                        jLabel1.setIcon(iconError);
                    } else if (x == 1) {
                        jLabel2.setIcon(iconError);
                    } else if (x == 2) {
                        jLabel3.setIcon(iconError);
                    } else if (x == 3) {
                        jLabel4.setIcon(iconError);
                    } else if (x == 4) {
                        jLabel5.setIcon(iconError);
                    } else if (x == 5) {
                        jLabel6.setIcon(iconError);
                    } else if (x == 6) {
                        jLabel7.setIcon(iconError);
                    } else if (x == 7) {
                        jLabel8.setIcon(iconError);
                    } else {
                    }
                    System.out.println("Failure - x = " + x);
                    jTable1.setValueAt("Failure", x, 1);
                    jTable1.setValueAt("AHHHHHHH", x, 2);
                    jTable1.setValueAt("Error", x, 3);

                    //insert failure Email code here
                    email01(IP[x][0][0][0][0].toString(), x);
                    //insert failure log code here
                    log01(IP[x][0][0][0][0].toString(), x, code);
                }
            }
        }

        //ToDo - Run in an individual thread 


    }

    //Function to check individual servers
    public void check02(int serv) {

        //Debug
        System.out.println("I have entered the check function");
        //check for connectivity

        if (IP[serv][0][0][0][0].toString() == null) {
        } else {
            try {
                URL t = new URL(IP[serv][0][0][0][0].toString());
                HttpURLConnection conn = (HttpURLConnection) t.openConnection();
                conn.setRequestMethod("GET");  //conn.setRequestMethod ("HEAD") or ("GET"); 
                conn.connect();
                code = conn.getResponseCode();
                jTable1.setValueAt(code, serv, 3);
                jTable1.setValueAt("Successful", serv, 1);
                jTable1.setValueAt("Functioning", serv, 2);
                System.out.println("Success - x = " + serv);

                //here comes an unbelievably unecessary and messy if structure due to not finding the way to have a loop decide which icon to update using a variable - ugh!
                if (serv == 0) {
                    jLabel1.setIcon(iconReady);
                } else if (serv == 1) {
                    jLabel2.setIcon(iconReady);
                } else if (serv == 2) {
                    jLabel3.setIcon(iconReady);
                } else if (serv == 3) {
                    jLabel4.setIcon(iconReady);
                } else if (serv == 4) {
                    jLabel5.setIcon(iconReady);
                } else if (serv == 5) {
                    jLabel6.setIcon(iconReady);
                } else if (serv == 6) {
                    jLabel7.setIcon(iconReady);
                } else if (serv == 7) {
                    jLabel8.setIcon(iconReady);
                } else {
                }

            } catch (Exception e) {
                //here comes an unbelievably unecessary and messy if structure due to not finding the way to have a loop decide which icon to update using a variable - ugh!
                if (serv == 0) {
                    jLabel1.setIcon(iconError);
                } else if (serv == 1) {
                    jLabel2.setIcon(iconError);
                } else if (serv == 2) {
                    jLabel3.setIcon(iconError);
                } else if (serv == 3) {
                    jLabel4.setIcon(iconError);
                } else if (serv == 4) {
                    jLabel5.setIcon(iconError);
                } else if (serv == 5) {
                    jLabel6.setIcon(iconError);
                } else if (serv == 6) {
                    jLabel7.setIcon(iconError);
                } else if (serv == 7) {
                    jLabel8.setIcon(iconError);
                } else {
                }
                System.out.println("Failure - serv = " + serv);
                jTable1.setValueAt("Failure", serv, 1);
                jTable1.setValueAt("AHHHHHHH", serv, 2);
                jTable1.setValueAt("Error", serv, 3);

                //insert failure Email code here
                email01(IP[serv][0][0][0][0].toString(), serv);
                //insert failure log code here
                log01(IP[serv][0][0][0][0].toString(), serv, code);
            }
        }
        //ToDo - Run in an individual thread 
    }

    //Threading Group
    class Processor1 extends Thread {
        
    @Override
        public void run() {
            int u = 0;
            int u1 = u + 1;
            int x = 0;
            while (running1) {
                x = x + 1;
                jTextField1.setText(Integer.toString(x));
                System.out.println(x);
                try {
                    Thread.sleep(slp);

                    //Debug
                    System.out.println("I have entered the check function");
                    //check for connectivity  
                    try {
                        URL t = new URL(IP[u][0][0][0][0].toString());
                        HttpURLConnection conn = (HttpURLConnection) t.openConnection();
                        conn.setRequestMethod("GET");  //conn.setRequestMethod ("HEAD") or ("GET"); 
                        System.out.println(t);
                        conn.connect();
                        code = conn.getResponseCode();
                        jTable1.setValueAt(code, u, 3);
                        jTable1.setValueAt("Successful", u, 1);
                        jTable1.setValueAt("Functioning", u, 2);
                        System.out.println("Success - x = " + 0);
                        jLabel1.setIcon(iconReady);
                    } catch (Exception e) {
                        jLabel1.setIcon(iconError);
                        System.out.println("Failure - x = " + 0);
                        jTable1.setValueAt("Failure", u, 1);
                        jTable1.setValueAt("AHHHHHHH", u, 2);
                        jTable1.setValueAt("Error", u, 3);
                        //insert failure Email code here
                        email01(IP[u][0][0][0][0].toString(), 0);
                        //insert failure log code here
                        log01(IP[u][0][0][0][0].toString(), 0, code);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    class Processor2 extends Thread {
@Override
        public void run() {
            int u = 1;
            int u1 = u + 1;
            int x = 0;
            while (running2) {
                x = x + 1;
                jTextField2.setText(Integer.toString(x));
                System.out.println(x);
                try {
                    Thread.sleep(slp);

                    //Debug
                    System.out.println("I have entered the check function");
                    //check for connectivity  
                    try {
                        URL t = new URL(IP[u][0][0][0][0].toString());
                        HttpURLConnection conn = (HttpURLConnection) t.openConnection();
                        conn.setRequestMethod("GET");  //conn.setRequestMethod ("HEAD") or ("GET"); 
                        System.out.println(t);
                        conn.connect();
                        code = conn.getResponseCode();
                        jTable1.setValueAt(code, u, 3);
                        jTable1.setValueAt("Successful", u, 1);
                        jTable1.setValueAt("Functioning", u, 2);
                        System.out.println("Success - x = " + 0);
                        jLabel2.setIcon(iconReady);
                    } catch (Exception e) {
                        jLabel2.setIcon(iconError);
                        System.out.println("Failure - x = " + 0);
                        jTable1.setValueAt("Failure", u, 1);
                        jTable1.setValueAt("AHHHHHHH", u, 2);
                        jTable1.setValueAt("Error", u, 3);
                        //insert failure Email code here
                        email01(IP[u][0][0][0][0].toString(), 0);
                        //insert failure log code here
                        log01(IP[u][0][0][0][0].toString(), 0, code);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    class Processor3 extends Thread {
@Override
public void run() {
            int u = 2;
            int u1 = u + 1;
            int x = 0;
            while (running3) {
                x = x + 1;
                jTextField3.setText(Integer.toString(x));
                System.out.println(x);
                try {
                    Thread.sleep(slp);

                    //Debug
                    System.out.println("I have entered the check function");
                    //check for connectivity  
                    try {
                        URL t = new URL(IP[u][0][0][0][0].toString());
                        HttpURLConnection conn = (HttpURLConnection) t.openConnection();
                        conn.setRequestMethod("GET");  //conn.setRequestMethod ("HEAD") or ("GET"); 
                        System.out.println(t);
                        conn.connect();
                        code = conn.getResponseCode();
                        jTable1.setValueAt(code, u, 3);
                        jTable1.setValueAt("Successful", u, 1);
                        jTable1.setValueAt("Functioning", u, 2);
                        System.out.println("Success - x = " + 0);
                        jLabel3.setIcon(iconReady);
                    } catch (Exception e) {
                        jLabel3.setIcon(iconError);
                        System.out.println("Failure - x = " + 0);
                        jTable1.setValueAt("Failure", u, 1);
                        jTable1.setValueAt("AHHHHHHH", u, 2);
                        jTable1.setValueAt("Error", u, 3);
                        //insert failure Email code here
                        email01(IP[u][0][0][0][0].toString(), 0);
                        //insert failure log code here
                        log01(IP[u][0][0][0][0].toString(), 0, code);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    class Processor4 extends Thread {
@Override
        public void run() {
            int u = 3;
            int u1 = u + 1;
            int x = 0;
            while (running4) {
                x = x + 1;
                jTextField4.setText(Integer.toString(x));
                System.out.println(x);
                try {
                    Thread.sleep(slp);

                    //Debug
                    System.out.println("I have entered the check function");
                    //check for connectivity  
                    try {
                        URL t = new URL(IP[u][0][0][0][0].toString());
                        HttpURLConnection conn = (HttpURLConnection) t.openConnection();
                        conn.setRequestMethod("GET");  //conn.setRequestMethod ("HEAD") or ("GET"); 
                        System.out.println(t);
                        conn.connect();
                        code = conn.getResponseCode();
                        jTable1.setValueAt(code, u, 3);
                        jTable1.setValueAt("Successful", u, 1);
                        jTable1.setValueAt("Functioning", u, 2);
                        System.out.println("Success - x = " + 0);
                        jLabel4.setIcon(iconReady);
                    } catch (Exception e) {
                        jLabel4.setIcon(iconError);
                        System.out.println("Failure - x = " + 0);
                        jTable1.setValueAt("Failure", u, 1);
                        jTable1.setValueAt("AHHHHHHH", u, 2);
                        jTable1.setValueAt("Error", u, 3);
                        //insert failure Email code here
                        email01(IP[u][0][0][0][0].toString(), 0);
                        //insert failure log code here
                        log01(IP[u][0][0][0][0].toString(), 0, code);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    class Processor5 extends Thread {
@Override
        public void run() {
            int u = 4;
            int u1 = u + 1;
            int x = 0;
            while (running5) {
                x = x + 1;
                jTextField5.setText(Integer.toString(x));
                System.out.println(x);
                try {
                    Thread.sleep(slp);

                    //Debug
                    System.out.println("I have entered the check function");
                    //check for connectivity  
                    try {
                        URL t = new URL(IP[u][0][0][0][0].toString());
                        HttpURLConnection conn = (HttpURLConnection) t.openConnection();
                        conn.setRequestMethod("GET");  //conn.setRequestMethod ("HEAD") or ("GET"); 
                        System.out.println(t);
                        conn.connect();
                        code = conn.getResponseCode();
                        jTable1.setValueAt(code, u, 3);
                        jTable1.setValueAt("Successful", u, 1);
                        jTable1.setValueAt("Functioning", u, 2);
                        System.out.println("Success - x = " + 0);
                        jLabel5.setIcon(iconReady);
                    } catch (Exception e) {
                        jLabel5.setIcon(iconError);
                        System.out.println("Failure - x = " + 0);
                        jTable1.setValueAt("Failure", u, 1);
                        jTable1.setValueAt("AHHHHHHH", u, 2);
                        jTable1.setValueAt("Error", u, 3);
                        //insert failure Email code here
                        email01(IP[u][0][0][0][0].toString(), 0);
                        //insert failure log code here
                        log01(IP[u][0][0][0][0].toString(), 0, code);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    class Processor6 extends Thread {
@Override
        public void run() {
            int u = 5;
            int u1 = u + 1;
            int x = 0;
            while (running6) {
                x = x + 1;
                jTextField6.setText(Integer.toString(x));
                System.out.println(x);
                try {
                    Thread.sleep(slp);

                    //Debug
                    System.out.println("I have entered the check function");
                    //check for connectivity  
                    try {
                        URL t = new URL(IP[u][0][0][0][0].toString());
                        HttpURLConnection conn = (HttpURLConnection) t.openConnection();
                        conn.setRequestMethod("GET");  //conn.setRequestMethod ("HEAD") or ("GET"); 
                        System.out.println(t);
                        conn.connect();
                        code = conn.getResponseCode();
                        jTable1.setValueAt(code, u, 3);
                        jTable1.setValueAt("Successful", u, 1);
                        jTable1.setValueAt("Functioning", u, 2);
                        System.out.println("Success - x = " + 0);
                        jLabel6.setIcon(iconReady);
                    } catch (Exception e) {
                        jLabel6.setIcon(iconError);
                        System.out.println("Failure - x = " + 0);
                        jTable1.setValueAt("Failure", u, 1);
                        jTable1.setValueAt("AHHHHHHH", u, 2);
                        jTable1.setValueAt("Error", u, 3);
                        //insert failure Email code here
                        email01(IP[u][0][0][0][0].toString(), 0);
                        //insert failure log code here
                        log01(IP[u][0][0][0][0].toString(), 0, code);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    class Processor7 extends Thread {
@Override
        public void run() {
            int u = 6;
            int u1 = u + 1;
            int x = 0;
            while (running7) {
                x = x + 1;
                jTextField7.setText(Integer.toString(x));
                System.out.println(x);
                try {
                    Thread.sleep(slp);

                    //Debug
                    System.out.println("I have entered the check function");
                    //check for connectivity  
                    try {
                        URL t = new URL(IP[u][0][0][0][0].toString());
                        HttpURLConnection conn = (HttpURLConnection) t.openConnection();
                        conn.setRequestMethod("GET");  //conn.setRequestMethod ("HEAD") or ("GET"); 
                        System.out.println(t);
                        conn.connect();
                        code = conn.getResponseCode();
                        jTable1.setValueAt(code, u, 3);
                        jTable1.setValueAt("Successful", u, 1);
                        jTable1.setValueAt("Functioning", u, 2);
                        System.out.println("Success - x = " + 0);
                        jLabel7.setIcon(iconReady);
                    } catch (Exception e) {
                        jLabel7.setIcon(iconError);
                        System.out.println("Failure - x = " + 0);
                        jTable1.setValueAt("Failure", u, 1);
                        jTable1.setValueAt("AHHHHHHH", u, 2);
                        jTable1.setValueAt("Error", u, 3);
                        //insert failure Email code here
                        email01(IP[u][0][0][0][0].toString(), 0);
                        //insert failure log code here
                        log01(IP[u][0][0][0][0].toString(), 0, code);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    class Processor8 extends Thread {
@Override
        public void run() {
            int u = 7;
            int u1 = u + 1;
            int x = 0;
            while (running8) {
                x = x + 1;
                jTextField8.setText(Integer.toString(x));
                System.out.println(x);
                try {
                    Thread.sleep(slp);

                    //Debug
                    System.out.println("I have entered the check function");
                    //check for connectivity  
                    try {
                        URL t = new URL(IP[u][0][0][0][0].toString());
                        HttpURLConnection conn = (HttpURLConnection) t.openConnection();
                        conn.setRequestMethod("GET");  //conn.setRequestMethod ("HEAD") or ("GET"); 
                        System.out.println(t);
                        conn.connect();
                        code = conn.getResponseCode();
                        jTable1.setValueAt(code, u, 3);
                        jTable1.setValueAt("Successful", u, 1);
                        jTable1.setValueAt("Functioning", u, 2);
                        System.out.println("Success - x = " + 0);
                        jLabel8.setIcon(iconReady);
                    } catch (Exception e) {
                        jLabel8.setIcon(iconError);
                        System.out.println("Failure - x = " + 0);
                        jTable1.setValueAt("Failure", u, 1);
                        jTable1.setValueAt("AHHHHHHH", u, 2);
                        jTable1.setValueAt("Error", u, 3);
                        //insert failure Email code here
                        email01(IP[u][0][0][0][0].toString(), 0);
                        //insert failure log code here
                        log01(IP[u][0][0][0][0].toString(), 0, code);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    //shutdown procedures for threads
    public void shutdown(int num) {
        if (num == 1) {
            running1 = false;
            jTextField1.setText("--:--:--");
            jCheckBox1.setSelected(false);
        } else if (num == 2) {
            running2 = false;
            jTextField2.setText("--:--:--");
            jCheckBox2.setSelected(false);
        } else if (num == 3) {
            running3 = false;
            jTextField3.setText("--:--:--");
            jCheckBox3.setSelected(false);
        } else if (num == 4) {
            running4 = false;
            jTextField4.setText("--:--:--");
            jCheckBox4.setSelected(false);
        } else if (num == 5) {
            running5 = false;
            jTextField5.setText("--:--:--");
            jCheckBox5.setSelected(false);
        } else if (num == 6) {
            running6 = false;
            jTextField6.setText("--:--:--");
            jCheckBox6.setSelected(false);
        } else if (num == 7) {
            running7 = false;
            jTextField7.setText("--:--:--");
            jCheckBox7.setSelected(false);
        } else if (num == 8) {
            running8 = false;
            jTextField8.setText("--:--:--");
            jCheckBox8.setSelected(false);
        }
    }

    //write to log file
    public void log01(String server, int row, int code) {
        System.out.println("I have entered the Log function");
        Date date = new Date();
        System.out.println(date.toString());//test to console
        System.out.println(server + " - " + row + " - " + code + "\r\n");
        // The name of the file to open.
        

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                    new FileWriter(fileName, true);
            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // Note that write() does not automatically
            // append a newline character.
            Date t = new Date();
            String message01="The server - " + server + " - did not respond at - " + t;
            bufferedWriter.append(message01);
            bufferedWriter.append("\r\n------------------------\r\n");
            System.out.println(bufferedWriter);
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                    + fileName + "'");
        }
        UpdateTextArea();
    }

    //Email on error
    public void email01(String server, int row) {
        System.out.println("I have entered the E-Mail function");
        {
            //debugging to print info to command line
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
            StackTraceElement tracer = stacktrace[1];
            String methodName = tracer.getMethodName();
            System.out.println("Entering the " + methodName + " method");

            final String username = "CarmineBelmontetest@gmail.com";
            final String password = "!Whiskey1";
            String SendTo = "carminebelmonte4@gmail.com";
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            try {
                Date t = new Date();
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(SendTo));
                message.setSubject("Server Error");
                String msg = "Administrator,"
                        + "\n This has been sent to you to inform you of a pending server disaster! "
                        + "\n The time of occurance was " + t
                        + "\n The Server was " + server + "and the thread was " + Thread.currentThread()
                        + "\n The database row was " + row + "\n";
                message.setText(msg);
                Transport.send(message);
                System.out.println("Done");
                JOptionPane.showMessageDialog(null, "An Error has occured!  \n  An E-Mail has been sent to the programmers \n regarding this error!", "E-Mail Sent", JOptionPane.PLAIN_MESSAGE);

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Delete all values from memory
    public void reset01() {
        //Reset table values
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            for (int j = 0; j < jTable1.getColumnCount(); j++) {
                jTable1.setValueAt("", i, j);
            }
        }
        //reset IP values
        IP0 = "";
        IP1 = "";
        IP2 = "";
        IP3 = "";
        IP4 = "";
        IP5 = "";
        IP6 = "";
        IP7 = "";

        //reset icons        
        jLabel1.setIcon(null);
        jLabel2.setIcon(null);
        jLabel3.setIcon(null);
        jLabel4.setIcon(null);
        jLabel5.setIcon(null);
        jLabel6.setIcon(null);
        jLabel7.setIcon(null);
        jLabel8.setIcon(null);


        //now that there are no loaded values, Select, Test and checkboxes are disabled
        jButton1.setEnabled(false);

        jToggleButton1.setEnabled(false);
        jCheckBox1.setEnabled(false);
        jCheckBox2.setEnabled(false);
        jCheckBox3.setEnabled(false);
        jCheckBox4.setEnabled(false);
        jCheckBox5.setEnabled(false);
        jCheckBox6.setEnabled(false);
        jCheckBox7.setEnabled(false);
        jCheckBox8.setEnabled(false);

    }

    //read log file to TextArea
    public void UpdateTextArea() {
        // clear current text in textarea
        jTextArea1.setText("");

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                jTextArea1.append(line + "\r\n");
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

    //Quit Program
    public void exit() {
        System.exit(0);
    }

    // 5 second sleep
   private static void sleepThread() {
        try
            {
                Thread.sleep(5000);
            }
            catch (InterruptedException ex)
            {
                // Do something, if there is an exception
                System.out.println(ex.toString());
            }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Monitor01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Monitor01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Monitor01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Monitor01.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*Show splashScreen Longer*/
        sleepThread();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Monitor01().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
