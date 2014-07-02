package mp3organizer.gui;

import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import mp3organizer.core.MediaFile;
import mp3organizer.core.MediaFileList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yousef-alsber
 */
public class FileFrame extends javax.swing.JFrame {

    /**
     * Creates new form FileFrame
     */
    public FileFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButtton = new javax.swing.JButton();
        changeButton = new javax.swing.JButton();
        sortButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        songList = new javax.swing.JList();
        removeButtton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addButtton.setText("+ file ...");
        addButtton.setToolTipText("");
        addButtton.setActionCommand("Brow");
        addButtton.setName("addButtton"); // NOI18N
        addButtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButttonActionPerformed(evt);
            }
        });

        changeButton.setText("Change Tag");
        changeButton.setName("changeButton"); // NOI18N
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        sortButton.setText("Sort Files");
        sortButton.setActionCommand("");
        sortButton.setName("sortButton"); // NOI18N
        sortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortButtonActionPerformed(evt);
            }
        });

        songList.setName("songList"); // NOI18N
        jScrollPane1.setViewportView(songList);

        removeButtton.setText("Remove");
        removeButtton.setToolTipText("");
        removeButtton.setActionCommand("Brow");
        removeButtton.setName("removeButtton"); // NOI18N
        removeButtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addButtton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeButtton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(sortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(addButtton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeButtton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeButton)
                    .addComponent(sortButton))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButttonActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        int ret = fc.showOpenDialog(this);
        if (ret == JFileChooser.APPROVE_OPTION) {
            DefaultListModel listModel = getNewListModel();
            File[] files = fc.getSelectedFiles();
            for (File f : files) {
                listModel.addElement(f.getAbsolutePath());
            }
            songList.setModel(listModel);
        }
    }//GEN-LAST:event_addButttonActionPerformed

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        TagsFrame tagesFrame = new TagsFrame();
        tagesFrame.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_changeButtonActionPerformed

    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortButtonActionPerformed
        SortFrame sortFrame = new SortFrame();
        sortFrame.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_sortButtonActionPerformed

    private void removeButttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButttonActionPerformed
        int[] selectedIndices = songList.getSelectedIndices();
        DefaultListModel modelList = getNewListModel();
        if (selectedIndices.length == 0) {
            return;
        }
        for (int i = selectedIndices.length - 1; i >= 0; i--) {
            modelList.remove(selectedIndices[i]);
        }
        songList.setModel(modelList);
    }//GEN-LAST:event_removeButttonActionPerformed

    private MediaFileList getMediaFileList() {
        MediaFileList mediaFileList = new MediaFileList();
        for (int i = 0 ;i< songList.getModel().getSize() ; i++) {
            try {
                mediaFileList.addFile(new MediaFile((String)songList.getModel().getElementAt(i)));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                //TODO do something to tell the user
            }
        }
        return mediaFileList;
    }
    //
    private DefaultListModel getNewListModel() {
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < songList.getModel().getSize(); i++) {
            listModel.addElement(songList.getModel().getElementAt(i));
        }
        return listModel;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButtton;
    private javax.swing.JButton changeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButtton;
    private javax.swing.JList songList;
    private javax.swing.JButton sortButton;
    // End of variables declaration//GEN-END:variables
}
