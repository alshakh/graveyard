
package symcode;
/**
 *
 * @author Ahmed Alshakh <ahmed.s.alshakh@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print(symcode.lab.LabLoader.loadLab(new java.io.File("labs/demoLab.json")).toString());
    }
    
}
