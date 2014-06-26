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

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javax.swing.JLabel;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.core.GenericTypeMatcher;
import static org.fest.assertions.Assertions.assertThat;
import org.fest.swing.fixture.JFileChooserFixture;
import org.fest.swing.core.Robot;
import org.fest.swing.finder.JFileChooserFinder;
/**
 *
 * @author yousef-alsber
 */
public class FileFrameTest
{
    
    public FileFrameTest() {
    }
    
    private FrameFixture window;  
    private Robot robot;
    final JFileChooser fileChooser = new JFileChooser();
       
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
//    public void shouldFindFileChooser() 
//    {
//      asserNotNull(window);  
//      window.button("Browes").click();
//      JFileChooserFixture found = JFileChooserFinder.findFileChooser().using(robot);
//      assertThat(found.target).isSameAs(window.fileChooser);
//  }
//    public void shouldFailIfFileChooserNotFound() 
//    {
//        JFileChooserFinder.findFileChooser().using(robot);
//    }

}
