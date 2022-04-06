import javax.swing.*;
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

    public MainWin(String title) {
        shelter = new Shelter(title);
        frame = new JFrame(title);
        fc = new JFileChooser();

        JMenuBar mb = new JMenuBar();
        fileMenu = new JMenu("File");
        animalMenu = new JMenu("Animal");
        helpMenu = new JMenu("Help");

        i1 = new JMenuItem("New Shelter");
        i2 = new JMenuItem("Open Shelter");
        i3 = new JMenuItem("Save Shelter");
        i4 = new JMenuItem("Save Shelter As");
        i5 = new JMenuItem("Quit");

        cat = new JMenuItem("New Cat");
        dog = new JMenuItem("New Dog");
        about = new JMenuItem("About");

        fileMenu.add(i1);
        fileMenu.add(i2);
        fileMenu.add(i3);
        fileMenu.add(i4);
        fileMenu.add(i5);
        animalMenu.add(cat);
        animalMenu.add(dog);
        helpMenu.add(about);

        btnHome = new JButton(new ImageIcon("images/img1.png"));
        btnDesc = new JButton(new ImageIcon("images/img2.png"));
        btnAsc = new JButton(new ImageIcon("images/img3.png"));
        btnNew = new JButton(new ImageIcon("images/img4.png"));
        btnCat = new JButton(new ImageIcon("images/img5.png"));
        btnDog = new JButton(new ImageIcon("images/img6.png"));

        btnHome.setBorderPainted(false);
        btnDesc.setBorderPainted(false);
        btnAsc.setBorderPainted(false);
        btnNew.setBorderPainted(false);
        btnCat.setBorderPainted(false);
        btnDog.setBorderPainted(false);

        toolbar.add(btnHome);
        toolbar.add(btnDesc);
        toolbar.add(btnAsc);
        toolbar.add(btnNew);
        toolbar.add(btnCat);
        toolbar.add(btnDog);

        mb.add(fileMenu);
        mb.add(animalMenu);
        mb.add(helpMenu);

        frame.setJMenuBar(mb);
        frame.getContentPane().add(toolbar, BorderLayout.PAGE_START);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        frame.add(panel);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        addButtonEvents();
        addToolbarEvents();

    }

    public void addToolbarEvents() {
        i1.addActionListener(e -> onNewShelterClick());
        i2.addActionListener(e -> {
            try {
                onOpenShelterClick();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });
        i3.addActionListener(e -> {
            try {
                onSaveShelterClick();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });
        i4.addActionListener(e -> {
            try {
                onSaveShelterAsClick();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });
        i5.addActionListener(e -> onQuitClick());
        cat.addActionListener(e -> {
            try {
                onNewCatClick();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });
        dog.addActionListener(e -> {
            try {
                onNewDogClick();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });

        about.addActionListener(evt -> onAboutClick());
    }

    public void addButtonEvents() {
        btnHome.addActionListener(e -> {

            try {
                onOpenShelterClick();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        });
        btnDesc.addActionListener(e -> {
            try {
                onSaveShelterClick();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });
        btnAsc.addActionListener(e -> {
            try {
                onSaveShelterAsClick();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });
        btnNew.addActionListener(e -> onNewShelterClick());
        btnCat.addActionListener(e -> {
            try {
                onNewCatClick();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });
        btnDog.addActionListener(e -> {
            try {
                onNewDogClick();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        });
    }

    public void onNewShelterClick() {
        String name = JOptionPane.showInputDialog(frame,"Shelter Name");
        if (name.trim().equals("")){
            name = "Untitled Shelter";
        }
        shelter.setName(name+" Shelter");
    }

    public void onOpenShelterClick() throws IOException {
        BufferedReader br = null;
        try {
            fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("Data file", "mass"));
            fc.setMultiSelectionEnabled(false);
            int r = fc.showOpenDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {
                String file = fc.getSelectedFile().getAbsolutePath();
                shelter.setFilename(file);
                br = new BufferedReader(new FileReader(shelter.getFilename()));
                shelter = new Shelter(br);
                shelter.setFilename(file);
                updateDisplay();
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            br.close();
        }
    }

    public void onSaveShelterClick() throws IOException {
        if (!"".equals(shelter.getFilename())) {
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(shelter.getFilename()));
                shelter.save(bw);
                updateDisplay();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            } finally {
                bw.close();
            }
        }



    }

    public void onSaveShelterAsClick() throws IOException {
                fc = new JFileChooser();
        fc.setDialogTitle("Specify a file to save");

        int userSelection = fc.showSaveDialog(null);
        fc.setFileFilter(new FileNameExtensionFilter("Data file", "mass"));
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fc.getSelectedFile();
            File f = new File(fileToSave.getAbsolutePath());
            if(!f.exists()){
                f.createNewFile();
            }
            BufferedWriter  bw = new BufferedWriter(new FileWriter(fileToSave.getAbsolutePath()));
            shelter.save(bw);
            updateDisplay();
        }
    }

    public void onNewDogClick() throws IOException {
        BufferedReader br = null;
        try {
            fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("Data file", "mass"));
            fc.setMultiSelectionEnabled(false);
            int r = fc.showOpenDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {
                String file = fc.getSelectedFile().getAbsolutePath();
                br = new BufferedReader(new FileReader(file));
                Dog dog = new Dog(br);
                shelter.addAnimal(dog);
                updateDisplay();
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            br.close();
        }
    }

    public void onNewCatClick() throws IOException {
        BufferedReader br = null;
        try {
            fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new FileNameExtensionFilter("Data file", "mass"));
            fc.setMultiSelectionEnabled(false);
            int r = fc.showOpenDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {
                String file = fc.getSelectedFile().getAbsolutePath();

                br = new BufferedReader(new FileReader(file));
                Cat dog = new Cat(br);
                shelter.addAnimal(dog);
                updateDisplay();
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            br.close();
        }
    }

    public void onAboutClick() {
        JOptionPane.showMessageDialog(frame, "Mavs Animal Shelter Software (MASS),\n" +
                "which manages a no-kill shelter aiming to help companion \n" +
                "animals of various types to adopt humans");
    }

    public void onQuitClick() {
        System.exit(0);
    }

    public void updateDisplay() {
        panel.removeAll();
        for (Animal an : shelter.getAnimals()) {
            data = new JLabel(an.toString());
            data.setBorder(new EmptyBorder(0, 0, 5, 0));
            panel.add(data);
            panel.revalidate();
        }
    }
}
