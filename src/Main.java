import java.util.HashSet;
import java.util.Set;
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(33);
        System.out.println(s1.GetAll(s));
    }
}
class Solution{
    public Set<Set<Integer>> GetAll(Set<Integer> sets){
        Set<Set<Integer>> result = new HashSet<>();
        backtrack(result,new HashSet<Integer>(), sets);
        return result;
    }
    public void backtrack(Set<Set<Integer>> result, Set<Integer> current, Set<Integer> individual){
        result.add(new HashSet<>(current));

        for(int i: individual){
            current.add(i);
            Set<Integer> newIndividual = new HashSet<>(individual);
            newIndividual.remove(i);
            // Recur with the new subset and the remaining elements
            backtrack(result, current, newIndividual);
            // Backtrack: remove the last added element
            current.remove(i);
        }

    }
}