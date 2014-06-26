/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mp3organizer.gui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.JLabel;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JComboBoxFixture;
import org.fest.swing.fixture.JLabelFixture;
import org.fest.swing.fixture.JTextComponentFixture;
import org.fest.swing.exception.ComponentLookupException;
import org.fest.swing.format.IntrospectionComponentFormatter;
import org.fest.swing.format.Formatting;
import org.fest.swing.core.GenericTypeMatcher;
import javax.swing.JButton;
import org.fest.swing.fixture.ContainerFixture;

/**
 *
 * @author yousef-alsber
 */
public class FileFrameTest
{
    
    public FileFrameTest() {
    }
    
    private FrameFixture window;
       
    @Before
    public void setUp() 
    {
        window = new FrameFixture(new FileFrame());
        window.show();
    }
    
    @After
    public void tearDown() 
    {
        window.cleanUp();
    }

    @Test
    public void testChangeClick()
    { 
      window.button(new GenericTypeMatcher<JButton>() 
      {
         @Override protected boolean isMatching(JButton button) 
         {
                return "Change Tag".equals(button.getText());
         } 
       });
    }
    
    @Test
    public void testCancelClick()
    { 
      window.button(new GenericTypeMatcher<JButton>() 
      {
         @Override protected boolean isMatching(JButton button) 
         {
                return "Sort Files".equals(button.getText());
         } 
       });
    }
    
//    @Test
//    public void testFileChooserClick()
//    { 
//      window.button(new GenericTypeMatcher<JButton>() 
//      {
//         @Override protected boolean isMatching(JButton button) 
//         {
//                return "File Chooser".equals(button.getText());
//         } 
//       });
//    }
    
    
}
