import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class ClientTable extends AbstractTableModel{
    static int colnum = 11;
    private int rownum;

    private final  ArrayList<String[]> ResultSets;

    static String[] colNames = {"ID", "Вид", "№договора", "Валюта", "Начало", "Окончание", "Срок",
                                "Сумма", "%", "ID клиента", "Фамилия"};

    public ClientTable(ArrayList<String[]> rs) {
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
