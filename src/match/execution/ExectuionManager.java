package match.execution;

import domainmodel.Match;
import interfaces.IMatchExecution;

public class ExectuionManager implements IMatchExecution{

	@Override
	public void beginMatch(Match match) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finishMatch(Match match) {
		// TODO Auto-generated method stub
		
	}
	
	private void showMenu() {
		System.out.println("1. Potwierdz rozpoczêcie meczu");
	}

}
