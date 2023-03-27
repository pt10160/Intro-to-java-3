// CS 143, Homework: HTML checker
// Zeqi Li




import java.util.*;
import java.io.*;

public class HTMLChecker {
    public static void main(String[] args) {
        String failedTests = "";

        File folder = new File("tests/");
        File[] listOfFiles = folder.listFiles();

        for (File file: listOfFiles) {
            if (file.isFile()) {
                String actualResult = check(folder.getName() + "/" + file.getName());
                String expectedResult = getManager("expected_output/" + file.getName().replace("html", "txt")).toString();
                if (actualResult.equals(expectedResult))
                    System.out.println("----> Result matches Expected Output!");
                else {
                    System.out.println("----> Something isn't working right! \nFixed HTML should be: \n" + expectedResult);
                    failedTests += file.getName() + " ";
                }
                System.out.println();
            }
        }
        
        System.out.println("===============================");
        if(failedTests.equals(""))
            System.out.println("        All tests passed!");
        else
            System.out.println("Failed tests: " + failedTests);
        System.out.println("===============================");
    }

    public static String check(String file) {
        System.out.println("===============================");
        System.out.println("Processing " + file + "...");
        System.out.println("===============================");

        HTMLManager manager = getManager(file);
        //System.out.println("Loaded tags: " + manager.getTags());
        System.out.println("HTML: " + manager);
        System.out.println("Checking HTML for errors...");
        manager.fixHTML();
        System.out.println("HTML after fix: " + manager);
        return manager.toString();
    }

    public static HTMLParser getParser(String path) {
        HTMLParser result = null;
        try {
            result = new HTMLParser(new File(path));
        } catch (Exception e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        }
        return result;
    }

    public static HTMLManager getManager(String file) {
        HTMLManager m = null;
        HTMLParser parser = getParser(file);
        if (parser != null) {
            Queue < HTMLTag > tags = parser.parse();
            m = new HTMLManager(tags);
        } else {
            System.err.println("Couldn't resolve input.  Try again!");
        }
        return m;
    }
}

/* ===============================
 Processing tests/test3.html...
 ===============================
 HTML: <br /></p></p>
 Checking HTML for errors...
 HTML after fix: <br />
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test2.html...
 ===============================
 HTML: <a><a><a></a>
 Checking HTML for errors...
 HTML after fix: <a><a><a></a></a></a>
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test5.html...
 ===============================
 HTML: <div><h1></h1><div><img /><p><br /><br /><br /></div></div></table>
 Checking HTML for errors...
 HTML after fix: <div><h1></h1><div><img /><p><br /><br /><br /></p></div></div>
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test4.html...
 ===============================
 HTML: <div><div><ul><li></li><li></li><li></ul></div>
 Checking HTML for errors...
 HTML after fix: <div><div><ul><li></li><li></li><li></li></ul></div></div>
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test1.html...
 ===============================
 HTML: <b><i><br /></b></i>
 Checking HTML for errors...
 HTML after fix: <b><i><br /></i></b>
 ----> Result matches Expected Output!
 
 ===============================
         All tests passed!
 ===============================
 */
 