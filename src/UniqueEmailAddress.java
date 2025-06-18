import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    Set<String> uniqueEmails = new HashSet<String>();
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(new UniqueEmailAddress().numUniqueEmails(emails));
    }
    
    public int numUniqueEmails(String[] emails) {
        for(String email : emails){
            String[] emailParts = email.split("@");
            String localName = emailParts[0];
            String domainName = emailParts[1];
            
            localName = localName.replace(".", "");
            int plusIndex = localName.indexOf("+");
            if(plusIndex != -1) {
                localName = localName.substring(0, plusIndex);
            }
            uniqueEmails.add(localName + "@" + domainName);
        }
        return uniqueEmails.size();
    }
}