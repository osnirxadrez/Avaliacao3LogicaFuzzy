package FuzzyLogic;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

/**
 * Test parsing an FCL file
 * @author Osnir
 */
public class Avaliacao3 {
    public static void main(String[] args) throws Exception {
        // Load from 'FCL' file
        String fileName = "arquivo.fcl";
        FIS fis = FIS.load(fileName, true);

        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }
        //Get default function block
        FunctionBlock fb = fis.getFunctionBlock(null);

        // Set inputs
        fb.setVariable("PAS", 101);
        fb.setVariable("PAD", 61);

        // Evaluate
        fb.evaluate();

        // Show output variable's chart
        fb.getVariable("DIAGNOSTICO").defuzzify();

        // Print ruleSet
        System.out.println(fb);
        System.out.println("Diagnóstico: "+ fb.getVariable("DIAGNOSTICO").getValue());
    }
}
