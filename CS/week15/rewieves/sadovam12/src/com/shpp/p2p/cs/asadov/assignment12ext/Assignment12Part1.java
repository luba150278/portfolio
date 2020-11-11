package com.shpp.p2p.cs.asadov.assignment12ext;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;

import static com.shpp.p2p.cs.asadov.assignment12ext.Service.readFile;


public class Assignment12Part1 {
    private String fileName;
    private String filePath;
    private BufferedImage image;

    private PaintPanel canvas;
    private JButton selectFolderBtn;
    private JButton scanerBlockBtn;
    private JButton scanerPixBtn;
    private JButton scanerEdgeBtn;
    private JButton scanerColorBtn;
    private JLabel resultLbl;
    private JList<String> list;

    private final String[] dataList = {};

    public static void main(String[] args) {
        String fileName = args.length > 0 ? args[0] : "test.jpg";
        Assignment12Part1 app = new Assignment12Part1(fileName);
        app.run();
    }

    public Assignment12Part1(String fileName) {
        this.fileName = fileName;
        filePath = "";
    }

    private void run () {
        makeGUI();
    }

    private void makeGUI() {
        ButtonEventListener btnListener = new ButtonEventListener();

        resultLbl = new JLabel("Result: ");
        scanerBlockBtn = new JButton("Block scanner");
        scanerBlockBtn.addActionListener(btnListener);
        scanerEdgeBtn = new JButton("Edge scanner");
        scanerEdgeBtn.addActionListener(btnListener);
        scanerPixBtn = new JButton("Pix scanner");
        scanerPixBtn.addActionListener(btnListener);
        scanerColorBtn = new JButton("Color scanner");
        scanerColorBtn.addActionListener(btnListener);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.add(scanerBlockBtn);
        topPanel.add(scanerPixBtn);
        topPanel.add(scanerEdgeBtn);
        topPanel.add(scanerColorBtn);
        topPanel.add(resultLbl);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        selectFolderBtn = new JButton("Select folder");
        selectFolderBtn.addActionListener(btnListener);
        list = new JList<String>(dataList);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setPrototypeCellValue("Select folder");
        list.addListSelectionListener(new listSelectionListener());
        leftPanel.add(selectFolderBtn);
        leftPanel.add(new JScrollPane(list));

        canvas = new PaintPanel();
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add("North", topPanel);
        mainPanel.add("West", leftPanel);
        mainPanel.add("Center", new JScrollPane(canvas));

        JFrame frame = new JFrame("Render");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private class listSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                fileName = list.getSelectedValue();
                setImage();
            }
        }
    }

    private void setImage() {
        image = readFile(filePath, fileName);
        if (image != null) {
            canvas.setImage(image);
            canvas.setSize(new Dimension(image.getWidth(), image.getHeight()));
            canvas.repaint();
        }
    }

    private class ButtonEventListener implements ActionListener, FilenameFilter {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == selectFolderBtn) {
                updateList();
                return;
            }
            setImage();
            Scanner scanner;
            if (e.getSource() == scanerBlockBtn)
                scanner = new ScannerBlocks(fileName, filePath, image);
            else if (e.getSource() == scanerEdgeBtn)
                scanner = new ScannerEdge(fileName, filePath, image);
            else if (e.getSource() == scanerPixBtn)
                scanner = new ScannerPix(fileName, filePath, image);
            else
                scanner = new ScannerColor(fileName, filePath, image);
            int res = scanner.scanImage();
            resultLbl.setText("Result: " + res + " silhouettes");
            canvas.repaint();
        }

        private void updateList() {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select folder");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION ) {
                File path = fileChooser.getSelectedFile();
                filePath = path.toString();
                //JOptionPane.showMessageDialog(null, fileChooser.getSelectedFile());
                String[] files = path.list(this);
                list.setListData(files);
            }
        }

        @Override
        public boolean accept(File dir, String name) {
            if (name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg") || name.endsWith(".bmp"))
                return true;
            return false;
        }
    }
}
