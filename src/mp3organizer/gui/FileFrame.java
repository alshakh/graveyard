package mp3organizer.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import mp3organizer.core.MediaFile;
import mp3organizer.core.MediaFileList;
import mp3organizer.core.ProblemWithAudioFileException;

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
        setTitle("Mp3Organizer");

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(removeButtton, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changeButton)
                    .addComponent(sortButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButttonActionPerformed
        StringBuilder errors = new StringBuilder();
        //
        java.awt.FileDialog fd = new java.awt.FileDialog((java.awt.Frame) null);
        fd.setFilenameFilter(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".mp3")) {
                    return true;
                }
                return false;
            }
        });
        fd.setMultipleMode(true);

        fd.setVisible(true);
        if(fd!=null){
            DefaultListModel listModel = getNewListModel();
            File[] files = fd.getFiles();
            for (File f : files) {
                try {
                    new MediaFile(f);
                } catch (Exception ex) {
                    errors.append("\n").append(f.getAbsolutePath());
                    continue;
                }
                // avoid duplication
                if(listModel.contains(f.getAbsolutePath())) continue;
                //
                listModel.addElement(f.getAbsolutePath());
            }
            songList.setModel(listModel);
        }
        if(errors.length()!=0) {
            errors.insert(0, "\nThese files could not be opened");
            JOptionPane.showMessageDialog(this,
                                              "Some/All file/s couldn't be opened"+errors.toString(), "",
                                              JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addButttonActionPerformed

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        if(songList.getModel().getSize() == 0){
            JOptionPane.showMessageDialog(this,
                                              "No Files", "Error",
                                              JOptionPane.ERROR_MESSAGE);
            return;
        }
        TagsFrame tagesFrame = new TagsFrame(getMediaFileList());
        tagesFrame.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_changeButtonActionPerformed

    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortButtonActionPerformed
        if(songList.getModel().getSize() == 0){
            JOptionPane.showMessageDialog(this,
                                              "No Files", "Error",
                                              JOptionPane.ERROR_MESSAGE);
            return;
        }
        SortFrame sortFrame = new SortFrame(getMediaFileList());
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
                // already checked with the add function
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
