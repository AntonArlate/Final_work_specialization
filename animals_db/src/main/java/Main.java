//13. ������� ����� � ������������� ������� � ������������� �� ���������.
/*
14. �������� ���������, ����������� ������ ������� �������� ��������.
� ��������� ������ ���� ���������� ��������� ����������:
14.1 ������� ����� ��������
14.2 ���������� �������� � ���������� �����
14.3 ������� ������ ������, ������� ��������� ��������
14.4 ������� �������� ����� ��������
14.5 ����������� ��������� �� ����
 */
/*
15. ������?�� ����� �������, � �������� ���� ����� add(), �������������?
�������� ����������? int ����������? �� 1 ��� ������� �������� �����
�������� �������� ���, ����� � �������� ������ ���� ����� ���� �������� �
����� try-with-resources. ����� ������� ����������, ���� ������ � ��������
���� ������� ���� �� � ��������� try �/��� ������ ������� ������. ��������
������� � ������� try, ���� ��� ��������� ��������� ��������� ��� ����.

������� � ������ MyUi
 */

import Repo.DataBase;
import Viewer.MyUI;

public class Main {
    public static void main(String[] args) throws Exception {
        DataBase dataBase = new DataBase();
        MyUI ui = new MyUI();
        ui.setDataBase(dataBase);

        ui.start();
    }
}
