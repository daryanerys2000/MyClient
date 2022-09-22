import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.TableColumn;

public final class ClientForm extends JFrame {
    static Socket socket = null;
    static BufferedReader br = null;
    static PrintStream ps = null;
    String userID;

    public ClientForm(String userID) {
        super();
        setBounds(75, 200, 1000, 1000);

        initComponents();
        this.userID = userID;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 1024);
            ps = new PrintStream(socket.getOutputStream()); // отправляем
            br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // получаем
        }
        catch (IOException e) {
            System.err.println("ошибка I/О потока " + e);
        }
        SetTable(1);
    }

    private JButton buttonAddDep;
    private JComboBox<String> comboBoxFilter;
    private JScrollPane jScrollPane1;
    private JTable tableClient;
    private JOptionPane JOptionPaneTest;

    private JFrame WindowDep; // для формы депозитов
    private JButton buttonOk, buttonClose;
    private JLabel labelError, jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jLabel10;
    private JTextField docNum, term, sum, proc, id, FIO;
    private JComboBox boxType, boxCurrency, boxDayB, boxMonthB, boxYearB, boxDayE, boxMonthE, boxYearE;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        WindowDep = new JFrame();

        buttonOk = new JButton(); buttonClose = new JButton();

        JOptionPaneTest = new JOptionPane();

        jLabel1 = new JLabel(); jLabel2 = new JLabel(); jLabel3 = new JLabel(); jLabel4 = new JLabel();
        jLabel5 = new JLabel(); jLabel6 = new JLabel(); jLabel7 = new JLabel(); jLabel8 = new JLabel();
        jLabel9 = new JLabel(); jLabel10 = new JLabel(); labelError = new JLabel();

        jLabel1.setText("Вид депозита:");
        jLabel2.setText("№ договора:");
        jLabel3.setText("Валюта:");
        jLabel4.setText("Дата начала депозитной программы:");
        jLabel5.setText("Дата окончания депозитной программы:");
        jLabel6.setText("Срок договора:");
        jLabel7.setText("Сумма вклада:");
        jLabel8.setText("% по вкладу:");
        jLabel9.setText("ID клиента:");
        jLabel10.setText("ФИО регистратора:");

        docNum = new JTextField(); term = new JTextField(); sum = new JTextField();
        proc = new JTextField(); id = new JTextField(); FIO = new JTextField();

        String[] boxDayS = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18",
                "19","20", "21","22","23","24","25","26","27","28","29","30","31"};
        String[] boxMonthS = {"01","02","03","04","05","06","07","08","09","10", "11","12"};
        String[] boxYearSBegin = {"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010",
                "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"}; // с года основания
        String[] boxYearSEnd = {"2021","2022","2023","2024","2025","2026","2027","2028","2029","2030",
                "2031","2032","2033","2034","2035","2036","2037","2038","2039","2040"};

        boxDayB = new JComboBox(boxDayS); boxMonthB = new JComboBox(boxMonthS); boxYearB = new JComboBox(boxYearSBegin);
        boxDayE = new JComboBox(boxDayS); boxMonthE = new JComboBox(boxMonthS); boxYearE = new JComboBox(boxYearSEnd);

        String[] boxTypeS = {"ON-LINE безотзывный", "ON-LINE отзывный", "Срочный безотзывный банковский вклад " +
                "«Элитный выбор»", "Срочный отзывный банковский вклад «Удачный старт»"};
        String[] boxCurrencyS = {"BYN", "USD", "RUB", "UAH", "EUR"};

        boxType = new JComboBox(boxTypeS); boxCurrency = new JComboBox(boxCurrencyS);

        WindowDep.setTitle("Регистрация");
        WindowDep.setAlwaysOnTop(true);
        WindowDep.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                WindowDepAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        buttonOk.setText("OK");
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    buttonOkActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonClose.setText("Закрыть");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        // ====================================== все для таблицы депозитов ==========================================
        jScrollPane1 = new JScrollPane();
        tableClient = new JTable();
        comboBoxFilter = new JComboBox<>();
        buttonAddDep = new JButton();

        labelError.setForeground(new java.awt.Color(255, 0, 0));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        tableClient.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null}
                },
                new String [] { // заголовки
                        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"
                }
        ));
        jScrollPane1.setViewportView(tableClient);

        comboBoxFilter.setModel(new DefaultComboBoxModel<>(new String[] { "<20", ">20" }));

        buttonAddDep.setText("Добавить депозит");
        buttonAddDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddDepActionPerformed(evt);
            }
        });

        boxDayB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener(evt);
            }
        });
        boxMonthB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener(evt);
            }
        });
        boxYearB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener(evt);
            }
        });
        boxDayE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener1(evt);
            }
        });
        boxMonthE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener1(evt);
            }
        });
        boxYearE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener1(evt);
            }
        });
        boxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener2(evt);
            }
        });
        boxCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener3(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(58, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(buttonAddDep)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(comboBoxFilter, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))))
                                .addGap(48, 48, 48))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(buttonAddDep, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(22, 22, 22))
        );

        pack();

        Container c = WindowDep.getContentPane();
        GroupLayout WindowDepLayout = new GroupLayout(c);
        c.setLayout(WindowDepLayout);
        WindowDepLayout.setHorizontalGroup(
                WindowDepLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(WindowDepLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, WindowDepLayout.createSequentialGroup()
                                                .addComponent(buttonOk, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(buttonClose, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(WindowDepLayout.createSequentialGroup()
                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3)
                                                        .addComponent(jLabel4).addComponent(jLabel5).addComponent(jLabel6)
                                                        .addComponent(jLabel7).addComponent(jLabel8).addComponent(jLabel9)
                                                        .addComponent(jLabel10))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(boxType, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(docNum, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(boxCurrency, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(boxDayB, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(boxMonthB, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(boxYearB, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(boxDayE, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(boxMonthE, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(boxYearE, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(term, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sum, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(proc, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(id, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(FIO, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                ))
                                        .addGroup(GroupLayout.Alignment.TRAILING, WindowDepLayout.createSequentialGroup()
                                                .addComponent(labelError)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        WindowDepLayout.setVerticalGroup(
                WindowDepLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(WindowDepLayout.createSequentialGroup()
                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(WindowDepLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(WindowDepLayout.createSequentialGroup()
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel1))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(docNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(boxCurrency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxDayB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel4))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxMonthB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel4))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxYearB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel4))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxDayE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel5))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxMonthE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel5))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxYearE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel5))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(term, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel6))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(sum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel7))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(proc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel8))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel9))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(FIO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel10))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowDepLayout.createSequentialGroup()
                                                                        .addGap(15, 15, 15)
                                                                        .addComponent(labelError))))

                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(WindowDepLayout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addGroup(WindowDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(buttonOk, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(buttonClose, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                                                        )
                                        )
                                )
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String beginDay = "01"; String beginMonth = "01"; String beginYear = "2001";
    String begin = beginYear + "/" + beginMonth + "/" + beginDay;
    public void BoxActionListener(java.awt.event.ActionEvent evt){
        beginDay = boxDayB.getSelectedItem().toString();
        beginMonth =  boxMonthB.getSelectedItem().toString();
        beginYear = boxYearB.getSelectedItem().toString();
        begin =  beginYear + "/" + beginMonth + "/" + beginDay;
    }

    String endDay = "01"; String endMonth = "01"; String endYear = "2021";
    String end = endYear + "/" + endMonth + "/" + endDay;
    public void BoxActionListener1(java.awt.event.ActionEvent evt){
        endDay = boxDayE.getSelectedItem().toString();
        endMonth =  boxMonthE.getSelectedItem().toString();
        endYear = boxYearE.getSelectedItem().toString();
        end =  endYear + "/" + endMonth + "/" + endDay;
    }

    String type = "ON-LINE безотзывный";
    public void BoxActionListener2(java.awt.event.ActionEvent evt){
        type = boxType.getSelectedItem().toString();
    }

    String currency = "BYN";
    public void BoxActionListener3(java.awt.event.ActionEvent evt){
        currency = boxCurrency.getSelectedItem().toString();
    }

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        if(evt.getSource() == buttonOk) {
            String checkRes = CheckDep().trim();
            if(checkRes.equals("true")) {
                setDep();
            }
            else labelError.setText(checkRes);
        }
    }

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {
        WindowDep.dispose();
    }

    private void WindowDepAncestorMoved(java.awt.event.HierarchyEvent evt) {
    }

    private void buttonAddDepActionPerformed(java.awt.event.ActionEvent evt) { // добавить депозит
        if(evt.getSource() == buttonAddDep) {
            WindowDep.setVisible(true);
            WindowDep.setEnabled(true);
            WindowDep.setBounds(450, 10,500,710);
            WindowDep.getContentPane().setBackground(Color.LIGHT_GRAY);
        }
    }

    void SetTable(int count1) {
        try {
            socket = new Socket(InetAddress.getLocalHost(), 1024);
            ps = new PrintStream(socket.getOutputStream()); // отправляем
            br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // получаем
        }
        catch (IOException e) {
            System.err.println("ошибка I/О потока " + e);
        }
        try {
            ArrayList<String[]> getTableInfo = new ArrayList<>();
            String[] str;
            ps.println("gettable");
            ps.println(userID);
            int count = count1;
            count = Integer.parseInt(br.readLine());

            for(int i = 0; i < count;i++) {
                str = new String[11];
                for(int j = 0; j < 11; j++) {
                    str[j] = br.readLine();
                }
                getTableInfo.add(str);
            }
            tableClient.setModel(new ClientTable(getTableInfo));
            tableClient.setSize(900, 500);
            tableClient.getColumnModel().getColumn(0).setPreferredWidth(10);
            tableClient.getColumnModel().getColumn(1).setPreferredWidth(130);
            tableClient.getColumnModel().getColumn(2).setPreferredWidth(120);
            tableClient.getColumnModel().getColumn(3).setPreferredWidth(18);
            tableClient.getColumnModel().getColumn(4).setPreferredWidth(40);
            tableClient.getColumnModel().getColumn(5).setPreferredWidth(40);
            tableClient.getColumnModel().getColumn(6).setPreferredWidth(12);
            tableClient.getColumnModel().getColumn(7).setPreferredWidth(20);
            tableClient.getColumnModel().getColumn(8).setPreferredWidth(10);
            tableClient.getColumnModel().getColumn(9).setPreferredWidth(40);
            tableClient.getColumnModel().getColumn(10).setPreferredWidth(80);
        }
        catch(IOException e) {System.out.println("Ошибка");}
    }

    String CheckDep() {
        if (docNum.getText().isEmpty() || term.getText().isEmpty() || sum.getText().isEmpty()
                || proc.getText().isEmpty() || id.getText().isEmpty() || FIO.getText().isEmpty()){
            return "Не все необходимые поля заполнены. Попробуйте снова";
        }

        Pattern docNumRegex = Pattern.compile("^[0-9]+"); // + один и более раз
        Pattern sumRegex = Pattern.compile("^[0-9\\.]+");
        Pattern nameRegex = Pattern.compile("^[А-Я][а-я]{1,20}$"); // $ конец строки

        Matcher matcher;
        matcher = docNumRegex.matcher(docNum.getText());
        if (!matcher.matches())
            return "Неверно введен номер договора. Попробуйте снова";
        matcher = docNumRegex.matcher(term.getText());
        if (!matcher.matches())
            return "Неверно введен срок договора. Попробуйте снова";
        matcher = sumRegex.matcher(sum.getText());
        if (!matcher.matches())
            return "Неверно введена сумма вклада. Попробуйте снова";
        matcher = docNumRegex.matcher(proc.getText());
        if (!matcher.matches())
            return "Неверно введен процент по вкладу. Попробуйте снова";
        matcher = docNumRegex.matcher(id.getText());
        if (!matcher.matches())
            return "Неверно введен ID пользователя. Попробуйте снова";
        matcher = nameRegex.matcher(FIO.getText());
        if (!matcher.matches())
            return "Неверно введена фамилия. Попробуйте снова";

        /*int procInt = Integer.parseInt(proc.getText());
        if (boxType.equals("ON-LINE безотзывный") && boxCurrency.equals("BYN")){
            if (procInt != 12) {
                return "Процент не соответствует депозиту";
            }
        }
        if (boxType.equals("Срочный отзывный банковский вклад «Удачный старт»") && boxCurrency.equals("BYN")){
            if (procInt != 1) {
                return "Процент не соответствует депозиту";
            }
        }
        if ((boxType.equals("ON-LINE безотзывный")||boxType.equals("ON-LINE отзывный")) && boxCurrency.equals("USD")){
            if (procInt != 1) {
                return "Процент не соответствует депозиту";
            }
        }
        if (boxType.equals("ON-LINE отзывный") && boxCurrency.equals("BYN")){
            if (procInt != 8) {
                return "Процент не соответствует депозиту";
            }
        }*/

        int termInt = Integer.parseInt(term.getText());
        if (termInt > 100){
            return "Срок договора больше 100 лет. Попробуйте снова";
        }
        if (docNum.getText().length() != 13){
            return "Количество цифр в номере договора не соответствует 13. Попробуйте снова";
        }

        return "true";
    }

    void setDep() throws IOException {
        ps.println("idExists");
        ps.println(id.getText());
        String result = br.readLine();
        int resInt = Integer.parseInt(result);
        if (resInt == 1) {
            ps.println("addDep");
            ps.println(type);
            ps.println(docNum.getText());
            ps.println(currency);
            ps.println(begin);
            ps.println(end);
            ps.println(term.getText());
            ps.println(sum.getText());
            ps.println(proc.getText());
            ps.println(id.getText());
            ps.println(FIO.getText());

            ps.println("addAccount");
            ps.println(sum.getText());
            ps.println(id.getText());
            ps.println("addAccount2");
            ps.println(id.getText());
            //ps.println("exit");
        }
        else {
            WindowDep.dispose();
            JOptionPane.showMessageDialog(JOptionPaneTest,
                    "<html><h2>Ошибка</h2><i>Пользователь с таким айди не существует</i>");
        }

        try {
            socket = new Socket(InetAddress.getLocalHost(), 1024);
            ps = new PrintStream(socket.getOutputStream()); // отправляем
            br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // получаем
        }
        catch (IOException e) {
            System.err.println("ошибка I/О потока " + e);
        }
        SetTable(1);
    }
}
