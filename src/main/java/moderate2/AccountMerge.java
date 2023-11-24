package moderate2;

import java.util.*;

/*
Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0]
is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person
if there is some common email to both accounts. Note that even if two accounts have the same name,
they may belong to different people as people could have the same name.
A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name,
and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 */
public class AccountMerge {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("James", "j1mail")));
        accounts.add(new ArrayList<>(Arrays.asList("James", "j4mail", "j5mail")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "m1mail", "m2mail")));
        accounts.add(new ArrayList<>(Arrays.asList("James", "j2mail")));

        System.out.println(accountsMerge(accounts));
    }

    static Map<String, String> emailToName = new HashMap<>();
    static Map<String, Set<String>> emailToNeighbors = new HashMap<>();

    private static List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int j = 1; j < account.size(); j++) {
                emailToName.put(account.get(j), name);
                if (!emailToNeighbors.containsKey(account.get(j))) {
                    emailToNeighbors.put(account.get(j), new HashSet<>());
                }

                if (j == 1) {
                    continue;
                }
                emailToNeighbors.get(account.get(j)).add(account.get(j-1));
                emailToNeighbors.get(account.get(j-1)).add(account.get(j));
            }
        }

        List<List<String>> ans = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for (String email : emailToName.keySet()) {
            List<String> list = new ArrayList<>();
            if (visited.add(email)) {
                checkAndAdd(visited, email, list, emailToNeighbors);
                Collections.sort(list);
                list.add(0, emailToName.get(email));
                ans.add(list);
            }
        }

        return ans;
    }

    private static void checkAndAdd(Set<String> visited, String email, List<String> list, Map<String, Set<String>>
                                    emailToNeighbors) {
        list.add(email);
        for (String next : emailToNeighbors.get(email)) {
            if (visited.add(next)) {
                checkAndAdd(visited, next, list, emailToNeighbors);
            }
        }

    }

}
