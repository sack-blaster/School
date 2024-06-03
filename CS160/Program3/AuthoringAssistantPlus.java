/**
 *  Program 3b
 *  This program is designed to assist authors in editing their documents.
 *  CS160-01
 *  6/2/2024
 *  @author  Jacob Archer
  */

public class AuthoringAssistantPlus extends AuthoringAssistant {

    // Method to replace every occurrence of 'find' with 'replaceWith' in usrStr
    public String findAndReplaceWith(String find, String replaceWith) {
        usrStr = usrStr.replaceAll(find, replaceWith);
        return usrStr;
    }

    // Method to add 'spaces' number of spaces at the start of usrStr
    public String indent(int spaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }
        sb.append(usrStr);
        usrStr = sb.toString();
        return usrStr;
    }

    // Method to set usrStr equal to userString parameter
    public void setInputString(String userString) {
        usrStr = userString;
    }
}
