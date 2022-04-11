mport javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.*;

public class MainWin extends JFrame {
    JToolBar toolbar = new JToolBar("Applications");
    JFrame frame;
    JPanel panel = new JPanel();
    JButton btnHome, btnDesc, btnAsc, btnNew, btnCat, btnDog;
    JMenu fileMenu, animalMenu, helpMenu;
    JMenuItem i1, i2, i3, i4, i5;
    JMenuItem cat, dog, about;
    JFileChooser fc;
    private Shelter shelter;
    private JLabel data;
