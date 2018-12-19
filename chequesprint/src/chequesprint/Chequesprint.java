/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chequesprint;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;
import static java.lang.Integer.parseInt;
import java.net.InetAddress;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.Calendar;
import java.util.logging.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import org.apache.derby.drda.NetworkServerControl;
import datepicker.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel; 
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import say.swing.JFontChooser;

 



/**
 *
 * @author seebdcell
 */
public class Chequesprint extends javax.swing.JFrame implements Printable{
    //private Object mmmDate;
    String username;
    String usertype;
    
    String tableName="bankloc";
    
    final UIManager.LookAndFeelInfo[] plafInfos = UIManager.getInstalledLookAndFeels();
    String[] plafNames = new String[plafInfos.length]; 
    
    //jPanel6.setBorder( new TitledBorder("FlowLayout(FlowLayout.RIGHT, 3,3)") );
    final private JDatePickerImpl datePicker;
     
    final JFontChooser fontChooser = new JFontChooser();
    final JFrame window = new JFrame("Font");

    
    @Override
    public int print (Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {
                    if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
                
                //PrinterJob pj = PrinterJob.getPrinterJob();
               // PageFormat pf1 = pj.pageDialog(pj.defaultPage());
                
                PageFormat pf1 = new PageFormat();
                //Graphics g3= this.getGraphics();
                Graphics2D g2d = (Graphics2D)g;

               // pf1.setOrientation(PageFormat.PORTRAIT);
                //g2d.translate(600, 50);
                g2d.translate(pf1.getImageableX(), pf1.getImageableY());
                //g2d.translate(pf1.getImageableWidth(), pf1.getImageableHeight());
                
                               
                this.jPanel1.printComponents(g);
                
                return PAGE_EXISTS;

            }


    /**
     * Creates new form JFrame3
     */
    public Chequesprint() {        
        
        initComponents();      
      
     this.setIconImage(new ImageIcon(getClass().getResource("/chequesprint/formimg.jpeg")).getImage());
       //JComboBoxAutoCompletador jcb = new JComboBoxAutoCompletador(jComboBox1);
     // AutoCompleteJComboBoxer jcb2 = new AutoCompleteJComboBoxer(jComboBox1);  
     ((AbstractDocument)deg.getDocument()).setDocumentFilter( new MyDocumentFilter()/*{
         Pattern regEx = Pattern.compile("//d+");
        
         public void replace(DocumentFilter.FilterBypass fp, int offset , int length, String text, AttributeSet aset) throws BadLocationException {
             Matcher matcher= regEx.matcher(text);
             if(!matcher.matches()){return;}
             super.replace(fp, offset, length, text, aset);
         }
        }*/); 
     
     //new javax.swing.JDialog();
        dateDialog.setLayout(new FlowLayout());
	dateDialog.setResizable(false);
	dateDialog.add(new JLabel("Select the Date: "));
		
        UtilDateModel model = new UtilDateModel();
	model.setDate(2016, 04, 05);
	model.setSelected(true);
	Properties i18nStrings = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model,i18nStrings);
         datePicker = new JDatePickerImpl(datePanel, new datepicker.DateLabelFormatter());
	//java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
        

	dateDialog.add(datePicker);
        
	dateDialog.setSize(250, 200);
	dateDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	dateDialog.setLocationRelativeTo(null);
        
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(sas, 1.0f);
        //jTextPane1.setParagraphAttributes(sas, true); 
        
       
     
    }
    
    public Chequesprint(String user, String usertype) {
        
         username= user;
        initComponents();
       if("user".equals(usertype)){
          // this.jButton3.setVisible(false);
           //this.jButton4.setVisible(false);
           this.jButton3.setEnabled(false);
           this.jButton4.setEnabled(false);
           this.jButton5.setEnabled(false);
          // this.remove(jButton3);
          // this.remove(jButton4);
       }
      
     this.setIconImage(new ImageIcon(getClass().getResource("/chequesprint/formimg.jpeg")).getImage());
       //JComboBoxAutoCompletador jcb = new JComboBoxAutoCompletador(jComboBox1);
     // AutoCompleteJComboBoxer jcb2 = new AutoCompleteJComboBoxer(jComboBox1);    
     
     ////////////// this code to ceate jTextField which accept only digits  /////////////////////
     ((AbstractDocument)deg.getDocument()).setDocumentFilter( new MyDocumentFilter()/*{
         Pattern regEx = Pattern.compile("//d+");       
        
        }*/);
     
     //want to format the displayed number in the digit 
    /* try{
        MaskFormatter formatter = new MaskFormatter("#,###");
        JLabel jLabel14 =new JLabel(formatter);
         }catch (Exception e){e.printStackTrace();}*/
     
    
     
                
        dateDialog.setLayout(new FlowLayout());
	dateDialog.setResizable(false);
	dateDialog.add(new JLabel("Select the Date: "));
		
        UtilDateModel model = new UtilDateModel();
	model.setDate(2016, 04, 05);
	model.setSelected(true);
	Properties i18nStrings = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model,i18nStrings);
         datePicker = new JDatePickerImpl(datePanel, new datepicker.DateLabelFormatter());
	//java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
        

	dateDialog.add(datePicker);        
	dateDialog.setSize(300, 200);
	dateDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	dateDialog.setLocationRelativeTo(null);
        
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(sas, 1.0f);
        //jTextPane1.setParagraphAttributes(sas, true);
     
    }
    
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dateDialog = new javax.swing.JDialog();
        jButton7 = new javax.swing.JButton();
        themesDialog = new javax.swing.JDialog();
        pack = new javax.swing.JCheckBox();
        plafChooser = new javax.swing.JComboBox();
        helpDialog = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new DrawingCanvas();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        deg = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBox1 =  new FilterComboBox(Fillcombotest());
        jComboBox2 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        jSpinner5 = new javax.swing.JSpinner();
        jSpinner6 = new javax.swing.JSpinner();
        jSpinner7 = new javax.swing.JSpinner();
        jSpinner8 = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jSpinner9 = new javax.swing.JSpinner();
        jSpinner10 = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        userlbl = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        dateDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dateDialog.setTitle("Calendar");
        dateDialog.setAlwaysOnTop(true);

        jButton7.setText("OK");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dateDialogLayout = new javax.swing.GroupLayout(dateDialog.getContentPane());
        dateDialog.getContentPane().setLayout(dateDialogLayout);
        dateDialogLayout.setHorizontalGroup(
            dateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateDialogLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jButton7)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        dateDialogLayout.setVerticalGroup(
            dateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dateDialogLayout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(19, 19, 19))
        );

        themesDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        themesDialog.setTitle("Themes");
        themesDialog.setAlwaysOnTop(true);
        themesDialog.getContentPane().setLayout(new java.awt.FlowLayout());

        pack.setText("Pack on PLAF change");
        pack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packActionPerformed(evt);
            }
        });
        themesDialog.getContentPane().add(pack);

        plafChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 - Metal", "2 - Nimbus", "3 - CDE/Motif", "4 - Windows", "5 - Windows Classic", " " }));
        plafChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plafChooserActionPerformed(evt);
            }
        });
        themesDialog.getContentPane().add(plafChooser);

        themesDialog.getAccessibleContext().setAccessibleParent(null);

        helpDialog.setTitle("About ");
        helpDialog.setAlwaysOnTop(true);
        helpDialog.getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel9.setPreferredSize(new java.awt.Dimension(300, 250));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(0, 102, 255));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Cheques Print Program \nVersion 2.1\n\n\n\nContact Developer:\n\nMobile: +968-95392260 E-Mail:m5a2003@yahoo.com");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTextArea1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                    .addContainerGap(24, Short.MAX_VALUE)
                    .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        helpDialog.getContentPane().add(jPanel9);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cheques Printing System");
        setName("Cheques Print Software"); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(410, 200));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel3.setText("OMAN TRADING ESTABLISHMENT LLC");
        jLabel3.setMaximumSize(new java.awt.Dimension(240, 25));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 90, 270, 22);
        jPanel1.add(jLabel15);
        jLabel15.setBounds(0, 30, 110, 110);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel1.setText("One Hundred Only");
        jLabel1.setMaximumSize(new java.awt.Dimension(250, 25));
        jLabel1.setMinimumSize(new java.awt.Dimension(90, 14));
        jLabel1.setName(""); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(240, 22));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 110, 270, 22);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel2.setText("15/03/2015");
        jLabel2.setMaximumSize(new java.awt.Dimension(75, 24));
        jLabel2.setMinimumSize(new java.awt.Dimension(54, 14));
        jLabel2.setName(""); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(75, 22));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(330, 40, 75, 22);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel14.setText("100.00");
        jLabel14.setPreferredSize(new java.awt.Dimension(75, 22));
        jPanel1.add(jLabel14);
        jLabel14.setBounds(300, 110, 70, 20);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(410, 200));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deg.setText("100");
        deg.setPreferredSize(new java.awt.Dimension(72, 25));
        deg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degActionPerformed(evt);
            }
        });
        deg.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                degPropertyChange(evt);
            }
        });
        deg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                degKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                degKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                degKeyTyped(evt);
            }
        });
        jPanel2.add(deg, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 11, 60, -1));

        jTextField2.setText("72");
        jTextField2.setToolTipText("Installments Number");
        jTextField2.setPreferredSize(new java.awt.Dimension(72, 25));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 11, 33, -1));

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jFormattedTextField2.setToolTipText("Please enter the installment date in the right format \nExample\"11/02/2007\"");
        jFormattedTextField2.setPreferredSize(new java.awt.Dimension(72, 25));
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });
        jFormattedTextField2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFormattedTextField2PropertyChange(evt);
            }
        });
        jFormattedTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField2KeyReleased(evt);
            }
        });
        jPanel2.add(jFormattedTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 11, 75, -1));

        jButton6.setText("Select the Date");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 45, -1, -1));

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 76, 79, 68));

        jComboBox1.setEditable(true);
        jComboBox1.setMaximumRowCount(25);
        jComboBox1.setToolTipText("");
        jComboBox1.setAutoscrolls(true);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox1FocusGained(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 124, 252, -1));

        jComboBox2.setEditable(true);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Oman Trading Establishment LLC", "Oman Gulf Enterprises LLC", "General Trading Enterprises LLC", " " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 76, 252, -1));

        jLabel9.setText("Installment Date:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 16, -1, -1));

        jLabel10.setText("Month No:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 16, -1, -1));

        jLabel11.setText("Amount:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 16, -1, -1));

        jLabel17.setText("Select the Benificiary Name:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 54, 200, -1));

        jLabel12.setText("Select the Benificiary Name:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 102, 200, 16));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(410, 125));

        jCheckBox1.setText("Don't Print Date");
        jCheckBox1.setContentAreaFilled(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Don't Print Benificiary Name");
        jCheckBox2.setContentAreaFilled(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Don't Print Amount in Letter");
        jCheckBox3.setContentAreaFilled(false);
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setText("Don't Print Amount in Digit");
        jCheckBox4.setContentAreaFilled(false);
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setText("Print without \"A/C PAYEE ONLY\"");
        jCheckBox5.setContentAreaFilled(false);
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBox5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox4))
                        .addGap(27, 27, 27))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(5, 5, 5)
                        .addComponent(jCheckBox3)
                        .addGap(5, 5, 5)
                        .addComponent(jCheckBox5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addGap(5, 5, 5)
                        .addComponent(jCheckBox4))))
        );

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(158, 370));

        jLabel5.setText("Date Field  (X,Y)");

        jLabel6.setText("Benificiary Name  (X,Y)");

        jLabel7.setText("Amount in Letter   (X,Y)");

        jLabel8.setText("Amount in Digit   (X,Y)");

        jSpinner1.setPreferredSize(new java.awt.Dimension(60, 25));
        jSpinner1.setValue(jLabel2.getX());
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jSpinner2.setPreferredSize(new java.awt.Dimension(60, 25));
        jSpinner2.setValue(jLabel2.getY());
        jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner2StateChanged(evt);
            }
        });

        jSpinner3.setPreferredSize(new java.awt.Dimension(60, 25));
        jSpinner3.setValue(jLabel3.getX());
        jSpinner3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner3StateChanged(evt);
            }
        });

        jSpinner4.setPreferredSize(new java.awt.Dimension(60, 25));
        jSpinner4.setValue(jLabel3.getY());
        jSpinner4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner4StateChanged(evt);
            }
        });

        jSpinner5.setPreferredSize(new java.awt.Dimension(60, 25));
        jSpinner5.setValue(jLabel1.getX());
        jSpinner5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner5StateChanged(evt);
            }
        });

        jSpinner6.setPreferredSize(new java.awt.Dimension(60, 25));
        jSpinner6.setValue(jLabel1.getY());
        jSpinner6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner6StateChanged(evt);
            }
        });

        jSpinner7.setPreferredSize(new java.awt.Dimension(60, 25));
        jSpinner7.setValue(jLabel14.getX());
        jSpinner7.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner7StateChanged(evt);
            }
        });

        jSpinner8.setPreferredSize(new java.awt.Dimension(60, 25));
        jSpinner8.setValue(jLabel14.getY());
        jSpinner8.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner8StateChanged(evt);
            }
        });

        jLabel16.setText("A/C PAYEE ONLY  (X,Y)");

        jSpinner9.setPreferredSize(new java.awt.Dimension(60, 25));
        jSpinner9.setValue(jLabel15.getX());
        jSpinner9.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner9StateChanged(evt);
            }
        });

        jSpinner10.setPreferredSize(new java.awt.Dimension(60, 25));
        jSpinner10.setValue(jLabel15.getY());
        jSpinner10.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner10StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel5.setPreferredSize(new java.awt.Dimension(555, 55));

        jLabel13.setForeground(new java.awt.Color(0, 102, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Copyright © 2012-2015 Smart Systems and its licensors. All Rights Reserved. ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(jLabel13)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(608, 67));

        userlbl.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        userlbl.setForeground(new java.awt.Color(102, 0, 0));
        userlbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userlbl.setText("Welcome");

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Printer Type"));
        jPanel8.setMinimumSize(new java.awt.Dimension(149, 40));
        jPanel8.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("CENTRE");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jRadioButton1);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("RIGHT");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel8.add(jRadioButton2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(164, 125));

        jButton2.setText("Update Bank");
        jButton2.setMaximumSize(new java.awt.Dimension(135, 30));
        jButton2.setPreferredSize(new java.awt.Dimension(140, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Remove Bank");
        jButton4.setPreferredSize(new java.awt.Dimension(140, 23));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Add New Bank");
        jButton3.setPreferredSize(new java.awt.Dimension(140, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Users Management");
        jButton5.setPreferredSize(new java.awt.Dimension(140, 23));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New Session");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Undo");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Redo");
        jMenu2.add(jMenuItem4);
        jMenu2.add(jSeparator1);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Cut");
        jMenu2.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Copy");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Paste");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("View");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Show/Hide Toolbar");
        jMenu3.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Font");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem2);

        jMenuItem8.setText("Themes");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Help");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem9.setText("About");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(629, 681));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public List<String> test =new ArrayList();
    private List<String> Fillcombotest(){
        
         /////////////////////////////////
    try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        }catch(ClassNotFoundException e){
            System.out.println(e);            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Chequesprint.class.getName()).log(Level.SEVERE, null, ex);}    
        
    ////////////////////////////////////////////////
        
    Connection conn1;
    Statement stmt1;   
    
       
        String dbURL = "jdbc:derby://localhost:1527/chqsprintDB";
        //String tableName= "bankloc";
        //jComboBox1.removeAllItems();
        try{
             conn1=DriverManager.getConnection(dbURL,"MUSER","MUSER");
             stmt1 = conn1.createStatement();
             conn1.setAutoCommit(false);
            
            //String selectstr = "select bankname from bankloc order by bankname";            
            ResultSet rs1 = stmt1.executeQuery("select bankname from "+tableName+" order by bankname ");
                while(rs1.next()){
                    String name = rs1.getString("bankname");                   
                  // jComboBox1.addItem(name);
                   test.add(name);
                   
                    }                 
                rs1.close();          
                stmt1.close();
                conn1.commit();
                conn1.close();
        }    
        catch(SQLException e){            
            JOptionPane.showMessageDialog(null,e);
            //TO show the error e in the dialog
            //JOptionPane.showMessageDialog(null,e);
            System.err.println(e);
        }   return test;     }    
   
  
        
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        userlbl.setText("Welcome "+username);
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Chequesprint chequesprint = new Chequesprint(username,usertype);
        chequesprint.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        // TODO add your handling code here:
        try{
        int result = fontChooser.showDialog(window);
	if (result == JFontChooser.OK_OPTION)
	{   Font font = fontChooser.getSelectedFont(); 
            //this comand can't work that is why replaced --jTextPane1.setFont(font);
            SimpleAttributeSet sas2 = new SimpleAttributeSet();
            StyleConstants.setFontFamily(sas2,font.getFamily());
            StyleConstants.setFontSize(sas2,font.getSize());
            StyleConstants.setBold(sas2, (font.getStyle()& Font.ITALIC)!=0);
            StyleConstants.setBold(sas2, (font.getStyle()& Font.BOLD)!=0);
            //jTextPane1.setCharacterAttributes(sas2, true);            
        
            //jTextField1.setFont(font);
            //jTextArea1.setFont(font);
            jLabel1.setFont(font);
            jLabel2.setFont(font);
            jLabel3.setFont(font);
            jLabel14.setFont(font);
            jLabel15.setFont(font);
            
            window.setVisible(false);
            
            }
        else if (result == JFontChooser.CANCEL_OPTION){window.setVisible(false);}}
        catch (Exception e)
		{e.printStackTrace();}

    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        //this button inside the date dialog which set the date fields with the selected date..
        
        
        try{
            
            java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
            
            
         
            String defaultdate = sdf2.format(selectedDate);
            System.out.println(defaultdate);
            System.out.println(selectedDate);
            //System.out.println( datePanel.getModel().getValue());
            System.out.println( datePicker.getJFormattedTextField().getText());

            jFormattedTextField2.setText(defaultdate);   
            jLabel2.setText(defaultdate);
            
        }catch(Exception e){}
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setLocation(300,250);
                frame.setContentPane(new usersMasterDetailForm());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton5ActionPerformed

  
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //ADD NEW BANK TO THE DB AND THE COMBOBOX

        int result= JOptionPane.showConfirmDialog(null, "New Bank Will Be Added, please confirm","Adding New Bank",2);
        if (result==0){
        String bankname= jComboBox1.getModel().getSelectedItem().toString();
        int datelocx=(int)jSpinner1.getValue();
        int datelocy=(int)jSpinner2.getValue();
        int benlocx=(int)jSpinner3.getValue();
        int benlocy=(int)jSpinner4.getValue();
        int letterlocx=(int)jSpinner5.getValue();
        int letterlocy=(int)jSpinner6.getValue();
        int digitlocx=(int)jSpinner7.getValue();
        int digitlocy=(int)jSpinner8.getValue();
        int acx=(int)jSpinner9.getValue();
        int acy=(int)jSpinner10.getValue();

        /////////////////////////////////
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        }catch(ClassNotFoundException e){
            System.out.println(e);

        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Chequesprint.class.getName()).log(Level.SEVERE, null, ex);
        }

        ////////////////////////////////////////////////
        String dbURL = "jdbc:derby://localhost:1527/chqsprintDB";
        //String tableName= "bankloc";
        Connection conn4;
        Statement stmt4;

        try{
            conn4=DriverManager.getConnection(dbURL,"MUSER","MUSER");
            stmt4 = conn4.createStatement();

            String insertstr = "insert into  "+tableName+" values ('"+bankname+"',"+datelocx+","+datelocy+","+benlocx+","+benlocy+","+letterlocx+","+letterlocy+","+digitlocx+","+digitlocy+","+acx+","+acy+")";
            stmt4.executeUpdate(insertstr);

            conn4.setAutoCommit(false);

            //ADDING THE BANK NAME TO THE COMBOBOX
            Object banknameObj= jComboBox1.getModel().getSelectedItem();
            jComboBox1.addItem(banknameObj);test.add((String)banknameObj);

            JOptionPane.showMessageDialog(null, "New Bank Added Successfully!");
            stmt4.close();
            conn4.commit();
            conn4.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"NOT added database error!");
            //TO show the error e in the dialog
            //JOptionPane.showMessageDialog(null,e);
            System.err.println(e);
        }
       }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //REMOVE THE BANK NAME FROM THE DB AND THE COMBOBOX

        int result = JOptionPane.showConfirmDialog(null, "Selected Bank Will Be Deleted, please confirm","Remove Bank",2);
       
        if (result==0){
        
        /////////////////////////////////
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        }catch(ClassNotFoundException e){
            System.out.println(e);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Chequesprint.class.getName()).log(Level.SEVERE, null, ex);}

        ////////////////////////////////////////////////
        String dbURL = "jdbc:derby://localhost:1527/chqsprintDB";
        //String tableName= "bankloc";
        Connection conn5;
        Statement stmt5;
        String bankname= jComboBox1.getModel().getSelectedItem().toString();
        try{
            conn5=DriverManager.getConnection(dbURL,"MUSER","MUSER");
            stmt5 = conn5.createStatement();

            String delstr = "delete from  "+tableName+" where bankname= '"+bankname+"'";
            stmt5.executeUpdate(delstr);

            conn5.setAutoCommit(false);

            //REMOVE THE BANK NAME FROM THE COMBOBOX
            Object banknameObj= jComboBox1.getModel().getSelectedItem();
            jComboBox1.removeItem(banknameObj);test.remove((String)banknameObj);

            JOptionPane.showMessageDialog(null, "Bank Removed Successfully!");
            stmt5.close();
            conn5.commit();
            conn5.close();
        }

        catch(SQLException e){

            JOptionPane.showMessageDialog(null,"Bank not removed database error!");
            JOptionPane.showMessageDialog(null,e);
            System.err.println(e);
        }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //press to update bank in DB and

       int result =JOptionPane.showConfirmDialog(null, "Selected Bank Will Be Updated, please confirm","Update Bank",2);
        if (result==0){
        /////////////////////////////////

        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        }catch(ClassNotFoundException e){
            System.out.println(e);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Chequesprint.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn3;
        Statement stmt3;

        String dbURL = "jdbc:derby://localhost:1527/chqsprintDB";
        String USERNAME = "MUSER";
        String PASSWORD = "MUSER";
        //  String tableName= "bankloc";

        String bankname= jComboBox1.getModel().getSelectedItem().toString();
        int datelocx=(int)jSpinner1.getValue();
        int datelocy=(int)jSpinner2.getValue();
        int benlocx=(int)jSpinner3.getValue();
        int benlocy=(int)jSpinner4.getValue();
        int letterlocx=(int)jSpinner5.getValue();
        int letterlocy=(int)jSpinner6.getValue();
        int digitlocx=(int)jSpinner7.getValue();
        int digitlocy=(int)jSpinner8.getValue();
        int acx=(int)jSpinner9.getValue();
        int acy=(int)jSpinner10.getValue();

        try {
            conn3 = DriverManager.getConnection(dbURL,USERNAME,PASSWORD);
            stmt3 = conn3.createStatement();
            String updatestr = "update  "+tableName+" set DATELOCX="+datelocx+", DATELOCY="+datelocy+", BENLOCX="+benlocx+", BENLOCY="+benlocy+", LETTERLOCX="+letterlocx+", LETTERLOCY="+letterlocy+", DIGITLOCX="+digitlocx+", DIGITLOCY="+digitlocy+", ACX="+acx+", ACY="+acy+" where "+tableName+".bankname='"+bankname+"'";

            stmt3.executeUpdate(updatestr);
            conn3.setAutoCommit(false);

            JOptionPane.showMessageDialog(null, "'"+bankname+"' Updated Successfully!");

            //pstmt.close();
            stmt3.close();
            conn3.commit();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            System.err.println(e);}
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void plafChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plafChooserActionPerformed
        // TODO add your handling code here:
        int index = plafChooser.getSelectedIndex();
        try { UIManager.setLookAndFeel( plafInfos[index].getClassName() );
            SwingUtilities.updateComponentTreeUI(this);
            if (pack.isSelected()) {
                this.pack();
                //Chequesprint.setMinimumSize(this.getSize());
            } }
            catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) { e.printStackTrace(); }
    }//GEN-LAST:event_plafChooserActionPerformed

    private void jSpinner10StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner10StateChanged
        // TODO add your handling code here:
        jLabel15.setLocation((int)jSpinner9.getValue(),(int)jSpinner10.getValue());
    }//GEN-LAST:event_jSpinner10StateChanged

    private void jSpinner9StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner9StateChanged
        // TODO add your handling code here:
        jLabel15.setLocation((int)jSpinner9.getValue(),(int)jSpinner10.getValue());
    }//GEN-LAST:event_jSpinner9StateChanged

    private void jSpinner8StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner8StateChanged
        // TODO add your handling code here:
        jLabel14.setLocation((int)jSpinner7.getValue(),(int)jSpinner8.getValue());
    }//GEN-LAST:event_jSpinner8StateChanged

    private void jSpinner7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner7StateChanged
        // TODO add your handling code here:
        jLabel14.setLocation((int)jSpinner7.getValue(),(int)jSpinner8.getValue());
    }//GEN-LAST:event_jSpinner7StateChanged

    private void jSpinner6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner6StateChanged
        // TODO add your handling code here:
        jLabel1.setLocation((int)jSpinner5.getValue(),(int)jSpinner6.getValue());
    }//GEN-LAST:event_jSpinner6StateChanged

    private void jSpinner5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner5StateChanged
        // TODO add your handling code here:
        jLabel1.setLocation((int)jSpinner5.getValue(),(int)jSpinner6.getValue());
    }//GEN-LAST:event_jSpinner5StateChanged

    private void jSpinner4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner4StateChanged
        // TODO add your handling code here:
        jLabel3.setLocation((int)jSpinner3.getValue(),(int)jSpinner4.getValue());
    }//GEN-LAST:event_jSpinner4StateChanged

    private void jSpinner3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner3StateChanged
        // TODO add your handling code here:
        jLabel3.setLocation((int)jSpinner3.getValue(),(int)jSpinner4.getValue());
    }//GEN-LAST:event_jSpinner3StateChanged

    private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
        // TODO add your handling code here:
        //jLabel2.setLocation(null,Y);
        jLabel2.setLocation((int)jSpinner1.getValue(),(int)jSpinner2.getValue());
    }//GEN-LAST:event_jSpinner2StateChanged

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        //jLabel2.setLocation(X,null);
        jLabel2.setLocation((int)jSpinner1.getValue(),(int)jSpinner2.getValue());
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox5.isSelected())jLabel15.setVisible(false);
        if (!jCheckBox5.isSelected())jLabel15.setVisible(true);
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox4.isSelected())jLabel14.setVisible(false);
        if (!jCheckBox4.isSelected())jLabel14.setVisible(true);
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox3.isSelected())jLabel1.setVisible(false);
        if (!jCheckBox3.isSelected())jLabel1.setVisible(true);
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox2.isSelected())jLabel3.setVisible(false);
        if (!jCheckBox2.isSelected())jLabel3.setVisible(true);
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox1.isSelected())jLabel2.setVisible(false);
        if (!jCheckBox1.isSelected())jLabel2.setVisible(true);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        //to select benificiary name from the combo or to write new name,also to add the suffix *****
        jLabel3.setText((String)jComboBox2.getSelectedItem()+"****");
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1FocusGained

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        // TODO add your handling code here:
        // select the bank name from the combobox1 will update the spinner's

        Connection conn2;
        Statement stmt2;
        ResultSet rs2;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        }catch(ClassNotFoundException e){
            System.out.println(e);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Chequesprint.class.getName()).log(Level.SEVERE, null, ex);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        String dbURL = "jdbc:derby://localhost:1527/chqsprintDB";
        //String tableName= "bankloc";

        String bankname= jComboBox1.getSelectedItem().toString();
        //int index = jComboBox1.getSelectedIndex();

        try{
            conn2=DriverManager.getConnection(dbURL,"MUSER","MUSER");
            stmt2 = conn2.createStatement();
            rs2= stmt2.executeQuery("select * from  "+tableName+" where bankname= '"+bankname+"'");

            while(rs2.next()){
                jComboBox1.setSelectedItem((rs2.getString("bankname")));
                jSpinner1.setValue(rs2.getInt("datelocx")) ;
                jSpinner2.setValue(rs2.getInt("datelocy"));
                jSpinner3.setValue(rs2.getInt("benlocx")) ;
                jSpinner4.setValue(rs2.getInt("benlocy"));
                jSpinner5.setValue(rs2.getInt("letterlocx"));
                jSpinner6.setValue(rs2.getInt("letterlocy"));
                jSpinner7.setValue(rs2.getInt("digitlocx"));
                jSpinner8.setValue(rs2.getInt("digitlocy"));
                jSpinner9.setValue(rs2.getInt("acx"));
                jSpinner10.setValue(rs2.getInt("acy"));
            }
            rs2.close();
            stmt2.close();
            conn2.commit();
        }
        catch(SQLException e){
            System.err.println(e);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        {
            try {
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                Calendar calendar2 = new GregorianCalendar(2001,2,28);

                java.util.Date defaultdate;
                defaultdate = sdf2.parse(jFormattedTextField2.getText());
                calendar2.setTime(defaultdate);
                System.out.println("Date is:"+sdf2.format(calendar2.getTime()));
                final int enteredday =calendar2.get(Calendar.DAY_OF_MONTH);

                for(int i=1;i<=parseInt(jTextField2.getText());i++){
                    int day =calendar2.get(Calendar.DAY_OF_MONTH);
                    int month =calendar2.get(Calendar.MONTH);
                    int year =calendar2.get(Calendar.YEAR);

                    jFormattedTextField2.setText(sdf2.format(calendar2.getTime()));
                    jLabel2.setText(jFormattedTextField2.getText());
                    System.out.println("Date is:"+sdf2.format(calendar2.getTime()));

                    calendar2.roll(2,1);
                    {if (calendar2.getActualMaximum(Calendar.DAY_OF_MONTH)>=enteredday)
                        calendar2.set(Calendar.DAY_OF_MONTH, enteredday);}
                    if((month%11==0)&&(month!=0))calendar2.roll(1,1);

                    // this.repaint();
                    PrinterJob job = PrinterJob.getPrinterJob();
                    PageFormat pf1 = new PageFormat();
                    pf1.setOrientation(PageFormat.LANDSCAPE);
                    Paper myPaper = new Paper();
                    double width = 410 ;
                    double height= 700;
                    double margin= 10;
                    myPaper.setSize(width, height);

                    myPaper.setImageableArea(margin*10, margin*10, width-(margin*2), height-(margin*2));
                    pf1.setPaper(myPaper);
                    job.setPrintable(this,pf1);
                    /*
                    this.jTextField3.setText(valueOf(myPaper.getHeight())+valueOf(myPaper.getWidth())+valueOf(myPaper.getImageableX())
                        +valueOf(myPaper.getImageableY())+valueOf(myPaper.getImageableWidth())+valueOf(myPaper.getImageableHeight())
                        +valueOf(pf1.getImageableWidth())+valueOf(pf1.getImageableHeight()));
                    */

                    /*to print with print dialog just remove the 3 comment mark's*/
                    //boolean ok = job.printDialog();
                    //if (ok) {
                        try {
                            job.print(); }
                        catch (PrinterException ex) {
                            /* The job did not successfully complete */
                        }
                        //}

                }
            }catch (ParseException ex) {
                Logger.getLogger(Chequesprint.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ParseException");}

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        //JDatePickerImpl datePicker = null;
        /*JButton buttonOK = new JButton("OK");
        buttonOK.addActionListener((ActionListener) this);

        dateDialog.add(buttonOK);
        JDatePickerDemo datePickerDemo = new JDatePickerDemo();
        datePickerDemo.setVisible(true);
        */

        dateDialog.setVisible(true);

        //datePickerDemo.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jFormattedTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2KeyReleased

    private void jFormattedTextField2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFormattedTextField2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2PropertyChange

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed
        try {
            /*try{
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                String strOfdefaultdate = "15/03/2015";
                java.util.Date defaultdate=sdf1.parse(strOfdefaultdate);
                Calendar calendar1 = new GregorianCalendar(15,2,2015);
                //jFormattedTextField2.setText(strOfdefaultdate);
                jLabel2.setText(jFormattedTextField2.getText());
            } catch (ParseException ex) {
                Logger.getLogger(Chequesprint.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            jLabel2.setText(jFormattedTextField2.getFormatter().valueToString(jFormattedTextField2.getValue()));
            //jLabel2.setText(jFormattedTextField2.getText());
        } catch (ParseException ex) {
            Logger.getLogger(Chequesprint.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void degKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_degKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_degKeyTyped

    private void degKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_degKeyReleased
        NumberToWord NtW1 = new NumberToWord();
        int x = parseInt(deg.getText());
        String y= deg.getText()+".000";
        String traNum= NtW1.convert(x);
        System.out.println("jLabel1 text value is:"+traNum+" Only");
        jLabel1.setText(traNum+ " Only");
        jLabel14.setText(y);        
    }//GEN-LAST:event_degKeyReleased

    private void degKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_degKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_degKeyPressed

    private void degPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_degPropertyChange

    }//GEN-LAST:event_degPropertyChange

    private void degActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degActionPerformed
        //TODO add your handling code here:

        //if(!("".equals(deg.getText()))){};
        /* NumberToWord NtW1 = new NumberToWord();
        int x = parseInt(deg.getText());
        String y= deg.getText()+".000";
        String traNum= NtW1.convert(x);
        System.out.println("jLabel1 text value is:"+traNum+" Only");
        jLabel1.setText(traNum+ " Only");
        jLabel14.setText(y);
        /*else{NumberToWord NtW1 = new NumberToWord();
            int x = parseInt("0");
            String y= "0.000";
            String traNum= NtW1.convert(x);
            System.out.println("jLabel1 text value is:"+traNum+" Only");
            jLabel1.setText(traNum+ " Only");
            jLabel14.setText(y);}*/

        /*    if(((evt.getKeyCode()>=KeyEvent.VK_0)&&(evt.getKeyCode()<=KeyEvent.VK_9))) {
            NumberToWord NtW1 = new NumberToWord();
            int x= parseInt(deg.getText());
            String y= deg.getText()+".000";
            String traNum= NtW1.convert(x);
            System.out.println("jLabel1 text value is:"+traNum+" Only");
            jLabel1.setText(traNum+ " Only");
            jLabel14.setText(y);
        }
        else if(evt.getKeyCode()==KeyEvent.VK_SPACE){Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"This field accepting number's only ");}
        else{
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null,"This field accepting number's only ");

        }  */
    }//GEN-LAST:event_degActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        themesDialog.setVisible(true);
        themesDialog.setSize(250, 100);
        themesDialog.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        tableName="bankloc2";        
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        tableName="bankloc";
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        helpDialog.setVisible(true);
        helpDialog.setSize(400, 300);
        helpDialog.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void packActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_packActionPerformed

    /**
     * @param args the command line arguments
     */
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
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Chequesprint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
       
                       
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    
                try {    
                 Chequesprint chqsprintwindow =   new Chequesprint();
                 chqsprintwindow.setVisible(true);
                 System.out.println(UIManager.getSystemLookAndFeelClassName());
                 UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                 SwingUtilities.updateComponentTreeUI(chqsprintwindow);   
                 
                    
                } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Chequesprint.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            });
            
                        
            NetworkServerControl server;
            try{
                server = new NetworkServerControl(InetAddress.getByName("localhost"),1527);
                server.start(null);
            }catch (Exception e1){}                 
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDialog dateDialog;
    private static javax.swing.JTextField deg;
    private javax.swing.JDialog helpDialog;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JCheckBox pack;
    private javax.swing.JComboBox plafChooser;
    private javax.swing.JDialog themesDialog;
    private javax.swing.JLabel userlbl;
    // End of variables declaration//GEN-END:variables

    /*private String parse(DateFormat df) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

}
