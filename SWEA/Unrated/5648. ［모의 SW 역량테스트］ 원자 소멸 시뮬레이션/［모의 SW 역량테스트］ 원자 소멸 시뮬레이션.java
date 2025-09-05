import java.io.*;
import java.util.*;

public class Solution {
	static class Atom implements Comparable<Atom>{
		int x,y,dir,e;

		public Atom(int x, int y, int dir, int e) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.e = e;
		}
		@Override
		public int compareTo(Atom o) {
			return this.x<o.x ? -1 : (this.x != o.x ? Integer.compare(this.x, o.x) : Integer.compare(this.y, o.y));
		}	
	}
	
	static class Pair implements Comparable<Pair>{ //충돌리스트의 담을 충돌하는 두 원자와 그 때의 시간 정보.
		int i, j, time;

		public Pair(int i, int j, int time) {
			super();
			this.i = i;
			this.j = j;
			this.time = time;
		}
		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.time, o.time);
		}
	}
	
	static int n;
	static int[][] map = new int[4001][4001];
	static ArrayList<Atom> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			n = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())*2;
				int y = Integer.parseInt(st.nextToken())*2;
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list.add(new Atom(x,y,d,e));
			}
			
			
			
			
			
			sb.append(makeBoomPair()).append('\n');
		}
		System.out.println(sb);
		
	}
	static int makeBoomPair() {
		Collections.sort(list);
		ArrayList<Pair> boomList = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				Atom a = list.get(i);
				Atom b = list.get(j);
				
				//수직선에서 만날때
				if(a.x == b.x) {
					if(a.dir == 0 && b.dir == 1) {
						boomList.add(new Pair(i, j, Math.abs(a.y-b.y)/2));
					}
				}
				//수평선에서 만날때
				if(a.y == b.y) {
					if(a.dir == 3 && b.dir == 2) {
						boomList.add(new Pair(i, j, Math.abs(a.x-b.x)/2));
					}
				}
				// /대각선 라인에 있는 대상들이 만날때
				if(a.x-a.y == b.x-b.y) {
					if(a.dir==3 && b.dir==1 || a.dir == 0 && b.dir==2) {
						boomList.add(new Pair(i, j, Math.abs(a.x-b.x)));
					}
				}
				// \대각선 라인에 있는 대상들이 만날때
				if(a.x+a.y == b.x+b.y) {
					if(a.dir==3 && b.dir==0 || a.dir == 1 && b.dir==2) {
						boomList.add(new Pair(i, j, Math.abs(a.x-b.x)));
					}
				}
			}
		}
		
		
		
		return getTotalEnerge(boomList);
	}
	static int getTotalEnerge(ArrayList<Pair> boomList) {
		Collections.sort(boomList);
		int INF = Integer.MAX_VALUE;
		int boomTimes[] = new int[n];
		Arrays.fill(boomTimes, INF);
		int sum = 0;
		
		for(Pair p : boomList) {
			if(boomTimes[p.i]< p.time || boomTimes[p.j]< p.time ) continue;
			
			if(boomTimes[p.i] == INF) {
				boomTimes[p.i] = p.time;
				sum += list.get(p.i).e;
			}
			
			if(boomTimes[p.j] == INF) {
				boomTimes[p.j] = p.time;
				sum += list.get(p.j).e;
			}
		}
		return sum;
	
	}
}









