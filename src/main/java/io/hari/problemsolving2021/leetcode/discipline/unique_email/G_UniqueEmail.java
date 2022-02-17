package io.hari.problemsolving2021.leetcode.discipline.unique_email;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class G_UniqueEmail {

    @Test
    public void foo() {
        //not worning
        int uniqueEmails = numUniqueEmails(new String[]{"abc@gmail.com", "abc.abc@gmail.com", "abc+abc@gmail.com"});
        System.out.println("uniqueEmails = " + uniqueEmails);

        //working
        int uniqueEmails2 = numUniqueEmails2(new String[]{"abc@gmail.com", "abc.abc@gmail.com", "abc+abc@gmail.com"});
        System.out.println("uniqueEmails2 = " + uniqueEmails2);
    }


    //for each email
    // - break into 2 parts
    // -

    /** HL : store in set + return set length
     * - for each email : abc.cde+abc@gmail.com"
     * - break into 2 parts : abc.cde+abc , gmail.com   --> A
     * - left part break into 2 parts : abc.cde, abc    --> B
     * - from above remove all "." -> "" : abc          --> C
     * - create final email : C + "@" + A
     * - add final string to set
     *
     * ref :    - java string methods :  replace, replace all, substring, indexOf, regex, Pattern class
     *          - regex,  what is meta character ?, literal
     *
     */
    public int numUniqueEmails2(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String e : emails) {
            String[] parts = e.split("@");
            String leftPart = parts[0];
            String localEmail = leftPart.replaceAll(".", "");
            String finalLocalEmail = localEmail + "@" + parts[1];
            set.add(finalLocalEmail);
        }
        return set.size();
    }


    //my approach
    public static Set<String> set = new HashSet<>();

    public int numUniqueEmails(String[] emails) {
        for (String email : emails) {
            recHelper(email);
        }
        System.out.println(set);
        return set.size();
    }

    public void recHelper(String email) {
        if (!isValid(email)) return;
        if (!email.contains(".") && !email.contains("+")) set.add(email);

        if (email.contains(".")) {
            email = email.replaceAll(".", "");
            recHelper(email);
        }

        if (email.contains("+")) {
            int i1 = email.indexOf("+");
            int i2 = email.indexOf("@");
            //validation
            String sub = email.substring(i1 + 1, i2 - 1);
            email = email.replace(sub, "");
            recHelper(email);
        }
    }

    public boolean isValid(String email) {
        if (email.contains("@")) return true;
        if (!email.contains("@")) return false;
        if (email.contains(".") || email.contains("+") || email.contains("@")) return true;
        return false;
    }
}
