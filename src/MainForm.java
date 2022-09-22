import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainForm extends JFrame {
    static String ID; // int 1
    private JPanel panel1;
    private JOptionPane JOptionPaneTest;

    public MainForm() throws ParseException {
        super("Belinvestbank");
        setLocation(450,280);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() throws ParseException {
        WindowRegistration = new JFrame();

        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        panelMain = new JPanel();
        jPanel1 = new JPanel();

        buttonRegistration = new JButton();
        buttonLogin = new JButton();
        fieldLogin = new JTextField();
        fieldPass = new JPasswordField();
        background = new JLabel();

        JOptionPaneTest = new JOptionPane();

        buttonOk = new JButton();
        buttonClose = new JButton();

        labelError = new JLabel();
        labelLoginError = new JLabel();
        labelWelcome = new JLabel();
        labelPassword = new JLabel();
        labelLogin = new JLabel();
        jLabel2 = new JLabel(); jLabel3 = new JLabel(); jLabel4 = new JLabel();
        jLabel5 = new JLabel(); jLabel6 = new JLabel(); jLabel10 = new JLabel();
        jLabel20 = new JLabel(); jLabel21 = new JLabel(); jLabel22 = new JLabel();
        jLabel23 = new JLabel(); jLabel24 = new JLabel(); jLabel25 = new JLabel();
        jLabel26 = new JLabel(); jLabel27 = new JLabel(); jLabel28 = new JLabel();
        jLabel29 = new JLabel(); jLabel30 = new JLabel(); jLabel31 = new JLabel();
        jLabel32 = new JLabel(); jLabel33 = new JLabel(); jLabel34 = new JLabel();
        jLabel35 = new JLabel(); jLabel36 = new JLabel(); jLabel37 = new JLabel();
        jLabel9 = new JLabel();  jLabel11 = new JLabel(); jLabel12 = new JLabel();

        login = new JTextField();
        name = new JTextField();
        surname = new JTextField();
        middle_name = new JTextField();
        place_of_birth = new JTextField();
        address = new JTextField();
        email = new JTextField();
        workplace = new JTextField();
        work_position = new JTextField();
        income = new JTextField();
        passport_country = new JTextField();
        pass = new JPasswordField();
        rpass = new JPasswordField();

        home_tel = new JFormattedTextField();
        MaskFormatter mf1 = new MaskFormatter("##-##-##");
        home_tel = new JFormattedTextField(mf1);

        mob_tel = new JFormattedTextField();
        MaskFormatter mf2 = new MaskFormatter("+375-(##)-###-##-##");
        mob_tel = new JFormattedTextField(mf2);

        identity_num = new JFormattedTextField();
        MaskFormatter mf3 = new MaskFormatter("#######U###UU#");
        identity_num = new JFormattedTextField(mf3);

        passport = new JFormattedTextField();
        MaskFormatter mf4 = new MaskFormatter("UU#######");
        passport = new JFormattedTextField(mf4);

        flag1 = new JRadioButton("да"); // на пенсии
        flag2 = new JRadioButton("нет");
        bg = new ButtonGroup(); bg.add(flag1); bg.add(flag2);
        flag3 = new JRadioButton("да"); // военнообязанный
        flag4 = new JRadioButton("нет");
        bg1 = new ButtonGroup(); bg1.add(flag3); bg1.add(flag4);

        String[] boxDayS = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18",
                "19","20", "21","22","23","24","25","26","27","28","29","30","31"};
        String[] boxMonthS = {"01","02","03","04","05","06","07","08","09","10", "11","12"};
        String[] boxYearS = {"1940","1941","1942","1943","1944","1945","1946","1947","1948", "1949","1950","1951",
                "1952","1953","1954","1955","1956","1957","1958","1959", "1960","1961","1962","1963","1964","1965",
                "1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979",
                "1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990", "1991","1992","1993",
                "1994","1995","1996","1997","1998","1999", "2000","2001","2002"};
        String[] boxYearSPassport = {"2000", "2001","2002","2003","2004","2005","2006","2007","2008","2009","2010",
                "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"};

        String[] boxCityS = {"Минск", "Гродно", "Гомель", "Витебск", "Могилев", "Брест"};
        String[] boxMaritalStatusS = {"В браке", "В разводе", "Не замужем/не женат"};
        String[] boxCitizenshipS = {"Беларусь", "Россия", "Украинка", "Польша"};
        String[] boxDisabilityS = {"Нет", "1 группа", "2 группа", "3 группа"};

        boxDay = new JComboBox(boxDayS); boxMonth = new JComboBox(boxMonthS); boxYear = new JComboBox(boxYearS);
        boxDay1 = new JComboBox(boxDayS); boxMonth1 = new JComboBox(boxMonthS);
        boxCity = new JComboBox(boxCityS); boxYearPassport = new JComboBox(boxYearSPassport);
        boxMaritalStatus = new JComboBox(boxMaritalStatusS);
        boxCitizenship = new JComboBox(boxCitizenshipS);
        boxDisability = new JComboBox(boxDisabilityS);

        jLabel2.setText("Логин:");
        jLabel3.setText("Пароль:");
        jLabel4.setText("Имя:");
        jLabel5.setText("Фамилия:");
        jLabel6.setText("Повторите пароль:");
        jLabel10.setText("Отчество:");
        jLabel9.setText("Паспорт:");
        jLabel20.setText("Дата рождения:");
        jLabel21.setText("Место рождения:");
        jLabel22.setText("Город проживания:");
        jLabel23.setText("Адрес:");
        jLabel24.setText("Домашний телефон:");
        jLabel25.setText("Мобильный телефон:");
        jLabel26.setText("Email:");
        jLabel27.setText("Место работы:");
        jLabel28.setText("Должность:");
        jLabel29.setText("Семейное положение:");
        jLabel30.setText("Гражданство:");
        jLabel31.setText("Инвалидность:");
        jLabel32.setText("Наличие пенсии:");
        jLabel33.setText("Доход:");
        jLabel34.setText("Военнообязанный:");
        jLabel35.setText("Страна выдачи паспорта:");
        jLabel36.setText("Дата выдачи паспорта:");
        jLabel37.setText("Индентификационный номер:");

        WindowRegistration.setTitle("Регистрация");
        WindowRegistration.setAlwaysOnTop(true);
        WindowRegistration.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                WindowRegistrationAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        buttonOk.setText("OK");
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOkActionPerformed(evt);
            }
        });

        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        buttonClose.setText("Закрыть");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(SwingConstants.VERTICAL);
        jSeparator2.setOrientation(SwingConstants.VERTICAL);

        labelError.setForeground(new java.awt.Color(255, 0, 0));

        GroupLayout WindowRegistrationLayout = new GroupLayout(WindowRegistration.getContentPane());
        WindowRegistration.getContentPane().setLayout(WindowRegistrationLayout);
        WindowRegistrationLayout.setHorizontalGroup(
                WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(WindowRegistrationLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, WindowRegistrationLayout.createSequentialGroup()
                                                .addComponent(buttonOk, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(buttonClose, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(WindowRegistrationLayout.createSequentialGroup()
                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(login, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                                        .addComponent(pass)
                                                        .addComponent(rpass))))
                                .addGap(18, 18, 18)

                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)

                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(WindowRegistrationLayout.createSequentialGroup()
                                                        .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel4).addComponent(jLabel5).addComponent(jLabel10).addComponent(jLabel20)
                                                                .addComponent(jLabel21).addComponent(jLabel22).addComponent(jLabel23).addComponent(jLabel24)
                                                                .addComponent(jLabel25).addComponent(jLabel26).addComponent(jLabel27).addComponent(jLabel28)
                                                                )
                                                        .addGap(18, 18, 18)

                                                        .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(surname, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(name, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(middle_name, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(boxDay, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(boxMonth, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(boxYear, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(place_of_birth, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(boxCity, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(address, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(home_tel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(mob_tel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(email, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(workplace, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(work_position, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        )))
                                        .addComponent(labelError))
                                .addGap(18, 18, 18)

                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)

                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(WindowRegistrationLayout.createSequentialGroup()
                                                        .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel29).addComponent(jLabel30).addComponent(jLabel31).addComponent(jLabel32)
                                                                .addComponent(jLabel33).addComponent(jLabel34).addComponent(jLabel35).addComponent(jLabel36)
                                                                .addComponent(jLabel37).addComponent(jLabel9)
                                                        )
                                                        .addGap(18, 18, 18)

                                                        .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(boxMaritalStatus, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(boxCitizenship, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(boxDisability, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(flag1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(flag2, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(income, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(flag3, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(flag4, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)                                                                .addComponent(passport_country, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(boxDay1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(boxMonth1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(boxYearPassport, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(identity_num, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(passport, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        )))
                                        .addComponent(labelError))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        WindowRegistrationLayout.setVerticalGroup(
                WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(WindowRegistrationLayout.createSequentialGroup()
                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(WindowRegistrationLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 590, GroupLayout.PREFERRED_SIZE)
                                                .addGap(57, 57, 57)
                                                .addComponent(jLabel11))

                                        .addGroup(WindowRegistrationLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 590, GroupLayout.PREFERRED_SIZE)
                                                .addGap(57, 57, 57)
                                                .addComponent(jLabel12))

                                        .addGroup(WindowRegistrationLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(WindowRegistrationLayout.createSequentialGroup()
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(surname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel5))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel10)
                                                                        .addComponent(middle_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel20))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel20))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel20))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(place_of_birth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel21))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel22))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel23))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(home_tel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel24))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(mob_tel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel25))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel26))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(workplace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel27))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(work_position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel28))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))

                                                        .addGroup(WindowRegistrationLayout.createSequentialGroup()
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(login, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(rpass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))

                                                        .addGroup(WindowRegistrationLayout.createSequentialGroup()
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxMaritalStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel29))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxCitizenship, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel30))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxDisability, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel31))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(flag1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel32))
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(flag2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel32))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(income, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel33))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(flag3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel34))
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(flag4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel34))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(passport_country, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel35))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxDay1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel36))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxMonth1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel36))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(boxYearPassport, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel36))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(identity_num, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel37))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(passport, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel9))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        )
                                                )

                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(WindowRegistrationLayout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addGroup(WindowRegistrationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(buttonOk, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(buttonClose, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(WindowRegistrationLayout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addComponent(labelError)))
                                        )
                                )
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panelMain.setMinimumSize(new java.awt.Dimension(200, 200));
        panelMain.setPreferredSize(new java.awt.Dimension(1000, 1000));
        panelMain.setLayout(null);

        labelLoginError.setForeground(new java.awt.Color(255, 0, 0));
        panelMain.add(labelLoginError);
        labelLoginError.setBounds(10, 200, 140, 20);

        labelWelcome.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelWelcome.setForeground(new java.awt.Color(255, 255, 255));
        labelWelcome.setText("Вы входите в \"БЕЛИНВЕСТБАНК\"");
        panelMain.add(labelWelcome);
        labelWelcome.setBounds(20, 10, 300, 22);

        labelPassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelPassword.setForeground(new java.awt.Color(0, 141, 122));
        labelPassword.setText("Пароль");
        panelMain.add(labelPassword);
        labelPassword.setBounds(10, 100, 70, 30);

        labelLogin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelLogin.setForeground(new java.awt.Color(0, 141, 122));
        labelLogin.setText("Логин:");
        panelMain.add(labelLogin);
        labelLogin.setBounds(10, 50, 60, 30);

        jPanel1.setBackground(new java.awt.Color(0, 141, 122));
        jPanel1.setForeground(new java.awt.Color(0, 141, 122));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 30, Short.MAX_VALUE)
        );

        panelMain.add(jPanel1);
        jPanel1.setBounds(10, 10, 320, 30);

        buttonRegistration.setText("Регистрация");
        buttonRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrationActionPerformed(evt);
            }
        });
        panelMain.add(buttonRegistration);
        buttonRegistration.setBounds(10, 160, 130, 40);

        flag1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlagActionListener(evt);
            }
        });
        flag2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlagActionListener(evt);
            }
        });
        flag3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlagActionListener1(evt);
            }
        });
        flag4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlagActionListener1(evt);
            }
        });

        boxDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener(evt);
            }
        });
        boxMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener(evt);
            }
        });
        boxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener(evt);
            }
        });
        boxDay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener1(evt);
            }
        });
        boxMonth1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener1(evt);
            }
        });
        boxYearPassport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener1(evt);
            }
        });
        boxCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener2(evt);
            }
        });
        boxMaritalStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener3(evt);
            }
        });
        boxCitizenship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener4(evt);
            }
        });
        boxDisability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxActionListener5(evt);
            }
        });

        buttonLogin.setText("Войти");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    buttonLoginActionPerformed(evt);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        panelMain.add(buttonLogin);
        buttonLogin.setBounds(190, 160, 140, 40);
        panelMain.add(fieldLogin);
        fieldLogin.setBounds(140, 50, 190, 30);
        panelMain.add(fieldPass);
        fieldPass.setBounds(140, 100, 190, 30);

        panelMain.add(background);
        background.setBounds(0, 0, 820, 360);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelMain, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelMain, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void buttonRegistrationActionPerformed(java.awt.event.ActionEvent evt) {
        if(evt.getSource() == buttonRegistration) {
            WindowRegistration.setVisible(true);
            WindowRegistration.setEnabled(true);
            WindowRegistration.setExtendedState(JFrame.MAXIMIZED_BOTH);
            WindowRegistration.getContentPane().setBackground(Color.LIGHT_GRAY);
        }
    }

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {
        if(evt.getSource() == buttonOk) {
            String checkRes = CheckRegistration().trim();
            if(checkRes.equals("true")) {
                SetUser();
                WindowRegistration.dispose();
            }
            else labelError.setText(checkRes);
        }
    }

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {
        WindowRegistration.dispose();
    }

    private void WindowRegistrationAncestorMoved(java.awt.event.HierarchyEvent evt) {
    }

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {
        if(evt.getSource() == buttonLogin) {
            System.out.println(CheckLogin());
            if(!fieldLogin.getText().isEmpty() && !fieldPass.getText().isEmpty()) {
                if (CheckLogin().equals("true") || CheckLogin().equals("asadmin")) {
                    dispose();
                    System.out.println("Успешный вход");
                }
                else labelLoginError.setText("Ошибка входа");
                if(CheckLogin().equals("true")) {
                    dispose();
                    System.out.println("Успешный вход клиента");
                    new ClientForm(ID).setVisible(true);
                }
                if(CheckLogin().equals("asadmin")) {
                    dispose();
                    System.out.println("Успешный вход администратора");
                    new AdminWindow().setVisible(true);
                }
            }
            else{labelLoginError.setText("Ошибка входа");}
        }
    }

    String isRetiredBool = "";
    private void FlagActionListener(java.awt.event.ActionEvent evt) {
            if(flag1.isSelected()){ // да
                isRetiredBool = "true";
                isRetiredBool.trim();
            }
            else if(flag2.isSelected()){ // нет
                isRetiredBool = "false";
                isRetiredBool.trim();
            }
        }

    String militaryBool = "";
    private void FlagActionListener1(java.awt.event.ActionEvent evt) {
        if(flag3.isSelected()){ // да
            militaryBool = "true";
            militaryBool.trim();
        }
        else if(flag4.isSelected()){ // нет
            militaryBool = "false";
            militaryBool.trim();
        }
    }

    String birthDay = "01"; String birthMonth = "01"; String birthYear = "1960";
    String birth = birthYear + "/" + birthMonth + "/" + birthDay;
    public void BoxActionListener(java.awt.event.ActionEvent evt){
        birthDay = boxDay.getSelectedItem().toString();
        birthMonth =  boxMonth.getSelectedItem().toString();
        birthYear = boxYear.getSelectedItem().toString();
        birth = birthYear + "/" + birthMonth + "/" + birthDay;
    }
    String passportDay = "01"; String passportMonth = "01"; String passportYear = "2000";
    String passport_date = passportYear + "/" + passportMonth + "/" + passportYear;
    public void BoxActionListener1(java.awt.event.ActionEvent evt){
        passportDay = boxDay1.getSelectedItem().toString();
        passportMonth =  boxMonth1.getSelectedItem().toString();
        passportYear = boxYearPassport.getSelectedItem().toString();
        passport_date = passportYear + "/" + passportMonth + "/" + passportDay;
    }
    String city_id = "Минск";
    public void BoxActionListener2(java.awt.event.ActionEvent evt){
        city_id = boxCity.getSelectedItem().toString();
    }
    String marital_status_id = "В браке";
    public void BoxActionListener3(java.awt.event.ActionEvent evt){
        marital_status_id = boxMaritalStatus.getSelectedItem().toString();
    }

    String citizenship_id = "Беларусь";
    public void BoxActionListener4(java.awt.event.ActionEvent evt){
        citizenship_id = boxCitizenship.getSelectedItem().toString();
    }
    String disability_id = "Нет";
    public void BoxActionListener5(java.awt.event.ActionEvent evt){
        disability_id = boxDisability.getSelectedItem().toString();
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainForm().setVisible(true);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    String CheckRegistration() {
        if (login.getText().isEmpty() || pass.getText().isEmpty() || name.getText().isEmpty()
                || surname.getText().isEmpty() || middle_name.getText().isEmpty() || place_of_birth.getText().isEmpty()
                || address.getText().isEmpty() || isRetiredBool.isEmpty() || militaryBool.isEmpty()
                || passport_country.getText().isEmpty() || identity_num.getText().isEmpty()
                || passport.getText().isEmpty()){
            return "Не все необходимые поля заполнены. Попробуйте снова";
        }

        Pattern passportRegex = Pattern.compile("^[А-Я]{2}[0-9]{7}");
        Pattern nameRegex = Pattern.compile("^[А-Я][а-я]{1,20}$"); // $ конец строки
        Pattern loginRegex = Pattern.compile("^[a-z0-9]+"); // + один и более раз
        Pattern addressRegex = Pattern.compile("^[а-яА-яa-zA-Z0-9\\D]+");
        Pattern incomeRegex = Pattern.compile("^[0-9\\.]+");
        Pattern identityNumRegex = Pattern.compile("^[0-9]{7}[A-Z][0-9]{3}[A-Z]{2}[0-9]");

        Matcher matcher;
        matcher = loginRegex.matcher(login.getText());
        if (!matcher.matches())
            return "Неверно введен логин. Попробуйте снова";
        if(!pass.getText().equals(rpass) && pass.getText().isEmpty())
            return "Пароли не совпадают. Попробуйте снова";
        matcher = nameRegex.matcher(name.getText());
        if (!matcher.matches())
            return "Неверно введено имя. Попробуйте снова";
        matcher = nameRegex.matcher(surname.getText());
        if (!matcher.matches())
            return "Неверно введена фамилия. Попробуйте снова";
        matcher = nameRegex.matcher(middle_name.getText());
        if (!matcher.matches())
            return "Неверно введено отчество. Попробуйте снова";
        matcher = addressRegex.matcher(place_of_birth.getText());
        if (!matcher.matches())
            return "Неверно введено место рождения. Попробуйте снова";
        matcher = addressRegex.matcher(address.getText());
        if (!matcher.matches())
            return "Неверно введен адрес. Попробуйте снова";
        if (!email.getText().isEmpty()) {
            if (!email.getText().contains("@"))
                return "Неверно введен email. Попробуйте снова";
        }
        if (!workplace.getText().isEmpty()) {
            matcher = addressRegex.matcher(workplace.getText());
            if (!matcher.matches())
                return "Неверно введено место работы. Попробуйте снова";
        }
        if (!work_position.getText().isEmpty()) {
            matcher = addressRegex.matcher(work_position.getText());
            if (!matcher.matches())
                return "Неверно введена должность. Попробуйте снова";
        }
        matcher = incomeRegex.matcher(income.getText());
        if (!matcher.matches())
            return "Неверно введен доход. Попробуйте снова";
        matcher = nameRegex.matcher(passport_country.getText());
        if (!matcher.matches())
            return "Неверно введена страна выдачи паспорта. Попробуйте снова";
        matcher = identityNumRegex.matcher(identity_num.getText());
        if (!matcher.matches())
            return "Неверно введен идентификационный номер. Попробуйте снова";
        matcher = passportRegex.matcher(passport.getText());
        if (!matcher.matches())
            return "Неверно введен паспорт. Попробуйте снова";

        return "true";
    }

    String CheckLogin() {
        Socket socket = null;
        BufferedReader br = null;
        PrintStream ps = null;
        String exitFlag;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 1024);
            ps = new PrintStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps.println("login");
            ps.println(fieldLogin.getText());
            ps.println(fieldPass.getText());
            if (fieldLogin.getText().equals("admin") && br.readLine().equals("ok")){
                exitFlag = "asadmin";
            }
            else {
                if(br.readLine().equals("ok")) {
                    exitFlag = "true";
                    ID = br.readLine();
                }
                else {
                    labelLoginError.setText("Ошибка входа");
                    exitFlag = "false";
                }
            }
        }
        catch (IOException e) {
            System.err.println(e);
            exitFlag = "false";
            ps.println("exit");
        }
        finally {
            if (br != null) {
                ps.println("exit");
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
            if (socket!= null) {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
        return exitFlag;
    }

    void SetUser() {
        Socket socket = null;
        BufferedReader br = null;
        PrintStream ps = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 1024);
            ps = new PrintStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps.println("loginExists");
            ps.println(login.getText());
            String result = br.readLine();
            //System.out.println("Количество пользователей с таким именем " + result);
            int resInt = Integer.parseInt(result);
            if (resInt == 0) {
                ps.println("adduser");
                ps.println(login.getText());
                ps.println(pass.getText());
                ps.println(surname.getText());
                ps.println(name.getText());
                ps.println(middle_name.getText());
                ps.println(birth);
                ps.println(place_of_birth.getText());
                ps.println(city_id);
                ps.println(address.getText());
                ps.println(home_tel.getText());
                ps.println(mob_tel.getText());
                ps.println(email.getText());
                ps.println(workplace.getText());
                ps.println(work_position.getText());
                ps.println(marital_status_id);
                ps.println(citizenship_id);
                ps.println(disability_id);
                ps.println(isRetiredBool);
                ps.println(income.getText());
                ps.println(militaryBool);
                ps.println(passport_country.getText());
                ps.println(passport_date);
                ps.println(identity_num.getText());
                ps.println(passport.getText());
                ps.println("exit");
            }
            else {
                WindowRegistration.dispose();
                JOptionPane.showMessageDialog(JOptionPaneTest,
                        "<html><h2>Ошибка</h2><i>Пользователь с таким именем уже существует</i>");
            }

        }
        catch (IOException e) {
            System.err.println(e);
            ps.println("exit");
        }
        finally {
            if (br != null) {
                ps.println("exit");
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
            if (socket!= null) {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private JFrame WindowRegistration;
    private JLabel background;

    private JButton buttonClose, buttonLogin, buttonOk, buttonRegistration;

    private JTextField fieldLogin;
    private JPasswordField fieldPass;

    private JLabel jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel9, jLabel10, jLabel11, jLabel12,
            jLabel20, jLabel21, jLabel22, jLabel23, jLabel24, jLabel25, jLabel26, jLabel27, jLabel28, jLabel29, jLabel30,
            jLabel31, jLabel32, jLabel33, jLabel34, jLabel35, jLabel36, jLabel37;

    private JPanel jPanel1;
    private JSeparator jSeparator1, jSeparator2;

    private JLabel labelError, labelLogin, labelLoginError, labelPassword, labelWelcome;

    private JTextField surname;
    private JTextField login;
    private JTextField name;
    private JTextField middle_name;
    private JTextField place_of_birth;
    private JTextField address;
    private JTextField home_tel;
    private JTextField mob_tel;
    private JTextField email;
    private JTextField workplace;
    private JTextField work_position;
    private JTextField income;
    private JTextField passport_country;
    private JTextField identity_num;
    private JTextField passport;

    private JRadioButton flag1, flag2;
    ButtonGroup bg;
    private JRadioButton flag3, flag4;
    ButtonGroup bg1;

    private JComboBox boxDay, boxMonth, boxYear, boxDay1, boxMonth1, boxYearPassport;
    private JComboBox boxCity, boxMaritalStatus, boxCitizenship, boxDisability;

    private JPanel panelMain;
    private JPasswordField pass;
    private JPasswordField rpass;
}