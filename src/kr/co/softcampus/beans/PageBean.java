package kr.co.softcampus.beans;

public class PageBean {
	
	//최소 페이지 번호. 해당 페이지 블록의 첫 페이지번호
	private int min;
	
	//최대 페이지 번호. 해당 페이지 블록의 마지막 페이지번호
	private int max;
	
	//이전 버튼의 페이지 번호. 현재 페이지의 min이 51이라면 prevPage는 50
	private int prevPage;
	
	//다음 버튼의 페이지 번호. 현재 페이지의 max가 60라면 nextPage는 61.만약 max가 pageCnt 많다면 pageCnt가 max가 된다. 
	private int nextPage;
	
	//전체 페이지 개수 전체글/페이지당글갯수
	private int pageCnt;
	
	//현재 페이지 번호
	private int currentPage;

	
	//contentCnt : 전체글 개수, currentPage : 현재 글 번호, contentPageCnt : 페이지당 글의 개수, paginationCnt : 페이지버튼의 개수
	public PageBean(int contentCnt,int currentPage, int contentPageCnt,int paginationCnt) {
		//현재 페이지 번호
		this.currentPage=currentPage;
		
		//전체 페이지 개수
		pageCnt=contentCnt/contentPageCnt;
		
		if(contentCnt%contentPageCnt>0) {
			pageCnt++;
		}
		
		min = ((currentPage-1)/contentPageCnt)*contentPageCnt+1;
		max= min + paginationCnt - 1;
		
		//만약 전체페이지 개수가 53까지 있다면 51~60이 나오는 걸 방지해야한다. 51~53이 나오도록해야된다.
		if(max>pageCnt) {
			max=pageCnt;
		}
		
		prevPage=min-1;
		nextPage=max+1;
		//위와 마찬가지로 마지막 페이지를 넘어가지 않도록 전체페이지 갯수보다 크게 나온다면 마지막페이지를 전체페이지 갯수록
		if(nextPage>pageCnt) {
			nextPage=pageCnt;
		}
	}
	
	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	
	
}
