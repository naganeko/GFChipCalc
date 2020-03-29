package main.ui.help;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import main.App;
import main.resource.Resources;
import main.util.Fn;

/**
 *
 * @author Bunnyspa
 */
public class HelpAboutHiddenDialog extends JDialog {

    private final App app;

    public static HelpAboutHiddenDialog getInstance(App app) {
        return new HelpAboutHiddenDialog(app);
    }

    private HelpAboutHiddenDialog(App app) {
        initComponents();
        this.app = app;
        init();
    }

    private void init() {
        setBackground(new Color(0, 0, 0, 0));
        DisplayMode dm = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
        int width = dm.getWidth();
        int height = dm.getHeight();
        setPreferredSize(new Dimension(width, height));
        loadImage(height);
        pack();
        addListeners();
    }

    private void addListeners() {
        Fn.addEscDisposeListener(this);
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
    }

    private void loadImage(double height) {
        ImageIcon icon = Resources.MP448;
        double factor = height / icon.getIconHeight();
        Image image = icon.getImage().getScaledInstance((int) (icon.getIconWidth() * factor), (int) (icon.getIconHeight() * factor), Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(image));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        setResizable(false);

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageLabel;
    // End of variables declaration//GEN-END:variables
}