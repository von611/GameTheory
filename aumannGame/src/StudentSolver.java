import java.math.BigInteger;
import java.util.HashSet;

public class StudentSolver {
	public static void main(String[] args) {
		AumannProblem a = new AumannProblem();
		a.initializeExample();
		a.printout();
		
		Pair<BigInteger, BigInteger> sol = solve(a);
		System.out.println(sol.toString());
	}
	
	public static Pair<BigInteger,BigInteger> solve(AumannProblem problem) {
		for(HashSet<Integer> part : problem.aPartition) {
			
		}
		return null;
		
	}

}
