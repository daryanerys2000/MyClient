import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class AccountsTable extends AbstractTableModel{
    static int colnum = 6;
    private int rownum;

    private final  ArrayList<String[]> ResultSets;

    static String[] colNames = {"ID", "Код", "А/П", "Дебет", "Кредит", "ID клиента"};

    public AccountsTable(ArrayList<String[]> rs) {
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
