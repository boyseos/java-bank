package beans;

public class AdminBean extends MemberBean{
	private int sabun;
	
	public int getSabun() {
		return sabun;
	}
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
