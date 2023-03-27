// CS 143, Homework: HTML checker
// Zeqi Li
import java.util.*;

public class HTMLManager
{
   private Queue<HTMLTag> tags;

  
   public HTMLManager(Queue<HTMLTag> html)
   {
      
       if (html == null)
       {
           throw new IllegalArgumentException("Can't construct an HTML Manager");
       }
       else
       {
           tags = html;
       }
   }
   public Queue<HTMLTag> getTags()
   {
       return tags;
   }

   public String toString()
   {
       String ret = "";
             Iterator<HTMLTag> itr = tags.iterator();
       while(itr.hasNext())
       {
                      ret += itr.next().toString().trim();
       }

       return ret;
   }

     public void fixHTML()
   {
              Stack<HTMLTag> unclosedOpeners = new Stack<>();
              Queue<HTMLTag> newTags = new LinkedList<HTMLTag>();
       
       Iterator<HTMLTag> itr = tags.iterator();

       while(itr.hasNext())
       {
           HTMLTag temp = itr.next();
          
         
           if (temp.isOpening())
           {
               unclosedOpeners.add(temp);
               newTags.add(temp);
           }
           
           if (temp.isClosing())
           {
               
                              
                  if (!unclosedOpeners.isEmpty())
               {
                  
                   HTMLTag lastOpening = unclosedOpeners.pop();
                  
                  
                                     if (lastOpening.matches(temp))
                   {
                       newTags.add(temp);
                   }
                   
                   else
                   {
                       newTags.add(lastOpening.getMatching());
                   }
               }
           }
           
           if (temp.isSelfClosing())
           {
               newTags.add(temp);
           }
          
           itr.remove();
       }

       
       itr = unclosedOpeners.iterator();

              while(itr.hasNext())
       {
           
           
                      newTags.add(itr.next().getMatching());
           itr.remove();
       }

              tags = newTags;
   }
}
