package smartcard;

import java.util.List;
import java.util.Scanner;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;
import javax.xml.bind.DatatypeConverter;

class TestPCSC 
{
    static String Pcsc()  
    {
        String str="Card Not Detected";
        try
        {
        TerminalFactory tf = TerminalFactory.getDefault();
        List< CardTerminal> terminals = tf.terminals().list();
        CardTerminal cardTerminal = (CardTerminal) terminals.get(0);
        Card connection = cardTerminal.connect("DIRECT");
        CardChannel cardChannel = connection.getBasicChannel();
        str=DatatypeConverter.printHexBinary(connection.getATR().getBytes());
        connection.disconnect(true);
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        str="FFABBB";
        System.out.println(str);
        return str;
    }

}