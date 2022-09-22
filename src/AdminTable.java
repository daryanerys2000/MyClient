import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class AdminTable extends AbstractTableModel{
    static int colnum = 25;
    private int rownum;

    private final  ArrayList<String[]> ResultSets;

    static String[] colNames = {"ID", "Логин", "Паспорт", "Фамилия", "Имя", "Отчество", "Дата рождения", "Место рождения",
            "Город проживания", "Адрес", "Дом. тел.", "Моб. тел.", "Email", "Место работы", "Должность",
            "Семейное положение", "Гражданство", "Инвалидность", "Пенсия", "Доход", "Военнообязанный",
            "Страна выдачи паспорта", "Дата выдачи паспорта", "Идентификационный номер", "Паспорт"};

    public AdminTable(ArrayList<String[]> rs) {
        ResultSets = rs;
    }

    public Object getValueAt(int rowindex, int columnindex) {
        String[] row = ResultSets.get(rowindex);
        return row[columnindex];
    }

    public int getRowCount() {
        return ResultSets.size();
    }

    public int getColumnCount() {
        return colnum;
    }

    public String getColumnName(int param) {
        return colNames[param];
    }
}
