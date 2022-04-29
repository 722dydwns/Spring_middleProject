package pos.beans;

import java.util.Map;

public interface InfoInterface {
	
	//기존 데이터 세팅
	public void OriginalData();
	
	public Map<String, Object[]> getData();

	public void Input(); //추가할 데이터 사용자에게 얻음
}

