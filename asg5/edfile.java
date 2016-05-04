// edfile.java
// Template for a line-oriented text editor inspired by ed.

import java.util.Scanner;
import static java.lang.System.*;
import java.io.*;

class edfile{

   public static void main (String[] args) throws IOException {
      System.out.println("Hi, I am Edfile");
      boolean want_echo = true;
      dllist lines = new dllist ();

      //auxlib.STUB ("Check for -e option");
      String filename = null;
      if (args.length == 0) {
   	  System.out.println("no filename"); // my test, Delete it
      } else if (!args[0].equals("-e")) {
         want_echo = false;
         filename = args[0];
      } else {
   	  want_echo = true;
   	  if (args.length == 2){
   	     filename = args[1];
   	  } else {
   	     System.out.println("no filename"); // my test, Delete it
        }
      }

      //auxlib.STUB ("Load file from args filename, if any.");
      if (filename != null) {
         BufferedReader myFile = new BufferedReader(new FileReader(filename));
         while (true) {
            String contents = myFile.readLine();
            if (contents==null) break;
            //lines.insert(contents, )
         }
      }


      Scanner stdin = new Scanner (in);
      for (;;) {
         if (! stdin.hasNextLine()) break;
         String inputline = stdin.nextLine();
         if (want_echo) out.printf ("%s%n", inputline);
         if (inputline.matches ("^\\s*$")) continue;
         char command = inputline.charAt(0);
         switch (command) {
            case '#':
               break;  // what do I have to do with this?
            case '$':
               lines.setPosition(position.LAST);
               break;
            case '*':
               lines.setPosition(position.FIRST);
               while(!lines.isEmpty) {
                  lines.getItem();
                  lines.setPosition(position.FOLLOWING);
                  if (position.FOLLOWING == position.LAST) break;
               }
               break;
            case '.': auxlib.STUB ("Call . command function."); break;
            case '0': auxlib.STUB ("Call 0 command function."); break;
            case '<': auxlib.STUB ("Call < command function."); break;
            case '>': auxlib.STUB ("Call > command function."); break;
            case 'a': auxlib.STUB ("Call a command function."); break;
            case 'd': auxlib.STUB ("Call d command function."); break;
            case 'i': auxlib.STUB ("Call i command function."); break;
            case 'r': auxlib.STUB ("Call r command function."); break;
            case 'w': auxlib.STUB ("Call w command function."); break;
            default : auxlib.STUB ("Print invalid command."); break;
         }
      }
      auxlib.STUB ("(eof)");
   }

}

