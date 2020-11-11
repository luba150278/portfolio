package com.shpp.p2p.cs.asadov.assignment13ext;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;

import static com.shpp.p2p.cs.asadov.assignment13ext.Service.readFile;

public class Assignment13extPart1 {
    private String fileName;
    private String filePath;
    private BufferedImage image;

    private PaintPanel canvas;
    private JButton selectFolderBtn;
    private JButton scanerBlockDFSBtn;
    private JButton scanerPixBFSBtn;
    private JButton scanerEdgeBFSBtn;
    private JButton scanerPixEdgeBFSBtn;
    private JButton scanerColorBFSBtn;
    private JButton scanerBlocksBFSBtn;
    private JLabel resultLbl;
    private JList<String> list;

    private final String[] dataList = {};

    public static void main(String[] args) {
        String fileName = args.length > 0 ? args[0] : "test.jpg";
        Assignment13extPart1 app = new Assignment13extPart1(fileName);
        app.run();
    }

    public Assignment13extPart1(String fileName) {
        this.fileName = fileName;
        filePath = "";
    }

    private void run () {
        makeGUI();
    }

    private void makeGUI() {
        ButtonEventListener btnListener = new ButtonEventListener();

        resultLbl = new JLabel("Result: ");
        scanerBlockDFSBtn = new JButton("Block DFS");
        scanerBlockDFSBtn.addActionListener(btnListener);
        scanerEdgeBFSBtn = new JButton("Edge BFS");
        scanerEdgeBFSBtn.addActionListener(btnListener);
        scanerPixBFSBtn = new JButton("Pix BFS");
        scanerPixBFSBtn.addActionListener(btnListener);
        scanerColorBFSBtn = new JButton("Color DFS");
        scanerColorBFSBtn.addActionListener(btnListener);
        scanerBlocksBFSBtn = new JButton("Block BFS");
        scanerBlocksBFSBtn.addActionListener(btnListener);
        scanerPixEdgeBFSBtn = new JButton("Pix Edge BFS");
        scanerPixEdgeBFSBtn.addActionListener(btnListener);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.add(scanerBlockDFSBtn);
        topPanel.add(scanerColorBFSBtn);
        topPanel.add(scanerEdgeBFSBtn);
        topPanel.add(scanerBlocksBFSBtn);
        topPanel.add(scanerPixBFSBtn);
        topPanel.add(scanerPixEdgeBFSBtn);
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
            if (e.getSource() == scanerBlockDFSBtn)
                scanner = new ScannerBlocksDFS(fileName, filePath, image);
            else if (e.getSource() == scanerPixBFSBtn)
                scanner = new ScannerPixBFS(fileName, filePath, image);
            else if (e.getSource() == scanerBlocksBFSBtn)
                scanner = new ScannerBlocksBFS(fileName, filePath, image);
            else if (e.getSource() == scanerColorBFSBtn)
                scanner = new ScannerColorBFS(fileName, filePath, image);
            else if (e.getSource() == scanerPixEdgeBFSBtn)
                scanner = new ScannerPixEdgeBFS(fileName, filePath, image);
            else
                scanner = new ScannerEdgeBFS(fileName, filePath, image);


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
