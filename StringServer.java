import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> s = new ArrayList<>();
    ArrayList<String> sLab = new ArrayList<>();

    public String handleRequest(URI url) 
    {
        if (url.getPath().equals("/")) 
        {
            String words = "";
            if(sLab.size() == 0)
            {
                return String.format("Nothing added yet.");
            }
            for(String word : sLab)
            {
                words += "\n" + word ;
            }
            return String.format(words);
        } 
        else if (url.getPath().equals("/add")) 
        {
            if (url.getQuery().contains("s")) 
            {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s"))
                 {
                    s.add(parameters[1]);
                    return "Added.";
                }
            }
            return "add?";
        }
        else if (url.getPath().equals("/search")) 
        {
            String words = "Added words are listed below: \n";
            if(s.size() != 0)
            {
                for(String word : s)
                {
                    words += "\n" + word ;
                }
                return String.format(words);
            }
            return "Not added anything yet";
        }
        else if (url.getPath().equals("/add-message")) 
        {
            if (url.getQuery().contains("sLab")) 
            {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("sLab"))
                 {
                    sLab.add(parameters[1]);
                    return "Added.";
                }
            }
            return "add?";
        }
         else 
        {
            return "404 Not Found!";
        }
    }
}


public class StringServer 
{
    public static void main(String[] args) throws IOException {
    if(args.length == 0){
        System.out.println("Missing port number! Try any number between 1024 to 49151");
        return;
    }

    int port = Integer.parseInt(args[0]);

    Server.start(port, new Handler());
    }
}
