import com.peterabeles.auto64fto32f.ConvertFile32From64;
import com.peterabeles.auto64fto32f.RecursiveConvert;

import java.io.File;

/**
 * Auto generates 32bit code from 64bit code in all files inside it's search path.
 *
 * @author Peter Abeles
 */
public class Example64to32App extends RecursiveConvert {


    public Example64to32App(ConvertFile32From64 converter) {
        super(converter);
    }

    public static void main(String args[] ) {
        // Specify list of directories to recursively search
        String directories[] = new String[]{
                "examples"};

        ConvertFile32From64 converter = new ConvertFile32From64(true);

        // Add your own specialized strings
        converter.replacePattern("MyConstants.EPS", "MyConstants.F_EPS");

        Example64to32App app = new Example64to32App(converter);
        for( String dir : directories ) {
            // this will output the F32 files in the same directory as the input.  if you wish it to go to
            // a different location you need to add another parameter with the output file
            app.process(new File(dir) );
        }
    }
}
